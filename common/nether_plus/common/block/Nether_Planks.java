package nether_plus.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Nether_Planks extends Block
{
	public static final String[] woodType = new String[] {"GrimwoodPlanks"};
	@SideOnly(Side.CLIENT)
	private IIcon[] IconArray;

	public Nether_Planks()
    {
        super(Material.wood);
        this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if (metadata < 0 || metadata >= this.IconArray.length)
        {
            metadata = 0;
        }

        return this.IconArray[metadata];
    }
    
    public int damageDropped(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        list.add(new ItemStack(item, 1, 0));
//        list.add(new ItemStack(item, 1, 1));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.IconArray = new IIcon[woodType.length];

        for (int i = 0; i < this.IconArray.length; ++i)
        {
            this.IconArray[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + woodType[i]);
        }
    }
}