package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CorruptedCobblestone extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_94441_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_94440_b;

    protected CorruptedCobblestone()
    {
        super(Material.rock);
        this.setTickRandomly(true);
        this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4, int par5)
    {
        return AxisAlignedBB.getAABBPool().getAABB((double)(par2 + 0), (double)(par3 + 0), (double)(par4 + 0), (double)(par2 + 1), (double)(par3 + 1), (double)(par4 + 1));
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 0 || par1 == 1 || par1 == 2 || par1 == 3 || par1 == 4 || par1 == 5 ? (par2 > 0 ? this.field_94441_a : this.field_94440_b) : this.blockIcon;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!this.isWaterNearby(par1World, par2, par3, par4) && !par1World.canLightningStrikeAt(par2, par3 + 1, par4))
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l > 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, l - 1, 2);
            }
        }
        else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 7, 2);
        }
    }

    private boolean isWaterNearby(World par1World, int par2, int par3, int par4)
    {
        for (int l = par2 - 5; l <= par2 + 5; ++l)
        {
            for (int i1 = par3; i1 <= par3 + 1; ++i1)
            {
                for (int j1 = par4 - 5; j1 <= par4 + 5; ++j1)
                {
                    if (par1World.getBlock(l, i1, j1).getMaterial() == Material.lava)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return NPBlockList.CorruptedCobblestone.getItemDropped(0, par2Random, par3);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.field_94441_a = par1IconRegister.registerIcon("nether_plus:CorruptedCobblestone2");
        this.field_94440_b = par1IconRegister.registerIcon("nether_plus:CorruptedCobblestone1");
    }
}