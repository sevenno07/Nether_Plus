package nether_plus.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SkeletonWhiteArmor extends ItemArmor
{
	public SkeletonWhiteArmor(ArmorMaterial armorMaterial, int type, int layer)
	{
		super(armorMaterial, type, layer);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsArmor);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.getItem().equals(NPItemList.SkeletonWhiteLeggings))
		{
			return "/mods/nether_plus/textures/armors/WhiteSkeleton_2.png"; //armure WhiteSkeleton, jambières
		}
		else
		{
			return "/mods/nether_plus/textures/armors/WhiteSkeleton_1.png"; //armure WhiteSkeleton, casque + plastron + bottes
		}
	}

	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
    {
        itemIcon = iconregister.registerIcon("nether_plus:"+getUnlocalizedName().substring(5));
    }
	
	public boolean getIsRepairable(ItemStack stack, ItemStack stack2)
    {
        return true;
    }
}