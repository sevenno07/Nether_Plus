package nether_plus.common.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPRecipe
{
	public static void loadRecipe()
	{
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GlowstoneSand, 1), new Object[]{"XX", "XX", 'X', Items.glowstone_dust});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonWhiteHelmet, 1), new Object[]{"XXX", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonWhiteChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonWhiteLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonWhiteBoot, 1), new Object[]{"X X", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonBlackHelmet, 1), new Object[]{"XXX", "X X", 'X', NPItemList.blackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonBlackChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.blackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonBlackLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.blackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonBlackBoot, 1), new Object[]{"X X", "X X", 'X', NPItemList.blackBone});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.blackBoneMeal, 3), new Object[]{NPItemList.blackBone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.fourOff, 1), new Object[]{"XXX", "X X", "YYY", 'X', NPBlockList.CorruptedBrick, 'Y', Blocks.obsidian});
		GameRegistry.addShapelessRecipe(new ItemStack(NPBlockList.NetherPlanks, 4, 0), new Object[]{NPBlockList.GrimwoodLog});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodWorkbench, 1), new Object[]{"XX", "XX", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodStick, 4), new Object[]{"X", "X", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodSword, 1), new Object[]{"X", "X", "Y", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodShovel, 1), new Object[]{"X", "Y", "Y", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodHoe, 1), new Object[]{"XX ", " Y ", " Y ", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.InfernumBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.infernumIngot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.BlackIronBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.blackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CharoiteBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.charoiteCrystal});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodChest, 1), new Object[]{"XXX", "X X", "XXX", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.charoiteCrystal, 9), new Object[]{NPBlockList.CharoiteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.infernumIngot, 9), new Object[]{NPBlockList.InfernumBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.blackIronIngot, 9), new Object[]{NPBlockList.BlackIronBlock});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedBrickStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedCobblestoneStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.NetherrackBrickStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedBrickWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedCobblestoneWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModFence, 4), new Object[]{"XXX", "XXX", 'X', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.NetherrackBrickWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 1), new Object[]{"XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 0), new Object[]{"XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModWoodSlab, 6, 0), new Object[]{"XXX", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 2), new Object[]{"XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.itemGrimwoodDoor, 1), new Object[]{"XX", "XX", "XX", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPItemList.deadBread, 1), new Object[]{"XXX", 'X', NPItemList.whiteWheat});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronHelmet, 1), new Object[]{"XXX", "X X", 'X', NPItemList.blackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.blackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.blackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronBoot, 1), new Object[]{"X X", "X X", 'X', NPItemList.blackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronSword, 1), new Object[]{"X", "X", "Y", 'X', NPItemList.blackIronIngot, 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', NPItemList.blackIronIngot, 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', NPItemList.blackIronIngot, 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronShovel, 1), new Object[]{"X", "Y", "Y", 'X', NPItemList.blackIronIngot, 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.blackIronHoe, 1), new Object[]{"XX ", " Y ", " Y ", 'X', NPItemList.blackIronIngot, 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.salamanderHelmet, 1), new Object[]{"XXX", "X X", 'X', NPItemList.salamanderLeather});
		GameRegistry.addRecipe(new ItemStack(NPItemList.salamanderChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.salamanderLeather});
		GameRegistry.addRecipe(new ItemStack(NPItemList.salamanderLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.salamanderLeather});
		GameRegistry.addRecipe(new ItemStack(NPItemList.salamanderBoot, 1), new Object[]{"X X", "X X", 'X', NPItemList.salamanderLeather});
		GameRegistry.addRecipe(new ItemStack(NPItemList.chiliSeed, 1), new Object[]{"X", 'X', NPItemList.chili});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ChiliB, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.chili});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodTorch, 4), new Object[]{"X", "Y",  'X', NPItemList.charoiteCrystal, 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.Ladder, 3), new Object[]{"X X", "XXX", "X X", 'X', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.goldBucket, 1), new Object[]{"X X", " X ", 'X', Items.gold_ingot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.SoulGlassPane, 16), new Object[]{"XXX", "XXX", 'X', NPBlockList.SoulGlass});
	}
	
	public static void loadSmelting()
	{
		GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(NPBlockList.SoulGlass), 2.0F);
		GameRegistry.addSmelting(NPBlockList.GlowstoneSand, new ItemStack(Blocks.glowstone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedGoldOre, new ItemStack(Items.gold_ingot), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedBlackIronOre, new ItemStack(NPItemList.blackIronIngot), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedCharoiteOre, new ItemStack(NPItemList.charoiteCrystal), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptionStone, new ItemStack(NPBlockList.CorruptedCobblestone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.InfernumOre, new ItemStack(NPItemList.infernumIngot), 2.0F);
	}
}