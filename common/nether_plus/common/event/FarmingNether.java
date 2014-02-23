package nether_plus.common.event;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import nether_plus.common.block.NPBlockList;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FarmingNether
{
	@SubscribeEvent
	public void onUseHoe(UseHoeEvent event)
	{
		Block block = event.world.getBlock(event.x, event.y, event.z);
		if(block == Blocks.soul_sand)
		{
			event.world.setBlock(event.x, event.y, event.z, NPBlockList.nether_Farm, 0, 3);
			event.world.playSoundAtEntity(event.entityPlayer, block.stepSound.getBreakSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
			event.setResult(Result.ALLOW);
		}
	}
}