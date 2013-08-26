package nether_plus.common.item;

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
}
