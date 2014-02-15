package nether_plus.common.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.entity.player.BonemealEvent;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlackBoneMeal extends Item
{
	public BlackBoneMeal()
	{
		super();
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            if (par1ItemStack.getItemDamage() == 0)
            {
                if (applyBonemeal(par1ItemStack, par3World, par4, par5, par6, par2EntityPlayer))
                {
                    if (!par3World.isRemote)
                    {
                        par3World.playAuxSFX(2005, par4, par5, par6, 0);
                    }

                    return true;
                }
            }
            else if (par1ItemStack.getItemDamage() == 3)
            {
                Block i1 = par3World.getBlock(par4, par5, par6);
                int j1 = par3World.getBlockMetadata(par4, par5, par6);

                if (i1 == Blocks.log && BlockLog.limitToValidMetadata(j1) == 3)
                {
                    if (par7 == 0)
                    {
                        return false;
                    }

                    if (par7 == 1)
                    {
                        return false;
                    }

                    if (par7 == 2)
                    {
                        --par6;
                    }

                    if (par7 == 3)
                    {
                        ++par6;
                    }

                    if (par7 == 4)
                    {
                        --par4;
                    }

                    if (par7 == 5)
                    {
                        ++par4;
                    }

                    return true;
                }
            }

            return false;
        }
    }

    public static boolean func_96604_a(ItemStack par0ItemStack, World par1World, int par2, int par3, int par4)
    {
        return applyBonemeal(par0ItemStack, par1World, par2, par3, par4, FakePlayerFactory.getMinecraft(par1World));
    }

    public static boolean applyBonemeal(ItemStack par0ItemStack, World par1World, int par2, int par3, int par4, EntityPlayer player)
    {
        Block block = par1World.getBlock(par2, par3, par4);

        BonemealEvent event = new BonemealEvent(player, par1World, block, par2, par3, par4);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            if (!par1World.isRemote)
            {
                par0ItemStack.stackSize--;
            }
            return true;
        }

        if (block == Blocks.sapling)
        {
            if (!par1World.isRemote)
            {
                if ((double)par1World.rand.nextFloat() < 0.45D)
                {
                    ((BlockSapling)Blocks.sapling).markOrGrowMarked(par1World, par2, par3, par4, par1World.rand);
                }

                --par0ItemStack.stackSize;
            }

            return true;
        }
        else if (block != Blocks.brown_mushroom && block != Blocks.red_mushroom)
        {
            if (block != Blocks.melon_stem && block != Blocks.pumpkin_stem)
            {
                if (block > 0 && Block.blocksList[block] instanceof BlockCrops)
                {
                    if (par1World.getBlockMetadata(par2, par3, par4) == 7)
                    {
                        return false;
                    }
                    else
                    {
                        if (!par1World.isRemote)
                        {
                            ((BlockCrops)Block.blocksList[block]).fertilize(par1World, par2, par3, par4);
                            --par0ItemStack.stackSize;
                        }

                        return true;
                    }
                }
                else
                {
                    int i1;
                    int j1;
                    int k1;

                    if (block == Blocks.cocoa)
                    {
                        i1 = par1World.getBlockMetadata(par2, par3, par4);
                        j1 = BlockDirectional.getDirection(i1);
                        k1 = BlockCocoa.func_72219_c(i1);

                        if (k1 >= 2)
                        {
                            return false;
                        }
                        else
                        {
                            if (!par1World.isRemote)
                            {
                                ++k1;
                                par1World.setBlockMetadataWithNotify(par2, par3, par4, k1 << 2 | j1, 2);
                                --par0ItemStack.stackSize;
                            }

                            return true;
                        }
                    }
                    else if (block != Blocks.grass)
                    {
                        return false;
                    }
                    else
                    {
                        if (!par1World.isRemote)
                        {
                            --par0ItemStack.stackSize;
                            label102:

                            for (i1 = 0; i1 < 128; ++i1)
                            {
                                j1 = par2;
                                k1 = par3 + 1;
                                int l1 = par4;

                                for (int i2 = 0; i2 < i1 / 16; ++i2)
                                {
                                    j1 += itemRand.nextInt(3) - 1;
                                    k1 += (itemRand.nextInt(3) - 1) * itemRand.nextInt(3) / 2;
                                    l1 += itemRand.nextInt(3) - 1;

                                    if (par1World.getBlock(j1, k1 - 1, l1) != Blocks.grass || par1World.isBlockNormalCube(j1, k1, l1))
                                    {
                                        continue label102;
                                    }
                                }

                                if (par1World.getBlock(j1, k1, l1) == 0)
                                {
                                    if (itemRand.nextInt(10) != 0)
                                    {
                                        if (Blocks.tallgrass.canBlockStay(par1World, j1, k1, l1))
                                        {
                                            par1World.setBlock(j1, k1, l1, Blocks.tallgrass, 1, 3);
                                        }
                                    }
                                    else
                                    {
                                        ForgeHooks.plantGrass(par1World, j1, k1, l1);
                                    }
                                }
                            }
                        }

                        return true;
                    }
                }
            }
            else if (par1World.getBlockMetadata(par2, par3, par4) == 7)
            {
                return false;
            }
            else
            {
                if (!par1World.isRemote)
                {
                    ((BlockStem)Block.blocksList[block]).fertilizeStem(par1World, par2, par3, par4);
                    --par0ItemStack.stackSize;
                }

                return true;
            }
        }
        else
        {
            if (!par1World.isRemote)
            {
                if ((double)par1World.rand.nextFloat() < 0.4D)
                {
                    ((BlockMushroom)Block.blocksList[block]).fertilizeMushroom(par1World, par2, par3, par4, par1World.rand);
                }

                --par0ItemStack.stackSize;
            }

            return true;
        }
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:BlackBoneMeal");
 	}
}