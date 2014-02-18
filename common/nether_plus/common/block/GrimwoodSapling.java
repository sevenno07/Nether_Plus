package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
//import nether_plus.common.GrimGenTree;
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
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
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
		/*int l = world.getBlockMetadata(i, j, k) & 3;
		world.setBlock(i, j, k, this, 0, l);
		Object obj = null;
		obj = new GrimGenTree(false);
		if(!((WorldGenerator)(obj)).generate(world, random, i, j, k))
		{
			world.setBlock(i, j, k, this, l, 3);
		}*/
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativetabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
	}

	public void fertilize(World world, int x, int y, int z)
	{
	}
}