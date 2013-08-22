package nether_plus.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;

public class TileEntityGrimwoodChest extends TileEntityChest implements IInventory
{
	@Override
	public boolean isInvNameLocalized()
	{
		return true;
	}
}