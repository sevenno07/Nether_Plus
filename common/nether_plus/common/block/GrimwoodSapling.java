package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import nether_plus.common.GrimGenTree;
import nether_plus.common.config.NPProperties;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrimwoodSapling extends BlockSapling
	{
	public GrimwoodSapling()
	{
		super();
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}

	public void registerIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nether_plus:GrimwoodSapling");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return blockIcon;
	}

	public void growTree(World world, int i, int j, int k, Random random)
	{
		int l = world.getBlockMetadata(i, j, k) & 3;
		world.setBlock(i, j, k, 0);
		Object obj = null;
		obj = new GrimGenTree(false);
		if(!((WorldGenerator)(obj)).generate(world, random, i, j, k))
		{
			world.setBlock(i, j, k, blockID, l, 3);
		}
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int blockid)
	{
		return blockid == NPProperties.CorruptionStoneID;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativetabs, List list)
	{
		list.add(new ItemStack(blockid, 1, 0));
	}

	public void fertilize(World world, int x, int y, int z)
	{
	}
}