package nether_plus.common.item;

import net.minecraft.item.Item;
import nether_plus.common.config.NPProperties;

public class NPItemList
{
	public static Item CharoiteCrystal;
	public static Item BlackIronIngot;
	public static Item BlackBone;
	public static Item BlackBoneMeal;
	public static Item Fireslimeball;
	
	public static void loadItem()
	{
		CharoiteCrystal = new CharoiteCrystal(NPProperties.CharoiteCrystalID).setUnlocalizedName("CharoiteCrystal");
		BlackIronIngot = new BlackIronIngot(NPProperties.BlackIronIngotID).setUnlocalizedName("BlackIronIngot");
		BlackBone = new BlackBone(NPProperties.BlackBoneID).setUnlocalizedName("BlackBone");
		BlackBoneMeal = new BlackBoneMeal(NPProperties.BlackBoneMealID).setUnlocalizedName("BlackBoneMeal");
		Fireslimeball = new Fireslimeball(NPProperties.FireslimeballID).setUnlocalizedName("Fireslimeball");
	}
}
