package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrimwoodLeaves extends BlockLeaves implements IShearable
	{
	private IIcon fastIcon;

	public GrimwoodLeaves()
	{
		super();
		this.setTickRandomly(true);
		this.setLightOpacity(1);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nether_plus:GrimwoodLeaves");
		fastIcon = iconregister.registerIcon("nether_plus:GrimwoodLeaves_2");
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		return -1;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int par1)
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return Blocks.leaves.isOpaqueCube();
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side)
	{
		return !this.isOpaqueCube() ? true : super.shouldSideBeRendered(blockaccess, x, y, z, side);
	}

	public IIcon getIcon(int side, int metadata)
	{
		return(isOpaqueCube() ? fastIcon : blockIcon);
	}

	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}

	public Item idDropped(int metadata, Random random, int par3)
	{
		return Item.getItemFromBlock(NPBlockList.GrimwoodSapling);
	}

	public void getSubBlocks(Item par1, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(par1, 1, 0));
	}

	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7)
	{
		if(!world.isRemote)
		{
			byte var8 = 20;

			if((par5 & 3) == 3)
			{
				var8 = 40;
			}

			if(world.rand.nextInt(var8) == 0)
			{
				Item var9 = this.idDropped(par5, world.rand, par7);
				this.dropBlockAsItem(world, x, y, z, new ItemStack(var9, 1, this.damageDropped(par5)));
			}
		}
	}

	public int colorMultiplier(IBlockAccess blockaccess, int x, int y, int z)
	{
		return -1;
	}

	@Override
	public String[] func_150125_e()
	{
		return null;
	}
}