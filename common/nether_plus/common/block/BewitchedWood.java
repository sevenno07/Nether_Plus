package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class BewitchedWood extends BlockLog
	{
	private IIcon topIcon;
	
	public BewitchedWood()
	{
		super();
		this.setCreativeTab (NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}

	public int idDropped(int side, Random random, int par3)
	{
		return this.blockID;
	}

	public void registerIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nether_plus:BewitchedWood-side");
		topIcon = iconregister.registerIcon("nether_plus:BewitchedWood-top");
	}

	public Icon getIcon(int side, int metadata)
	{
		int k = metadata & 12;
		return k == 0 && (side == 1 || side == 0) ? topIcon : (k == 4 && (side == 5 || side == 4) ? topIcon : (k == 8 && (side == 2 || side == 3) ? topIcon : blockIcon));
	}

	public void getSubBlocks(int id, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(id, 1, 0));
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z)
	{
		return true;
	}
}