package nether_plus.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DeadBread extends ItemFood
{
	public DeadBread(int par2, float par3, boolean par4)
	{
		super(par2, par3, par4);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsFood);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:DeadBread");
 	}
}