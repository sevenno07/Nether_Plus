package nether_plus.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import nether_plus.common.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CorruptionStone extends Block
{
	private Icon CCStone;

	public CorruptionStone(int id) 
	{
		super(id, Material.rock);
		this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
	}
	
	@SideOnly(Side.CLIENT)
	
    public Icon getIcon(int par1, int par2)
    {
		if(par2 == 0)
		{
			return par2 == 0 && (par1 == 0) ? this.blockIcon : this.blockIcon;
		}
		if(par2 == 1)
		{
			return par2 == 12 && (par1 == 0) ? this.CCStone : this.CCStone;
		}
		return blockIcon;
    }
	
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.blockIcon = iconregister.registerIcon("nether_plus:CorruptionStone");
        this.CCStone = iconregister.registerIcon("nether_plus:CorruptedCobblestone");
 	}
}