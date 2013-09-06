package nether_plus.common.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import nether_plus.common.item.NPItemList;

public class NPCreativeTabsFood extends CreativeTabs
{
	public NPCreativeTabsFood(String name)
	{
		super(name);
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(NPItemList.DeadBread);
	}
}