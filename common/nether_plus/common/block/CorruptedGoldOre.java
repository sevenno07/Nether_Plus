package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class CorruptedGoldOre extends Block
{
	public CorruptedGoldOre() 
	{
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
}