package nether_plus.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class SalamanderArmor extends ItemArmor
{
	public SalamanderArmor(ArmorMaterial armorMaterial, int type, int layer)
	{
		super(armorMaterial, type, layer);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsArmor);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem().equals(NPItemList.salamanderLeggings))
		{
			return "nether_plus:textures/armor/Salamander_2.png";
		}
		else
		{
			return "nether_plus:textures/armor/Salamander_1.png";
		}
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem() == NPItemList.blackIronIngot)
			return true;
		return false;
	}
}