package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Netherraze extends Block
{
	public Netherraze(int id, Material par2Material) 
	{
		super(id, par2Material);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
	
	
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
{
float var5 = 0.0625F;
return AxisAlignedBB.getAABBPool().getAABB((double)((float)x + var5), (double)y, (double)((float)z + var5), (double)((float)(x + 1) - var5), (double)((float)(y + 1) - var5), (double)((float)(z + 1) - var5));
}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
{
entity.setFire(15);
}
	
	
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.blockIcon = iconregister.registerIcon("nether_plus:Netherraze");
 	}
}