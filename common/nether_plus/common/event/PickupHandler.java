package nether_plus.common.event;

import nether_plus.common.achievement.NPAchievements;
import nether_plus.common.block.NPBlockList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class PickupHandler
{
	@SubscribeEvent
	public void onItemPickup(ItemPickupEvent event)
	{
		System.out.println("Player has pickup a item");
		if(event.pickedUp.getEntityItem().getItem().equals(NPBlockList.CorruptedCobblestone))
		{
			event.player.triggerAchievement(NPAchievements.pickCorruptedCobblestone);
		}

		if(event.pickedUp.getEntityItem().getItem().equals(NPBlockList.GrimwoodLog))
		{
			event.player.triggerAchievement(NPAchievements.pickGrimwoodLog);
		}
	}
}