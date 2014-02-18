package nether_plus.common.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class QuickSilverBucket extends GoldBucket
{
	public QuickSilverBucket(Block block)
	{
		super(block);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("nether_plus:QuicksilverBucket");
    }
}