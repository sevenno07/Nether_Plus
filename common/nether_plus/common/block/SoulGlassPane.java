package nether_plus.common.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoulGlassPane extends BlockPane
{
	protected SoulGlassPane(String par2Str, String par3Str, Material par4Material, boolean par5)
	{
		super(par2Str, par3Str, par4Material, par5);
	}
	
	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 0.4D;
        par5Entity.motionZ *= 0.4D;
    }
}