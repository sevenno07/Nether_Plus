package nether_plus.common.item;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import nether_plus.common.Nether_plus;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class NPItemList
{
	public static Item charoiteCrystal;
	public static Item blackIronIngot;
	public static Item blackBone;
	public static Item blackBoneMeal;
	public static Item fireslimeball;
	public static Item grimwoodStick;
	public static Item bloodGem;
	public static Item infernumIngot;
	public static Item itemGrimwoodDoor;
	public static Item itemBlackironDoor;
	public static Item salamanderLeather;

	public static Item skeletonWhiteHelmet;
	public static Item skeletonWhiteChestplate;
	public static Item skeletonWhiteLeggings;
	public static Item skeletonWhiteBoot;

	public static Item skeletonBlackHelmet;
	public static Item skeletonBlackChestplate;
	public static Item skeletonBlackLeggings;
	public static Item skeletonBlackBoot;

	public static Item grimwoodSword;
	public static Item grimwoodPickaxe;
	public static Item grimwoodAxe;
	public static Item grimwoodShovel;
	public static Item grimwoodHoe;

	public static Item corruptionstoneSword;
	public static Item corruptionstonePickaxe;
	public static Item corruptionstoneAxe;
	public static Item corruptionstoneShovel;
	public static Item corruptionstoneHoe;

	public static Item blackIronSword;
	public static Item blackIronPickaxe;
	public static Item blackIronAxe;
	public static Item blackIronShovel;
	public static Item blackIronHoe;

	public static Item blackIronHelmet;
	public static Item blackIronChestplate;
	public static Item blackIronLeggings;
	public static Item blackIronBoot;

	public static Item salamanderHelmet;
	public static Item salamanderChestplate;
	public static Item salamanderLeggings;
	public static Item salamanderBoot;

	public static Item whiteWheatSeeds;
	public static Item whiteWheat;
	public static Item chiliSeed;
	public static Item chili;

	public static Item rice;

	public static Item deadBread;

	public static Item goldBucket;
	public static Item waterBucket;
	public static Item lavaBucket;
	public static Item milkBucket;
	public static Item quickSilverBucket;
	public static Item soulplasmBucket;
	public static Item acidBucket1;
	public static Item acidBucket2;
	
	public static Item grimwoodBow;
	public static Item grimwoodArrow;

	public static Item salamanderBoat;

	public static ArmorMaterial skeletonWhiteArmor = EnumHelper.addArmorMaterial("SkeletonWhiteArmor", 7, new int[] { 2, 5, 3, 1 }, 25);
	public static ArmorMaterial skeletonBlackArmor = EnumHelper.addArmorMaterial("SkeletonBlackArmor", 15, new int[] { 2, 6, 5, 2 }, 9);
	public static ArmorMaterial blackIronArmor = EnumHelper.addArmorMaterial("BlackIronArmor", 23, new int[] { 3, 9, 8, 3 }, 14);
	public static ArmorMaterial salamanderArmor = EnumHelper.addArmorMaterial("SalamanderArmor", 8, new int[] { 2, 5, 3, 2 }, 23);
	public static ToolMaterial grimwoodTool = EnumHelper.addToolMaterial("GrimwoodTool", 0, 89, 3.0F, 0, 23);
	public static ToolMaterial corruptionStoneTool = EnumHelper.addToolMaterial("CorruptionStoneTool", 1, 131, 4.0F, 1, 5);
	public static ToolMaterial blackIronTool = EnumHelper.addToolMaterial("BlackIronTool", 3, 375, 9.0F, 3, 21);

	public static void loadItem()
	{
		try
		{
			charoiteCrystal = new CharoiteCrystal().setUnlocalizedName("CharoiteCrystal");
			blackIronIngot = new BlackIronIngot().setUnlocalizedName("BlackIronIngot");
			blackBone = new BlackBone().setUnlocalizedName("BlackBone");
			blackBoneMeal = new BlackBoneMeal().setUnlocalizedName("BlackBoneMeal");
			fireslimeball = new Fireslimeball().setUnlocalizedName("Fireslimeball");
			grimwoodStick = new GrimwoodStick().setUnlocalizedName("GrimwoodStick");
			bloodGem = new BloodGem().setUnlocalizedName("BloodGem");
			infernumIngot = new InfernumIngot().setUnlocalizedName("InfernumIngot");
			itemGrimwoodDoor = new ItemModDoor(Material.wood).setUnlocalizedName("ItemGrimwoodDoor").setTextureName("nether_plus:ItemGrimwoodDoor");
			itemBlackironDoor = new ItemModDoor(Material.iron).setUnlocalizedName("itemBlackironDoor").setTextureName("nether_plus:ItemBlackironDoor");

			salamanderLeather = new SalamanderLeather().setUnlocalizedName("SalamanderLeather");

			skeletonWhiteHelmet = new SkeletonWhiteArmor(skeletonWhiteArmor, 0, 0).setUnlocalizedName("SkeletonWhiteHelmet").setTextureName("nether_plus:SkeletonWhiteHelmet");
			skeletonWhiteChestplate = new SkeletonWhiteArmor(skeletonWhiteArmor, 0, 1).setUnlocalizedName("SkeletonWhiteChestplate").setTextureName("nether_plus:SkeletonWhiteChestplate");
			skeletonWhiteLeggings = new SkeletonWhiteArmor(skeletonWhiteArmor, 0, 2).setUnlocalizedName("SkeletonWhiteLeggings").setTextureName("nether_plus:SkeletonWhiteLeggings");
			skeletonWhiteBoot = new SkeletonWhiteArmor(skeletonWhiteArmor, 0, 3).setUnlocalizedName("SkeletonWhiteBoot").setTextureName("nether_plus:SkeletonWhiteBoot");

			skeletonBlackHelmet = new SkeletonBlackArmor(skeletonBlackArmor, 0, 0).setUnlocalizedName("SkeletonBlackHelmet").setTextureName("nether_plus:SkeletonBlackHelmet");
			skeletonBlackChestplate = new SkeletonBlackArmor(skeletonBlackArmor, 0, 1).setUnlocalizedName("SkeletonBlackChestplate").setTextureName("nether_plus:SkeletonBlackChestplate");
			skeletonBlackLeggings = new SkeletonBlackArmor(skeletonBlackArmor, 0, 2).setUnlocalizedName("SkeletonBlackLeggings").setTextureName("nether_plus:SkeletonBlackLeggings");
			skeletonBlackBoot = new SkeletonBlackArmor(skeletonBlackArmor, 0, 3).setUnlocalizedName("SkeletonBlackBoot").setTextureName("nether_plus:SkeletonBlackBoot");

			grimwoodSword = new GrimwoodSword(grimwoodTool).setUnlocalizedName("GrimwoodSword");
			grimwoodPickaxe = new GrimwoodPickaxe(grimwoodTool).setUnlocalizedName("GrimwoodPickaxe");
			grimwoodAxe = new GrimwoodAxe(grimwoodTool).setUnlocalizedName("GrimwoodAxe");
			grimwoodShovel = new GrimwoodShovel(grimwoodTool).setUnlocalizedName("GrimwoodShovel");
			grimwoodHoe = new GrimwoodHoe(grimwoodTool).setUnlocalizedName("GrimwoodHoe");

			corruptionstoneSword = new CorruptionstoneSword(corruptionStoneTool).setUnlocalizedName("CorruptionstoneSword");
			corruptionstonePickaxe = new CorruptionstonePickaxe(corruptionStoneTool).setUnlocalizedName("CorruptionstonePickaxe");
			corruptionstoneAxe = new CorruptionstoneAxe(corruptionStoneTool).setUnlocalizedName("CorruptionstoneAxe");
			corruptionstoneShovel = new CorruptionstoneShovel(corruptionStoneTool).setUnlocalizedName("CorruptionstoneShovel");
			corruptionstoneHoe = new CorruptionstoneHoe(corruptionStoneTool).setUnlocalizedName("CorruptionstoneHoe");

			whiteWheatSeeds = new WhiteWheatSeeds(NPBlockList.crops,NPBlockList.nether_Farm).setUnlocalizedName("WhiteWheatSeeds");
			whiteWheat = new WhiteWheat().setUnlocalizedName("WhiteWheat");
			chiliSeed = new ChiliSeed(NPBlockList.chiliC,NPBlockList.nether_Farm).setUnlocalizedName("ChiliSeed");
			chili = new Chili(10, 0.6F, false).setUnlocalizedName("Chili");
			rice = new Rice(NPBlockList.riceC, NPBlockList.nether_Farm).setUnlocalizedName("Rice");

			deadBread = new DeadBread(5, 0.6F, false).setUnlocalizedName("DeadBread");
			goldBucket = new GoldBucket(Blocks.air).setUnlocalizedName("GoldBucket").setMaxStackSize(16);
			waterBucket = new WaterBucket(Blocks.flowing_water).setUnlocalizedName("WaterBucket").setContainerItem(goldBucket);
			lavaBucket = new LavaBucket(Blocks.flowing_lava).setUnlocalizedName("LavaBucket").setContainerItem(goldBucket);
			milkBucket = new MilkBucket().setUnlocalizedName("MilkBucket").setContainerItem(goldBucket);
			quickSilverBucket = new QuickSilverBucket(NPBlockList.blockQuicksilver).setUnlocalizedName("QuickSilverBucket").setContainerItem(goldBucket);
			soulplasmBucket = new SoulplasmBucket(NPBlockList.blockSoulplasm).setUnlocalizedName("SoulplasmBucket").setContainerItem(goldBucket);
			acidBucket1 = new AcidBucket1(NPBlockList.blockAcid).setUnlocalizedName("AcidBucket1").setContainerItem(goldBucket);
			acidBucket2 = new AcidBucket2(NPBlockList.blockAcid).setUnlocalizedName("AcidBucket2").setContainerItem(Items.bucket);

			blackIronHelmet = new BlackIronArmor(blackIronArmor, 0, 0).setUnlocalizedName("BlackIronHelmet").setTextureName("nether_plus:BlackIronHelmet");
			blackIronChestplate = new BlackIronArmor(blackIronArmor, 0, 1).setUnlocalizedName("BlackIronChestplate").setTextureName("nether_plus:BlackIronChestplate");
			blackIronLeggings = new BlackIronArmor(blackIronArmor, 0, 2).setUnlocalizedName("BlackIronLeggings").setTextureName("nether_plus:BlackIronLeggings");
			blackIronBoot = new BlackIronArmor(blackIronArmor, 0, 3).setUnlocalizedName("BlackIronBoot").setTextureName("nether_plus:BlackIronBoot");

			blackIronSword = new BlackIronSword(blackIronTool).setUnlocalizedName("BlackIronSword");
			blackIronPickaxe = new BlackIronPickaxe(blackIronTool).setUnlocalizedName("BlackIronPickaxe");
			blackIronAxe = new BlackIronAxe(blackIronTool).setUnlocalizedName("BlackIronAxe");
			blackIronShovel = new BlackIronShovel(blackIronTool).setUnlocalizedName("BlackIronShovel");
			blackIronHoe = new BlackIronHoe(blackIronTool).setUnlocalizedName("BlackIronHoe");

			salamanderHelmet = new SalamanderArmor(salamanderArmor, 0, 0).setUnlocalizedName("SalamanderHelmet").setTextureName("nether_plus:SalamanderHelmet");
			salamanderChestplate = new SalamanderArmor(salamanderArmor, 0, 1).setUnlocalizedName("SalamanderChestplate").setTextureName("nether_plus:SalamanderChestplate");
			salamanderLeggings = new SalamanderArmor(salamanderArmor, 0, 2).setUnlocalizedName("SalamanderLeggings").setTextureName("nether_plus:SalamanderLeggings");
			salamanderBoot = new SalamanderArmor(salamanderArmor, 0, 3).setUnlocalizedName("SalamanderBoot").setTextureName("nether_plus:SalamanderBoot");

			salamanderBoat = new ItemSalamanderBoat().setUnlocalizedName("SalamanderBoat");
			
			grimwoodArrow = new GrimwoodArrow().setUnlocalizedName("GrimwoodArrow").setTextureName("nether_plus:GrimwoodArrow").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsItem);
			grimwoodBow = new GrimwoodBow().setUnlocalizedName("GrimwoodBow").setTextureName("nether_plus:GrimwoodBow").setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsArmor);
			
			GameRegistry.registerItem(charoiteCrystal, "CharoiteCrystal");
			GameRegistry.registerItem(blackIronIngot, "BlackIronIngot");
			GameRegistry.registerItem(blackBone, "BlackBone");
			GameRegistry.registerItem(blackBoneMeal, "BlackBoneMeal");
			GameRegistry.registerItem(fireslimeball, "Fireslimeball");
			GameRegistry.registerItem(grimwoodStick, "GrimwoodStick");
			GameRegistry.registerItem(bloodGem, "BloodGem");
			GameRegistry.registerItem(infernumIngot, "InfernumIngot");
			GameRegistry.registerItem(itemGrimwoodDoor, "ItemGrimwoodDoor");
			GameRegistry.registerItem(itemBlackironDoor, "ItemBlackironDoor");
			GameRegistry.registerItem(salamanderLeather, "SalamanderLeather");
			GameRegistry.registerItem(skeletonWhiteHelmet, "SkeletonWhiteHelmet");
			GameRegistry.registerItem(skeletonWhiteChestplate, "SkeletonWhiteChestplate");
			GameRegistry.registerItem(skeletonWhiteLeggings, "SkeletonWhiteLeggings");
			GameRegistry.registerItem(skeletonWhiteBoot, "SkeletonWhiteBoot");
			GameRegistry.registerItem(skeletonBlackHelmet, "SkeletonBlackHelmet");
			GameRegistry.registerItem(skeletonBlackChestplate, "SkeletonBlackChestplate");
			GameRegistry.registerItem(skeletonBlackLeggings, "SkeletonBlackLeggings");
			GameRegistry.registerItem(skeletonBlackBoot, "SkeletonBlackBoot");
			GameRegistry.registerItem(grimwoodSword, "GrimwoodSword");
			GameRegistry.registerItem(grimwoodPickaxe, "GrimwoodPickaxe");
			GameRegistry.registerItem(grimwoodAxe, "GrimwoodAxe");
			GameRegistry.registerItem(grimwoodShovel, "GrimwoodShovel");
			GameRegistry.registerItem(grimwoodHoe, "GrimwoodHoe");
			GameRegistry.registerItem(corruptionstoneSword, "CorruptionstoneSword");
			GameRegistry.registerItem(corruptionstonePickaxe, "CorruptionstonePickaxe");
			GameRegistry.registerItem(corruptionstoneAxe, "CorruptionstoneAxe");
			GameRegistry.registerItem(corruptionstoneShovel, "CorruptionstoneShovel");
			GameRegistry.registerItem(corruptionstoneHoe, "CorruptionstoneHoe");
			GameRegistry.registerItem(blackIronHelmet, "BlackIronHelmet");
			GameRegistry.registerItem(blackIronChestplate, "BlackIronChestplate");
			GameRegistry.registerItem(blackIronLeggings, "BlackIronLeggings");
			GameRegistry.registerItem(blackIronBoot, "BlackIronBoot");
			GameRegistry.registerItem(blackIronSword, "BlackIronSword");
			GameRegistry.registerItem(blackIronPickaxe, "BlackIronPickaxe");
			GameRegistry.registerItem(blackIronAxe, "BlackIronAxe");
			GameRegistry.registerItem(blackIronShovel, "BlackIronShovel");
			GameRegistry.registerItem(blackIronHoe, "BlackIronHoe");
			GameRegistry.registerItem(salamanderHelmet, "SalamanderHelmet");
			GameRegistry.registerItem(salamanderChestplate, "SalamanderChestplate");
			GameRegistry.registerItem(salamanderLeggings, "SalamanderLeggings");
			GameRegistry.registerItem(salamanderBoot, "SalamanderBoot");
			GameRegistry.registerItem(whiteWheatSeeds, "WhiteWheatSeeds");
			GameRegistry.registerItem(whiteWheat, "WhiteWheat");
			GameRegistry.registerItem(chiliSeed, "ChiliSeed");
			GameRegistry.registerItem(chili, "Chili");
			GameRegistry.registerItem(rice, "Rice");
			GameRegistry.registerItem(deadBread, "DeadBread");
			GameRegistry.registerItem(goldBucket, "GoldBucket");
			GameRegistry.registerItem(waterBucket, "WaterBucket");
			GameRegistry.registerItem(lavaBucket, "LavaBucket");
			GameRegistry.registerItem(milkBucket, "MilkBucket");
			GameRegistry.registerItem(quickSilverBucket, "QuickSilverBucket");
			GameRegistry.registerItem(soulplasmBucket, "SoulplasmBucket");
			GameRegistry.registerItem(acidBucket1, "AcidBucket1");
			GameRegistry.registerItem(acidBucket2, "AcidBucket2");
			GameRegistry.registerItem(salamanderBoat, "SalamanderBoat");
			
			GameRegistry.registerItem(grimwoodArrow, "GrimwoodArrow");
			GameRegistry.registerItem(grimwoodBow, "GrimwoodBow");
			
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("quickSilver", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(quickSilverBucket), FluidContainerRegistry.EMPTY_BUCKET);
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("soulPlasm", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(soulplasmBucket), FluidContainerRegistry.EMPTY_BUCKET);
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("acid", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(acidBucket1), FluidContainerRegistry.EMPTY_BUCKET);
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("acid", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(acidBucket2), FluidContainerRegistry.EMPTY_BUCKET);
		}catch(Exception ex)
		{
			Nether_plus.npLog.severe("Erreur lors de l'initialisation des Items!");
		}
		Nether_plus.npLog.info("Initialisation des Items terminés!");
	}
}