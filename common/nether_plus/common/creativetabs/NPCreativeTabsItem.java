package nether_plus.common.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nether_plus.common.item.NPItemList;

public class NPCreativeTabsItem extends CreativeTabs
{
	public NPCreativeTabsItem(String name)
	{
		super(name);
	}

	@Override
	public Item getTabIconItem()
	{
		return NPItemList.BloodGem;
	}
}