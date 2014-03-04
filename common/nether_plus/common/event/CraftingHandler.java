package nether_plus.common.event;

import nether_plus.common.achievement.NPAchievements;
import nether_plus.common.block.NPBlockList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class CraftingHandler
{
	@SubscribeEvent
	public void ItemCraftedEvent(ItemCraftedEvent event)
	{
		if(event.crafting.getItem().equals(NPBlockList.grimwoodWorkbench))
		{
			event.player.addStat(NPAchievements.craftGrimwoodWorkbench, 1);
		}
	}
	
	@SubscribeEvent
	public void ItemSmeltedEvent(ItemSmeltedEvent event)
	{
		/*if(event.smelting.getItem().equals())
		{
			event.player.addStat(NPAchievements, 1);
		}*/
	}
}