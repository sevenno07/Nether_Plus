package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AcidFluid extends BlockDynamicLiquid
{
    private IIcon[] field_149806_a;
	
	public AcidFluid()
	{
		super(Material.water);            
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
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
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block blockid)
	{
		super.onNeighborBlockChange(world, x, y, z, blockid);
		this.checkdoexplode(world, x, y, z);
	}
	
	public void checkdoexplode(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y - 1, z) == Blocks.water || world.getBlock(x, y + 1, z) == Blocks.water || world.getBlock(x - 1, y, z) == Blocks.water || world.getBlock(x + 1, y, z) == Blocks.water || world.getBlock(x, y, z - 1) == Blocks.water || world.getBlock(x, y, z + 1) == Blocks.water || world.getBlock(x, y - 1, z) == Blocks.flowing_water || world.getBlock(x, y + 1, z) == Blocks.flowing_water || world.getBlock(x - 1, y, z) == Blocks.flowing_water || world.getBlock(x + 1, y, z) == Blocks.flowing_water || world.getBlock(x, y, z - 1) == Blocks.flowing_water || world.getBlock(x, y, z + 1) == Blocks.flowing_water ||
				  (world.getBlock(x, y - 1, z) == Blocks.lava || world.getBlock(x, y + 1, z) == Blocks.lava || world.getBlock(x - 1, y, z) == Blocks.lava || world.getBlock(x + 1, y, z) == Blocks.lava || world.getBlock(x, y, z - 1) == Blocks.lava || world.getBlock(x, y, z + 1) == Blocks.lava || world.getBlock(x, y - 1, z) == Blocks.flowing_lava || world.getBlock(x, y + 1, z) == Blocks.flowing_lava || world.getBlock(x - 1, y, z) == Blocks.flowing_lava || world.getBlock(x + 1, y, z) == Blocks.flowing_lava || world.getBlock(x, y, z - 1) == Blocks.flowing_lava || world.getBlock(x, y, z + 1) == Blocks.flowing_lava) ||
				  (world.getBlock(x, y - 1, z) == NPBlockList.blockQuicksilver || world.getBlock(x, y + 1, z) == NPBlockList.blockQuicksilver || world.getBlock(x - 1, y, z) == NPBlockList.blockQuicksilver || world.getBlock(x + 1, y, z) == NPBlockList.blockQuicksilver || world.getBlock(x, y, z - 1) == NPBlockList.blockQuicksilver || world.getBlock(x, y, z + 1) == NPBlockList.blockQuicksilver ||
				  (world.getBlock(x, y - 1, z) == NPBlockList.SoulplasmStill || world.getBlock(x, y + 1, z) == NPBlockList.SoulplasmStill || world.getBlock(x - 1, y, z) == NPBlockList.SoulplasmStill || world.getBlock(x + 1, y, z) == NPBlockList.SoulplasmStill || world.getBlock(x, y, z - 1) == NPBlockList.SoulplasmStill || world.getBlock(x, y, z + 1) == NPBlockList.SoulplasmStill )))
		{
			if(!world.isRemote)
			{
				world.setBlockToAir(x, y, z);
				float power = (float)world.rand.nextInt(15) - 5.5F;
				if(power < 2.5F)
				{
					power = 5F;
				}
				EntityTNTPrimed tnt = new EntityTNTPrimed(world);
				world.newExplosion(tnt, x, y, z, power, true, true);
				world.notifyBlockChange(x, y, z, this);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.field_149806_a = new IIcon[] { iconRegister.registerIcon("nether_plus:Acid"), iconRegister.registerIcon("nether_plus:Acid_flow") };
	}
}