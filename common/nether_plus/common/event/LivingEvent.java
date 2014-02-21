package nether_plus.common.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
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
}
