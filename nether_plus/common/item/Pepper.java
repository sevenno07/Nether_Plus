package nether_plus.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Pepper extends ItemFood
{
	public Pepper(int id, int par2, float par3, boolean par4)
	{
		super(id, par2, par3, par4);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsFood);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:Pepper");
 	}
}