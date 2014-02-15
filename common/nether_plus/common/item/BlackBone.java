package nether_plus.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlackBone extends Item
{
	public BlackBone()
	{
		super();
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:BlackBone");
 	}
}