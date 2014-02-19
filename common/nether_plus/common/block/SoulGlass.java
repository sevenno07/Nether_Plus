package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoulGlass extends BlockBreakable
{
    protected SoulGlass(Material par2Material, boolean par3)
    {
		super("glass", par2Material, par3);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}

	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    protected boolean canSilkHarvest()
    {
        return true;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.125F;
        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 0.4D;
        par5Entity.motionZ *= 0.4D;
    }

	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
	{
        this.blockIcon = iconregister.registerIcon("nether_plus:SoulGlass");
 	}
}