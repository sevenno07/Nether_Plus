package nether_plus.common.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;
import nether_plus.proxy.NPClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChiliC extends BlockBush implements IGrowable
{
    private final Block ChiliIcon;
    @SideOnly(Side.CLIENT)
    private IIcon field_149876_b;

    protected ChiliC(Block block)
    {
        this.ChiliIcon = block;
        this.setTickRandomly(true);
        float f = 0.125F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setCreativeTab((CreativeTabs)null);
    }

    /**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block block)
    {
        return block == NPBlockList.nether_Farm;
    }

	public boolean renderAsNormalBlock()
	{
		return false;
	}
    
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        super.updateTick(world, x, y, z, random);

        if (world.getBlockLightValue(x, y + 1, z) >= 9)
        {
            float f = this.func_149875_n(world, x, y, z);

            if (random.nextInt((int)(25.0F / f) + 1) == 0)
            {
                int l = world.getBlockMetadata(x, y, z);

                if (l < 7)
                {
                    ++l;
                    world.setBlockMetadataWithNotify(x, y, z, l, 2);
                }
                else
                {
                    if (world.getBlock(x - 1, y, z) == this.ChiliIcon)
                    {
                        return;
                    }

                    if (world.getBlock(x + 1, y, z) == this.ChiliIcon)
                    {
                        return;
                    }

                    if (world.getBlock(x, y, z - 1) == this.ChiliIcon)
                    {
                        return;
                    }

                    if (world.getBlock(x, y, z + 1) == this.ChiliIcon)
                    {
                        return;
                    }

                    int i1 = random.nextInt(4);
                    int j1 = x;
                    int k1 = z;

                    if (i1 == 0)
                    {
                        j1 = x - 1;
                    }

                    if (i1 == 1)
                    {
                        ++j1;
                    }

                    if (i1 == 2)
                    {
                        k1 = z - 1;
                    }

                    if (i1 == 3)
                    {
                        ++k1;
                    }

                    Block block = world.getBlock(j1, y - 1, k1);

                    if (world.isAirBlock(j1, y, k1) && (block.canSustainPlant(world, j1, y - 1, k1, UP, this) || block == Blocks.soul_sand || block == NPBlockList.corruptedCobblestone))
                    {
                        world.setBlock(j1, y, k1, this.ChiliIcon);
                    }
                }
            }
        }
    }

    public void fertilizeStem(World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }
    
    public void func_149874_m(World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    private float func_149875_n(World world, int x, int y, int z)
    {
        float f = 1.0F;
        Block block = world.getBlock(x, y, z - 1);
        Block block1 = world.getBlock(x, y, z + 1);
        Block block2 = world.getBlock(x - 1, y, z);
        Block block3 = world.getBlock(x + 1, y, z);
        Block block4 = world.getBlock(x - 1, y, z - 1);
        Block block5 = world.getBlock(x + 1, y, z - 1);
        Block block6 = world.getBlock(x + 1, y, z + 1);
        Block block7 = world.getBlock(x - 1, y, z + 1);
        boolean flag = block2 == this || block3 == this;
        boolean flag1 = block == this || block1 == this;
        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

        for (int l = x - 1; l <= x + 1; ++l)
        {
            for (int i1 = z - 1; i1 <= z + 1; ++i1)
            {
                Block block8 = world.getBlock(l, y - 1, i1);
                float f1 = 0.0F;

                if (block8.canSustainPlant(world, l, y - 1, i1, UP, this))
                {
                    f1 = 1.0F;

                    if (block8.isFertile(world, l, y - 1, i1))
                    {
                        f1 = 3.0F;
                    }
                }

                if (l != x || i1 != z)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
            f /= 2.0F;
        }

        return f;
    }
    
    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        float f = 0.125F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int x, int y, int z)
    {
        this.maxY = (double)((float)(iblockaccess.getBlockMetadata(x, y, z) * 2 + 2) / 16.0F);
        float f = 0.125F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, (float)this.maxY, 0.5F + f);
    }

    /**
     * The type of render function that is called for this block
     */
    @SideOnly(Side.CLIENT)
	public int getRenderType()
    {
    	return NPClientProxy.renderStemModID;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
    	return true;
    }

    /**
     * Returns the current state of the stem. Returns -1 if the stem is not fully grown, or a value between 0 and 3
     * based on the direction the stem is facing.
     */
    @SideOnly(Side.CLIENT)
    public int getState(IBlockAccess iblockaccess, int x, int y, int z)
    {
        int l = iblockaccess.getBlockMetadata(x, y, z);
        return l < 7 ? -1 : (iblockaccess.getBlock(x - 1, y, z) == this.ChiliIcon ? 0 : (iblockaccess.getBlock(x + 1, y, z) == this.ChiliIcon ? 1 : (iblockaccess.getBlock(x, y, z - 1) == this.ChiliIcon ? 2 : (iblockaccess.getBlock(x, y, z + 1) == this.ChiliIcon ? 3 : -1))));
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
        super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);

        
        if (!p_149690_1_.isRemote)
        {
            Item item = null;

            if (this.ChiliIcon == NPBlockList.chiliB)
            {
                item = NPItemList.chiliSeed;
            }

            for (int j1 = 0; j1 < 3; ++j1)
            {
                if (p_149690_1_.rand.nextInt(15) <= p_149690_5_)
                {
                    this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(item));
                }
            }
        }
        
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_) != 7;
    }

    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return true;
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return this.ChiliIcon == NPBlockList.chiliB ? NPItemList.chiliSeed :  Item.getItemById(0);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_disconnected");
        this.field_149876_b = p_149651_1_.registerIcon(this.getTextureName() + "_connected");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getStemIcon()
    {
        return this.field_149876_b;
    }

    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        this.func_149874_m(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
    }


    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        Item item = null;
        item = ChiliIcon == NPBlockList.chiliB ? NPItemList.chiliSeed : item;

        for (int i = 0; item != null && i < 3; i++)
        {
            ret.add(new ItemStack(item));
        }

        return ret;
    }
}