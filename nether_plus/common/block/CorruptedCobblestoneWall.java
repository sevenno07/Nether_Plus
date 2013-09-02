package nether_plus.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class CorruptedCobblestoneWall extends BlockWall
{
	public CorruptedCobblestoneWall(int par1, Block par2Block)
	{
		super(par1, par2Block);
	}
	
	public Icon getIcon(int par1, int par2)
	{
		return NPBlockList.CorruptedCobblestone.getBlockTextureFromSide(par1);
	}
	
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
	}
}