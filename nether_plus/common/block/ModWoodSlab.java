package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import nether_plus.common.NetherPlusCreativeTabs;

public class ModWoodSlab extends BlockHalfSlab
{
public static final String[] StepTypes = new String[] {"GrimwoodPlanks"};

	public ModWoodSlab(int id, boolean isdouble)
	{
		super(id, isdouble, Material.wood);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		if(!this.isDoubleSlab)
		{
			this.setLightOpacity(0);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(int id)
	{
		return id == NPBlockList.ModWoodSlab.blockID;
	}
	
	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return isBlockSingleSlab(this.blockID) ? this.blockID : NPBlockList.ModWoodDoubleSlab.blockID;
	}
	
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return NPBlockList.ModWoodSlab.blockID;
	}
	
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(NPBlockList.ModWoodSlab.blockID, 2, metadata & 7);
	}
	
	public String getFullSlabName(int metadata)
	{
		if(metadata < 0 || metadata >= StepTypes.length)
		{
			metadata = 0;
		}
		return super.getUnlocalizedName() + "." + StepTypes[metadata];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs creativeTabs, List list)
	{
		if(id != NPBlockList.ModWoodDoubleSlab.blockID)
		{
			for(int i = 0; i < StepTypes.length; i++)
			{
				list.add(new ItemStack(id, 1, i));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		int k = metadata & 7;
		return k == 0 ? NPBlockList.GrimwoodPlanks.getBlockTextureFromSide(side) : NPBlockList.GrimwoodPlanks.getBlockTextureFromSide(side);
	}
}