package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class InfernumOre extends Block
{
	public InfernumOre() 
	{
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
}