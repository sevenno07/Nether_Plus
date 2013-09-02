package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CorruptedCobblestone extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon field_94441_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94440_b;

    protected CorruptedCobblestone(int par1)
    {
        super(par1, Material.rock);
        this.setTickRandomly(true);
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
    public Icon getIcon(int par1, int par2)
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
                    if (par1World.getBlockMaterial(l, i1, j1) == Material.lava)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return NPBlockList.CorruptedCobblestone.idDropped(0, par2Random, par3);
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return NPBlockList.CorruptedCobblestone.blockID;
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94441_a = par1IconRegister.registerIcon("nether_plus:CorruptedCobblestone2");
        this.field_94440_b = par1IconRegister.registerIcon("nether_plus:CorruptedCobblestone1");
    }
}