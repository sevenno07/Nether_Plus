package nether_plus.common.block;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class QuicksilverFluid extends BlockLiquid
{
    private IIcon[] field_149806_a;
    
	public QuicksilverFluid()
	{
		super(Material.water);            
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
	}
       
	public void onEntityCollidedWithBlock(World world, int par2, int par3, int par4, Entity entity)
	{
		if (entity instanceof EntityLiving)
		{
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.getId(),25, 500));
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),200, 10));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.field_149806_a = new IIcon[] { iconRegister.registerIcon("nether_plus:Quicksilver"), iconRegister.registerIcon("nether_plus:Quicksilver_flow") };
	}
}