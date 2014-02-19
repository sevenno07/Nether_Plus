package nether_plus.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import nether_plus.common.Nether_plus;
import nether_plus.common.block.NPBlockList;

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
	
	public static Item CorruptionstoneSword;
	public static Item CorruptionstonePickaxe;
	public static Item CorruptionstoneAxe;
	public static Item CorruptionstoneShovel;
	public static Item CorruptionstoneHoe;
	
	public static Item BlackIronSword;
	public static Item BlackIronPickaxe;
	public static Item BlackIronAxe;
	public static Item BlackIronShovel;
	public static Item BlackIronHoe;
	
	public static Item BlackIronHelmet;
	public static Item BlackIronChestplate;
	public static Item BlackIronLeggings;
	public static Item BlackIronBoot;
	
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
	public static ToolMaterial CorruptionStoneTool = EnumHelper.addToolMaterial("CorruptionStoneTool", 1, 131, 4.0F, 1, 5);
	public static ToolMaterial BlackIronTool = EnumHelper.addToolMaterial("BlackIronTool", 3, 375, 9.0F, 3, 21);
	
	public static void loadItem()
	{
		try
		{
		CharoiteCrystal = new CharoiteCrystal().setUnlocalizedName("CharoiteCrystal");
		BlackIronIngot = new BlackIronIngot().setUnlocalizedName("BlackIronIngot");
		BlackBone = new BlackBone().setUnlocalizedName("BlackBone");
		BlackBoneMeal = new BlackBoneMeal().setUnlocalizedName("BlackBoneMeal");
		Fireslimeball = new Fireslimeball().setUnlocalizedName("Fireslimeball");
		GrimwoodStick = new GrimwoodStick().setUnlocalizedName("GrimwoodStick");
		BloodGem = new BloodGem().setUnlocalizedName("BloodGem");
		InfernumIngot = new InfernumIngot().setUnlocalizedName("InfernumIngot");
		ItemGrimwoodDoor = new ItemGrimwoodDoor(Material.wood).setUnlocalizedName("ItemGrimwoodDoor");
		
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
		
		CorruptionstoneSword = new CorruptionstoneSword(CorruptionStoneTool).setUnlocalizedName("CorruptionstoneSword");
		CorruptionstonePickaxe = new CorruptionstonePickaxe(CorruptionStoneTool).setUnlocalizedName("CorruptionstonePickaxe");
		CorruptionstoneAxe = new CorruptionstoneAxe(CorruptionStoneTool).setUnlocalizedName("CorruptionstoneAxe");
		CorruptionstoneShovel = new CorruptionstoneShovel(CorruptionStoneTool).setUnlocalizedName("CorruptionstoneShovel");
		CorruptionstoneHoe = new CorruptionstoneHoe(CorruptionStoneTool).setUnlocalizedName("CorruptionstoneHoe");
		
		WhiteWheatSeeds = new WhiteWheatSeeds(NPBlockList.Crops, NPBlockList.Nether_Farm).setUnlocalizedName("WhiteWheatSeeds");
		WhiteWheat = new WhiteWheat().setUnlocalizedName("WhiteWheat");
		ChiliSeed = new ChiliSeed(NPBlockList.ChiliC, NPBlockList.Nether_Farm).setUnlocalizedName("ChiliSeed");
		Chili = new Chili(10, 0.6F, false).setUnlocalizedName("Chili");
		Rice = new Rice(0, 0, NPBlockList.RiceC, NPBlockList.Nether_Farm).setUnlocalizedName("Rice");
		
		DeadBread = new DeadBread(5, 0.6F, false).setUnlocalizedName("DeadBread");
		GoldBucket = new GoldBucket(Blocks.air).setUnlocalizedName("GoldBucket").setMaxStackSize(16);
		WaterBucket = new WaterBucket(Blocks.flowing_water).setUnlocalizedName("WaterBucket").setContainerItem(GoldBucket);
	    LavaBucket = new LavaBucket(Blocks.flowing_lava).setUnlocalizedName("LavaBucket").setContainerItem(GoldBucket);
	    MilkBucket = new MilkBucket().setUnlocalizedName("MilkBucket").setContainerItem(GoldBucket);
	    QuickSilverBucket = new QuickSilverBucket(NPBlockList.QuicksilverMoving).setUnlocalizedName("QuickSilverBucket").setContainerItem(GoldBucket);
	    SoulplasmBucket = new SoulplasmBucket(NPBlockList.SoulplasmMoving).setUnlocalizedName("SoulplasmBucket").setContainerItem(GoldBucket);
	    AcidBucket1 = new AcidBucket1(NPBlockList.AcidMoving).setUnlocalizedName("AcidBucket1").setContainerItem(GoldBucket);
	    AcidBucket2 = new AcidBucket2(NPBlockList.AcidMoving).setUnlocalizedName("AcidBucket2").setContainerItem(Items.bucket);

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
	    
	    SalamanderBoat = new ItemSalamanderBoat().setUnlocalizedName("SalamanderBoat");

	    GameRegistry.registerItem(CharoiteCrystal, "CharoiteCrystal");
	    GameRegistry.registerItem(BlackIronIngot, "BlackIronIngot");
	    GameRegistry.registerItem(BlackBone, "BlackBone");
	    GameRegistry.registerItem(BlackBoneMeal, "BlackBoneMeal");
	    GameRegistry.registerItem(Fireslimeball, "Fireslimeball");
	    GameRegistry.registerItem(GrimwoodStick, "GrimwoodStick");
	    GameRegistry.registerItem(BloodGem, "BloodGem");
	    GameRegistry.registerItem(InfernumIngot, "InfernumIngot");
	    GameRegistry.registerItem(ItemGrimwoodDoor, "ItemGrimwoodDoor");
	    GameRegistry.registerItem(SalamanderLeather, "SalamanderLeather");
	    GameRegistry.registerItem(SkeletonWhiteHelmet, "SkeletonWhiteHelmet");
	    GameRegistry.registerItem(SkeletonWhiteChestplate, "SkeletonWhiteChestplate");
	    GameRegistry.registerItem(SkeletonWhiteLeggings, "SkeletonWhiteLeggings");
	    GameRegistry.registerItem(SkeletonWhiteBoot, "SkeletonWhiteBoot");
	    GameRegistry.registerItem(SkeletonBlackHelmet, "SkeletonBlackHelmet");
	    GameRegistry.registerItem(SkeletonBlackChestplate, "SkeletonBlackChestplate");
	    GameRegistry.registerItem(SkeletonBlackLeggings, "SkeletonBlackLeggings");
	    GameRegistry.registerItem(SkeletonBlackBoot, "SkeletonBlackBoot");
	    GameRegistry.registerItem(GrimwoodSword, "GrimwoodSword");
	    GameRegistry.registerItem(GrimwoodPickaxe, "GrimwoodPickaxe");
	    GameRegistry.registerItem(GrimwoodAxe, "GrimwoodAxe");
	    GameRegistry.registerItem(GrimwoodShovel, "GrimwoodShovel");
	    GameRegistry.registerItem(GrimwoodHoe, "GrimwoodHoe");
	    GameRegistry.registerItem(CorruptionstoneSword, "CorruptionstoneSword");
	    GameRegistry.registerItem(CorruptionstonePickaxe, "CorruptionstonePickaxe");
	    GameRegistry.registerItem(CorruptionstoneAxe, "CorruptionstoneAxe");
	    GameRegistry.registerItem(CorruptionstoneShovel, "CorruptionstoneShovel");
	    GameRegistry.registerItem(CorruptionstoneHoe, "CorruptionstoneHoe");
	    GameRegistry.registerItem(BlackIronHelmet, "BlackIronHelmet");
	    GameRegistry.registerItem(BlackIronChestplate, "BlackIronChestplate");
	    GameRegistry.registerItem(BlackIronLeggings, "BlackIronLeggings");
	    GameRegistry.registerItem(BlackIronBoot, "BlackIronBoot");
	    GameRegistry.registerItem(BlackIronSword, "BlackIronSword");
	    GameRegistry.registerItem(BlackIronPickaxe, "BlackIronPickaxe");
	    GameRegistry.registerItem(BlackIronAxe, "BlackIronAxe");
	    GameRegistry.registerItem(BlackIronShovel, "BlackIronShovel");
	    GameRegistry.registerItem(BlackIronHoe, "BlackIronHoe");
	    GameRegistry.registerItem(SalamanderHelmet, "SalamanderHelmet");
	    GameRegistry.registerItem(SalamanderChestplate, "SalamanderChestplate");
	    GameRegistry.registerItem(SalamanderLeggings, "SalamanderLeggings");
	    GameRegistry.registerItem(SalamanderBoot, "SalamanderBoot");
	    GameRegistry.registerItem(WhiteWheatSeeds, "WhiteWheatSeeds");
	    GameRegistry.registerItem(WhiteWheat, "WhiteWheat");
	    GameRegistry.registerItem(ChiliSeed, "ChiliSeed");
	    GameRegistry.registerItem(Chili, "Chili");
	    GameRegistry.registerItem(Rice, "Rice");
	    GameRegistry.registerItem(DeadBread, "DeadBread");
	    GameRegistry.registerItem(GoldBucket, "GoldBucket");
	    GameRegistry.registerItem(WaterBucket, "WaterBucket");
	    GameRegistry.registerItem(LavaBucket, "LavaBucket");
	    GameRegistry.registerItem(MilkBucket, "MilkBucket");
	    GameRegistry.registerItem(QuickSilverBucket, "QuickSilverBucket");
	    GameRegistry.registerItem(SoulplasmBucket, "SoulplasmBucket");
	    GameRegistry.registerItem(AcidBucket1, "AcidBucket1");
	    GameRegistry.registerItem(AcidBucket2, "AcidBucket2");
	    GameRegistry.registerItem(SalamanderBoat, "SalamanderBoat");
		}
		catch(Exception ex)
		{
			Nether_plus.NPlog.severe("Erreur lors de l'initialisation des Items!");
		}
		Nether_plus.NPlog.info("Initialisation des Items terminés!");
	}
}
