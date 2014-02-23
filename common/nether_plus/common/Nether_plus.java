package nether_plus.common;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.MinecraftForge;
import nether_plus.common.achievement.NPAchievements;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import nether_plus.common.entity.NPEntityList;
import nether_plus.common.event.BucketEvent;
import nether_plus.common.event.FarmingNether;
import nether_plus.common.event.GrimBoneMeal;
import nether_plus.common.event.LivingEvent;
import nether_plus.common.event.PickupHandler;
import nether_plus.common.gui.GuiHandler;
import nether_plus.common.item.NPItemList;
import nether_plus.common.recipe.NPRecipe;
import nether_plus.common.tileentity.NPTEntityList;
import nether_plus.proxy.NPCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = "nether_plus", name = "Nether plus", version = "1.0.0")
// @NetworkMod(clientSideRequired = true, serverSideRequired = false,
// clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Nether_Plus"},
// packetHandler = ClientPacketHandler.class),
// serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Nether_Plus"},
// packetHandler = ServerPacketHandler.class))
public class Nether_plus
{
	@SidedProxy(clientSide = "nether_plus.proxy.NPClientProxy", serverSide = "nether_plus.proxy.NPCommonProxy")
	public static NPCommonProxy proxy;

	@Instance("nether_plus")
	public static Nether_plus instance;

	public static Logger NPlog = Logger.getLogger("Nether_Plus");

	protected static final GuiHandler GuiHandler = new GuiHandler();

	@EventHandler
	public void preload(FMLPreInitializationEvent event)
	{
		// NPlog.setParent((Logger) FMLLog.getLogger());

		NetherPlusCreativeTabs.loadCreativeTab();// CreativeTab
		NPBlockList.loadBlock();// Block
		NPItemList.loadItem();// Item
		NPAchievements.loadAchievements();

		proxy.initSound();// Sound
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		NPEntityList.loadEntity();// Entity
		this.removeRecipe(new ItemStack(Blocks.glowstone));

		proxy.registerRender();
		proxy.registerRenderEntity();

		MinecraftForge.EVENT_BUS.register(new GrimBoneMeal());
		MinecraftForge.EVENT_BUS.register(new LivingEvent());
		MinecraftForge.EVENT_BUS.register(new FarmingNether());
		MinecraftForge.EVENT_BUS.register(new PickupHandler());
		MinecraftForge.EVENT_BUS.register(new BucketEvent());
		// *1

		NPTEntityList.loadTileEntity();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiHandler);
	}

	@EventHandler
	public void modloaded(FMLPostInitializationEvent event)
	{
		NPRecipe.loadRecipe();// Recipe
		NPRecipe.loadSmelting();// Smelting
	}

	public static void removeRecipe(ItemStack par1)
	{
		List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
		for(int i = 0; i < recipeList.size(); i++)
		{
			IRecipe currentRecipe = recipeList.get(i);
			if(currentRecipe instanceof ShapedRecipes)
			{
				ShapedRecipes shape = (ShapedRecipes)currentRecipe;
				ItemStack output = shape.getRecipeOutput();
				if(ItemStack.areItemStacksEqual(par1, output))
				{
					recipeList.remove(i);
				}
			}

			if(currentRecipe instanceof ShapelessRecipes)
			{
				ShapelessRecipes shapeless = (ShapelessRecipes)currentRecipe;
				ItemStack output = shapeless.getRecipeOutput();
				if(ItemStack.areItemStacksEqual(par1, output))
				{
					recipeList.remove(i);
				}
			}
		}
	}
}