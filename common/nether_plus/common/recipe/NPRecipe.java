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
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteHelmet, 1), new Object[]{"XXX", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteBoot, 1), new Object[]{"X X", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackHelmet, 1), new Object[]{"XXX", "X X", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackBoot, 1), new Object[]{"X X", "X X", 'X', NPItemList.BlackBone});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.BlackBoneMeal, 3), new Object[]{NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.fourOff, 1), new Object[]{"XXX", "X X", "YYY", 'X', NPBlockList.CorruptedBrick, 'Y', Blocks.obsidian});
		GameRegistry.addShapelessRecipe(new ItemStack(NPBlockList.NetherPlanks, 4, 0), new Object[]{NPBlockList.GrimwoodLog});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodWorkbench, 1), new Object[]{"XX", "XX", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodStick, 4), new Object[]{"X", "X", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodSword, 1), new Object[]{"X", "X", "Y", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodShovel, 1), new Object[]{"X", "Y", "Y", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodHoe, 1), new Object[]{"XX ", " Y ", " Y ", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0), 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.InfernumBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.InfernumIngot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.BlackIronBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.BlackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CharoiteBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.CharoiteCrystal});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodChest, 1), new Object[]{"XXX", "X X", "XXX", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.CharoiteCrystal, 9), new Object[]{NPBlockList.CharoiteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.InfernumIngot, 9), new Object[]{NPBlockList.InfernumBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.BlackIronIngot, 9), new Object[]{NPBlockList.BlackIronBlock});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedBrickStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedCobblestoneStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.NetherPlanks});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.NetherrackBrickStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedBrickWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedCobblestoneWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModFence, 4), new Object[]{"XXX", "XXX", 'X', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.NetherrackBrickWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 1), new Object[]{"XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 0), new Object[]{"XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModWoodSlab, 6, 0), new Object[]{"XXX", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 2), new Object[]{"XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.ItemGrimwoodDoor, 1), new Object[]{"XX", "XX", "XX", 'X', new ItemStack(NPBlockList.NetherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPItemList.DeadBread, 1), new Object[]{"XXX", 'X', NPItemList.WhiteWheat});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronHelmet, 1), new Object[]{"XXX", "X X", 'X', NPItemList.BlackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.BlackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.BlackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronBoot, 1), new Object[]{"X X", "X X", 'X', NPItemList.BlackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronSword, 1), new Object[]{"X", "X", "Y", 'X', NPItemList.BlackIronIngot, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', NPItemList.BlackIronIngot, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', NPItemList.BlackIronIngot, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronShovel, 1), new Object[]{"X", "Y", "Y", 'X', NPItemList.BlackIronIngot, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.BlackIronHoe, 1), new Object[]{"XX ", " Y ", " Y ", 'X', NPItemList.BlackIronIngot, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SalamanderHelmet, 1), new Object[]{"XXX", "X X", 'X', NPItemList.SalamanderLeather});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SalamanderChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.SalamanderLeather});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SalamanderLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.SalamanderLeather});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SalamanderBoot, 1), new Object[]{"X X", "X X", 'X', NPItemList.SalamanderLeather});
		GameRegistry.addRecipe(new ItemStack(NPItemList.ChiliSeed, 1), new Object[]{"X", 'X', NPItemList.Chili});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ChiliB, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.Chili});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodTorch, 4), new Object[]{"X", "Y",  'X', Items.coal, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodTorch, 4), new Object[]{"X", "Y",  'X', new ItemStack(Items.coal, 1, 1), 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.Ladder, 3), new Object[]{"X X", "XXX", "X X", 'X', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GoldBucket, 1), new Object[]{"X X", " X ", 'X', Items.gold_ingot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.SoulGlassPane, 16), new Object[]{"XXX", "XXX", 'X', NPBlockList.SoulGlass});
	}
	
	public static void loadSmelting()
	{
		GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(NPBlockList.SoulGlass), 2.0F);
		GameRegistry.addSmelting(NPBlockList.GlowstoneSand, new ItemStack(Blocks.glowstone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedGoldOre, new ItemStack(Items.gold_ingot), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedBlackIronOre, new ItemStack(NPItemList.BlackIronIngot), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedCharoiteOre, new ItemStack(NPItemList.CharoiteCrystal), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptionStone, new ItemStack(NPBlockList.CorruptedCobblestone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.InfernumOre, new ItemStack(NPItemList.InfernumIngot), 2.0F);
	}
}