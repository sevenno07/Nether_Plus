package nether_plus.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import nether_plus.common.block.NPBlockList;

public class NetherPlusCreativeTabs extends CreativeTabs
	{
	public static CreativeTabs NPCreativeTabsBlock;
	public static CreativeTabs NPCreativeTabsItem;
	public static CreativeTabs NPCreativeTabsArmor;
	public static CreativeTabs NPCreativeTabsTool;

	public static void loadCreativeTab()
	{
		NPCreativeTabsBlock = new NetherPlusCreativeTabs("NPCreativeTabsBlock");
		NPCreativeTabsItem = new NetherPlusCreativeTabs("NPCreativeTabsItem");
		NPCreativeTabsArmor = new NetherPlusCreativeTabs("NPCreativeTabsArmor");
		NPCreativeTabsTool = new NetherPlusCreativeTabs("NPCreativeTabsTool");
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