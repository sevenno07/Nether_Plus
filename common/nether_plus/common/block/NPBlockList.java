package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import nether_plus.common.Nether_plus;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPBlockList
{
	public static Block glowstoneSand;
	public static Block soulGlass;
	public static Block netherraze;
	public static Block bewitchedWood;
	public static Block corruptionStone;
	public static Block corruptedCobblestone;
	
	public static Block grimwoodLog;
	public static Block grimwoodLeaves;
	public static Block grimwoodSapling;
	
	public static Block corruptedGoldOre;
	public static Block corruptedCharoiteOre;
	public static Block corruptedBlackIronOre;
	public static Block infernumOre;
	public static Block infernumBlock;
	public static Block blackIronBlock;
	public static Block charoiteBlock;
	
	public static Block netherPlanks;
	public static Block corruptedBrick;
	public static Block netherrackBrick;
	
	public static Block grimwoodWorkbench;
	public static Block fourOff;
	public static Block fourOn;
	public static Block grimwoodChest;
	
	public static Block grimwoodStairs;
	public static Block corruptedCobblestoneStairs;
	public static Block corruptedBrickStairs;
	public static Block netherrackBrickStairs;
	
	public static Block modWoodSlab;
	public static Block modWoodDoubleSlab;
	public static Block modStoneSlab;
	public static Block modStoneDoubleSlab;
	
	public static Block modFence;
	public static Block corruptedCobblestoneWall;
	public static Block corruptedBrickWall;
	public static Block netherrackBrickWall;
	
	public static Block whiteSkull;
	public static Block blackSkull;
	
	public static Block soulGlassPane;
	
	public static Block blockGrimwoodDoor;
	public static Block blockBlackironDoor;
	
	public static Block nether_Farm;
	public static Block crops;
	public static Block chiliC;
	public static Block chiliB;
	public static Block riceC;
	
	public static Block ladder;
	public static Block netherRail;
	public static Block netherDetectorRail;
	public static Block netherPoweredRail;
	public static Block grimwoodTorch;
	public static Block netherDonjonSpawner;
	
	//Liquid
	public static Fluid quickSilver;
	public static Fluid soulPlasm;
	public static Fluid acid;
	public static Block blockQuicksilver;
	public static Block blockSoulplasm;
	public static Block blockAcid;
	
	public static Block steelWool;
	
	public static void loadBlock()
	{
		//liquides
		quickSilver = new Fluid("quickSilver").setDensity(4000).setViscosity(1000).setTemperature(288).setLuminosity(0).setUnlocalizedName("quickSilver");
		soulPlasm = new Fluid("soulPlasm").setDensity(4000).setViscosity(6000).setTemperature(288).setLuminosity(0).setUnlocalizedName("soulPlasm");
		acid = new Fluid("acid").setDensity(4000).setViscosity(1000).setTemperature(288).setLuminosity(0).setUnlocalizedName("acid");
		FluidRegistry.registerFluid(quickSilver);
		FluidRegistry.registerFluid(soulPlasm);
		FluidRegistry.registerFluid(acid);

		blockQuicksilver = new Quicksilver(quickSilver, Material.water).setBlockName("Quicksilver");
		GameRegistry.registerBlock(blockQuicksilver, "Quicksilver");
		quickSilver.setBlock(blockQuicksilver);

		blockSoulplasm = new Soulplasm(soulPlasm, Material.lava).setLightLevel(1.0F).setBlockName("Soulplasm");
		GameRegistry.registerBlock(blockSoulplasm, "Soulplasm");
		soulPlasm.setBlock(blockSoulplasm);

		blockAcid = new Acid(acid, Material.water).setBlockName("AcidStill");
		GameRegistry.registerBlock(blockAcid, "Acid");
		acid.setBlock(blockAcid);

		glowstoneSand = new GlowstoneSand(Material.sand).setStepSound(Block.soundTypeSand).setLightLevel(1.0F).setHardness(0.5F).setBlockName("GlowstoneSand").setBlockTextureName("nether_plus:GlowstoneSand");
		soulGlass = new SoulGlass(Material.glass, false).setStepSound(Block.soundTypeGlass).setHardness(0.3F).setBlockName("SoulGlass").setBlockTextureName("nether_plus:SoulGlass");
		netherraze = new Netherraze().setStepSound(Block.soundTypeStone).setLightLevel(0.4F).setHardness(3.0F).setBlockName("Netherraze");
		bewitchedWood = new BewitchedWood().setStepSound(Block.soundTypeWood).setHardness(2.0F).setBlockName("BewitchedWood");
		corruptionStone = new CorruptionStone().setStepSound(Block.soundTypeStone).setHardness(1.0F).setBlockName("CorruptionStone").setBlockTextureName("nether_plus:CorruptionStone");
		corruptedCobblestone = new CorruptedCobblestone().setStepSound(Block.soundTypeStone).setHardness(1.5F).setBlockName("CorruptedCobblestone");
		
		grimwoodSapling = new GrimwoodSapling().setStepSound(Block.soundTypeGrass).setResistance(5.0F).setBlockName("GrimwoodSapling");
		grimwoodLog = new GrimwoodLog().setStepSound(Block.soundTypeWood).setHardness(1.0F).setResistance(5.0F).setBlockName("GrimwoodLog");
		grimwoodLeaves = new GrimwoodLeaves().setStepSound(Block.soundTypeGrass).setHardness(0.2F).setResistance(5.0F).setBlockName("GrimwoodLeaves");
		
		corruptedGoldOre = new CorruptedGoldOre().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("CorruptedGoldOre").setBlockTextureName("nether_plus:CorruptedGoldOre");
		corruptedCharoiteOre = new CorruptedCharoiteOre().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("CorruptedCharoiteOre").setBlockTextureName("nether_plus:CorruptedCharoiteOre");
		corruptedBlackIronOre = new CorruptedBlackIronOre().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("CorruptedBlackIronOre").setBlockTextureName("nether_plus:CorruptedBlackIronOre");
		infernumOre = new InfernumOre().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("InfernumOre").setBlockTextureName("nether_plus:InfernumOre");
		infernumBlock = new InfernumBlock().setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F).setBlockName("InfernumBlock").setBlockTextureName("nether_plus:InfernumBlock");
		blackIronBlock = new BlackIronBlock().setStepSound(Block.soundTypeMetal).setHardness(3.0F).setResistance(5.0F).setBlockName("BlackIronBlock").setBlockTextureName("nether_plus:BlackIronBlock");
		charoiteBlock = new CharoiteBlock().setStepSound(Block.soundTypeMetal).setHardness(3.0F).setResistance(5.0F).setBlockName("CharoiteBlock").setBlockTextureName("nether_plus:CharoiteBlock");
		
		netherPlanks = new Nether_Planks().setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("GrimwoodPlanks").setBlockTextureName("nether_plus:GrimwoodPlanks");
		corruptedBrick = new CorruptedBrick().setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(7.0F).setBlockName("CorruptedBrick").setBlockTextureName("nether_plus:CorruptedBrick");
		netherrackBrick = new NetherrackBrick().setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(7.0F).setBlockName("NetherrackBrick").setBlockTextureName("nether_plus:NetherrackBrick");
		grimwoodWorkbench  = new GrimwoodWorkbench().setStepSound(Block.soundTypeWood).setHardness(1.5F).setResistance(5.0F).setBlockName("GrimwoodWorkbench");
		grimwoodChest = new GrimwoodChest(0).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("GrimwoodChest");
		fourOn = new BlockFour(true).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(7.0F).setBlockName("CorruptedFurnace");
		fourOff = new BlockFour(false).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(7.0F).setBlockName("CorruptedFurnace").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		
		whiteSkull = new WhiteSkull().setStepSound(Block.soundTypeStone).setHardness(1.0F).setResistance(1.0F).setBlockName("WhiteSkull");
		blackSkull = new BlackSkull().setStepSound(Block.soundTypeStone).setHardness(1.0F).setResistance(1.0F).setBlockName("BlackSkull");
		
		grimwoodStairs = new ModStairs(netherPlanks, 0).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("GrimwoodStairs");
		corruptedCobblestoneStairs = new ModStairs(corruptedCobblestone, 0).setStepSound(Block.soundTypeStone).setHardness(2.0F).setResistance(5.0F).setBlockName("CorruptedCobblestoneStairs");
		corruptedBrickStairs = new ModStairs(corruptedBrick, 0).setStepSound(Block.soundTypeStone).setHardness(2.0F).setResistance(5.0F).setBlockName("CorruptedBrickStairs");
		netherrackBrickStairs = new ModStairs(netherrackBrick, 0).setStepSound(Block.soundTypeStone).setHardness(2.0F).setResistance(5.0F).setBlockName("NetherrackBrickStairs");
		
		modWoodSlab = new ModWoodSlab(false).setStepSound(Block.soundTypeWood).setHardness(1.5F).setResistance(5.0F).setBlockName("ModWoodSlab").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		modWoodDoubleSlab = new ModWoodSlab(true).setStepSound(Block.soundTypeWood).setHardness(1.5F).setResistance(5.0F).setBlockName("ModWoodSlab");
		modStoneSlab = new ModStoneSlab(false).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(5.0F).setBlockName("ModStoneSlab").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		modStoneDoubleSlab = new ModStoneSlab(true).setStepSound(Block.soundTypeStone).setHardness(1.5F).setResistance(5.0F).setBlockName("ModStoneSlab");
		
		modFence = new ModFence("nether_plus:GrimwoodPlanks", Material.wood).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("ModFence");
		corruptedCobblestoneWall = new CorruptedCobblestoneWall(corruptedCobblestone).setBlockName("CorruptedCobblestoneWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		corruptedBrickWall = new CorruptedBrickWall(corruptedBrick).setBlockName("CorruptedBrickWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		netherrackBrickWall = new NetherrackBrickWall(netherrackBrick).setBlockName("NetherrackBrickWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		
		soulGlassPane = new SoulGlassPane("nether_plus:SoulGlasspane", "nether_plus:SoulGlasspane_top", Material.glass, false).setStepSound(Block.soundTypeGlass).setHardness(0.5F).setResistance(5.0F).setBlockName("SoulGlassPane").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		blockGrimwoodDoor = new BlockModDoor(Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("BlockGrimwoodDoor").setBlockTextureName("nether_plus:doorGrimwood");
		blockBlackironDoor = new BlockModDoor(Material.iron).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setBlockName("BlockBlackironDoor").setBlockTextureName("nether_plus:doorBlackiron");
		
		nether_Farm = new Nether_Farm().setStepSound(Block.soundTypeSand).setHardness(0.5F).setBlockName("Nether_Farm");
		crops = new Crops().setBlockName("Crops");
		chiliB = new ChiliB().setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("ChiliB");
		chiliC = new ChiliC(chiliB).setBlockName("ChiliC").setBlockTextureName("nether_plus:stem");
		riceC = new RiceC().setBlockName("RiceC");
		
		ladder = new Ladder().setStepSound(Block.soundTypeLadder).setHardness(0.4F).setResistance(5.0F).setBlockName("Ladder");
		netherRail = new NetherRail().setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("NetherRail").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock).setBlockTextureName("nether_plus:NetherRail");
		netherDetectorRail = new NetherDetectorRail().setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("NetherDetectorRail").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		netherPoweredRail = new NetherPoweredRail().setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("NetherPoweredRail").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock).setBlockTextureName("nether_plus:NetherPoweredRail");
		grimwoodTorch = new GrimwoodTorch().setStepSound(Block.soundTypeWood).setLightLevel(0.9375F).setHardness(0.0F).setResistance(5.0F).setBlockName("GrimwoodTorch");
		netherDonjonSpawner = new NetherDonjonSpawner().setStepSound(Block.soundTypeMetal).setHardness(5.0F).setResistance(5.0F).setBlockName("NetherDonjonSpawner");
		
		steelWool = new SteelWool().setStepSound(Block.soundTypeCloth).setHardness(2.0F).setResistance(5.0F).setBlockName("SteelWool");
		
		try
		{
		GameRegistry.registerBlock(glowstoneSand, "Glowstone_Sand");
		GameRegistry.registerBlock(soulGlass, "Soul_Glass");
		GameRegistry.registerBlock(netherraze, "Netherraze");
		GameRegistry.registerBlock(bewitchedWood, "bewitched_Wood");
		GameRegistry.registerBlock(corruptionStone, "Corruption_Stone");
		GameRegistry.registerBlock(corruptedCobblestone, "Corrupted_Cobblestone");
		
		GameRegistry.registerBlock(grimwoodLog, "Grimwood_Log");
		GameRegistry.registerBlock(grimwoodLeaves, "Grimwood_Leaves");
		GameRegistry.registerBlock(grimwoodSapling, "Grimwood_Sapling");
		
		GameRegistry.registerBlock(corruptedGoldOre, "Corrupted_Gold_Ore");
		GameRegistry.registerBlock(corruptedCharoiteOre, "Corrupted_Charoite_Ore");
		GameRegistry.registerBlock(corruptedBlackIronOre, "Corrupted_Black_Iron_Ore");
		GameRegistry.registerBlock(infernumOre, "InfernumOre");

		GameRegistry.registerBlock(infernumBlock, "Infernum_Block");
		GameRegistry.registerBlock(blackIronBlock, "Black_Iron_Block");
		GameRegistry.registerBlock(charoiteBlock, "Charoite_Block");
		
		GameRegistry.registerBlock(netherPlanks, "Nether_Planks");
		GameRegistry.registerBlock(corruptedBrick, "Corrupted_Brick");
		GameRegistry.registerBlock(netherrackBrick, "Netherrack_Brick");
		GameRegistry.registerBlock(grimwoodWorkbench, "Grimwood_Workbench");
		GameRegistry.registerBlock(grimwoodChest, "Grimwood_Chest");
		
		GameRegistry.registerBlock(fourOn, "CorruptedFurnace_on");
		GameRegistry.registerBlock(fourOff, "CorruptedFurnace");
		
		GameRegistry.registerBlock(grimwoodStairs, "Grimwood_Stairs");
		GameRegistry.registerBlock(corruptedCobblestoneStairs, "Corrupted_Cobblestone_Stairs");
		GameRegistry.registerBlock(corruptedBrickStairs, "Corrupted_Brick_Stairs");
		GameRegistry.registerBlock(netherrackBrickStairs, "Netherrack_Brick_Stairs");		
		
/*		// TODO fix slab
		GameRegistry.registerBlock(modWoodSlab, ItemBlockModWoodSlab.class, "Mod_Wood_Slab", "nether_plus");
		GameRegistry.registerBlock(modWoodDoubleSlab, ItemBlockModWoodSlab.class, "Mod_Wood_Double_Slab", "nether_plus");
		GameRegistry.registerBlock(modStoneSlab, ItemBlockModStoneSlab.class, "Mod_Stone_Slab", "nether_plus");
		GameRegistry.registerBlock(modStoneDoubleSlab, ItemBlockModStoneSlab.class, "Mod_Stone_Double_Slab", "nether_plus");*/
		
		GameRegistry.registerBlock(modFence, "Mod_Fence");
		GameRegistry.registerBlock(corruptedCobblestoneWall, "Corrupted_Cobblestone_Wall");
		GameRegistry.registerBlock(corruptedBrickWall, "Corrupted_Brick_Wall");
		GameRegistry.registerBlock(netherrackBrickWall, "Netherrack_Brick_Wall");
		
		GameRegistry.registerBlock(whiteSkull, "White_Skull");
		GameRegistry.registerBlock(blackSkull, "Black_Skull");
		
		GameRegistry.registerBlock(soulGlassPane, "Soul_Glass_Pane");
		GameRegistry.registerBlock(blockGrimwoodDoor, "Bloc_Grimwood_Door");
		GameRegistry.registerBlock(blockBlackironDoor, "Block_Blackiron_Door");
		GameRegistry.registerBlock(nether_Farm, "Nether_Farm");
		GameRegistry.registerBlock(crops, "Crops");
		GameRegistry.registerBlock(chiliC, "Chili_Crops");
		GameRegistry.registerBlock(chiliB, "Chili_Block");
		GameRegistry.registerBlock(riceC, "RiceC");
		
		GameRegistry.registerBlock(ladder, "Ladder");
		GameRegistry.registerBlock(netherRail, "Nether_Rail");
		GameRegistry.registerBlock(netherDetectorRail, "Nether_Detector_Rail");
		GameRegistry.registerBlock(netherPoweredRail, "Nether_Powered_Rail");
		GameRegistry.registerBlock(grimwoodTorch, "Grimwood_Torch");
		GameRegistry.registerBlock(netherDonjonSpawner, "Nether_Donjon_Spawner");
		
		GameRegistry.registerBlock(steelWool, "Iron_Wool");

		//MinecraftForge.setBlockHarvestLevel(CorruptedGoldOre, "pickaxe", 2);
		//MinecraftForge.setBlockHarvestLevel(CorruptedCharoiteOre, "pickaxe", 2);
		//MinecraftForge.setBlockHarvestLevel(CorruptedBlackIronOre, "pickaxe", 2);
		}
		catch(Exception ex)
		{
			Nether_plus.NPlog.severe("Erreur lors de l'initialisation des Blocks!");
		}
		Nether_plus.NPlog.info("Initialisation des Blocks terminés!");
	}
}