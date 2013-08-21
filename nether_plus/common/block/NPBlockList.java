package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import nether_plus.common.NetherPlusCreativeTabs;
import nether_plus.common.config.NPProperties;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPBlockList
{
	public static Block GlowstoneSand;
	public static Block SoulGlass;
	public static Block Netherraze;
	public static Block BewitchedWood;
	public static Block CorruptionStone;
	
	public static Block GrimwoodLog;
	public static Block GrimwoodLeaves;
	public static Block GrimwoodSapling;
	
	public static Block CorruptedGoldOre;
	public static Block CorruptedCharoiteOre;
	public static Block CorruptedBlackIronOre;
	
	public static Block GrimwoodPlanks;
	public static Block CorruptedBrick;
	public static Block NetherrackBrick;
	public static Block GrimwoodWorkbench;
	
	public static Block GrimwoodStairs;
	public static Block CorruptedBrickStairs;
	public static Block NetherrackBrickStairs;
	
	public static BlockHalfSlab ModWoodSlab;
	public static BlockHalfSlab ModWoodDoubleSlab;

	public static void loadBlock()
	{
		GlowstoneSand = new GlowstoneSand(NPProperties.GlowstoneSandID, Material.sand).setStepSound(Block.soundSandFootstep).setLightValue(1.0F).setHardness(0.5F).setUnlocalizedName("GlowstoneSand");
		SoulGlass = new SoulGlass(NPProperties.SoulGlassID, Material.glass, false).setStepSound(Block.soundGlassFootstep).setHardness(0.3F).setUnlocalizedName("SoulGlass");
		Netherraze = new Netherraze(NPProperties.NetherrazeID, Material.rock).setStepSound(Block.soundStoneFootstep).setLightValue(0.4F).setHardness(3.0F).setUnlocalizedName("Netherraze");
		BewitchedWood = new BewitchedWood(NPProperties.BewitchedWoodID).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setUnlocalizedName("BewitchedWood");
		CorruptionStone = new CorruptionStone(NPProperties.CorruptionStoneID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setUnlocalizedName("CorruptionStone");
		
		GrimwoodLog = new GrimwoodLog(NPProperties.GrimwoodLogID).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("GrimwoodLog");
		GrimwoodLeaves = new GrimwoodLeaves(NPProperties.GrimwoodLeavesID).setHardness(0.5F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("GrimwoodLeaves");
		GrimwoodSapling = new GrimwoodSapling(NPProperties.GrimwoodSaplingID).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("GrimwoodSapling");
		
		CorruptedGoldOre = new CorruptedGoldOre(NPProperties.CorruptedGoldOreID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("CorruptedGoldOre");
		CorruptedCharoiteOre = new CorruptedCharoiteOre(NPProperties.CorruptedCharoiteOreID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("CorruptedCharoiteOre");
		CorruptedBlackIronOre = new CorruptedBlackIronOre(NPProperties.CorruptedBlackIronOreID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("CorruptedBlackIronOre");
		
		GrimwoodPlanks = new GrimwoodPlanks(NPProperties.GrimwoodPlanksID, Material.wood).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("GrimwoodPlanks");
		CorruptedBrick = new CorruptedBrick(NPProperties.CorruptedBrickID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(7.0F).setUnlocalizedName("CorruptedBrick");
		NetherrackBrick = new NetherrackBrick(NPProperties.NetherrackBrickID, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(7.0F).setUnlocalizedName("NetherrackBrick");
		GrimwoodWorkbench  = new GrimwoodWorkbench(NPProperties.GrimwoodWorkbenchID).setStepSound(Block.soundWoodFootstep).setHardness(1.5F).setResistance(5.0F).setUnlocalizedName("GrimwoodWorkbench");
		
		GrimwoodStairs = new ModStairs(NPProperties.GrimwoodStairsID, GrimwoodPlanks, 0).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("GrimwoodStairs").setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
		CorruptedBrickStairs = new ModStairs(NPProperties.CorruptedBrickStairsID, CorruptedBrick, 0).setStepSound(Block.soundStoneFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("CorruptedBrickStairs").setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
		NetherrackBrickStairs = new ModStairs(NPProperties.NetherrackBrickStairsID, NetherrackBrick, 0).setStepSound(Block.soundStoneFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("NetherrackBrickStairs").setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
		
		ModWoodSlab = (BlockHalfSlab) new ModWoodSlab(NPProperties.ModWoodSlabID, false).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("ModSlab");
		ModWoodDoubleSlab = (BlockHalfSlab) new ModWoodSlab(NPProperties.ModWoodDoubleSlabID, true).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("ModSlab");

		GameRegistry.registerBlock(GlowstoneSand, "Glowstone_Sand");
		GameRegistry.registerBlock(SoulGlass, "Soul_Glass");
		GameRegistry.registerBlock(Netherraze, "Netherraze");
		GameRegistry.registerBlock(BewitchedWood, "bewitched_Wood");
		GameRegistry.registerBlock(CorruptionStone, "Corruption_Stone");
		
		GameRegistry.registerBlock(GrimwoodLog, "Grimwood_Log");
		GameRegistry.registerBlock(GrimwoodLeaves, "Grimwood_Leaves");
		GameRegistry.registerBlock(GrimwoodSapling, "Grimwood_Sapling");
		
		GameRegistry.registerBlock(CorruptedGoldOre, "Corrupted_Gold_Ore");
		GameRegistry.registerBlock(CorruptedCharoiteOre, "Corrupted_Charoite_Ore");
		GameRegistry.registerBlock(CorruptedBlackIronOre, "Corrupted_Black_Iron_Ore");
		
		GameRegistry.registerBlock(GrimwoodPlanks, "Grimwood_Planks");
		GameRegistry.registerBlock(CorruptedBrick, "Corrupted_Brick");
		GameRegistry.registerBlock(NetherrackBrick, "Netherrack_Brick");
		GameRegistry.registerBlock(GrimwoodWorkbench, "Grimwood_Workbench");
		
		GameRegistry.registerBlock(GrimwoodStairs, "Grimwood_Stairs");
		GameRegistry.registerBlock(CorruptedBrickStairs, "Corrupted_Brick_Stairs");
		GameRegistry.registerBlock(NetherrackBrickStairs, "Netherrack_Brick_Stairs");
		
		GameRegistry.registerBlock(ModWoodSlab);
		GameRegistry.registerBlock(ModWoodDoubleSlab);
		
		MinecraftForge.setBlockHarvestLevel(CorruptedGoldOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(CorruptedCharoiteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(CorruptedBlackIronOre, "pickaxe", 2);
	}
}
