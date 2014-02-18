package nether_plus.common.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class GlowstoneSand extends BlockFalling
{    
	public GlowstoneSand(Material material) 
	{
		super(material);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
}