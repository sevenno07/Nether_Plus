package nether_plus.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;

public class Salamander extends EntityAnimal
{

	public Salamander(World par1World)
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
    
    protected int getDropItemId()
    {
    	return NPItemList.BlackBone.itemID;
    }
    
    protected void dropFewItems(boolean par1, int par2)
    {
    	super.dropFewItems(par1, par2);

        if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0))
        {
            this.dropItem(NPItemList.SalamanderLeather.itemID, 1);
        }
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
	
	protected void dropRareDrop(int par1)
    {
        this.dropItem(NPItemList.BloodGem.itemID, 1);
    }
}