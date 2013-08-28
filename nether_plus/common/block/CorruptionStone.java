package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CorruptionStone extends Block
{
	public CorruptionStone(int id, Material par2Material) 
	{
		super(id, par2Material);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
      return NPBlockList.CorruptedCobblestone.blockID;
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.blockIcon = iconregister.registerIcon("nether_plus:CorruptionStone");
 	}
}