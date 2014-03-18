package nether_plus.common.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LivingEvent
{
	@SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event)
    {
		if(event.entity instanceof EntityPigZombie)
		{
			EntityItem newdrop = new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(NPItemList.bloodGem, 1));
			event.drops.add(newdrop);
		}
		else if(event.entity instanceof EntityBlaze)
		{
			EntityItem newdrop = new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(NPItemList.bloodGem, 1));
			event.drops.add(newdrop);
		}
		else if(event.entity instanceof EntityGhast)
		{
			EntityItem newdrop = new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(NPItemList.bloodGem, 1));
			event.drops.add(newdrop);
		}
		else if(event.entity instanceof EntityMagmaCube)
		{
			EntityItem newdrop = new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(NPItemList.bloodGem, 1));
			event.drops.add(newdrop);
		}
    }
	
	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		ItemStack helmet = event.entityLiving.getEquipmentInSlot(4);
		ItemStack chestplate = event.entityLiving.getEquipmentInSlot(3);
		ItemStack leggings = event.entityLiving.getEquipmentInSlot(2);
		ItemStack boots = event.entityLiving.getEquipmentInSlot(1);
		
		if(helmet != null && helmet.getItem() == NPItemList.salamanderHelmet && chestplate != null &&  chestplate.getItem() == NPItemList.salamanderChestplate && leggings != null && leggings.getItem() == NPItemList.salamanderLeggings && boots != null && boots.getItem() == NPItemList.salamanderBoot)
		{
			if(event.source.getDamageType().equals("inFire") || event.source.getDamageType().equals("onFire") || event.source.getDamageType().equals("lava"))
			{
				boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				event.ammount = 0;
			}
		}
	}
}