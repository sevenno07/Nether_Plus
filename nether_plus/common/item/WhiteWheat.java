package nether_plus.common.item;

import net.minecraft.item.Item;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class WhiteWheat extends Item
{
	public WhiteWheat(int id)
	{
		super(id);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
	}
}