package nether_plus.common.worldgenerator;

import cpw.mods.fml.common.registry.GameRegistry;

public class NPWorldGenerator
{
	public static void loadWorldGenerator()
	{
		GameRegistry.registerWorldGenerator(new WoldGeneratorMinable(), 0);
	}
}