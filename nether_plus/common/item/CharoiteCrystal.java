package nether_plus.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class CharoiteCrystal extends Item
{
    public CharoiteCrystal(int id)
    {
    	super(id);
    	this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
    }
    
  	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:CharoiteCrystal");
 	}
}