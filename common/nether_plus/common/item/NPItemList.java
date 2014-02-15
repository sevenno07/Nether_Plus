package nether_plus.common.item;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import nether_plus.common.Nether_plus;
import nether_plus.common.block.NPBlockList;
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
	public static Item SalamanderLeather;
	
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
	
	public static Item BlackIronHelmet;
	public static Item BlackIronChestplate;
	public static Item BlackIronLeggings;
	public static Item BlackIronBoot;
	
	public static Item BlackIronSword;
	public static Item BlackIronPickaxe;
	public static Item BlackIronAxe;
	public static Item BlackIronShovel;
	public static Item BlackIronHoe;
	
	public static Item SalamanderHelmet;
	public static Item SalamanderChestplate;
	public static Item SalamanderLeggings;
	public static Item SalamanderBoot;
	
	public static Item WhiteWheatSeeds;
	public static Item WhiteWheat;
	public static Item ChiliSeed;
	public static Item Chili;
	
	public static Item Rice;
	
	public static Item DeadBread;
	
	public static Item GoldBucket;
	public static Item WaterBucket;
	public static Item LavaBucket;
	public static Item MilkBucket;
	public static Item QuickSilverBucket;
	public static Item SoulplasmBucket;
	public static Item AcidBucket1;
	public static Item AcidBucket2;
	
	public static Item SalamanderBoat;

	public static ArmorMaterial SkeletonWhiteArmor = EnumHelper.addArmorMaterial("SkeletonWhiteArmor", 7, new int[]{2, 5, 3, 1}, 25);
	public static ArmorMaterial SkeletonBlackArmor = EnumHelper.addArmorMaterial("SkeletonBlackArmor", 15, new int[]{2, 6, 5, 2}, 9);
	public static ArmorMaterial BlackIronArmor = EnumHelper.addArmorMaterial("BlackIronArmor", 23, new int[]{3, 9, 8, 3}, 14);
	public static ArmorMaterial SalamanderArmor = EnumHelper.addArmorMaterial("SalamanderArmor", 8, new int[]{2, 5, 3, 2}, 23);
	public static ToolMaterial GrimwoodTool = EnumHelper.addToolMaterial("GrimwoodTool", 0, 89, 3.0F, 0, 23);
	public static ToolMaterial BlackIronTool = EnumHelper.addToolMaterial("BlackIronTool", 3, 375, 9.0F, 3, 21);
	
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
		
		SalamanderLeather = new SalamanderLeather().setUnlocalizedName("SalamanderLeather");
		
		SkeletonWhiteHelmet = new SkeletonWhiteArmor(SkeletonWhiteArmor, 0, 0).setUnlocalizedName("SkeletonWhiteHelmet");
		SkeletonWhiteChestplate = new SkeletonWhiteArmor(SkeletonWhiteArmor, 0, 1).setUnlocalizedName("SkeletonWhiteChestplate");
		SkeletonWhiteLeggings = new SkeletonWhiteArmor(SkeletonWhiteArmor, 0, 2).setUnlocalizedName("SkeletonWhiteLeggings");
		SkeletonWhiteBoot = new SkeletonWhiteArmor(SkeletonWhiteArmor, 0, 3).setUnlocalizedName("SkeletonWhiteBoot");

		SkeletonBlackHelmet = new SkeletonBlackArmor(SkeletonBlackArmor, 0, 0).setUnlocalizedName("SkeletonBlackHelmet");
		SkeletonBlackChestplate = new SkeletonBlackArmor(SkeletonBlackArmor, 0, 1).setUnlocalizedName("SkeletonBlackChestplate");
		SkeletonBlackLeggings = new SkeletonBlackArmor(SkeletonBlackArmor, 0, 2).setUnlocalizedName("SkeletonBlackLeggings");
		SkeletonBlackBoot = new SkeletonBlackArmor(SkeletonBlackArmor, 0, 3).setUnlocalizedName("SkeletonBlackBoot");
		
		GrimwoodSword = new GrimwoodSword(GrimwoodTool).setUnlocalizedName("GrimwoodSword");
		GrimwoodPickaxe = new GrimwoodPickaxe(GrimwoodTool).setUnlocalizedName("GrimwoodPickaxe");
		GrimwoodAxe = new GrimwoodAxe(GrimwoodTool).setUnlocalizedName("GrimwoodAxe");
		GrimwoodShovel = new GrimwoodShovel(GrimwoodTool).setUnlocalizedName("GrimwoodShovel");
		GrimwoodHoe = new GrimwoodHoe(GrimwoodTool).setUnlocalizedName("GrimwoodHoe");
		
		WhiteWheatSeeds = new WhiteWheatSeeds(NPProperties.WhiteWheatSeedsID, NPProperties.CropsID, NPProperties.Nether_FarmID).setUnlocalizedName("WhiteWheatSeeds");
		WhiteWheat = new WhiteWheat(NPProperties.WhiteWheatID).setUnlocalizedName("WhiteWheat");
		ChiliSeed = new ChiliSeed(NPProperties.ChiliSeedID, NPProperties.ChiliCID, NPProperties.Nether_FarmID).setUnlocalizedName("ChiliSeed");
		Chili = new Chili(NPProperties.ChiliID, 10, 0.6F, false).setUnlocalizedName("Chili");
		Rice = new Rice(NPProperties.RiceID, 0, 0, NPProperties.RiceCID, NPProperties.Nether_FarmID).setUnlocalizedName("Rice");
		
		DeadBread = new DeadBread(NPProperties.DeadBreadID, 5, 0.6F, false).setUnlocalizedName("DeadBread");
		GoldBucket = new GoldBucket(NPProperties.GoldBucketID, 0).setUnlocalizedName("GoldBucket").setMaxStackSize(16);
		WaterBucket = new WaterBucket(NPProperties.WaterBucketID, Blocks.waterMoving.blockID).setUnlocalizedName("WaterBucket").setContainerItem(GoldBucket);
	    LavaBucket = new LavaBucket(NPProperties.LavaBucketID, Blocks.lavaMoving.blockID).setUnlocalizedName("LavaBucket").setContainerItem(GoldBucket);
	    MilkBucket = new MilkBucket(NPProperties.MilkBucketID).setUnlocalizedName("MilkBucket").setContainerItem(GoldBucket);
	    QuickSilverBucket = new QuickSilverBucket(NPProperties.QuickSilverBucketID, NPBlockList.QuicksilverMoving.blockID).setUnlocalizedName("QuickSilverBucket").setContainerItem(GoldBucket);
	    SoulplasmBucket = new SoulplasmBucket(NPProperties.SoulplasmBucketID, NPBlockList.SoulplasmMoving.blockID).setUnlocalizedName("SoulplasmBucket").setContainerItem(GoldBucket);
	    AcidBucket1 = new AcidBucket1(NPProperties.AcidBucket1ID, NPBlockList.AcidMoving.blockID).setUnlocalizedName("AcidBucket1").setContainerItem(GoldBucket);
	    AcidBucket2 = new AcidBucket2(NPProperties.AcidBucket2ID, NPBlockList.AcidMoving.blockID).setUnlocalizedName("AcidBucket2").setContainerItem(Item.bucketEmpty);

	    BlackIronHelmet = new BlackIronArmor(BlackIronArmor, 0, 0).setUnlocalizedName("BlackIronHelmet");
	    BlackIronChestplate = new BlackIronArmor(BlackIronArmor, 0, 1).setUnlocalizedName("BlackIronChestplate");
		BlackIronLeggings = new BlackIronArmor(BlackIronArmor, 0, 2).setUnlocalizedName("BlackIronLeggings");
		BlackIronBoot = new BlackIronArmor(BlackIronArmor, 0, 3).setUnlocalizedName("BlackIronBoot");
		
		BlackIronSword = new BlackIronSword(BlackIronTool).setUnlocalizedName("BlackIronSword");
		BlackIronPickaxe = new BlackIronPickaxe(BlackIronTool).setUnlocalizedName("BlackIronPickaxe");
		BlackIronAxe = new BlackIronAxe(BlackIronTool).setUnlocalizedName("BlackIronAxe");
		BlackIronShovel = new BlackIronShovel(BlackIronTool).setUnlocalizedName("BlackIronShovel");
		BlackIronHoe = new BlackIronHoe(BlackIronTool).setUnlocalizedName("BlackIronHoe");
		
		SalamanderHelmet = new SalamanderArmor(SalamanderArmor, 0, 0).setUnlocalizedName("SalamanderHelmet");
	    SalamanderChestplate = new SalamanderArmor(SalamanderArmor, 0, 1).setUnlocalizedName("SalamanderChestplate");
		SalamanderLeggings = new SalamanderArmor(SalamanderArmor, 0, 2).setUnlocalizedName("SalamanderLeggings");
		SalamanderBoot = new SalamanderArmor(SalamanderArmor, 0, 3).setUnlocalizedName("SalamanderBoot");
	    
	    SalamanderBoat = new ItemSalamanderBoat(NPProperties.SalamanderBoatID).setUnlocalizedName("SalamanderBoat");

		}
		catch(Exception ex)
		{
		Nether_plus.NPlog.severe("Erreur lors de l'initialisation des Items!");
		}
		Nether_plus.NPlog.info("Initialisation des Items terminés!");
	}
}
