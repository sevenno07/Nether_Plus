package nether_plus.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.config.NPProperties;
import nether_plus.common.item.NPItemList;

public class Salamander extends EntityMob
{

	public Salamander(World par1World)
	{
		super(par1World);
		this.texture = "/mods/nether_plus/textures/Entity/salamander_orange.png";
		this.moveSpeed = 0.8F;
		this.stepHeight = 0.0F;
		this.isImmuneToFire = true;
	}

	@Override
	public int getMaxHealth()
	{
		return 5;
	}
	
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
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
    
    protected int getDropItemId()
    {
        return NPItemList.BlackBone.itemID;
    }
}
