package nether_plus.common.event;

import net.minecraft.block.Block;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import nether_plus.common.block.NPBlockList;

public class FarmingNether
{
	@ForgeSubscribe
	public void onUseHoe(UseHoeEvent event)
	{
		int blockId = event.world.getBlockId(event.x, event.y, event.z);
		if(blockId == Block.slowSand.blockID)
		{
			event.world.setBlock(event.x, event.y, event.z, NPBlockList.Nether_Farm.blockID, 0, 3);
			Block block = Block.blocksList[blockId];
			event.world.playSoundAtEntity(event.entityPlayer, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
			event.setResult(Result.ALLOW);
		}
	}
}