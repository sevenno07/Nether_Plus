package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import nether_plus.common.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlackSkull extends Block
{
	private Icon IconTop;
	private Icon IconBottom;
	
	public BlackSkull(int id)
	{
		super(id, Material.pumpkin);
		this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
	}
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return side == 0 ? IconBottom : side == 1 ? IconTop : blockIcon;
	}
	 
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("Nether_Plus:BlackSkull_Front");
	 	this.IconBottom = par1IconRegister.registerIcon("Nether_Plus:BlackSkull_Bottom");
	 	this.IconTop = par1IconRegister.registerIcon("Nether_Plus:BlackSkull_Top");
	}
}
