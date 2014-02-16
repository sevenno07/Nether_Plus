package nether_plus.common.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
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
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
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
        this.dropItem(NPItemList.BloodGem, 1);
    }

    protected Item getDropItemId()
    {
        return Item.getItemFromBlock(Blocks.brown_mushroom);
    }
}