package nether_plus.common.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import nether_plus.common.Nether_plus;

public class NetherPlusCreativeTabs
{
	public static CreativeTabs NPCreativeTabsBlock;
	public static CreativeTabs NPCreativeTabsItem;
	public static CreativeTabs NPCreativeTabsArmor;
	public static CreativeTabs NPCreativeTabsTool;

	public static void loadCreativeTab()
	{
		try
		{
			NPCreativeTabsBlock = new NPCreativeTabsBlock("NPCreativeTabsBlock");
			NPCreativeTabsItem = new NPCreativeTabsItem("NPCreativeTabsItem");
			NPCreativeTabsArmor = new NPCreativeTabsArmor("NPCreativeTabsArmor");
			NPCreativeTabsTool = new NPCreativeTabsTool("NPCreativeTabsTool");
		}
		catch(Exception ex)
		{
			Nether_plus.NPlog.severe("Erreur lors de l'initialisation des CreativeTabs!");	
		}
		Nether_plus.NPlog.info("Initialisation des CreativeTabs terminées!");
	}

}