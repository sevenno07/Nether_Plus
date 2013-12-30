package nether_plus.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;
import nether_plus.common.item.NPItemList;

public class RedMogus extends EntityCreature
{ 

    public RedMogus(World world)
    {
        super(world);
		this.texture = "/mods/nether_plus/textures/Entity/RedMogus.png";
        moveSpeed = 1.0F;
		this.setSize(0.50F, 0.50F);
        stepHeight = 0.0F;
        isImmuneToFire = true;
    }
    
	public int getMaxHealth() 
	{
		return 5;
	}
    	 
    public int getMaxSpawnedInChunk()
	{
	return 12;
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

    protected int getDropItemId()
    {
        return Block.mushroomRed.blockID;
    }
    
    protected void dropRareDrop(int par1)
    {
        this.dropItem(NPItemList.BloodGem.itemID, 1);
    }
}