package nether_plus.common.entity;

import java.awt.Color;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHell;
import nether_plus.common.Nether_plus;
import cpw.mods.fml.common.registry.EntityRegistry;

public class NPEntityList
{
	public static void loadEntity()
	{
		EntityRegistry.registerGlobalEntityID(Salamander.class, "Salamandre", EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 102, 0).getRGB(), new Color(0, 0, 0).getRGB());
		EntityRegistry.registerModEntity(Salamander.class, "Salamandre", 230, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Salamander.class, 100, 4, 7, EnumCreatureType.creature, BiomeGenBase.hell);
		
		EntityRegistry.registerGlobalEntityID(Wight.class, "Wight", EntityRegistry.findGlobalUniqueEntityId(), new Color(255, 255, 255).getRGB(), new Color(0, 0, 0).getRGB());
		EntityRegistry.registerModEntity(Wight.class, "Wight", 231, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Wight.class, 100, 4, 7, EnumCreatureType.creature, BiomeGenBase.hell);
	}
}