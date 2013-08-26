package nether_plus.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import nether_plus.common.NetherPlusCreativeTabs;

public class GrimwoodPickaxe extends ItemPickaxe
{

	public GrimwoodPickaxe(int id, EnumToolMaterial toolmaterial)
	{
		super(id, toolmaterial);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsTool);
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack outputstack)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:GrimwoodPickaxe");
 	}
}
