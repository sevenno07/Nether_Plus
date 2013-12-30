package nether_plus.common.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import nether_plus.common.item.NPItemList;

public class NPCreativeTabsArmor extends CreativeTabs
{

	public NPCreativeTabsArmor(String name)
	{
		super(name);
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(NPItemList.SkeletonBlackHelmet);
	}
}
