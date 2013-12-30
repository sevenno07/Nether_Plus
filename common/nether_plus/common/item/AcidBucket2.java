package nether_plus.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AcidBucket2 extends GoldBucket
{
	public AcidBucket2(int id, int par2)
	{
		super(id, par2);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("nether_plus:AcidBucket2");
    }
}