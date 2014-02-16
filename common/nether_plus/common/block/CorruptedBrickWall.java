package nether_plus.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class CorruptedBrickWall extends BlockWall
{
	public CorruptedBrickWall(Block par2Block)
	{
		super(par2Block);
	}
	
	public IIcon getIcon(int par1, int par2)
	{
		return NPBlockList.CorruptedBrick.getBlockTextureFromSide(par1);
	}
	
	public void getSubBlocks(Block par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
	}
}