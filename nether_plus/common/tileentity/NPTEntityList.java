package nether_plus.common.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class NPTEntityList
{
	public static void loadTileEntity()
	{
		GameRegistry.registerTileEntity(TileEntityFour.class, "TileEntityFour");
		GameRegistry.registerTileEntity(TileEntityGrimwoodWorkbench.class, "TileEntityGrimwoodWorkbench");
		GameRegistry.registerTileEntity(TileEntityGrimwoodChest.class, "TileEntityGrimwoodChest");
	}
}
