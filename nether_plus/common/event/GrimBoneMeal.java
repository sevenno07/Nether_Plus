package nether_plus.common.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import nether_plus.common.block.GrimwoodSapling;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.config.NPProperties;
 
public class GrimBoneMeal
{
 
	@ForgeSubscribe
	public void onUseBonemeal(BonemealEvent event)
	{
		if (event.ID == NPProperties.GrimwoodSaplingID)
		{
			if (!event.world.isRemote)
			{
				((GrimwoodSapling)NPBlockList.GrimwoodSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
				event.setResult(Event.Result.ALLOW);
			}
		}
	}
}