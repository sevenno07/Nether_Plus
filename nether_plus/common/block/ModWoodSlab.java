package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockStep;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import nether_plus.common.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModWoodSlab extends BlockStep
{
	public static final String[] StepTypes = new String[] {"GrimwoodPlanks", "CorrutionStone"};

	public ModWoodSlab(int id, boolean isDouble)
	{
		super(id, isDouble);
		this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
		if(!this.isDoubleSlab)
		{
			setLightOpacity(0);
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
		return new ItemStack(NPBlockList.ModWoodSlab.blockID, 2, metadata & 1);
	}

	public String getFullSlabName(int metadata)
	{
		if (metadata < 0 || metadata >= StepTypes.length)
		{
			metadata = 0;
		}

		return super.getUnlocalizedName() + "." + StepTypes[metadata];
	}
	
	public void getSubBlocks(int id, CreativeTabs creativeTabs, List list)
	{
		if (id != NPBlockList.ModWoodSlab.blockID)
		{

			for (int i = 0; i < StepTypes.length; i++)
			{
				list.add(new ItemStack(id, 1, i++));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		int k = metadata & 1;
		return k == 0 ? NPBlockList.GrimwoodPlanks.getBlockTextureFromSide(side) : NPBlockList.CorruptionStone.getBlockTextureFromSide(side);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {}
}