package nether_plus.common.block;

import net.minecraft.block.BlockRail;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherPoweredRail extends BlockRail
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150056_b;

    protected NetherPoweredRail()
    {
        super();
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 1.22D;
        par5Entity.motionZ *= 1.22D;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_2_ >= 6 ? this.field_150056_b : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        super.registerBlockIcons(p_149651_1_);
        this.field_150056_b = p_149651_1_.registerIcon(this.getTextureName() + "_Turn");
    }
}

/*import net.minecraft.block.Block;
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

    protected NetherPoweredRail()
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
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        super.registerBlockIcons(par1IconRegister);
        this.theIcon = par1IconRegister.registerIcon("nether_plus:NetherPoweredRail_Turn");
        this.blockIcon = par1IconRegister.registerIcon("nether_plus:NetherPoweredRail");
    }

    protected void func_150048_a(World world, int x, int y, int z, int par5, int par6, Block block)
    {
        boolean flag = world.isBlockIndirectlyGettingPowered(x, y, z);
        flag = flag || this.func_150058_a(world, x, y, z, par5, true, 0) || this.func_150058_a(world, x, y, z, par5, false, 0);
        boolean flag1 = false;

        if (flag && (par5 & 8) == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, par6 | 8, 3);
            flag1 = true;
        }
        else if (!flag && (par5 & 8) != 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, par6, 3);
            flag1 = true;
        }

        if (flag1)
        {
            world.notifyBlocksOfNeighborChange(x, y - 1, z, this);

            if (par6 == 2 || par6 == 3 || par6 == 4 || par6 == 5)
            {
                world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
            }
        }
    }
}*/