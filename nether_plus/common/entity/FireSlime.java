package nether_plus.common.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import nether_plus.common.item.NPItemList;

public class FireSlime extends EntityLiving implements IMob
{
    private int slimeJumpDelay;
	public float field_70811_b;
	public float field_70812_c;
	public float field_70813_a;

    public FireSlime(World world)
    {
        super(world);
        this.slimeJumpDelay = 0;
        this.texture = "/mods/nether_plus/textures/Entity/fireslime.png";
        int i = 1 << rand.nextInt(3);
        this.yOffset = 0.0F;
        this.slimeJumpDelay = rand.nextInt(20) + 10;
        this.setFireSlimeSize(i);
        this.experienceValue = i;
        this.isImmuneToFire = true;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)1));
    }

    public void setFireSlimeSize(int i)
    {
        this.dataWatcher.updateObject(16, new Byte((byte)i));
        this.setSize(0.6F * (float)i, 0.6F * (float)i);
        this.setPosition(posX, posY, posZ);
        this.setEntityHealth(getMaxHealth());
        this.experienceValue = i;
    }

    public int getMaxHealth()
    {
        int i = this.getFireSlimeSize();
        return i * i;
    }

    public int getFireSlimeSize()
    {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Size", getFireSlimeSize() - 1);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        this.setFireSlimeSize(nbttagcompound.getInteger("Size") + 1);
    }

    protected String getSlimeParticule()
    {
        return "flame";
    }

    protected String getJumpSound()
    {
        return "mob.slime" + (this.getFireSlimeSize() > 1 ? "big" : "small");
    }

    public void onUpdate()
    {
        if(!worldObj.isRemote && worldObj.difficultySetting == 0 && this.getFireSlimeSize() > 0)
        {
        	this.isDead = true;
        }
        this.field_70811_b += (this.field_70813_a - this.field_70811_b) * 0.5F;
        this.field_70812_c = this.field_70811_b;
        boolean flag = this.onGround;
        super.onUpdate();
        int i;
        
        if(this.onGround && !flag)
        {
            i = this.getFireSlimeSize();
            
            for(int j = 0; j < i * 8; ++j)
            {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
                this.worldObj.spawnParticle(this.getSlimeParticule(), this.posX + (double)f2, this.boundingBox.minY, this.posZ + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            if (this.makesSoundOnLand())
            {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }

            this.field_70813_a = -0.5F;
        }
        else if (!this.onGround && flag)
        {
            this.field_70813_a = 1.0F;
        }

        this.func_70808_l();

        if (this.worldObj.isRemote)
        {
            i = this.getFireSlimeSize();
            this.setSize(0.6F * (float)i, 0.6F * (float)i);
        }
    }

	protected void updateEntityActionState()
    {
        this.despawnEntity();
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

        if (entityplayer != null)
        {
            this.faceEntity(entityplayer, 10.0F, 20.0F);
        }

        if (this.onGround && this.slimeJumpDelay-- <= 0)
        {
            this.slimeJumpDelay = this.getJumpDelay();

            if (entityplayer != null)
            {
                this.slimeJumpDelay /= 3;
            }

            this.isJumping = true;

            if (this.makesSoundOnJump())
            {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }

            this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
            this.moveForward = (float)(1 * this.getFireSlimeSize());
        }
        else
        {
            this.isJumping = false;

            if (this.onGround)
            {
                this.moveStrafing = this.moveForward = 0.0F;
            }
        }
    }
	

	protected void func_70808_l()
	{
        this.field_70813_a *= 0.6F;
	}

    protected int getJumpDelay()
    {
        return rand.nextInt(20) + 10;
    }

    protected FireSlime createInstance()
    {
        return new FireSlime(this.worldObj);
    }

    public void setDead()
    {
        int i = this.getFireSlimeSize();
        
        if(!this.worldObj.isRemote && i > 1 && getHealth() <= 0)
        {
            int j = 2 + this.rand.nextInt(3);
            
            for(int k = 0; k < j; ++k)
            {
                float f = (((float)(k % 2) - 0.5F) * (float)i) / 4.0F;
                float f1 = (((float)(k / 2) - 0.5F) * (float)i) / 4.0F;
                FireSlime fireslime = this.createInstance();
                fireslime.setFireSlimeSize(i / 2);
                fireslime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360F, 0.0F);
                this.worldObj.spawnEntityInWorld(fireslime);
            }

        }
        super.setDead();
    }

    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if(this.canDamagePlayer())
        {
            int i = this.getFireSlimeSize();
            
            if(this.canEntityBeSeen(entityplayer) && (double)this.getDistanceSqToEntity(entityplayer) < 0.6D * (double)i * 0.6D * (double)i && entityplayer.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength()))
            {
                this.playSound("mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }
        }
    }

    protected boolean canDamagePlayer()
    {
        return getFireSlimeSize() > 1;
    }

    protected int getAttackStrength()
    {
        return getFireSlimeSize();
    }

    protected String getHurtSound()
    {
        return "mob.slime" + (this.getFireSlimeSize() > 1 ? "big" : "small");
    }

    protected String getDeathSound()
    {
        return "mob.slime" + (this.getFireSlimeSize() > 1 ? "big" : "small");
    }
    
    protected void dropRareDrop(int par1)
    {
        this.dropItem(NPItemList.BloodGem.itemID, 1);
    }
    
    protected int getDropItemId()
    {
    	return this.getFireSlimeSize() == 1 ? NPItemList.Fireslimeball.itemID : 0;
    }

    public boolean getCanSpawnHere()
    {
        Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
        if((getFireSlimeSize() == 1 || worldObj.difficultySetting > 0) && rand.nextInt(10) == 0 && chunk.getRandomWithSeed(0x3ad8025fL).nextInt(10) == 0 && posY < 40D)
        {
            return super.getCanSpawnHere();
        } else
        {
            return false;
        }
    }

    protected float getSoundVolume()
    {
        return 0.4F * (float)getFireSlimeSize();
    }

    public int getVerticalFaceSpeed()
    {
        return 0;
    }

    protected boolean makesSoundOnJump()
    {
        return getFireSlimeSize() > 1;
    }

    protected boolean makesSoundOnLand()
    {
        return getFireSlimeSize() > 2;
    }
}