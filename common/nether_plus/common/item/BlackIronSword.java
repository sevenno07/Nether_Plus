package nether_plus.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlackIronSword extends ItemSword
{
	public BlackIronSword(ToolMaterial toolmaterial)
	{
		super(toolmaterial);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsArmor);
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack outputstack)
	{
		if(stack.getItem().equals(this) && outputstack.getItem().equals(NPItemList.blackIronIngot))
		{
			return true;
		}
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:BlackIronSword");
 	}
}