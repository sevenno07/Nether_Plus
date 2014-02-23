package nether_plus.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Soulplasm extends BlockFluidClassic
{
    private IIcon stillIcon, flowingIcon;
	
	public Soulplasm(Fluid fluid, Material material)
	{
		super(fluid, material);
		this.setTickRandomly(true);
	}
       
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityLivingBase)
		{
			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(),300, 20));
			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.fireResistance.getId(),1000, 10));
		}
	}
	
	public IIcon getIcon(int side, int metadata)
	{
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.stillIcon = iconRegister.registerIcon("nether_plus:Soulplasm");
		this.flowingIcon = iconRegister.registerIcon("nether_plus:Soulplasm_flow");
	}
	
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z).getMaterial().isLiquid())
		{
			return false;
		}
		return super.canDisplace(world, x, y, z);
	}

	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z).getMaterial().isLiquid())
		{
			return false;
		}
		return super.displaceIfPossible(world, x, y, z);
	}
}