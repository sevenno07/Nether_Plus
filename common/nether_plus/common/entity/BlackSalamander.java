package nether_plus.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;

public class BlackSalamander extends EntityMob
{
	public BlackSalamander(World par1World)
	{
		super(par1World);
		this.setSize(1.25F, 0.75F);
		this.stepHeight = 0.0F;
		this.isImmuneToFire = true;
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(40D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(1.6D);
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
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
    
    protected void dropRareDrop(int par1)
    {
        this.dropItem(NPItemList.BloodGem.itemID, 1);
    }
    
    protected int getDropItemId()
    {
    	return NPItemList.BlackBone.itemID;
    }
    
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.itemID == NPItemList.BlackBone.itemID;
    }
}