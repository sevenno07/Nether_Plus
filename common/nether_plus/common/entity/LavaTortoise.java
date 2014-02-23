package nether_plus.common.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;

public class LavaTortoise extends EntityCreature
{
	public LavaTortoise(World World)
	{
		super(World);
		this.setSize(2.20F, 1.75F);//Hitbox
		this.isImmuneToFire = true;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.2D);
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
	}
	
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}
	
	protected Entity findPlayerToAttack()
    {
        float f = this.getBrightness(1.0F);

        if (f < 0.5F)
        {
            double d0 = 16.0D;
            return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
        }
        else
        {
            return null;
        }
    }
	
	private void setAngry(boolean b)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (b)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
        }
	}
	
	public boolean isAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }
	
	public int getAttackStrength(Entity entity)
	{
		return 5;
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

        if (entity instanceof EntityPlayer)
        {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));
        }
        return super.attackEntityFrom(damagesource, i);
    }

    protected Item getDropItem()
    {
        return NPItemList.blackBone;
    }
    
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(2 + par2);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(NPItemList.blackBone, 1);
        }

        j = this.rand.nextInt(2 + par2);

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Item.getItemFromBlock(Blocks.obsidian), 1);
        }
    }
    
    protected void dropRareDrop(int par1)
    {
        this.dropItem(NPItemList.bloodGem, 1);
    }
}