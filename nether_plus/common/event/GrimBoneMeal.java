package nether_plus.common.event;

import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import nether_plus.common.block.Crops;
import nether_plus.common.block.GrimwoodSapling;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.block.PepperC;
import nether_plus.common.block.RizC;
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
		else if (event.ID == NPProperties.CropsID)
		{
			if (!event.world.isRemote)
			{
				((Crops)NPBlockList.Crops).fertilize(event.world, event.X, event.Y, event.Z);
				event.setResult(Event.Result.ALLOW);
			}
		}
		else if (event.ID == NPProperties.PepperCID)
		{
			if (!event.world.isRemote)
			{
				((PepperC)NPBlockList.PepperC).fertilizeStem(event.world, event.X, event.Y, event.Z);
				event.setResult(Event.Result.ALLOW);
			}
		}
		else if (event.ID == NPProperties.RizCID)
		{
			if (!event.world.isRemote)
			{
				((RizC)NPBlockList.RizC).fertilize(event.world, event.X, event.Y, event.Z);
				event.setResult(Event.Result.ALLOW);
			}
		}
	}
}