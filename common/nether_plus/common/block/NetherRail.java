package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherRail extends BlockRail
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150056_b;

    protected NetherRail()
    {
        super();
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

    protected void func_150048_a(World world, int x, int y, int z, int par5, int par6, Block block)
    {
        /*if (block.canProvidePower() && (new BlockRailBase.Rail(world, x, y, z)).func_150650_a() == 3)
        {
            this.func_150052_a(world, x, y, z, false);
        }*/
    }
}

/*import net.minecraft.block.Block;
import net.minecraft.block.BlockBaseRailLogic;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherRail extends BlockRailBase
{
    @SideOnly(Side.CLIENT)
    private Icon theIcon;

    protected NetherRail(int par1)
    {
        super(par1, false);
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return par2 >= 6 ? this.theIcon : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        super.registerIcons(par1IconRegister);
        this.theIcon = par1IconRegister.registerIcon("nether_plus:NetherRail_Turn");
        this.blockIcon = par1IconRegister.registerIcon("nether_plus:NetherRail");
    }

    protected void func_94358_a(World par1World, int par2, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 0 && Block.blocksList[par7].canProvidePower() && (new BlockBaseRailLogic(this, par1World, par2, par3, par4)).getNumberOfAdjacentTracks() == 3)
        {
            this.refreshTrackShape(par1World, par2, par3, par4, false);
        }
    }
}*/