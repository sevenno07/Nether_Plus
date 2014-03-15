package nether_plus.common.tileentity;

import nether_plus.common.Nether_plus;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPTEntityList
{
	public static void loadTileEntity()
	{
		try
		{
			GameRegistry.registerTileEntity(TileEntityFour.class, "TileEntityFour");
			GameRegistry.registerTileEntity(TileEntityGrimwoodChest.class, "TileEntityGrimwoodChest");
			GameRegistry.registerTileEntity(TileEntityGrimwoodWorkbench.class, "TileEntityGrimwoodWorkbench");
		}
		catch(Exception ex)
		{
		Nether_plus.npLog.severe("Erreur lors de l'initialisation des TileEntity's!");
		}
		Nether_plus.npLog.info("Initialisation des TileEntity's terminés!");
	}
}