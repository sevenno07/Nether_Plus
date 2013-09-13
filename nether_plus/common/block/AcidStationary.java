package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class AcidStationary extends BlockStationary
{
	public AcidStationary(int par1)
	{
		super(par1, Material.water);
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
		this.disableStats();
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
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid)
	{
		super.onNeighborBlockChange(world, x, y, z, blockid);
		this.checkdoexplode(world, x, y, z);
	}
	
	public void checkdoexplode(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y - 1, z) == Block.waterStill.blockID || world.getBlockId(x, y + 1, z) == Block.waterStill.blockID || world.getBlockId(x - 1, y, z) == Block.waterStill.blockID || world.getBlockId(x + 1, y, z) == Block.waterStill.blockID || world.getBlockId(x, y, z - 1) == Block.waterStill.blockID || world.getBlockId(x, y, z + 1) == Block.waterStill.blockID || world.getBlockId(x, y - 1, z) == Block.waterMoving.blockID || world.getBlockId(x, y + 1, z) == Block.waterMoving.blockID || world.getBlockId(x - 1, y, z) == Block.waterMoving.blockID || world.getBlockId(x + 1, y, z) == Block.waterMoving.blockID || world.getBlockId(x, y, z - 1) == Block.waterMoving.blockID || world.getBlockId(x, y, z + 1) == Block.waterMoving.blockID ||
		  (world.getBlockId(x, y - 1, z) == Block.lavaStill.blockID || world.getBlockId(x, y + 1, z) == Block.lavaStill.blockID || world.getBlockId(x - 1, y, z) == Block.lavaStill.blockID || world.getBlockId(x + 1, y, z) == Block.lavaStill.blockID || world.getBlockId(x, y, z - 1) == Block.lavaStill.blockID || world.getBlockId(x, y, z + 1) == Block.lavaStill.blockID || world.getBlockId(x, y - 1, z) == Block.lavaMoving.blockID || world.getBlockId(x, y + 1, z) == Block.lavaMoving.blockID || world.getBlockId(x - 1, y, z) == Block.lavaMoving.blockID || world.getBlockId(x + 1, y, z) == Block.lavaMoving.blockID || world.getBlockId(x, y, z - 1) == Block.lavaMoving.blockID || world.getBlockId(x, y, z + 1) == Block.lavaMoving.blockID) ||
		  (world.getBlockId(x, y - 1, z) == NPBlockList.QuicksilverStill.blockID || world.getBlockId(x, y + 1, z) == NPBlockList.QuicksilverStill.blockID || world.getBlockId(x - 1, y, z) == NPBlockList.QuicksilverStill.blockID || world.getBlockId(x + 1, y, z) == NPBlockList.QuicksilverStill.blockID || world.getBlockId(x, y, z - 1) == NPBlockList.QuicksilverStill.blockID || world.getBlockId(x, y, z + 1) == NPBlockList.QuicksilverStill.blockID || world.getBlockId(x, y - 1, z) == NPBlockList.QuicksilverMoving.blockID || world.getBlockId(x, y + 1, z) == NPBlockList.QuicksilverMoving.blockID || world.getBlockId(x - 1, y, z) == NPBlockList.QuicksilverMoving.blockID || world.getBlockId(x + 1, y, z) == NPBlockList.QuicksilverMoving.blockID || world.getBlockId(x, y, z - 1) == NPBlockList.QuicksilverMoving.blockID || world.getBlockId(x, y, z + 1) == NPBlockList.QuicksilverMoving.blockID) ||
		  (world.getBlockId(x, y - 1, z) == NPBlockList.SoulplasmStill.blockID || world.getBlockId(x, y + 1, z) == NPBlockList.SoulplasmStill.blockID || world.getBlockId(x - 1, y, z) == NPBlockList.SoulplasmStill.blockID || world.getBlockId(x + 1, y, z) == NPBlockList.SoulplasmStill.blockID || world.getBlockId(x, y, z - 1) == NPBlockList.SoulplasmStill.blockID || world.getBlockId(x, y, z + 1) == NPBlockList.SoulplasmStill.blockID || world.getBlockId(x, y - 1, z) == NPBlockList.SoulplasmMoving.blockID || world.getBlockId(x, y + 1, z) == NPBlockList.SoulplasmMoving.blockID || world.getBlockId(x - 1, y, z) == NPBlockList.SoulplasmMoving.blockID || world.getBlockId(x + 1, y, z) == NPBlockList.SoulplasmMoving.blockID || world.getBlockId(x, y, z - 1) == NPBlockList.SoulplasmMoving.blockID || world.getBlockId(x, y, z + 1) == NPBlockList.SoulplasmMoving.blockID))
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
				world.notifyBlockChange(x, y, z, 0);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.theIcon = new Icon[]
				{
				iconRegister.registerIcon("nether_plus:Acid"),
				iconRegister.registerIcon("nether_plus:Acid_flow")
				};
	}
}