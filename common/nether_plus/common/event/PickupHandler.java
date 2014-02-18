package nether_plus.common.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import nether_plus.common.achievement.NPAchievements;
import nether_plus.common.block.NPBlockList;

public class PickupHandler
{
	@SubscribeEvent
	public void ItemPickupEvent(EntityItem item, EntityPlayer player)
	{
		if(item.getEntityItem().getItem().equals(NPBlockList.CorruptedCobblestone))
		{
			player.triggerAchievement(NPAchievements.pickCorruptedCobblestone);
		}
		
		if(item.getEntityItem().getItem().equals(NPBlockList.GrimwoodLog))
		{
			player.triggerAchievement(NPAchievements.pickGrimwoodLog);
		}
	}
}