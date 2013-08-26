package nether_plus.common.item;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import nether_plus.common.NetherPlusCreativeTabs;

public class GrimwoodShovel extends ItemSpade
{

	public GrimwoodShovel(int id, EnumToolMaterial toolmaterial)
	{
		super(id, toolmaterial);
		this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);

	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack outputstack)
	{
		return true;
	}
}
