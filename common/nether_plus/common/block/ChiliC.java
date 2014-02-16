package nether_plus.common.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChiliC extends BlockBush implements IGrowable
{
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    protected ChiliC()
    {
        super();
        this.setTickRandomly(true);
        float f = 0.125F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setCreativeTab((CreativeTabs)null);
    }

    protected boolean canThisPlantGrowOnThisBlockID(Block block)
    {
        return block == NPBlockList.Nether_Farm;
    }

    public void updateTick(World world, int x, int y, int z, Random rand)
    {
    	super.updateTick(world, x, y, z, rand);

        if (world.getBlockLightValue(x, y + 1, z) >= 9)
        {
            int l = world.getBlockMetadata(x, y, z);

            if (l < 7)
            {
                float f = this.getGrowthModifier(world, x, y, z);

                if (rand.nextInt((int)(25.0F / f) + 1) == 0)
                {
                    ++l;
                    world.setBlockMetadataWithNotify(x, y, z, l, 2);
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

    private float getGrowthModifier(World world, int x, int y, int z)
    {
        float f = 1.0F;
        Block l = world.getBlock(x, y, z - 1);
        Block i1 = world.getBlock(x, y, z + 1);
        Block j1 = world.getBlock(x - 1, y, z);
        Block k1 = world.getBlock(x + 1, y, z);
        Block l1 = world.getBlock(x - 1, y, z - 1);
        Block i2 = world.getBlock(x + 1, y, z - 1);
        Block j2 = world.getBlock(x + 1, y, z + 1);
        Block k2 = world.getBlock(x - 1, y, z + 1);
        boolean flag = j1 == this || k1 == this;
        boolean flag1 = l == this || i1 == this;
        boolean flag2 = l1 == this || i2 == this || j2 == this || k2 == this;

        for (int l2 = x - 1; l2 <= x + 1; ++l2)
        {
            for (int i3 = z - 1; i3 <= z + 1; ++i3)
            {
                Block j3 = world.getBlock(l2, y - 1, i3);
                float f1 = 0.0F;

                if (j3 != null && j3.canSustainPlant(world, l2, y - 1, i3, ForgeDirection.UP, this))
                {
                    f1 = 1.0F;

                    if (j3.isFertile(world, l2, y - 1, i3))
                    {
                        f1 = 3.0F;
                    }
                }

                if (l2 != x || i3 != z)
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
    
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int par1)
    {
        int j = par1 * 32;
        int k = 255 - par1 * 8;
        int l = par1 * 4;
        return j << 16 | k << 8 | l;
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return this.getRenderColor(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }

    public void setBlockBoundsForItemRender()
    {
        float f = 0.125F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.maxY = (double)((float)(par1IBlockAccess.getBlockMetadata(par2, par3, par4) * 2 + 2) / 16.0F);
        float f = 0.125F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, (float)this.maxY, 0.5F + f);
    }
    
    public int getRenderType()
    {
        return -1;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
    	return this.getSeedItem();
    }

    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
    }

    @Override 
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        for (int i = 0; i < 3; i++)
        {
            if (world.rand.nextInt(15) <= metadata)
            {
                ret.add(new ItemStack(this.getSeedItem(), 1, 0));
            }
        }

        return ret;
    }

    public Item idDropped(int par1, Random par2Random, int par3)
    {
        return NPItemList.ChiliSeed;
    }

    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    protected Item getSeedItem()
    {
        return NPItemList.ChiliSeed;
    }
    
    @SideOnly(Side.CLIENT)
    public Item idPicked(World par1World, int par2, int par3, int par4)
    {
        return this.getSeedItem();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("nether_plus:stem_straight");
        this.theIcon = par1IconRegister.registerIcon("nether_plus:stem_bent");
    }

    @SideOnly(Side.CLIENT)
    public IIcon func_94368_p()
    {
        return this.theIcon;
    }

	@Override
	public boolean func_149851_a(World var1, int var2, int var3, int var4, boolean var5)
	{
		return false;
	}

	@Override
	public boolean func_149852_a(World var1, Random var2, int var3, int var4, int var5)
	{
		return false;
	}

	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z)
	{
		return;
	}
}