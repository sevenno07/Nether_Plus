package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import nether_plus.common.NetherPlusCreativeTabs;

public class ModFence extends BlockFence
{
    public ModFence(int par1, String par2Str, Material par3Material)
    {
        super(par1, par2Str, par3Material);
        this.setCreativeTab(NetherPlusCreativeTabs.NetherPlusCreativeTabs);
	}
    
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.blockIcon = iconregister.registerIcon("nether_plus:GrimwoodPlanks");
 	}
}