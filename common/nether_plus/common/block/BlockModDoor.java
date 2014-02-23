package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;

public class BlockModDoor extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon[] Icon_UP;
    @SideOnly(Side.CLIENT)
    private IIcon[] Icon_DOWN;

    protected BlockModDoor(Material material)
    {
        super(material);
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int part1, int part2)
    {
        return this.Icon_DOWN[0];
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess block, int part2, int part3, int part4, int part5)
    {
        if (part5 != 1 && part5 != 0)
        {
            int i1 = this.part_g(block, part2, part3, part4);
            int j1 = i1 & 3;
            boolean flag = (i1 & 4) != 0;
            boolean flag1 = false;
            boolean flag2 = (i1 & 8) != 0;

            if (flag)
            {
                if (j1 == 0 && part5 == 2)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && part5 == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && part5 == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && part5 == 4)
                {
                    flag1 = !flag1;
                }
            }
            else
            {
                if (j1 == 0 && part5 == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && part5 == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && part5 == 4)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && part5 == 2)
                {
                    flag1 = !flag1;
                }

                if ((i1 & 16) != 0)
                {
                    flag1 = !flag1;
                }
            }

            return flag2 ? this.Icon_UP[flag1?1:0] : this.Icon_DOWN[flag1?1:0];
        }
        else
        {
            return this.Icon_DOWN[0];
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister registericon)
    {
        this.Icon_UP = new IIcon[2];
        this.Icon_DOWN = new IIcon[2];
        this.Icon_UP[0] = registericon.registerIcon(this.getTextureName() + "_upper");
        this.Icon_DOWN[0] = registericon.registerIcon(this.getTextureName() + "_lower");
        this.Icon_UP[1] = new IconFlipped(this.Icon_UP[0], true, false);
        this.Icon_DOWN[1] = new IconFlipped(this.Icon_DOWN[0], true, false);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess block, int part2, int part3, int part4)
    {
        int l = this.part_g(block, part2, part3, part4);
        return (l & 4) != 0;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 7;
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
    {
        this.part_b(this.part_g(block, x, y, z));
    }

    public int func_150013_e(IBlockAccess block, int x, int y, int z)
    {
        return this.part_g(block, x, y, z) & 3;
    }

    public boolean part_f(IBlockAccess block, int x, int y, int z)
    {
        return (this.part_g(block, x, y, z) & 4) != 0;
    }

    private void part_b(int part1)
    {
        float f = 0.1875F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        int j = part1 & 3;
        boolean flag = (part1 & 4) != 0;
        boolean flag1 = (part1 & 16) != 0;

        if (j == 0)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
        }
        else if (j == 1)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }
        }
        else if (j == 2)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
            }
            else
            {
                this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        else if (j == 3)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }
        }
    }

    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer entity)
    {
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entity, int block, float r, float p, float h)
    {
        if (this.blockMaterial == Material.iron)
        {
            return false;
        }
        else
        {
            int i1 = this.part_g(world, x, y, z);
            int j1 = i1 & 7;
            j1 ^= 4;

            if ((i1 & 8) == 0)
            {
            	world.setBlockMetadataWithNotify(x, y, z, j1, 2);
            	world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            }
            else
            {
            	world.setBlockMetadataWithNotify(x, y - 1, z, j1, 2);
            	world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
            }

            world.playAuxSFXAtEntity(entity, 1003, x, y, z, 0);
            return true;
        }
    }

    public void func_150014_a(World world, int x, int y, int z, boolean block)
    {
        int l = this.part_g(world, x, y, z);
        boolean flag1 = (l & 4) != 0;

        if (flag1 != block)
        {
            int i1 = l & 7;
            i1 ^= 4;

            if ((l & 8) == 0)
            {
            	world.setBlockMetadataWithNotify(x, y, z, i1, 2);
            	world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            }
            else
            {
            	world.setBlockMetadataWithNotify(x, y - 1, z, i1, 2);
            	world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
            }

            world.playAuxSFXAtEntity((EntityPlayer)null, 1003, x, y, z, 0);
        }
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0)
        {
            boolean flag = false;

            if (world.getBlock(x, y + 1, z) != this)
            {
            	world.setBlockToAir(x, y, z);
                flag = true;
            }

            if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z))
            {
            	world.setBlockToAir(x, y, z);
                flag = true;

                if (world.getBlock(x, y + 1, z) == this)
                {
                	world.setBlockToAir(x, y + 1, z);
                }
            }

            if (flag)
            {
                if (!world.isRemote)
                {
                    this.dropBlockAsItem(world, x, y, z, l, 0);
                }
            }
            else
            {
                boolean flag1 = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z);

                if ((flag1 || block.canProvidePower()) && block != this)
                {
                    this.func_150014_a(world, x, y, z, flag1);
                }
            }
        }
        else
        {
            if (world.getBlock(x, y - 1, z) != this)
            {
            	world.setBlockToAir(x, y, z);
            }

            if (block != this)
            {
                this.onNeighborBlockChange(world, x, y - 1, z, block);
            }
        }
    }

    public Item getItemDropped(int part1, Random rand, int part3)
    {
        return (part1 & 8) != 0 ? null : (this.blockMaterial == Material.iron ? NPItemList.itemBlackironDoor : NPItemList.itemGrimwoodDoor);
    }

    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 colid5, Vec3 colid6)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.collisionRayTrace(world, x, y, z, colid5, colid6);
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return y >= 255 ? false : World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && super.canPlaceBlockAt(world, x, y, z) && super.canPlaceBlockAt(world, x, y + 1, z);
    }

    public int getMobilityFlag()
    {
        return 1;
    }

    public int part_g(IBlockAccess block, int x, int y, int z)
    {
        int l = block.getBlockMetadata(x, y, z);
        boolean flag = (l & 8) != 0;
        int i1;
        int j1;

        if (flag)
        {
            i1 = block.getBlockMetadata(x, y - 1, z);
            j1 = l;
        }
        else
        {
            i1 = l;
            j1 = block.getBlockMetadata(x, y + 1, z);
        }

        boolean flag1 = (j1 & 1) != 0;
        return i1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return this.blockMaterial == Material.iron ? NPItemList.itemBlackironDoor : NPItemList.itemGrimwoodDoor;
    }

    public void onBlockHarvested(World world, int x, int y, int z, int block, EntityPlayer entity)
    {
        if (entity.capabilities.isCreativeMode && (block & 8) != 0 && world.getBlock(x, y - 1, z) == this)
        {
        	world.setBlockToAir(x, y - 1, z);
        }
    }
}