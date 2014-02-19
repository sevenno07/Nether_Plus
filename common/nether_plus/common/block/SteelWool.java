package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class SteelWool extends Block
{
	public SteelWool() 
	{
		super(Material.cloth);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
	{
        this.blockIcon = iconregister.registerIcon("nether_plus:SteelWool");
 	}
}