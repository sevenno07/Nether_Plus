package nether_plus.common.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class Wight extends EntityCreature
{

	public Wight(World World)
	{
		super(World);
		this.texture = "/mods/nether_plus/textures/Entity/wight.png";
		this.moveSpeed = 0.3F;
		this.stepHeight = 0.0F;
		this.isImmuneToFire = true;
	}
	
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}
	
	@Override
	public int getMaxHealth()
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
        return Item.bone.itemID;
    }

}
