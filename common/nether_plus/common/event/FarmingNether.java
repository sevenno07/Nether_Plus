package nether_plus.common.event;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import nether_plus.common.block.NPBlockList;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class FarmingNether
{
	@EventHandler
	public void onUseHoe(UseHoeEvent event)
	{
		Block blockId = event.world.getBlock(event.x, event.y, event.z);
		if(blockId == Blocks.soul_sand)
		{
			event.world.setBlock(event.x, event.y, event.z, NPBlockList.Nether_Farm, 0, 3);
			event.world.playSoundAtEntity(event.entityPlayer, blockId.stepSound.getBreakSound(), (blockId.stepSound.getVolume() + 1.0F) / 2.0F, blockId.stepSound.getPitch() * 0.8F);
			event.setResult(Result.ALLOW);
		}
	}
}