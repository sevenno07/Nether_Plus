package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class ModStairs extends BlockStairs
{	
	public ModStairs(Block block, int metadata)
	{
        super(block, metadata);
        this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
        this.setLightOpacity(0);
    }
}