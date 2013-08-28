package nether_plus.common.block;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrimwoodWorkbench extends BlockWorkbench
{
    @SideOnly(Side.CLIENT)
    private Icon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private Icon workbenchIconFront;

    protected GrimwoodWorkbench(int par1)
    {
        super(par1);
        this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
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
}