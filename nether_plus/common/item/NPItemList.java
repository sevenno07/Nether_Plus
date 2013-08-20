package nether_plus.common.item;

import net.minecraft.item.Item;
import nether_plus.common.config.NPProperties;

public class NPItemList
{
	public static Item CharoiteCrystal;
	public static Item BlackIronIngot;
	
	public static void loadItem()
	{
		CharoiteCrystal = new CharoiteCrystal(NPProperties.CharoiteCrystalID).setUnlocalizedName("CharoiteCrystal");
		BlackIronIngot = new BlackIronIngot(NPProperties.BlackIronIngotID).setUnlocalizedName("BlackIronIngot");
	}
}
