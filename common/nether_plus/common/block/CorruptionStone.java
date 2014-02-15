package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.item.Item;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class CorruptionStone extends BlockStone
{
	public CorruptionStone() 
	{
		super();
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
	
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
		return Item.getItemFromBlock(NPBlockList.CorruptedCobblestone);
    }
}