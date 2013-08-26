package nether_plus.common.entity;

import java.awt.Color;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import nether_plus.common.Nether_plus;
import cpw.mods.fml.common.registry.EntityRegistry;

public class NPEntityList
{
	public static void loadEntity()
	{
		EntityRegistry.registerGlobalEntityID(Salamander.class, "Salamandre", EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 102, 0).getRGB(), new Color(0, 0, 0).getRGB());
		EntityRegistry.registerModEntity(Salamander.class, "Salamandre", 231, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Salamander.class, 100, 7, 7, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(BlackSalamander.class, "BlackSalamander", EntityRegistry.findGlobalUniqueEntityId(), new Color(0, 0, 0).getRGB(), new Color(255, 102, 0).getRGB());
		EntityRegistry.registerModEntity(BlackSalamander.class, "BlackSalamander", 232, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(BlackSalamander.class, 125, 7, 7, EnumCreatureType.monster, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(Wight.class, "Wight", EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 255, 255).getRGB(), new Color(0, 0, 0).getRGB());
		EntityRegistry.registerModEntity(Wight.class, "Wight", 233, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Wight.class, 100, 7, 7, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(Mogus.class, "Mogus", EntityRegistry.findGlobalUniqueEntityId(), new Color(156, 88, 37).getRGB(), new Color(255, 255, 255).getRGB());
		EntityRegistry.registerModEntity(Mogus.class, "Mogus", 234, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Mogus.class, 75, 12, 12, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(RedMogus.class, "RedMogus", EntityRegistry.findGlobalUniqueEntityId(), new Color(167, 37, 40).getRGB(), new Color(255, 255, 255).getRGB());
		EntityRegistry.registerModEntity(RedMogus.class, "RedMogus", 235, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(RedMogus.class, 75, 12, 12, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(LavaTortoise.class, "LavaTortoise", EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 126, 0).getRGB(), new Color(79, 0, 157).getRGB());
		EntityRegistry.registerModEntity(LavaTortoise.class, "LavaTortoise", 236, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(LavaTortoise.class, 100, 7, 7, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(Pordenfer.class, "Pordenfer", EntityRegistry.findGlobalUniqueEntityId(), new Color(167, 37, 40).getRGB(), new Color(255, 255, 255).getRGB());
		EntityRegistry.registerModEntity(Pordenfer.class, "Pordenfer", 237, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Pordenfer.class, 100, 7, 7, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(FireSlime.class, "FireSlime", EntityRegistry.findGlobalUniqueEntityId(), new Color(167, 37, 40).getRGB(), new Color(255, 255, 255).getRGB());
		EntityRegistry.registerModEntity(FireSlime.class, "FireSlime", 238, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(FireSlime.class, 100, 7, 7, EnumCreatureType.monster, BiomeGenBase.hell);
	}
}