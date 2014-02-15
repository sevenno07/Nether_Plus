package nether_plus.common.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
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
                Block block = par3World.getBlock(par4, par5, par6);
                int j1 = par3World.getBlockMetadata(par4, par5, par6);

                if (block == Blocks.log && BlockLog.func_150165_c(j1) == 3)
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
                    
                    if (par3World.isAirBlock(par4, par5, par6))
                    {
                        int i1 = Blocks.cocoa.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
                        par3World.setBlock(par4, par5, par6, Blocks.cocoa, i1, 2);

                        if (!par2EntityPlayer.capabilities.isCreativeMode)
                        {
                            --par1ItemStack.stackSize;
                        }
                    }
                    
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean func_96604_a(ItemStack par0ItemStack, World par1World, int par2, int par3, int par4)
    {
    	if(par1World instanceof WorldServer)
    	{
            return applyBonemeal(par0ItemStack, par1World, par2, par3, par4, FakePlayerFactory.getMinecraft((WorldServer) par1World));
    	}
    	return false;
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

        if (block instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)block;

            if (igrowable.func_149851_a(par1World, par2, par3, par4, par1World.isRemote))
            {
                if (!par1World.isRemote)
                {
                    if (igrowable.func_149852_a(par1World, par1World.rand, par2, par3, par4))
                    {
                        igrowable.func_149853_b(par1World, par1World.rand, par2, par3, par4);
                    }

                    --par0ItemStack.stackSize;
                }
                return true;
            }
        }
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:BlackBoneMeal");
 	}
}