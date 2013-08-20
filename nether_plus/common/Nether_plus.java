package nether_plus.common;

import java.io.File;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.config.NPProperties;
import nether_plus.common.entity.NPEntityList;
import nether_plus.common.item.NPItemList;
import nether_plus.common.recipe.NPRecipe;
import nether_plus.proxy.NPCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "nether_plus", name = "Nether plus", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Nether_plus
{
	@SidedProxy(clientSide = "nether_plus.proxy.NPClientProxy", serverSide = "nether_plus.proxy.NPCommonProxy")
	public static NPCommonProxy proxy;

	@Instance("nether_plus")
	public static nether_plus.common.Nether_plus instance;
	
	public static File ConfigFile;
	
	@PreInit
	public void preload(FMLPreInitializationEvent event)
	{
		ConfigFile = new File(event.getModConfigurationDirectory(), "Nether_Plus.cfg");
		Configuration cfg = new Configuration(ConfigFile);
		try
		{
			cfg.load();
			//Blocks
			NPProperties.GlowstoneSandID = cfg.getBlock("GlowstoneSand", 600).getInt();
			NPProperties.SoulGlassID = cfg.getBlock("SoulGlass", 601).getInt();
			NPProperties.NetherrazeID = cfg.getBlock("Netherraze", 602).getInt();
			NPProperties.BewitchedWoodID = cfg.getBlock("BewitchedWood", 603).getInt();
			NPProperties.CorruptionStoneID = cfg.getBlock("CorruptionStone", 604).getInt();
			NPProperties.GrimwoodLogID = cfg.getBlock("GrimwoodLog", 605).getInt();
			NPProperties.GrimwoodLeavesID = cfg.getBlock("GrimwoodLeaves", 606).getInt();
			NPProperties.GrimwoodSaplingID = cfg.getBlock("GrimwoodSapling", 607).getInt();
			NPProperties.CorruptedGoldOreID = cfg.getBlock("CorruptedGoldOre", 608).getInt();
			NPProperties.CorruptedCharoiteOreID = cfg.getBlock("CorruptedCharoiteOre", 609).getInt();
			NPProperties.CorruptedBlackIronOreID = cfg.getBlock("CorruptedBlackIronOre", 610).getInt();
			NPProperties.GrimwoodPlanksID = cfg.getBlock("GrimwoodPlanks", 611).getInt();
			NPProperties.CorruptedBrickID = cfg.getBlock("CorruptedBrick", 612).getInt();
			NPProperties.NetherrackBrickID = cfg.getBlock("NetherrackBrick", 613).getInt();
			NPProperties.GrimwoodWorkbenchID = cfg.getBlock("GrimwoodWorkbench", 614).getInt();
//			NPProperties.CorruptedFurnace_offID = cfg.getBlock("CorruptedFurnace_off", 615).getInt();
//			NPProperties.CorruptedFurnace_onID = cfg.getBlock("CorruptedFurnace_on", 616).getInt();
			NPProperties.GrimwoodStairsID = cfg.getBlock("GrimwoodStairs", 617).getInt();
			NPProperties.CorruptedBrickStairsID = cfg.getBlock("CorruptedBrickStairs", 618).getInt();
			NPProperties.NetherrackBrickStairsID = cfg.getBlock("NetherrackBrickStairs", 619).getInt();
			NPProperties.ModSlabID = cfg.getBlock("ModSlab", 620).getInt();
			NPProperties.ModDoubleSlabID = cfg.getBlock("ModDoubleSlab", 621).getInt();
		
			//Items
			NPProperties.CharoiteCrystalID = cfg.getItem("CharoiteCrystal", 4000).getInt();
			NPProperties.BlackIronIngotID = cfg.getItem("BlaackIronIngot", 4001).getInt();
			NPProperties.BlackBoneID = cfg.getItem("BlackBone", 4002).getInt();
		}
		catch(Exception ex)
		{
			event.getModLog().severe("Failed to load configuration");
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
		}
		
		NetherPlusCreativeTabs.loadCreativeTab();//CreativeTab
		NPBlockList.loadBlock();//block
		NPItemList.loadItem();//Item
	}

	@Init
	public void load(FMLInitializationEvent event)
	{
		NPEntityList.loadEntity();//Entity	
		this.removeRecipe(new ItemStack(Block.glowStone));
		
		proxy.registerRender();
		proxy.registerRenderEntity();

		MinecraftForge.EVENT_BUS.register(new GrimBoneMeal());		
	}

	@PostInit
	public void modloaded(FMLPostInitializationEvent event)
	{
		LanguageRegistry.instance().loadLocalization("/mods/nether_plus/lang/en_US.lang", "en_US", false);
		LanguageRegistry.instance().loadLocalization("/mods/nether_plus/lang/fr_FR.lang", "fr_FR", false);
		NPRecipe.loadRecipe();//Recipe
		NPRecipe.loadSmelting();//Smelting
		
	}
	
	public static void removeRecipe(ItemStack par1)
	{
	     List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
	     for(int i=0;i<recipeList.size();i++)
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
