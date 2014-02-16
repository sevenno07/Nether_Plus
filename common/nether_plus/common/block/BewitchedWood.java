package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class BewitchedWood extends BlockLog
	{
	private IIcon topIcon;
	
	public BewitchedWood()
	{
		super();
		this.setCreativeTab (NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}

	public Item idDropped(int side, Random random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

	public void registerIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nether_plus:BewitchedWood-side");
		topIcon = iconregister.registerIcon("nether_plus:BewitchedWood-top");
	}

	public IIcon getIcon(int side, int metadata)
	{
		int k = metadata & 12;
		return k == 0 && (side == 1 || side == 0) ? topIcon : (k == 4 && (side == 5 || side == 4) ? topIcon : (k == 8 && (side == 2 || side == 3) ? topIcon : blockIcon));
	}

	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
	}
}