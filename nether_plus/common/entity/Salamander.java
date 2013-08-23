package nether_plus.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;

public class Salamander extends EntityAnimal
{

	public Salamander(World par1World)
	{
		super(par1World);
		this.texture = "/mods/nether_plus/textures/Entity/salamander_orange.png";
		this.moveSpeed = 0.8F;
		this.setSize(0.6F, 0.8F);
		this.stepHeight = 0.0F;
		this.isImmuneToFire = true;
	}

	@Override
	public int getMaxHealth()
	{
		return 20;
	}
	
    public int getMaxSpawnedInChunk()
	{
	return 7;
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}
	
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}
	
	protected String getHurtSound()
    {
        return "mob.zombie.hurt";
    }

    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }
    
    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
    	Entity entity = damagesource.getEntity();
    	this.setTarget(entity);
    	return super.attackEntityFrom(damagesource, i);
    }
    
    protected int getDropItemId()
    {
    	return NPItemList.BlackBone.itemID;
    }
    
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.itemID == NPItemList.BlackBone.itemID;
    }
    
    public Salamander spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
    	return new Salamander(this.worldObj);
    }
    
	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return this.spawnBabyAnimal(entityageable);
	}
}