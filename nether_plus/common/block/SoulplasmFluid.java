package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class SoulplasmFluid extends BlockFlowing
{
       
	public SoulplasmFluid(int par1)
	{
		super(par1, Material.lava);            
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
	}
       
	public void onEntityCollidedWithBlock(World world, int par2, int par3, int par4, Entity entity)
	{
		if (entity instanceof EntityLiving)
		{
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(),300, 20));
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.fireResistance.getId(),1000, 10));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.theIcon = new Icon[]
				{
				iconRegister.registerIcon("nether_plus:Soulplasm"),
				iconRegister.registerIcon("nether_plus:Soulplasm_flow")
				};
	}
}