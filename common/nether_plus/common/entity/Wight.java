package nether_plus.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;

public class Wight extends EntityZombie
{
    private int angerLevel = 0;
    private int randomSoundDelay = 0;

    public Wight(World par1World)
    {
        super(par1World);
        this.isImmuneToFire = true;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(1.0D);
    }
    
    protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
	}

    protected boolean isAIEnabled()
    {
        return false;
    }

    public boolean getCanSpawnHere()
    {
        return this.worldObj.difficultySetting > 0 && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("Anger", (short)this.angerLevel);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.angerLevel = par1NBTTagCompound.getShort("Anger");
    }

    protected Entity findPlayerToAttack()
    {
        return this.angerLevel == 0 ? null : super.findPlayerToAttack();
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        Entity entity = damagesource.getEntity();
        this.setTarget(entity);
        return super.attackEntityFrom(damagesource, i);
    }

    public String getLivingSound()
    {
        return "nether_plus:Wight.idle";
    }

    protected String getHurtSound()
    {
        return "nether_plus:Wight.hit";
    }

    protected String getDeathSound()
    {
        return "nether_plus:Wight.death";
    }

    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        return false;
    }

    protected int getDropItemId()
    {
        return NPItemList.BlackBone.itemID;
    }
    
    protected void dropRareDrop(int par1)
    {
        this.dropItem(NPItemList.BloodGem.itemID, 1);
    }
}