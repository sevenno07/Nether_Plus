package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrimwoodLog extends BlockLog
{
	private IIcon topIcon;

	public GrimwoodLog()
	{
		super();
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}

	public Item idDropped(int side, Random random, int par3)
	{
		return Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("nether_plus:GrimwoodLog_sid");
		topIcon = iconregister.registerIcon("nether_plus:GrimwoodLog_top");
	}

	public IIcon getIcon(int side, int metadata)
	{
		int k = metadata & 12;
		return k == 0 && (side == 1 || side == 0) ? topIcon : (k == 4 && (side == 5 || side == 4) ? topIcon : (k == 8 && (side == 2 || side == 3) ? topIcon : blockIcon));
	}
}