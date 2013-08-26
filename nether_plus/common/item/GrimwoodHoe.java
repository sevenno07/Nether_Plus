package nether_plus.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import nether_plus.common.NetherPlusCreativeTabs;

public class GrimwoodHoe extends ItemHoe
{

	public GrimwoodHoe(int id, EnumToolMaterial toolmaterial)
	{
		super(id, toolmaterial);
		this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack outputstack)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:GrimwoodHoe");
 	}
}
