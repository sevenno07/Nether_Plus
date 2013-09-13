package nether_plus.common.block;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.liquids.ILiquid;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AcidStationary extends BlockStationary implements ILiquid

{
	public AcidStationary(int par1)
	{
		super(par1, Material.water);
		this.blockHardness = 100.0F;
		this.setLightOpacity(2);
		this.disableStats();
		this.setTickRandomly(true);
	}

	public void onEntityCollidedWithBlock(World world, int par2, int par3, int par4, Entity entity)
	{
		if (entity instanceof EntityLiving)
		{
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(),200, 500));
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(),200, 10));
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.getId(),100, 500));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.theIcon = new Icon[]
		{
		reg.registerIcon("nether_plus:Acid"), reg.registerIcon("nether_plus:Acid_flow")
		};
	}

	@Override
	public int stillLiquidId()
	{
		return this.blockID;
	}

	@Override
	public boolean isMetaSensitive()
	{
		return true;
	}

	@Override
	public int stillLiquidMeta()
	{
		return 0;
	}

	@Override
	public boolean isBlockReplaceable(World world, int i, int j, int k)
	{
		return true;
	}

}