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
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GlowstoneSand), new Object[]{"XX", "XX", 'X', Item.lightStoneDust});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteHelmet), new Object[]{"XXX", "X X", 'X', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteChestplate), new Object[]{"X X", "XXX", "XXX", 'X', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteLeggings), new Object[]{"XXX", "X X", "X X", 'X', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonWhiteBoot), new Object[]{"X X", "X X", 'X', Item.bone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackHelmet), new Object[]{"XXX", "X X", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackChestplate), new Object[]{"X X", "XXX", "XXX", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackLeggings), new Object[]{"XXX", "X X", "X X", 'X', NPItemList.BlackBone});
		GameRegistry.addRecipe(new ItemStack(NPItemList.SkeletonBlackBoot), new Object[]{"X X", "X X", 'X', NPItemList.BlackBone});
	}
	
	public static void loadSmelting()
	{
		GameRegistry.addSmelting(Block.slowSand.blockID, new ItemStack(NPBlockList.SoulGlass), 2.0F);
		GameRegistry.addSmelting(NPBlockList.GlowstoneSand.blockID, new ItemStack(Block.glowStone), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedGoldOre.blockID, new ItemStack(Item.ingotGold), 2.0F);
		GameRegistry.addSmelting(NPBlockList.CorruptedBlackIronOre.blockID, new ItemStack(NPItemList.BlackIronIngot), 2.0F);
	}
}
