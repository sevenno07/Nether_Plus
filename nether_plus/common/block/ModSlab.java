package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import nether_plus.common.NetherPlusCreativeTabs;
import nether_plus.common.config.NPProperties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModSlab extends BlockHalfSlab
	{
	public static final String[] woodType = new String[] {"GrimwoodPlanks", "CorruptedBrick", "NetherrackBrick"};

	public ModSlab(int par1, boolean par2)

	{
		super(par1, par2, Material.wood);
		this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return NPBlockList.GrimwoodPlanks.getIcon(par1, par2 & 7);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return NPProperties.ModSlabID;
	}

	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(NPProperties.ModSlabID, 2, par1 & 7);
	}

	public String getFullSlabName(int par1)
	{
		if (par1 < 0 || par1 >= woodType.length)
		{
			par1 = 0;
		}

		return super.getUnlocalizedName() + "." + woodType[par1];
	}

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		if (par1 != NPProperties.ModSlabID)
		{

			for (int j = 0; j < 5; ++j)
			{
				par3List.add(new ItemStack(par1, 1, j));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {}
}