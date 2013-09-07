package nether_plus.common;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

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
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import nether_plus.common.entity.NPEntityList;
import nether_plus.common.event.FarmingNether;
import nether_plus.common.event.GrimBoneMeal;
import nether_plus.common.event.LivingEvent;
import nether_plus.common.gui.GuiHandler;
import nether_plus.common.item.NPItemList;
import nether_plus.common.recipe.NPRecipe;
import nether_plus.common.tileentity.NPTEntityList;
import nether_plus.proxy.NPCommonProxy;
import nether_plus.proxy.network.ClientPacketHandler;
import nether_plus.proxy.network.ServerPacketHandler;
import cpw.mods.fml.common.FMLLog;
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
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "nether_plus", name = "Nether plus", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Nether_Plus"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Nether_Plus"}, packetHandler = ServerPacketHandler.class))
public class Nether_plus
{
	@SidedProxy(clientSide = "nether_plus.proxy.NPClientProxy", serverSide = "nether_plus.proxy.NPCommonProxy")
	public static NPCommonProxy proxy;

	@Instance("nether_plus")
	public static nether_plus.common.Nether_plus instance;
	
	public static File ConfigFile;
	public static Logger NPlog = Logger.getLogger("Nether_Plus");
	
	protected static final GuiHandler GuiHandler = new GuiHandler();
	
	@PreInit
	public void preload(FMLPreInitializationEvent event)
	{
		NPlog.setParent(FMLLog.getLogger());
		
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
			NPProperties.CorruptedCobblestoneID = cfg.getBlock("CorruptedCobblestone", 605).getInt();
			NPProperties.GrimwoodLogID = cfg.getBlock("GrimwoodLog", 606).getInt();
			NPProperties.GrimwoodLeavesID = cfg.getBlock("GrimwoodLeaves", 607).getInt();
			NPProperties.GrimwoodSaplingID = cfg.getBlock("GrimwoodSapling", 608).getInt();
			NPProperties.CorruptedGoldOreID = cfg.getBlock("CorruptedGoldOre", 609).getInt();
			NPProperties.CorruptedCharoiteOreID = cfg.getBlock("CorruptedCharoiteOre", 610).getInt();
			NPProperties.CorruptedBlackIronOreID = cfg.getBlock("CorruptedBlackIronOre", 611).getInt();
			NPProperties.GrimwoodPlanksID = cfg.getBlock("GrimwoodPlanks", 612).getInt();
			NPProperties.CorruptedBrickID = cfg.getBlock("CorruptedBrick", 613).getInt();
			NPProperties.NetherrackBrickID = cfg.getBlock("NetherrackBrick", 614).getInt();
			NPProperties.GrimwoodWorkbenchID = cfg.getBlock("GrimwoodWorkbench", 615).getInt();
			NPProperties.fourOffID = cfg.getBlock("fourOff", 616).getInt();
			NPProperties.fourOnID = cfg.getBlock("fourOn", 617).getInt();
//			NPProperties.CorruptedFurnace_OffID = cfg.getBlock("CorruptedFurnace_Off", 615).getInt();
//			NPProperties.CorruptedFurnace_OnID = cfg.getBlock("CorruptedFurnace_On", 616).getInt();
			NPProperties.GrimwoodStairsID = cfg.getBlock("GrimwoodStairs", 618).getInt();
			NPProperties.CorruptedCobblestoneStairsID = cfg.getBlock("CorruptedCobblestoneStairs", 619).getInt();
			NPProperties.CorruptedBrickStairsID = cfg.getBlock("CorruptedBrickStairs", 620).getInt();
			NPProperties.NetherrackBrickStairsID = cfg.getBlock("NetherrackBrickStairs", 621).getInt();
			NPProperties.ModWoodDoubleSlabID = cfg.getBlock("ModWoodDoubleSlab", 622).getInt();
			NPProperties.ModWoodSlabID = cfg.getBlock("ModWoodSlab", 623).getInt();
			NPProperties.ModStoneDoubleSlabID = cfg.getBlock("ModStoneDoubleSlab", 624).getInt();
			NPProperties.ModStoneSlabID = cfg.getBlock("ModStoneSlab", 625).getInt();
			NPProperties.ModFenceID = cfg.getBlock("ModFence", 626).getInt();
			NPProperties.CorruptedCobblestoneWallID = cfg.getBlock("CorruptedCobblestoneWall", 627).getInt();
			NPProperties.CorruptedBrickWallID = cfg.getBlock("CorruptedBrickWall", 628).getInt();
			NPProperties.NetherrackBrickWallID = cfg.getBlock("NetherrackBrickWall", 629).getInt();
			NPProperties.GrimwoodChestID = cfg.getBlock("GrimwoodChest", 630).getInt();
			NPProperties.WhiteSkullID = cfg.getBlock("WhiteSkull", 631).getInt();
			NPProperties.BlackSkullID = cfg.getBlock("BlackSkull", 632).getInt();
			NPProperties.SoulGlassPaneID = cfg.getBlock("SoulGlassPane", 633).getInt();
			NPProperties.InfernumOreID = cfg.getBlock("InfenumOre", 634).getInt();
			NPProperties.InfernumBlockID = cfg.getBlock("InfernumBlock", 635).getInt();
			NPProperties.BlockGrimwoodDoorID = cfg.getBlock("BlockGrimwoodDoor", 636).getInt();
			NPProperties.BlackIronBlockID = cfg.getBlock("BlackIronBlock", 637).getInt();
			NPProperties.CharoiteBlockID = cfg.getBlock("CharoiteBlock", 638).getInt();
			NPProperties.Nether_FarmID = cfg.getBlock("Nether_Farm", 639).getInt();
			NPProperties.CropsID = cfg.getBlock("Crops", 640).getInt();
			NPProperties.PepperCID = cfg.getBlock("PepperC", 641).getInt();
			NPProperties.PepperBID = cfg.getBlock("PepperB", 642).getInt();
			
			NPProperties.LadderID = cfg.getBlock("Lader", 644).getInt();
			NPProperties.NetherRailID = cfg.getBlock("NetherRail", 645).getInt();
			NPProperties.NetherDetectorRailID = cfg.getBlock("NetherDetectorRail", 646).getInt();
			NPProperties.NetherPoweredRailID = cfg.getBlock("NetherPoweredRail", 647).getInt();
			NPProperties.GrimwoodTorchID = cfg.getBlock("GrimwoodTorch", 648).getInt();
			NPProperties.NetherDonjonSpawnerID = cfg.getBlock("NetherDonjonSpawner", 649).getInt();
		
			//Items
			NPProperties.CharoiteCrystalID = cfg.getItem("CharoiteCrystal", 4000).getInt();
			NPProperties.BlackIronIngotID = cfg.getItem("BlaackIronIngot", 4001).getInt();
			NPProperties.BlackBoneID = cfg.getItem("BlackBone", 4002).getInt();
			NPProperties.BlackBoneMealID = cfg.getItem("BlackBoneMeal", 4003).getInt();
			NPProperties.FireslimeballID = cfg.getItem("Fireslimeball", 4004).getInt();
			
			NPProperties.SkeletonWhiteHelmetID = cfg.getItem("SkeletonWhiteHelmet", 4005).getInt();
			NPProperties.SkeletonWhiteChestplateID = cfg.getItem("SkeletonWhiteChestplate", 4006).getInt();
			NPProperties.SkeletonWhiteLeggingsID = cfg.getItem("SkeletonWhiteLeggings", 4007).getInt();
			NPProperties.SkeletonWhiteBootID = cfg.getItem("SkeletonWhiteBoot", 4008).getInt();
			
			NPProperties.SkeletonBlackHelmetID = cfg.getItem("SkeletonBlackHelmet", 4009).getInt();
			NPProperties.SkeletonBlackChestplateID = cfg.getItem("SkeletonBlackChestplate", 4010).getInt();
			NPProperties.SkeletonBlackLeggingsID = cfg.getItem("SkeletonBlackLeggings", 4011).getInt();
			NPProperties.SkeletonBlackBootID = cfg.getItem("SkeletonBlackBoot", 4012).getInt();
			
			NPProperties.GrimwoodSwordID = cfg.getItem("GrimwoodSword", 4013).getInt();
			NPProperties.GrimwoodPickaxeID = cfg.getItem("GrimwoodPickaxe", 4014).getInt();
			NPProperties.GrimwoodAxeID = cfg.getItem("GrimwoodAxe", 4015).getInt();
			NPProperties.GrimwoodShovelID = cfg.getItem("GrimwoodShovel", 4016).getInt();
			NPProperties.GrimwoodHoeID = cfg.getItem("GrimwoodHoe", 4017).getInt();
			NPProperties.GrimwoodStickID = cfg.getItem("GrimwoodStick", 4018).getInt();
			
			NPProperties.BloodGemID = cfg.getItem("BloodGem", 4019).getInt();
			NPProperties.InfernumIngotID = cfg.getItem("InfernumIngot", 4020).getInt();
			NPProperties.ItemGrimwoodDoorID = cfg.getItem("ItemGrimwoodDoor", 4021).getInt();
			
			NPProperties.WhiteWheatSeedsID = cfg.getItem("WhiteWheatSeeds", 4022).getInt();
			NPProperties.WhiteWheatID = cfg.getItem("WhiteWheat", 4023).getInt();
			NPProperties.PepperSeedID = cfg.getItem("PepperSeed", 4024).getInt();
			NPProperties.PepperID = cfg.getItem("Pepper", 4025).getInt();
			
			NPProperties.DeadBreadID = cfg.getItem("DeadBread", 4027).getInt();
			NPProperties.GoldBucketID = cfg.getItem("GoldBucket", 4028).getInt();
			NPProperties.WaterBucketID = cfg.getItem("WaterBucket", 4029).getInt();
			NPProperties.LavaBucketID = cfg.getItem("LavaBucket", 4030).getInt();

		}
		catch(Exception ex)
		{
			NPlog.severe("Failed to load configuration");
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
			
			NPlog.info("Initialisation des ID's terminé!");
		}
		
		NetherPlusCreativeTabs.loadCreativeTab();//CreativeTab
		NPBlockList.loadBlock();//Block
		NPItemList.loadItem();//Item
		
		proxy.initSound();//Sound
	}

	@Init
	public void load(FMLInitializationEvent event)
	{
		NPEntityList.loadEntity();//Entity	
		this.removeRecipe(new ItemStack(Block.glowStone));
		
		proxy.registerRender();
		proxy.registerRenderEntity();

		MinecraftForge.EVENT_BUS.register(new GrimBoneMeal());
		MinecraftForge.EVENT_BUS.register(new LivingEvent());
		MinecraftForge.EVENT_BUS.register(new FarmingNether());
		
		NPTEntityList.loadTileEntity();
		NetworkRegistry.instance().registerGuiHandler(this, GuiHandler);
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
