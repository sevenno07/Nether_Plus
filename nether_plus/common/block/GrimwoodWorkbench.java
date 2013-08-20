package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import nether_plus.common.NetherPlusCreativeTabs;

public class GrimwoodWorkbench extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private Icon workbenchIconFront;

    protected GrimwoodWorkbench(int par1)
    {
        super(par1, Material.wood);
        this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? NPBlockList.GrimwoodPlanks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Nether_plus:workbench_side");
        this.workbenchIconTop = par1IconRegister.registerIcon("Nether_plus:workbench_top");
        this.workbenchIconFront = par1IconRegister.registerIcon("Nether_plus:workbench_front");
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
            return true;
        }
    }
}