package nether_plus.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class BloodGem extends Item
{

	public BloodGem(int id)
	{
		super(id);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
	}
	
  	@SideOnly(Side.CLIENT)
  	public boolean hasEffect(ItemStack par1ItemStack)
  	{
  		return true;
  	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:BloodGem");
 	}
}