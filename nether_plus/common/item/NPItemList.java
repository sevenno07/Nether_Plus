package nether_plus.common.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import nether_plus.common.config.NPProperties;

public class NPItemList
{
	public static Item CharoiteCrystal;
	public static Item BlackIronIngot;
	public static Item BlackBone;
	public static Item BlackBoneMeal;
	public static Item Fireslimeball;
	
	public static Item SkeletonWhiteHelmet;
	public static Item SkeletonWhiteChestplate;
	public static Item SkeletonWhiteLeggings;
	public static Item SkeletonWhiteBoot;
	
	public static Item SkeletonBlackHelmet;
	public static Item SkeletonBlackChestplate;
	public static Item SkeletonBlackLeggings;
	public static Item SkeletonBlackBoot;
	
	public static EnumArmorMaterial SkeletonWhiteArmor = EnumHelper.addArmorMaterial("SkeletonWhiteArmor", 7, new int[]{2, 5, 3, 1}, 25);
	public static EnumArmorMaterial SkeletonBlackArmor = EnumHelper.addArmorMaterial("SkeletonBlackArmor", 15, new int[]{2, 6, 5, 2}, 9);
	
	public static void loadItem()
	{
		CharoiteCrystal = new CharoiteCrystal(NPProperties.CharoiteCrystalID).setUnlocalizedName("CharoiteCrystal");
		BlackIronIngot = new BlackIronIngot(NPProperties.BlackIronIngotID).setUnlocalizedName("BlackIronIngot");
		BlackBone = new BlackBone(NPProperties.BlackBoneID).setUnlocalizedName("BlackBone");
		BlackBoneMeal = new BlackBoneMeal(NPProperties.BlackBoneMealID).setUnlocalizedName("BlackBoneMeal");
		Fireslimeball = new Fireslimeball(NPProperties.FireslimeballID).setUnlocalizedName("Fireslimeball");
		
		SkeletonWhiteHelmet = new SkeletonWhiteArmor(NPProperties.SkeletonWhiteHelmetID, SkeletonWhiteArmor, 0, 0).setUnlocalizedName("SkeletonWhiteHelmet");
		SkeletonWhiteChestplate = new SkeletonWhiteArmor(NPProperties.SkeletonWhiteChestplateID, SkeletonWhiteArmor, 0, 1).setUnlocalizedName("SkeletonWhiteChestplate");
		SkeletonWhiteLeggings = new SkeletonWhiteArmor(NPProperties.SkeletonWhiteLeggingsID, SkeletonWhiteArmor, 0, 2).setUnlocalizedName("SkeletonWhiteLeggings");
		SkeletonWhiteBoot = new SkeletonWhiteArmor(NPProperties.SkeletonWhiteBootID, SkeletonWhiteArmor, 0, 3).setUnlocalizedName("SkeletonWhiteBoot");

		SkeletonBlackHelmet = new SkeletonBlackArmor(NPProperties.SkeletonBlackHelmetID, SkeletonBlackArmor, 0, 0).setUnlocalizedName("SkeletonBlackHelmet");
		SkeletonBlackChestplate = new SkeletonBlackArmor(NPProperties.SkeletonBlackChestplateID, SkeletonBlackArmor, 0, 1).setUnlocalizedName("SkeletonBlackChestplate");
		SkeletonBlackLeggings = new SkeletonBlackArmor(NPProperties.SkeletonBlackLeggingsID, SkeletonBlackArmor, 0, 2).setUnlocalizedName("SkeletonBlackLeggings");
		SkeletonBlackBoot = new SkeletonBlackArmor(NPProperties.SkeletonBlackBootID, SkeletonBlackArmor, 0, 3).setUnlocalizedName("SkeletonBlackBoot");

	}
}
