package nether_plus.common.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nether_plus.common.block.container.ContainerFour;
import nether_plus.common.block.container.ContainerGrimwoodChest;
import nether_plus.common.block.container.ContainerWorkbench;
import nether_plus.common.tileentity.TileEntityFour;
import nether_plus.common.tileentity.TileEntityGrimwoodChest;
import nether_plus.common.tileentity.TileEntityGrimwoodWorkbench;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

	if(tile_entity instanceof TileEntityFour)
	{
		return new ContainerFour(player.inventory, (TileEntityFour) tile_entity);
	}
	else if(tile_entity instanceof TileEntityGrimwoodWorkbench)
	{
		return new ContainerWorkbench(player.inventory, (TileEntityGrimwoodWorkbench) tile_entity, world);
	}
	else if(tile_entity instanceof TileEntityGrimwoodChest)
	{
		return new ContainerGrimwoodChest(player.inventory, (TileEntityGrimwoodChest) tile_entity);
	}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
	if(tile_entity instanceof TileEntityFour)
	{
		return new GuiFour(player.inventory, (TileEntityFour) tile_entity);
	}
	else if(tile_entity instanceof TileEntityGrimwoodWorkbench)
	{
		return new GuiWorkbench(player.inventory, (TileEntityGrimwoodWorkbench) tile_entity, world);
	}
	else if(tile_entity instanceof TileEntityGrimwoodChest)
	{
		return new GuiGrimwoodChest(player.inventory, (TileEntityGrimwoodChest) tile_entity);
	}
		return null;
	}

}