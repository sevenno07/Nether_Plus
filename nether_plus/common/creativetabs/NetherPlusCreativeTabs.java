package nether_plus.common.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

public class NetherPlusCreativeTabs
{
	public static CreativeTabs NPCreativeTabsBlock;
	public static CreativeTabs NPCreativeTabsItem;
	public static CreativeTabs NPCreativeTabsArmor;
	public static CreativeTabs NPCreativeTabsTool;

	public static void loadCreativeTab()
	{
		NPCreativeTabsBlock = new NPCreativeTabsBlock("NPCreativeTabsBlock");
		NPCreativeTabsItem = new NPCreativeTabsItem("NPCreativeTabsItem");
		NPCreativeTabsArmor = new NPCreativeTabsArmor("NPCreativeTabsArmor");
		NPCreativeTabsTool = new NPCreativeTabsTool("NPCreativeTabsTool");
	}

}