package nether_plus.common.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraftforge.common.EnumHelper;
import nether_plus.common.Nether_plus;
import nether_plus.common.config.NPProperties;

public class NPItemList
{
	public static Item CharoiteCrystal;
	public static Item BlackIronIngot;
	public static Item BlackBone;
	public static Item BlackBoneMeal;
	public static Item Fireslimeball;
	public static Item GrimwoodStick;
	public static Item BloodGem;
	public static Item InfernumIngot;
	public static Item ItemGrimwoodDoor;
	
	public static Item SkeletonWhiteHelmet;
	public static Item SkeletonWhiteChestplate;
	public static Item SkeletonWhiteLeggings;
	public static Item SkeletonWhiteBoot;
	
	public static Item SkeletonBlackHelmet;
	public static Item SkeletonBlackChestplate;
	public static Item SkeletonBlackLeggings;
	public static Item SkeletonBlackBoot;
	
	public static Item GrimwoodSword;
	public static Item GrimwoodPickaxe;
	public static Item GrimwoodAxe;
	public static Item GrimwoodShovel;
	public static Item GrimwoodHoe;
	
	public static Item WhiteWheatSeeds;
	public static Item WhiteWheat;
	public static Item PepperSeed;
	public static Item Pepper;
	
	public static Item DeadBread;
	
	public static Item GoldBucket;
	public static Item WaterBucket;
	public static Item LavaBucket;

	public static EnumArmorMaterial SkeletonWhiteArmor = EnumHelper.addArmorMaterial("SkeletonWhiteArmor", 7, new int[]{2, 5, 3, 1}, 25);
	public static EnumArmorMaterial SkeletonBlackArmor = EnumHelper.addArmorMaterial("SkeletonBlackArmor", 15, new int[]{2, 6, 5, 2}, 9);
	public static EnumToolMaterial GrimwoodTool = EnumHelper.addToolMaterial("GrimwoodTool", 0, 89, 3.0F, 0, 23);
	
	public static void loadItem()
	{
		try
		{
		CharoiteCrystal = new CharoiteCrystal(NPProperties.CharoiteCrystalID).setUnlocalizedName("CharoiteCrystal");
		BlackIronIngot = new BlackIronIngot(NPProperties.BlackIronIngotID).setUnlocalizedName("BlackIronIngot");
		BlackBone = new BlackBone(NPProperties.BlackBoneID).setUnlocalizedName("BlackBone");
		BlackBoneMeal = new BlackBoneMeal(NPProperties.BlackBoneMealID).setUnlocalizedName("BlackBoneMeal");
		Fireslimeball = new Fireslimeball(NPProperties.FireslimeballID).setUnlocalizedName("Fireslimeball");
		GrimwoodStick = new GrimwoodStick(NPProperties.GrimwoodStickID).setUnlocalizedName("GrimwoodStick");
		BloodGem = new BloodGem(NPProperties.BloodGemID).setUnlocalizedName("BloodGem");
		InfernumIngot = new InfernumIngot(NPProperties.InfernumIngotID).setUnlocalizedName("InfernumIngot");
		ItemGrimwoodDoor = new ItemGrimwoodDoor(NPProperties.ItemGrimwoodDoorID, Material.wood).setUnlocalizedName("ItemGrimwoodDoor");
		
		SkeletonWhiteHelmet = new SkeletonWhiteArmor(NPProperties.SkeletonWhiteHelmetID, SkeletonWhiteArmor, 0, 0).setUnlocalizedName("SkeletonWhiteHelmet");
		SkeletonWhiteChestplate = new SkeletonWhiteArmor(NPProperties.SkeletonWhiteChestplateID, SkeletonWhiteArmor, 0, 1).setUnlocalizedName("SkeletonWhiteChestplate");
		SkeletonWhiteLeggings = new SkeletonWhiteArmor(NPProperties.SkeletonWhiteLeggingsID, SkeletonWhiteArmor, 0, 2).setUnlocalizedName("SkeletonWhiteLeggings");
		SkeletonWhiteBoot = new SkeletonWhiteArmor(NPProperties.SkeletonWhiteBootID, SkeletonWhiteArmor, 0, 3).setUnlocalizedName("SkeletonWhiteBoot");

		SkeletonBlackHelmet = new SkeletonBlackArmor(NPProperties.SkeletonBlackHelmetID, SkeletonBlackArmor, 0, 0).setUnlocalizedName("SkeletonBlackHelmet");
		SkeletonBlackChestplate = new SkeletonBlackArmor(NPProperties.SkeletonBlackChestplateID, SkeletonBlackArmor, 0, 1).setUnlocalizedName("SkeletonBlackChestplate");
		SkeletonBlackLeggings = new SkeletonBlackArmor(NPProperties.SkeletonBlackLeggingsID, SkeletonBlackArmor, 0, 2).setUnlocalizedName("SkeletonBlackLeggings");
		SkeletonBlackBoot = new SkeletonBlackArmor(NPProperties.SkeletonBlackBootID, SkeletonBlackArmor, 0, 3).setUnlocalizedName("SkeletonBlackBoot");
		
		GrimwoodSword = new GrimwoodSword(NPProperties.GrimwoodSwordID, GrimwoodTool).setUnlocalizedName("GrimwoodSword");
		GrimwoodPickaxe = new GrimwoodPickaxe(NPProperties.GrimwoodPickaxeID, GrimwoodTool).setUnlocalizedName("GrimwoodPickaxe");
		GrimwoodAxe = new GrimwoodAxe(NPProperties.GrimwoodAxeID, GrimwoodTool).setUnlocalizedName("GrimwoodAxe");
		GrimwoodShovel = new GrimwoodShovel(NPProperties.GrimwoodShovelID, GrimwoodTool).setUnlocalizedName("GrimwoodShovel");
		GrimwoodHoe = new GrimwoodHoe(NPProperties.GrimwoodHoeID, GrimwoodTool).setUnlocalizedName("GrimwoodHoe");
		
		WhiteWheatSeeds = new WhiteWheatSeeds(NPProperties.WhiteWheatSeedsID, NPProperties.CropsID, NPProperties.Nether_FarmID).setUnlocalizedName("WhiteWheatSeeds");
		WhiteWheat = new WhiteWheat(NPProperties.WhiteWheatID).setUnlocalizedName("WhiteWheat");
		PepperSeed = new PepperSeed(NPProperties.PepperSeedID, NPProperties.PepperCID, NPProperties.Nether_FarmID).setUnlocalizedName("PepperSeed");
		
		DeadBread = new DeadBread(NPProperties.DeadBreadID, 5, 0.6F, false).setUnlocalizedName("DeadBread");
		GoldBucket = new GoldBucket(NPProperties.GoldBucketID, 0).setUnlocalizedName("GoldBucket").setMaxStackSize(16);
		WaterBucket = new GoldBucket(NPProperties.WaterBucketID, Block.waterMoving.blockID).setUnlocalizedName("WaterBucket").setContainerItem(GoldBucket);
	    LavaBucket = new GoldBucket(NPProperties.LavaBucketID, Block.lavaMoving.blockID).setUnlocalizedName("LavaBucket").setContainerItem(GoldBucket);
		}
		catch(Exception ex)
		{
		Nether_plus.NPlog.severe("Erreur lors de l'initialisation des Items!");
		}
		Nether_plus.NPlog.info("Initialisation des Items terminés!");
	}
}
