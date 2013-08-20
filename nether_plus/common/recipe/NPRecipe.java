package nether_plus.common.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.config.NPProperties;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPRecipe
{
	public static void loadRecipe()
	{
		GameRegistry.addRecipe(new ItemStack(NPBlockList.GlowstoneSand), new Object[]{"XX", "XX", 'X', Item.lightStoneDust});
	}
	
	public static void loadSmelting()
	{
		GameRegistry.addSmelting(Block.slowSand.blockID, new ItemStack(NPBlockList.SoulGlass), 2.0F);
		GameRegistry.addSmelting(NPProperties.GlowstoneSandID, new ItemStack(Block.glowStone), 2.0F);
		GameRegistry.addSmelting(NPProperties.CorruptedGoldOreID, new ItemStack(Item.ingotGold), 2.0F);
		GameRegistry.addSmelting(NPProperties.CorruptedBlackIronOreID, new ItemStack(NPItemList.BlackIronIngot), 2.0F);
	}
}
