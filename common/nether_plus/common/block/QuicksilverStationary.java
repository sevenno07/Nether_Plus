package nether_plus.common.block;

import net.minecraft.block.Block;
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

public class QuicksilverStationary extends BlockLiquid
{
    private IIcon[] field_149806_a;
	
	protected QuicksilverStationary()
	{
		super(Material.water);
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
		this.disableStats();
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        super.onNeighborBlockChange(world, x, y, z, block);

        if (world.getBlock(x, y, z) == this)
        {
            this.setNotStationary(world, x, y, z);
        }
    }
	
	private void setNotStationary(World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        world.setBlock(x, y, z, Block.getBlockById(Block.getIdFromBlock(this) - 1), l, 2);
        world.scheduleBlockUpdate(x, y, z, Block.getBlockById(Block.getIdFromBlock(this) - 1), this.tickRate(world));
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
/*
import net.minecraft.block.BlockStaticLiquid;
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

public class QuicksilverStationary extends BlockStaticLiquid
{
    private IIcon[] field_149806_a;
	public QuicksilverStationary()
	{
		super(Material.water);
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
		this.disableStats();
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
}*/