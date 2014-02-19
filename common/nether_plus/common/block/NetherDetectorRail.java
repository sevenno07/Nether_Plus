package nether_plus.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockRailDetector;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherDetectorRail extends BlockRailDetector
{
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public NetherDetectorRail()
    {
        super();
        this.setTickRandomly(true);
    }

    public int tickRate(World par1World)
    {
        return 20;
    }

    public boolean canProvidePower()
    {
        return true;
    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if ((l & 8) == 0)
            {
                this.setStateIfMinecartInteractsWithRail(par1World, par2, par3, par4, l);
            }
        }
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if ((l & 8) != 0)
            {
                this.setStateIfMinecartInteractsWithRail(par1World, par2, par3, par4, l);
            }
        }
    }

    public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) != 0 ? 15 : 0;
    }

    public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) == 0 ? 0 : (par5 == 1 ? 15 : 0);
    }

    private void setStateIfMinecartInteractsWithRail(World par1World, int par2, int par3, int par4, int par5)
    {
        boolean flag = (par5 & 8) != 0;
        boolean flag1 = false;
        float f = 0.125F;
        List list = par1World.getEntitiesWithinAABB(EntityMinecart.class, AxisAlignedBB.getAABBPool().getAABB((double)((float)par2 + f), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)(par3 + 1) - f), (double)((float)(par4 + 1) - f)));

        if (!list.isEmpty())
        {
            flag1 = true;
        }

        if (flag1 && !flag)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, par5 | 8, 3);
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this);
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this);
            par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
        }

        if (!flag1 && flag)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, par5 & 7, 3);
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this);
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this);
            par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
        }

        if (flag1)
        {
            par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World));
        }

        par1World.func_147453_f(par2, par3, par4, this);
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setStateIfMinecartInteractsWithRail(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4));
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        if ((par1World.getBlockMetadata(par2, par3, par4) & 8) > 0)
        {
            float f = 0.125F;
            List list = par1World.selectEntitiesWithinAABB(EntityMinecart.class, AxisAlignedBB.getAABBPool().getAABB((double)((float)par2 + f), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)(par3 + 1) - f), (double)((float)(par4 + 1) - f)), IEntitySelector.selectInventories);

            if (list.size() > 0)
            {
                return Container.calcRedstoneFromInventory((IInventory)list.get(0));
            }
        }

        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.iconArray = new IIcon[2];
        this.iconArray[0] = par1IconRegister.registerIcon("nether_plus:NetherDetectorRail");
        this.iconArray[1] = par1IconRegister.registerIcon("nether_plus:NetherDetectorRail_on");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return (par2 & 8) != 0 ? this.iconArray[1] : this.iconArray[0];
    }
}