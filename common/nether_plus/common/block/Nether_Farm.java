package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Nether_Farm extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_94441_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_94440_b;

    protected Nether_Farm()
    {
        super(Material.ground);
        this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
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
        return par1 == 1 ? (par2 > 0 ? this.field_94441_a : this.field_94440_b) : Blocks.soul_sand.getBlockTextureFromSide(par1);
    }

    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (!this.isWaterNearby(world, x, y, z) && !world.canLightningStrikeAt(x, y + 1, z))
        {
            int l = world.getBlockMetadata(x, y, z);

            if (l > 0)
            {
                world.setBlockMetadataWithNotify(x, y, z, l - 1, 2);
            }
            else if (!this.isCropsNearby(world, x, y, z))
            {
                world.setBlock(x, y, z, Blocks.soul_sand);
            }
        }
        else
        {
            world.setBlockMetadataWithNotify(x, y, z, 7, 2);
        }
    }

    public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
    {
        if (!par1World.isRemote && par1World.rand.nextFloat() < par6 - 0.5F)
        {
            if (!(par5Entity instanceof EntityPlayer) && !par1World.getGameRules().getGameRuleBooleanValue("mobGriefing"))
            {
                return;
            }

            par1World.setBlock(par2, par3, par4, Blocks.soul_sand);
        }
    }

    private boolean isCropsNearby(World world, int x, int y, int z)
    {
        byte b0 = 0;

        for (int l = x - b0; l <= x + b0; ++l)
        {
            for (int i1 = z - b0; i1 <= z + b0; ++i1)
            {
                Block j1 = world.getBlock(l, y + 1, i1);

                Block plant = j1;
                if (plant instanceof IPlantable && canSustainPlant(world, x, y, z, ForgeDirection.UP, (IPlantable)plant))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isWaterNearby(World world, int x, int y, int z)
    {
        for (int l = x - 4; l <= x + 4; ++l)
        {
            for (int i1 = y; i1 <= y + 1; ++i1)
            {
                for (int j1 = z - 4; j1 <= z + 4; ++j1)
                {
                    if (world.getBlock(l, i1, j1) == Material.lava)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        super.onNeighborBlockChange(world, x, y, z, block);
        Material material = world.getBlock(x, y + 1, z);

        if (material.isSolid())
        {
            world.setBlock(x, y, z, Blocks.soul_sand);
        }
    }

    public Item idDropped(int par1, Random par2Random, int par3)
    {
        return Blocks.soul_sand.getItemDropped(0, par2Random, par3);
    }

    @SideOnly(Side.CLIENT)
    public Item idPicked(World par1World, int par2, int par3, int par4)
    {
        return Item.getItemFromBlock(Blocks.soul_sand);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.field_94441_a = par1IconRegister.registerIcon("nether_plus:Nether_Farm_wet");
        this.field_94440_b = par1IconRegister.registerIcon("nether_plus:Nether_Farm_dry");
    }
}