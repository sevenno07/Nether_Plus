package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChiliB extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    protected ChiliB()
    {
        super(Material.gourd);
        this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 != 1 && par1 != 0 ? this.blockIcon : this.theIcon;
    }

    public Item idDropped(int par1, Random par2Random, int par3)
    {
        return NPItemList.Chili;
    }

    public int quantityDropped(Random par1Random)
    {
        return 3 + par1Random.nextInt(5);
    }

    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        int j = this.quantityDropped(par2Random) + par2Random.nextInt(1 + par1);

        if (j > 9)
        {
            j = 9;
        }

        return j;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("nether_plus:Chili_side");
        this.theIcon = par1IconRegister.registerIcon("nether_plus:Chili_top");
    }
}