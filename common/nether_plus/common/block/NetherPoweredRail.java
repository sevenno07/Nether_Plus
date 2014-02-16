package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherPoweredRail extends BlockRailPowered
{
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    protected NetherPoweredRail(int par1)
    {
        super();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par2 >= 6 ? this.theIcon : this.blockIcon;
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 2.0D;
        par5Entity.motionZ *= 2.0D;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        super.registerBlockIcons(par1IconRegister);
        this.theIcon = par1IconRegister.registerIcon("nether_plus:NetherPoweredRail_Turn");
        this.blockIcon = par1IconRegister.registerIcon("nether_plus:NetherPoweredRail");
    }

    protected void func_94358_a(World par1World, int par2, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 0 && Block.blocksList[par7].canProvidePower() && (new BlockBaseRailLogic(this, par1World, par2, par3, par4)).getNumberOfAdjacentTracks() == 3)
        {
            this.refreshTrackShape(par1World, par2, par3, par4, false);
        }
    }
}