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

	}
	
	public static void loadSmelting()
	{
		GameRegistry.addSmelting(Block.slowSand.blockID, new ItemStack(NPBlockList.SoulGlass), 2.0F);
		GameRegistry.addSmelting(NPBlockList.GlowstoneSand.blockID, new ItemStack(Block.glowStone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedGoldOre.blockID, new ItemStack(Item.ingotGold), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedBlackIronOre.blockID, new ItemStack(NPItemList.BlackIronIngot), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedCharoiteOre.blockID, new ItemStack(NPItemList.CharoiteCrystal), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedCobblestone.blockID, new ItemStack(NPBlockList.CorruptionStone), 2.0F);
	}
}
