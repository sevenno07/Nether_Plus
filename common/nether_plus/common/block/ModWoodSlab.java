package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModWoodSlab extends BlockSlab
{
	public static final String[] StepTypes = new String[] { "GrimwoodPlanks" };

	public ModWoodSlab(boolean isDouble)
	{
		super(isDouble, Material.wood);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return NPBlockList.netherPlanks.getIcon(side, metadata & 7);
	}

	public Item getItemDropped(int id, Random rand, int fortune)
	{
		return Item.getItemFromBlock(NPBlockList.modWoodSlab);
	}

	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(Item.getItemFromBlock(NPBlockList.modWoodSlab), 2, metadata & 7);
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
		if (item != Item.getItemFromBlock(NPBlockList.modWoodDoubleSlab))
		{
			for (int i = 0; i < StepTypes.length; i++)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {}
}