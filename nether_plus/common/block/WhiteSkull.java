package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import nether_plus.common.NetherPlusCreativeTabs;

public class WhiteSkull extends Block
{
	private Icon IconTop;
	private Icon IconFront;
	
	public WhiteSkull(int id)
	{
		super(id, Material.pumpkin);
		this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
	}
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return side == 1 ? this.IconTop : (side == 0 ? this.IconTop : (metadata == 2 && side == 2 ? this.IconFront : (metadata == 3 && side == 5 ? this.IconFront : (metadata == 0 && side == 3 ? this.IconFront : (metadata == 1 && side == 4 ? this.IconFront : this.blockIcon)))));
	}
	 
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("Nether_Plus:WhiteSkull_Bottom");
	 	this.IconFront = par1IconRegister.registerIcon("Nether_Plus:WhiteSkull_Front");
	 	this.IconTop = par1IconRegister.registerIcon("Nether_Plus:WhiteSkull_Top");
	}
}
