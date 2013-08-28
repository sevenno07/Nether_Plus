package nether_plus.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;


public class Pordenfer extends EntityMob
{ 
    public Pordenfer(World world)
    {
        super(world);
        this.texture = "/mods/nether_plus/textures/Entity/pordenfer.png";
        this.stepHeight = 0.0F;
        this.isImmuneToFire = true;
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
	
	@Override
	public int getMaxHealth()
	{
		return 10;
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
	
	public void setAttackTarget(EntityLiving par1EntityLiving)
    {
        super.setAttackTarget(par1EntityLiving);

        if (par1EntityLiving instanceof EntityPlayer)
        {
            this.setAngry(true);
        }
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
}