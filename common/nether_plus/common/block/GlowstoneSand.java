package nether_plus.common.block;

import net.minecraft.block.BlockSand;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class GlowstoneSand extends BlockSand
{
    public static boolean fallInstantly = false;
    
	public GlowstoneSand() 
	{
		super();
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
}