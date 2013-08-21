package nether_plus.common.block;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

	if(tile_entity instanceof TileEntityFour){
		return new ContainerFour(player.inventory, (TileEntityFour) tile_entity);
	}
	return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if(tile_entity instanceof TileEntityFour){
			return new GuiFour(player.inventory, (TileEntityFour) tile_entity);
		}
		return null;
	}

}