package nether_plus.common.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import nether_plus.common.item.NPItemList;

public class NPCreativeTabsTool extends CreativeTabs {

	public NPCreativeTabsTool(String name)
	{
		super(name);
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(NPItemList.GrimwoodSword);
	}
}
