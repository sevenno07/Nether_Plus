package nether_plus.common.entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHell;
import nether_plus.common.Nether_plus;
import cpw.mods.fml.common.registry.EntityRegistry;

public class NPEntityList
{
	public static void loadEntity()
	{
		EntityRegistry.registerGlobalEntityID(Salamander.class, "Salamandre", EntityRegistry.findGlobalUniqueEntityId(), 20, 10);
		EntityRegistry.registerModEntity(Salamander.class, "Salamandre", 1, Nether_plus.instance, 40, 1, true);
		EntityRegistry.addSpawn(Salamander.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.hell);
	}
}
