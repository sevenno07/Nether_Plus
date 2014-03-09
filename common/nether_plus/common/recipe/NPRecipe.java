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
		GameRegistry.addRecipe(new ItemStack(NPBlockList.glowstoneSand, 1), new Object[]{"XX", "XX", 'X', Items.glowstone_dust});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonWhiteHelmet, 1), new Object[]{"XXX", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonWhiteChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonWhiteLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonWhiteBoot, 1), new Object[]{"X X", "X X", 'X', Items.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonBlackHelmet, 1), new Object[]{"XXX", "X X", 'X', NPItemList.blackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonBlackChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.blackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonBlackLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.blackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.skeletonBlackBoot, 1), new Object[]{"X X", "X X", 'X', NPItemList.blackBone});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.blackBoneMeal, 3), new Object[]{NPItemList.blackBone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.fourOff, 1), new Object[]{"XXX", "X X", "YYY", 'X', NPBlockList.corruptedBrick, 'Y', Blocks.obsidian});
		GameRegistry.addShapelessRecipe(new ItemStack(NPBlockList.netherPlanks, 4, 0), new Object[]{NPBlockList.grimwoodLog});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.grimwoodWorkbench, 1), new Object[]{"XX", "XX", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodStick, 4), new Object[]{"X", "X", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodSword, 1), new Object[]{"X", "X", "Y", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodShovel, 1), new Object[]{"X", "Y", "Y", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodHoe, 1), new Object[]{"XX ", " Y ", " Y ", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0), 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.infernumBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.infernumIngot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.blackIronBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.blackIronIngot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.charoiteBlock, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.charoiteCrystal});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.grimwoodChest, 1), new Object[]{"XXX", "X X", "XXX", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.charoiteCrystal, 9), new Object[]{NPBlockList.charoiteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.infernumIngot, 9), new Object[]{NPBlockList.infernumBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(NPItemList.blackIronIngot, 9), new Object[]{NPBlockList.blackIronBlock});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.corruptedBrickStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.corruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.corruptedCobblestoneStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.corruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.grimwoodStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.netherPlanks});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.netherrackBrickStairs, 4), new Object[]{"X  ", "XX ", "XXX", 'X', NPBlockList.netherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.corruptedBrickWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.corruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.corruptedCobblestoneWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.corruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.modFence, 4), new Object[]{"XXX", "XXX", 'X', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.netherrackBrickWall, 4), new Object[]{"XXX", "XXX", 'X', NPBlockList.netherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.modStoneSlab, 6, 1), new Object[]{"XXX", 'X', NPBlockList.corruptedBrick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.modStoneSlab, 6, 0), new Object[]{"XXX", 'X', NPBlockList.corruptedCobblestone});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.modWoodSlab, 6, 0), new Object[]{"XXX", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.modStoneSlab, 6, 2), new Object[]{"XXX", 'X', NPBlockList.netherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.itemGrimwoodDoor, 1), new Object[]{"XX", "XX", "XX", 'X', new ItemStack(NPBlockList.netherPlanks, 1, 0)});
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
		GameRegistry.addRecipe(new ItemStack(NPBlockList.chiliB, 1), new Object[]{"XXX", "XXX", "XXX", 'X', NPItemList.chili});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.grimwoodTorch, 4), new Object[]{"X", "Y",  'X', NPItemList.charoiteCrystal, 'Y', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.ladder, 3), new Object[]{"X X", "XXX", "X X", 'X', NPItemList.grimwoodStick});
		GameRegistry.addRecipe(new ItemStack(NPItemList.goldBucket, 1), new Object[]{"X X", " X ", 'X', Items.gold_ingot});
		GameRegistry.addRecipe(new ItemStack(NPBlockList.soulGlassPane, 16), new Object[]{"XXX", "XXX", 'X', NPBlockList.soulGlass});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodBow, 1), new Object[] {" XY", "X Y", " XY" , 'X',  NPItemList.grimwoodStick, 'Y', Items.string});
		GameRegistry.addRecipe(new ItemStack(NPItemList.grimwoodArrow, 4), new Object[] {"Y", "X", "Z", 'X', NPItemList.grimwoodStick, 'Y', Items.quartz, 'Z', NPBlockList.steelWool});
	}
	
	public static void loadSmelting()
	{
		GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(NPBlockList.soulGlass), 2.0F);
		GameRegistry.addSmelting(NPBlockList.glowstoneSand, new ItemStack(Blocks.glowstone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.corruptedGoldOre, new ItemStack(Items.gold_ingot), 2.0F);
		GameRegistry.addSmelting(NPBlockList.corruptedBlackIronOre, new ItemStack(NPItemList.blackIronIngot), 2.0F);
		GameRegistry.addSmelting(NPBlockList.corruptedCharoiteOre, new ItemStack(NPItemList.charoiteCrystal), 2.0F);
		GameRegistry.addSmelting(NPBlockList.corruptionStone, new ItemStack(NPBlockList.corruptedCobblestone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.infernumOre, new ItemStack(NPItemList.infernumIngot), 2.0F);
	}
}