package nether_plus.common.block;

import net.minecraft.block.BlockStone;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class CorruptedBrick extends BlockStone
{
	public CorruptedBrick() 
	{
		super();
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
}