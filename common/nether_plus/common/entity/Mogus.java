package nether_plus.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;

public class Mogus extends EntityCreature
{ 
    public Mogus(World world)
    {
        super(world);
		this.setSize(0.50F, 0.50F);
        stepHeight = 0.0F;
        isImmuneToFire = true;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(2.0D);
    }
    
    protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
	}
    	 
    public int getMaxSpawnedInChunk()
	{
    	return 5;
	}

    protected String getLivingSound()
    {
        return "mob.zombie";
    }

    protected String getHurtSound()
    {
        return "mob.zombiehurt";
    }

    protected String getDeathSound()
    {
        return "mob.zombiedeath";
    }
    
    protected void dropRareDrop(int par1)
    {
        this.dropItem(NPItemList.BloodGem.itemID, 1);
    }

    protected int getDropItemId()
    {
        return Block.mushroomBrown.blockID;
    }
}