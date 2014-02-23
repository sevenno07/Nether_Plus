package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.util.IIcon;

public class CorruptedBrickWall extends BlockWall
{
	public CorruptedBrickWall(Block par2Block)
	{
		super(par2Block);
	}
	
	public IIcon getIcon(int par1, int par2)
	{
		return NPBlockList.corruptedBrick.getBlockTextureFromSide(par1);
	}
}