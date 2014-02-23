package nether_plus.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class SkeletonBlackArmor extends ItemArmor
{
	public SkeletonBlackArmor(ArmorMaterial armorMaterial, int type, int layer)
	{
		super(armorMaterial, type, layer);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsArmor);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem().equals(NPItemList.skeletonBlackLeggings))
		{
			return "nether_plus:textures/armor/BlackSkeleton_2.png";
		}
		else
		{
			return "nether_plus:textures/armor/BlackSkeleton_1.png";
		}
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem() == NPItemList.blackIronIngot)
			return true;
		return false;
	}
}