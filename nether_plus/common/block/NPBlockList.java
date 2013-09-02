package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import nether_plus.common.Nether_plus;
import nether_plus.common.config.NPProperties;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPBlockList
{
	public static Block GlowstoneSand;
	public static Block SoulGlass;
	public static Block Netherraze;
	public static Block BewitchedWood;
	public static Block CorruptionStone;
	public static Block CorruptedCobblestone;
	
	public static Block GrimwoodLog;
	public static Block GrimwoodLeaves;
	public static Block GrimwoodSapling;
	
	public static Block CorruptedGoldOre;
	public static Block CorruptedCharoiteOre;
	public static Block CorruptedBlackIronOre;
	public static Block InfernumOre;
	public static Block InfernumBlock;
	public static Block BlackIronBlock;
	public static Block CharoiteBlock;
	
	public static Block GrimwoodPlanks;
	public static Block CorruptedBrick;
	public static Block NetherrackBrick;
	
	public static Block GrimwoodWorkbench;
//	public static Block CorruptedFurnace_Off;
//	public static Block CorruptedFurnace_On;
	public static Block fourOff;
	public static Block fourOn;
	public static Block GrimwoodChest;
	
	public static Block GrimwoodStairs;
	public static Block CorruptedCobblestoneStairs;
	public static Block CorruptedBrickStairs;
	public static Block NetherrackBrickStairs;
	
	public static Block ModWoodSlab;
	public static Block ModWoodDoubleSlab;
	public static Block ModStoneSlab;
	public static Block ModStoneDoubleSlab;
	
	public static Block ModFence;
	public static Block CorruptedCobblestoneWall;
	public static Block CorruptedBrickWall;
	public static Block NetherrackBrickWall;
	
	public static Block WhiteSkull;
	public static Block BlackSkull;
	
	public static Block SoulGlassPane;
	
	public static Block BlockGrimwoodDoor;
	
	public static void loadBlock()
	{
		GlowstoneSand = new GlowstoneSand(NPProperties.GlowstoneSandID, Material.sand).setStepSound(Block.soundSandFootstep).setLightValue(1.0F).setHardness(0.5F).setUnlocalizedName("GlowstoneSand");
		SoulGlass = new SoulGlass(NPProperties.SoulGlassID, Material.glass, false).setStepSound(Block.soundGlassFootstep).setHardness(0.3F).setUnlocalizedName("SoulGlass");
		Netherraze = new Netherraze(NPProperties.NetherrazeID, Material.rock).setStepSound(Block.soundStoneFootstep).setLightValue(0.4F).setHardness(3.0F).setUnlocalizedName("Netherraze");
		BewitchedWood = new BewitchedWood(NPProperties.BewitchedWoodID).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setUnlocalizedName("BewitchedWood");
		CorruptionStone = new CorruptionStone(NPProperties.CorruptionStoneID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(1.0F).setUnlocalizedName("CorruptionStone");
		CorruptedCobblestone = new CorruptedCobblestone(NPProperties.CorruptedCobblestoneID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setUnlocalizedName("CorruptedCobblestone");
		
		GrimwoodLog = new GrimwoodLog(NPProperties.GrimwoodLogID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("GrimwoodLog");
		GrimwoodLeaves = new GrimwoodLeaves(NPProperties.GrimwoodLeavesID).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("GrimwoodLeaves");
		GrimwoodSapling = new GrimwoodSapling(NPProperties.GrimwoodSaplingID).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("GrimwoodSapling");
		
		CorruptedGoldOre = new CorruptedGoldOre(NPProperties.CorruptedGoldOreID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("CorruptedGoldOre");
		CorruptedCharoiteOre = new CorruptedCharoiteOre(NPProperties.CorruptedCharoiteOreID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("CorruptedCharoiteOre");
		CorruptedBlackIronOre = new CorruptedBlackIronOre(NPProperties.CorruptedBlackIronOreID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("CorruptedBlackIronOre");
		InfernumOre = new InfernumOre(NPProperties.InfernumOreID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("InfernumOre");
		InfernumBlock = new InfernumBlock(NPProperties.InfernumBlockID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("InfernumBlock");
		BlackIronBlock = new BlackIronBlock(NPProperties.BlackIronBlockID, Material.iron).setStepSound(Block.soundMetalFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("BlackIronBlock");
		CharoiteBlock = new CharoiteBlock(NPProperties.CharoiteBlockID, Material.iron).setStepSound(Block.soundMetalFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("CharoiteBlock");
		
		GrimwoodPlanks = new GrimwoodPlanks(NPProperties.GrimwoodPlanksID, Material.wood).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("GrimwoodPlanks");
		CorruptedBrick = new CorruptedBrick(NPProperties.CorruptedBrickID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(7.0F).setUnlocalizedName("CorruptedBrick");
		NetherrackBrick = new NetherrackBrick(NPProperties.NetherrackBrickID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(7.0F).setUnlocalizedName("NetherrackBrick");
		GrimwoodWorkbench  = new GrimwoodWorkbench(NPProperties.GrimwoodWorkbenchID).setStepSound(Block.soundWoodFootstep).setHardness(1.5F).setResistance(5.0F).setUnlocalizedName("GrimwoodWorkbench");
		GrimwoodChest = new GrimwoodChest(NPProperties.GrimwoodChestID).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("GrimwoodChest");
		fourOn = new BlockFour(NPProperties.fourOnID, true).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(7.0F).setUnlocalizedName("CorruptedFurnace");
		fourOff = new BlockFour(NPProperties.fourOffID, false).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(7.0F).setUnlocalizedName("CorruptedFurnace").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		
		WhiteSkull = new WhiteSkull(NPProperties.WhiteSkullID).setStepSound(Block.soundStoneFootstep).setHardness(1.0F).setResistance(1.0F).setUnlocalizedName("WhiteSkull");
		BlackSkull = new BlackSkull(NPProperties.BlackSkullID).setStepSound(Block.soundStoneFootstep).setHardness(1.0F).setResistance(1.0F).setUnlocalizedName("BlackSkull");
		
		GrimwoodStairs = new ModStairs(NPProperties.GrimwoodStairsID, GrimwoodPlanks, 0).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("GrimwoodStairs").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		CorruptedCobblestoneStairs = new ModStairs(NPProperties.CorruptedCobblestoneStairsID, CorruptedCobblestone, 0).setStepSound(Block.soundStoneFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("CorruptedCobblestoneStairs").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		CorruptedBrickStairs = new ModStairs(NPProperties.CorruptedBrickStairsID, CorruptedBrick, 0).setStepSound(Block.soundStoneFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("CorruptedBrickStairs").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		NetherrackBrickStairs = new ModStairs(NPProperties.NetherrackBrickStairsID, NetherrackBrick, 0).setStepSound(Block.soundStoneFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("NetherrackBrickStairs").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		
		ModWoodDoubleSlab = new ModWoodSlab(NPProperties.ModWoodDoubleSlabID, true).setStepSound(Block.soundWoodFootstep).setHardness(1.5F).setResistance(5.0F).setUnlocalizedName("ModWoodSlab");
		ModWoodSlab = new ModWoodSlab(NPProperties.ModWoodSlabID, false).setStepSound(Block.soundWoodFootstep).setHardness(1.5F).setResistance(5.0F).setUnlocalizedName("ModWoodSlab");
		ModStoneDoubleSlab = new ModStoneSlab(NPProperties.ModStoneDoubleSlabID, true).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(5.0F).setUnlocalizedName("ModStoneSlab");
		ModStoneSlab = new ModStoneSlab(NPProperties.ModStoneSlabID, false).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(5.0F).setUnlocalizedName("ModStoneSlab");
		
		ModFence = new ModFence(626, "nether_plus:GrimwoodPlanks", Material.wood).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("ModFence");
		CorruptedCobblestoneWall = new CorruptedCobblestoneWall(627, CorruptedCobblestone).setUnlocalizedName("CorruptedCobblestoneWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		CorruptedBrickWall = new CorruptedBrickWall(628, CorruptedBrick).setUnlocalizedName("CorruptedBrickWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		NetherrackBrickWall = new NetherrackBrickWall(629, NetherrackBrick).setUnlocalizedName("NetherrackBrickWall").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		
		SoulGlassPane = new SoulGlassPane(633, "nether_plus:SoulGlasspane", "nether_plus:SoulGlasspane_top", Material.glass, false).setStepSound(Block.soundGlassFootstep).setHardness(0.5F).setResistance(5.0F).setUnlocalizedName("SoulGlassPane").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		BlockGrimwoodDoor = new BlockGrimwoodDoor(NPProperties.BlockGrimwoodDoorID, Material.wood).setHardness(3.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("BlockGrimwoodDoor");
		
		try
		{
		GameRegistry.registerBlock(GlowstoneSand, "Glowstone_Sand");
		GameRegistry.registerBlock(SoulGlass, "Soul_Glass");
		GameRegistry.registerBlock(Netherraze, "Netherraze");
		GameRegistry.registerBlock(BewitchedWood, "bewitched_Wood");
		GameRegistry.registerBlock(CorruptionStone, "Corruption_Stone");
		GameRegistry.registerBlock(CorruptedCobblestone, "Corrupted_Cobblestone");
		
		GameRegistry.registerBlock(GrimwoodLog, "Grimwood_Log");
		GameRegistry.registerBlock(GrimwoodLeaves, "Grimwood_Leaves");
		GameRegistry.registerBlock(GrimwoodSapling, "Grimwood_Sapling");
		
		GameRegistry.registerBlock(CorruptedGoldOre, "Corrupted_Gold_Ore");
		GameRegistry.registerBlock(CorruptedCharoiteOre, "Corrupted_Charoite_Ore");
		GameRegistry.registerBlock(CorruptedBlackIronOre, "Corrupted_Black_Iron_Ore");
		GameRegistry.registerBlock(InfernumOre, "InfernumOre");

		GameRegistry.registerBlock(InfernumBlock, "Infernum_Block");
		GameRegistry.registerBlock(BlackIronBlock, "Black_Iron_Block");
		GameRegistry.registerBlock(CharoiteBlock, "Charoite_Block");
		
		GameRegistry.registerBlock(GrimwoodPlanks, "Grimwood_Planks");
		GameRegistry.registerBlock(CorruptedBrick, "Corrupted_Brick");
		GameRegistry.registerBlock(NetherrackBrick, "Netherrack_Brick");
		GameRegistry.registerBlock(GrimwoodWorkbench, "Grimwood_Workbench");
		GameRegistry.registerBlock(GrimwoodChest, "Grimwood_Chest");
		
		GameRegistry.registerBlock(fourOn, "four_On");
		GameRegistry.registerBlock(fourOff, "four_Off");
		
		GameRegistry.registerBlock(GrimwoodStairs, "Grimwood_Stairs");
		GameRegistry.registerBlock(CorruptedCobblestoneStairs, "Corrupted_Cobblestone_Stairs");
		GameRegistry.registerBlock(CorruptedBrickStairs, "Corrupted_Brick_Stairs");
		GameRegistry.registerBlock(NetherrackBrickStairs, "Netherrack_Brick_Stairs");
		
		GameRegistry.registerBlock(ModWoodSlab, ItemBlockModWoodSlab.class, "Mod_Wood_Slab");
		GameRegistry.registerBlock(ModWoodDoubleSlab, ItemBlockModWoodSlab.class, "Mod_Wood_Double_Slab");
		GameRegistry.registerBlock(ModStoneSlab, ItemBlockModStoneSlab.class, "Mod_Stone_Slab");
		GameRegistry.registerBlock(ModStoneDoubleSlab, ItemBlockModStoneSlab.class, "Mod_Stone_Double_Slab");
		
		GameRegistry.registerBlock(ModFence, "Mod_Fence");
		GameRegistry.registerBlock(CorruptedCobblestoneWall, "Corrupted_Cobblestone_Wall");
		GameRegistry.registerBlock(CorruptedBrickWall, "Corrupted_Brick_Wall");
		GameRegistry.registerBlock(NetherrackBrickWall, "Netherrack_Brick_Wall");
		
		GameRegistry.registerBlock(WhiteSkull, "White_Skull");
		GameRegistry.registerBlock(BlackSkull, "Black_Skull");
		
		GameRegistry.registerBlock(SoulGlassPane, "Soul_Glass_Pane");
		GameRegistry.registerBlock(BlockGrimwoodDoor, "BlockGrimwoodDoor");

		MinecraftForge.setBlockHarvestLevel(CorruptedGoldOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(CorruptedCharoiteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(CorruptedBlackIronOre, "pickaxe", 2);
		}
		catch(Exception ex)
		{
			Nether_plus.NPlog.severe("Erreur lors de l'initialisation des Blocks!");
		}
		Nether_plus.NPlog.info("Initialisation des Blocks terminés!");
	}
}
