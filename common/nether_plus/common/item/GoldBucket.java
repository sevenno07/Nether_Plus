package nether_plus.common.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GoldBucket extends Item
{
	private Block isFull;
	
	public GoldBucket(Block block)
	{
		super();
		this.maxStackSize = 1;
		this.isFull = block;
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

        if (movingobjectposition == null)
        {
            return par1ItemStack;
        }
        else
        {
            FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return par1ItemStack;
            }

            if (event.getResult() == Event.Result.ALLOW)
            {
                if (par3EntityPlayer.capabilities.isCreativeMode)
                {
                    return par1ItemStack;
                }

                if (--par1ItemStack.stackSize <= 0)
                {
                    return event.result;
                }

                if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result))
                {
                    par3EntityPlayer.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return par1ItemStack;
            }

            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                {
                    return par1ItemStack;
                }

                if (flag)
                {
                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }
                    
                    Material material = par2World.getBlock(i, j, k).getMaterial();
                    int l = par2World.getBlockMetadata(i, j, k);

                    if (material == Material.water && l == 0)
                    {
                        par2World.setBlockToAir(i, j, k);
                        return this.func_150910_a(par1ItemStack, par3EntityPlayer, NPItemList.waterBucket);
                    }

                    if (material == Material.lava && l == 0)
                    {
                        par2World.setBlockToAir(i, j, k);
                        return this.func_150910_a(par1ItemStack, par3EntityPlayer, NPItemList.lavaBucket);
                    }
                    
                    if (material == Material.water && l == 0)
                    {
                        par2World.setBlockToAir(i, j, k);
                        return this.func_150910_a(par1ItemStack, par3EntityPlayer, NPItemList.quickSilverBucket);
                    }
                }
                else
                {
                    if (this.isFull == Blocks.air)
                    {
                        return new ItemStack(NPItemList.goldBucket);
                    }

                    if (movingobjectposition.sideHit == 0)
                    {
                        --j;
                    }

                    if (movingobjectposition.sideHit == 1)
                    {
                        ++j;
                    }

                    if (movingobjectposition.sideHit == 2)
                    {
                        --k;
                    }

                    if (movingobjectposition.sideHit == 3)
                    {
                        ++k;
                    }

                    if (movingobjectposition.sideHit == 4)
                    {
                        --i;
                    }

                    if (movingobjectposition.sideHit == 5)
                    {
                        ++i;
                    }

                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                    if (this.tryPlaceContainedLiquid(par2World, i, j, k) && !par3EntityPlayer.capabilities.isCreativeMode)
                    {
                        return new ItemStack(NPItemList.goldBucket);
                    }
                }
            }
            return par1ItemStack;
        }
    }
	
	private ItemStack func_150910_a(ItemStack itemStack, EntityPlayer player, Item item)
    {
        if (player.capabilities.isCreativeMode)
        {
            return itemStack;
        }
        else if (--itemStack.stackSize <= 0)
        {
            return new ItemStack(item);
        }
        else
        {
            if (!player.inventory.addItemStackToInventory(new ItemStack(item)))
            {
                player.dropPlayerItemWithRandomChoice(new ItemStack(item, 1, 0), false);
            }

            return itemStack;
        }
    }
	
    public boolean tryPlaceContainedLiquid(World world, int x, int y, int z)
    {
        if (this.isFull == Blocks.air)
        {
            return false;
        }
        
        Material material = world.getBlock(x, y, z).getMaterial();
        boolean flag = !material.isSolid();
        
        if (!world.isAirBlock(x, y, z) && flag)
        {
            return false;
        }
        else
        {
            if (world.provider.isHellWorld && this.isFull == Blocks.flowing_water)
            {
                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

                for (int l = 0; l < 8; ++l)
                {
                    world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
                }
            }
            else
            {
                if (!world.isRemote && flag && !material.isLiquid())
                {
                    world.func_147480_a(x, y, z, true);
                }

                world.setBlock(x, y, z, this.isFull, 0, 3);
            }

            return true;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("nether_plus:GoldBucket");
    }
}