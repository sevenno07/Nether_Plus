package nether_plus.common.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nether_plus.common.block.NPBlockList;

public class NPCreativeTabsBlock extends CreativeTabs
{
	public NPCreativeTabsBlock(String name)
	{
		super(name);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(NPBlockList.CorruptionStone);
	}
}