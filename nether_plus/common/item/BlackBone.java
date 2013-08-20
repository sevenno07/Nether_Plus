package nether_plus.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import nether_plus.common.NetherPlusCreativeTabs;

public class BlackBone extends Item
{

	public BlackBone(int id)
	{
		super(id);
		this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:BlackBone");
 	}
}
