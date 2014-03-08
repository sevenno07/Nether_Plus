package nether_plus.common.event;

import net.minecraftforge.event.entity.player.BonemealEvent;
import nether_plus.common.block.ChiliC;
import nether_plus.common.block.Crops;
import nether_plus.common.block.GrimwoodSapling;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.block.RiceC;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 
public class GrimBoneMeal
{
	@SubscribeEvent
	public void onUseBonemeal(BonemealEvent event)
	{
		if (event.block == NPBlockList.crops)
		{
			if (!event.world.isRemote)
			{
				((Crops)NPBlockList.crops).fertilizeCrops(event.world, event.x, event.y, event.z);
				event.setResult(Event.Result.ALLOW);
			}
		}
		else if (event.block == NPBlockList.chiliC)
		{
			if (!event.world.isRemote)
			{
				((ChiliC)NPBlockList.chiliC).fertilizeStem(event.world, event.x, event.y, event.z);
				event.setResult(Event.Result.ALLOW);
			}
		}
		else if (event.block == NPBlockList.riceC)
		{
			if (!event.world.isRemote)
			{
				((RiceC)NPBlockList.riceC).fertilizeRiceC(event.world, event.x, event.y, event.z);
				event.setResult(Event.Result.ALLOW);
			}
		}
	}
}