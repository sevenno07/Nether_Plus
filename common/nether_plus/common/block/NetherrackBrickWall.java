package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.util.IIcon;

public class NetherrackBrickWall extends BlockWall
{
	public NetherrackBrickWall(Block par2Block)
	{
		super(par2Block);
	}
	
	public IIcon getIcon(int par1, int par2)
	{
		return NPBlockList.netherrackBrick.getBlockTextureFromSide(par1);
	}
}