package nether_plus.common.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPRecipe
{
	public static void loadRecipe()
	{
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GlowstoneSand, 1), new Object[]{"XX", "XX", 'X', Item.lightStoneDust});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteHelmet, 1), new Object[]{"XXX", "X X", 'X', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteBoot, 1), new Object[]{"X X", "X X", 'X', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackHelmet, 1), new Object[]{"XXX", "X X", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackBoot, 1), new Object[]{"X X", "X X", 'X', NPItemList.BlackBone});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.BlackBoneMeal, 3), new Object[]{NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.fourOff, 1), new Object[]{"XXX", "X X", "YYY", 'X', NPBlockList.CorruptedBrick, 'Y', Block.obsidian});
		GameRegistry.addShapelessRecipe(new ItemStack(NPBlockList.GrimwoodPlanks, 4), new Object[]{NPBlockList.GrimwoodLog});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodWorkbench, 1), new Object[]{"XX", "XX", 'X', NPBlockList.GrimwoodPlanks});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodStick, 4), new Object[]{"X", "X", 'X', NPBlockList.GrimwoodPlanks});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodSword, 1), new Object[]{"X", "X", "Y", 'X', NPBlockList.GrimwoodPlanks, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', NPBlockList.GrimwoodPlanks, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', NPBlockList.GrimwoodPlanks, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodShovel, 1), new Object[]{"X", "Y", "Y", 'X', NPBlockList.GrimwoodPlanks, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.GrimwoodHoe, 1), new Object[]{"XX ", " Y ", " Y ", 'X', NPBlockList.GrimwoodPlanks, 'Y', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.InfernumBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.InfernumIngot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.BlackIronBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.BlackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CharoiteBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.CharoiteCrystal});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodChest, 1), new Object[]{"XXX", "X X", "XXX", 'X', NPBlockList.GrimwoodPlanks});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.CharoiteCrystal, 9), new Object[]{NPBlockList.CharoiteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.InfernumIngot, 9), new Object[]{NPBlockList.InfernumBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.BlackIronIngot, 9), new Object[]{NPBlockList.BlackIronBlock});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedBrickStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedCobblestoneStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GrimwoodStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.GrimwoodPlanks});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.NetherrackBrickStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedBrickWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.CorruptedCobblestoneWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModFence, 4), new Object[]{"XXX", "XXX", 'X', NPItemList.GrimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.NetherrackBrickWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 1), new Object[]{"XXX", 'X', NPBlockList.CorruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 0), new Object[]{"XXX", 'X', NPBlockList.CorruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModWoodSlab, 6, 0), new Object[]{"XXX", 'X', NPBlockList.GrimwoodPlanks});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ModStoneSlab, 6, 2), new Object[]{"XXX", 'X', NPBlockList.NetherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.ItemGrimwoodDoor, 1), new Object[]{"XX", "XX", "XX", 'X', NPBlockList.GrimwoodPlanks});
	}
	
	public static void loadSmelting()
	{
		GameRegistry.addSmelting(Block.slowSand.blockID, new ItemStack(NPBlockList.SoulGlass), 2.0F);
		GameRegistry.addSmelting(NPBlockList.GlowstoneSand.blockID, new ItemStack(Block.glowStone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedGoldOre.blockID, new ItemStack(Item.ingotGold), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedBlackIronOre.blockID, new ItemStack(NPItemList.BlackIronIngot), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedCharoiteOre.blockID, new ItemStack(NPItemList.CharoiteCrystal), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptionStone.blockID, new ItemStack(NPBlockList.CorruptedCobblestone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.InfernumOre.blockID, new ItemStack(NPItemList.InfernumIngot), 2.0F);
	}
}
