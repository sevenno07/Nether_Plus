package nether_plus.common.block;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nether_plus.common.Nether_plus;
import nether_plus.common.block.container.InventoryGrimwoodLargeChest;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import nether_plus.common.tileentity.TileEntityGrimwoodChest;
import nether_plus.proxy.NPClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrimwoodChest extends BlockContainer
{
	private final Random random = new Random();
    public final int field_149956_a;
	
	protected GrimwoodChest(int i)
	{
		super(Material.wood);
		this.field_149956_a = i;
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
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
    public int getRenderType()
    {
        return NPClientProxy.renderGrimwoodChest;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z - 1) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (world.getBlock(x, y, z + 1) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
        }
        else if (world.getBlock(x - 1, y, z) == this)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (world.getBlock(x + 1, y, z) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
        }
        else
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.func_149954_e(world, x, y, z);
        Block l = world.getBlock(x, y, z - 1);
        Block i1 = world.getBlock(x, y, z + 1);
        Block j1 = world.getBlock(x - 1, y, z);
        Block k1 = world.getBlock(x + 1, y, z);

        if (l == this)
        {
            this.func_149954_e(world, x, y, z - 1);
        }

        if (i1 == this)
        {
            this.func_149954_e(world, x, y, z + 1);
        }

        if (j1 == this)
        {
            this.func_149954_e(world, x - 1, y, z);
        }

        if (k1 == this)
        {
            this.func_149954_e(world, x + 1, y, z);
        }
    }
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving living, ItemStack itemStack)
    {
        Block l = world.getBlock(x, y, z - 1);
        Block i1 = world.getBlock(x, y, z + 1);
        Block j1 = world.getBlock(x - 1, y, z);
        Block k1 = world.getBlock(x + 1, y, z);
        byte b0 = 0;
        int l1 = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l1 == 0)
        {
            b0 = 2;
        }

        if (l1 == 1)
        {
            b0 = 5;
        }

        if (l1 == 2)
        {
            b0 = 3;
        }

        if (l1 == 3)
        {
            b0 = 4;
        }

        if (l != this && i1 != this && j1 != this && k1 != this)
        {
            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
        }
        else
        {
            if ((l == this || i1 == this) && (b0 == 4 || b0 == 5))
            {
                if (l == this)
                {
                    world.setBlockMetadataWithNotify(x, y, z - 1, b0, 3);
                }
                else
                {
                    world.setBlockMetadataWithNotify(x, y, z + 1, b0, 3);
                }

                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
            }

            if ((j1 == this || k1 == this) && (b0 == 2 || b0 == 3))
            {
                if (j1 == this)
                {
                    world.setBlockMetadataWithNotify(x - 1, y, z, b0, 3);
                }
                else
                {
                    world.setBlockMetadataWithNotify(x + 1, y, z, b0, 3);
                }

                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
            }
        }

        if (itemStack.hasDisplayName())
        {
            ((TileEntityGrimwoodChest)world.getTileEntity(x, y, z)).func_145976_a(itemStack.getDisplayName());
        }
    }

    public void func_149954_e(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block l = world.getBlock(x, y, z - 1);
            Block i1 = world.getBlock(x, y, z + 1);
            Block j1 = world.getBlock(x - 1, y, z);
            Block k1 = world.getBlock(x + 1, y, z);
            boolean flag = true;
            Block l1;
            Block i2;
            boolean flag1;
            byte b0;
            int j2;

            if (l != this && i1 != this)
            {
                if (j1 != this && k1 != this)
                {
                    b0 = 3;

                    if (l.func_149730_j() && !i1.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if (i1.func_149730_j() && !l.func_149730_j())
                    {
                        b0 = 2;
                    }

                    if (j1.func_149730_j() && !k1.func_149730_j())
                    {
                        b0 = 5;
                    }

                    if (k1.func_149730_j() && !j1.func_149730_j())
                    {
                        b0 = 4;
                    }
                }
                else
                {
                    l1 = world.getBlock(j1 == this ? x - 1 : x + 1, y, z - 1);
                    i2 = world.getBlock(j1 == this ? x - 1 : x + 1, y, z + 1);
                    b0 = 3;
                    flag1 = true;

                    if (j1 == this)
                    {
                        j2 = world.getBlockMetadata(x - 1, y, z);
                    }
                    else
                    {
                        j2 = world.getBlockMetadata(x + 1, y, z);
                    }

                    if (j2 == 2)
                    {
                        b0 = 2;
                    }

                    if ((l.func_149730_j() || l1.func_149730_j()) && !i1.func_149730_j() && !i2.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if ((i1.func_149730_j() || i2.func_149730_j()) && !l.func_149730_j() && !l1.func_149730_j())
                    {
                        b0 = 2;
                    }
                }
            }
            else
            {
                l1 = world.getBlock(x - 1, y, l == this ? z - 1 : z + 1);
                i2 = world.getBlock(x + 1, y, l == this ? z - 1 : z + 1);
                b0 = 5;
                flag1 = true;

                if (l == this)
                {
                    j2 = world.getBlockMetadata(x, y, z - 1);
                }
                else
                {
                    j2 = world.getBlockMetadata(x, y, z + 1);
                }

                if (j2 == 4)
                {
                    b0 = 4;
                }

                if ((j1.func_149730_j() || l1.func_149730_j()) && !k1.func_149730_j() && !i2.func_149730_j())
                {
                    b0 = 5;
                }

                if ((k1.func_149730_j() || i2.func_149730_j()) && !j1.func_149730_j() && !l1.func_149730_j())
                {
                    b0 = 4;
                }
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
        }
    }
    
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        int l = 0;

        if (world.getBlock(x - 1, y, z) == this)
        {
            ++l;
        }

        if (world.getBlock(x + 1, y, z) == this)
        {
            ++l;
        }

        if (world.getBlock(x, y, z - 1) == this)
        {
            ++l;
        }

        if (world.getBlock(x, y, z + 1) == this)
        {
            ++l;
        }

        return l > 1 ? false : (this.func_149952_n(world, x - 1, y, z) ? false : (this.func_149952_n(world, x + 1, y, z) ? false : (this.func_149952_n(world, x, y, z - 1) ? false : !this.func_149952_n(world, x, y, z + 1))));
    }

    private boolean func_149952_n(World world, int x, int y, int z)
    {
        return world.getBlock(x, y, z) != this ? false : (world.getBlock(x - 1, y, z) == this ? true : (world.getBlock(x + 1, y, z) == this ? true : (world.getBlock(x, y, z - 1) == this ? true : world.getBlock(x, y, z + 1) == this)));
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        super.onNeighborBlockChange(world, x, y, z, block);
        TileEntityGrimwoodChest tileentitygrimwoodchest = (TileEntityGrimwoodChest)world.getTileEntity(x, y, z);

        if (tileentitygrimwoodchest != null)
        {
            tileentitygrimwoodchest.updateContainingBlockInfo();
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int par6)
    {
        TileEntityGrimwoodChest tileentitygrimwoodchest = (TileEntityGrimwoodChest)world.getTileEntity(x, y, z);

        if (tileentitygrimwoodchest != null)
        {
            for (int j1 = 0; j1 < tileentitygrimwoodchest.getSizeInventory(); ++j1)
            {
                ItemStack itemstack = tileentitygrimwoodchest.getStackInSlot(j1);

                if (itemstack != null)
                {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int k1 = this.random.nextInt(21) + 10;

                        if (k1 > itemstack.stackSize)
                        {
                            k1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= k1;
                        entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, par6);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            IInventory iinventory = this.func_149951_m(world, x, y, z);

            if (iinventory != null)
            {
            	player.openGui(Nether_plus.instance, 3, world, x, y, z);
            }

            return true;
        }
    }
    
    public IInventory func_149951_m(World world, int x, int y, int z)
    {
    	Object object = (TileEntityGrimwoodChest)world.getTileEntity(x, y, z);

        if (object == null)
        {
            return null;
        }
        else if (world.isSideSolid(x, y + 1, z, DOWN))
        {
            return null;
        }
        else if (func_149953_o(world, x, y, z))
        {
            return null;
        }
        else if (world.getBlock(x - 1, y, z) == this && (world.isSideSolid(x - 1, y + 1, z, DOWN) || func_149953_o(world, x - 1, y, z)))
        {
            return null;
        }
        else if (world.getBlock(x + 1, y, z) == this && (world.isSideSolid(x + 1, y + 1, z, DOWN) || func_149953_o(world, x + 1, y, z)))
        {
            return null;
        }
        else if (world.getBlock(x, y, z - 1) == this && (world.isSideSolid(x, y + 1, z - 1, DOWN) || func_149953_o(world, x, y, z - 1)))
        {
            return null;
        }
        else if (world.getBlock(x, y, z + 1) == this && (world.isSideSolid(x, y + 1, z + 1, DOWN) || func_149953_o(world, x, y, z + 1)))
        {
            return null;
        }
        else
        {
            if (world.getBlock(x - 1, y, z) == this)
            {
                object = new InventoryGrimwoodLargeChest("container.chestDouble", (TileEntityGrimwoodChest)world.getTileEntity(x - 1, y, z), (IInventory)object);
            }

            if (world.getBlock(x + 1, y, z) == this)
            {
                object = new InventoryGrimwoodLargeChest("container.chestDouble", (IInventory)object, (TileEntityGrimwoodChest)world.getTileEntity(x + 1, y, z));
            }

            if (world.getBlock(x, y, z - 1) == this)
            {
                object = new InventoryGrimwoodLargeChest("container.chestDouble", (TileEntityGrimwoodChest)world.getTileEntity(x, y, z - 1), (IInventory)object);
            }

            if (world.getBlock(x, y, z + 1) == this)
            {
                object = new InventoryGrimwoodLargeChest("container.chestDouble", (IInventory)object, (TileEntityGrimwoodChest)world.getTileEntity(x, y, z + 1));
            }

            return (IInventory)object;
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityGrimwoodChest();
	}
	
	public boolean canProvidePower()
    {
        return this.field_149956_a == 1;
    }

    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int p_149709_5_)
    {
        if (!this.canProvidePower())
        {
            return 0;
        }
        else
        {
            int i1 = ((TileEntityGrimwoodChest)world.getTileEntity(x, y, z)).numUsingPlayers;
            return MathHelper.clamp_int(i1, 0, 15);
        }
    }

    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int p_149748_5_)
    {
        return p_149748_5_ == 1 ? this.isProvidingWeakPower(world, x, y, z, p_149748_5_) : 0;
    }

    private static boolean func_149953_o(World world, int x, int y, int z)
    {
        Iterator iterator = world.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getAABBPool().getAABB((double)x, (double)(y + 1), (double)z, (double)(x + 1), (double)(y + 2), (double)(z + 1))).iterator();
        EntityOcelot entityocelot1;

        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }

            EntityOcelot entityocelot = (EntityOcelot)iterator.next();
            entityocelot1 = (EntityOcelot)entityocelot;
        }
        while (!entityocelot1.isSitting());

        return true;
    }
    
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
    {
        return Container.calcRedstoneFromInventory(this.func_149951_m(p_149736_1_, p_149736_2_, p_149736_3_, p_149736_4_));
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("nether_plus:GrimwoodPlanks");
    }
}