package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModStoneSlab extends BlockSlab
{
	public static final String[] StepTypes = new String[] {"CorruptedCobblestone", "CorruptedBrick", "NetherrackBrick"};

	public ModStoneSlab(boolean isDouble)
	{
		super(isDouble, Material.rock);
	}

	public Item idDropped(int id, Random rand, int fortune)
	{
		return Item.getItemFromBlock(NPBlockList.modStoneSlab);
	}

	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(Item.getItemFromBlock(NPBlockList.modStoneSlab), 2, metadata & 7);
	}

	public String func_150002_b(int metadata)
	{
		if (metadata < 0 || metadata >= StepTypes.length)
		{
			metadata = 0;
		}
		return super.getUnlocalizedName() + "." + StepTypes[metadata];
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		if (item != Item.getItemFromBlock(NPBlockList.modStoneDoubleSlab))
		{
			for (int i = 0; i < StepTypes.length; i++)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		int k = metadata & 7;
		return k == 0 ? NPBlockList.corruptedCobblestone.getBlockTextureFromSide(side) : k == 1 ? NPBlockList.corruptedBrick.getBlockTextureFromSide(side) : k == 2 ? NPBlockList.netherrackBrick.getBlockTextureFromSide(side) : NPBlockList.corruptedCobblestone.getBlockTextureFromSide(side);
	}
}