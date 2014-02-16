package nether_plus.common.event;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class ModBucket
{
	public static ModBucket INSTANCE = new ModBucket();
	public Map<Block, Item> buckets = new HashMap<Block, Item>();

	private ModBucket()
	{
	}

	@EventHandler
	public void onBucketFill(FillBucketEvent event)
	{
		ItemStack result = fillCustomBucket(event.world, event.target);

		if (result == null)
			return;

		event.result = result;
		event.setResult(Result.ALLOW);
	}

	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos)
	{

		Block blockID = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

		Item bucket = buckets.get(blockID);
		if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0)
		{
			world.setBlock(pos.blockX, pos.blockY, pos.blockZ, blockID, 0, 0);
			return new ItemStack(bucket);
		}
		else
			return null;
	}
}