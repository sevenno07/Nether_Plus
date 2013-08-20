package nether_plus.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import nether_plus.common.block.NPBlockList;

public class NetherPlusCreativeTabs extends CreativeTabs
	{
	public static CreativeTabs NetherPlusCreativeTabs;

	public static void loadCreativeTab()
	{
		NetherPlusCreativeTabs = new NetherPlusCreativeTabs("NetherPlusCreativeTabs");
	}

	public NetherPlusCreativeTabs(String name)
	{
		super(name);
	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(NPBlockList.CorruptionStone);
	}
}