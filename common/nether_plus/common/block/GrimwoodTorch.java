package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import static net.minecraftforge.common.util.ForgeDirection.*;

public class GrimwoodTorch extends BlockTorch
{
    protected GrimwoodTorch()
    {
        super();
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 2;
    }

    private boolean part_m(World world, int x, int y, int z)
    {
        if (World.doesBlockHaveSolidTopSurface(world, x, y, z))
        {
            return true;
        }
        else
        {
            Block block = world.getBlock(x, y, z);
            return block.canPlaceTorchOnTop(world, x, y, z);
        }
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return world.isSideSolid(x - 1, y, z, EAST,  true) ||
        		world.isSideSolid(x + 1, y, z, WEST,  true) ||
        		world.isSideSolid(x, y, z - 1, SOUTH, true) ||
        		world.isSideSolid(x, y, z + 1, NORTH, true) ||
        		part_m(world, x, y - 1, z);
    }

    public int onBlockPlaced(World world, int x, int y, int z, int block, float h, float p, float b, int bblock)
    {
        int j1 = bblock;

        if (block == 1 && this.part_m(world, x, y - 1, z))
        {
            j1 = 5;
        }

        if (block == 2 && world.isSideSolid(x, y, z + 1, NORTH, true))
        {
            j1 = 4;
        }

        if (block == 3 && world.isSideSolid(x, y, z - 1, SOUTH, true))
        {
            j1 = 3;
        }

        if (block == 4 && world.isSideSolid(x + 1, y, z, WEST, true))
        {
            j1 = 2;
        }

        if (block == 5 && world.isSideSolid(x - 1, y, z, EAST, true))
        {
            j1 = 1;
        }

        return j1;
    }

    public void updateTick(World world, int x, int y, int z, Random random)
    {
        super.updateTick(world, x, y, z, random);

        if (world.getBlockMetadata(x, y, z) == 0)
        {
            this.onBlockAdded(world, x, y, z);
        }
    }

    protected boolean part_e(World world, int x, int y, int z)
    {
        if (!this.canPlaceBlockAt(world, x, y, z))
        {
            if (world.getBlock(x, y, z) == this)
            {
                this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                world.setBlockToAir(x, y, z);
            }

            return false;
        }
        else
        {
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        int l = world.getBlockMetadata(x, y, z);
        double d0 = (double)((float)x + 0.5F);
        double d1 = (double)((float)y + 0.7F);
        double d2 = (double)((float)z + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

        if (l == 1)
        {
        	world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        	world.spawnParticle("portal", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 2)
        {
        	world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        	world.spawnParticle("portal", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 3)
        {
        	world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        	world.spawnParticle("portal", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 4)
        {
        	world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("portal", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
        }
        else
        {
        	world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        	world.spawnParticle("portal", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
	{
        this.blockIcon = iconregister.registerIcon("nether_plus:GrimwoodTorch");
 	}
}