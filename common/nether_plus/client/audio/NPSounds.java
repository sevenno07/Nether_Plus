package nether_plus.client.audio;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import nether_plus.common.Nether_plus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class NPSounds
{
	public static ResourceLocation sounds = new ResourceLocation("nether_plus:sounds");
	
	@SubscribeEvent
	public void onSoundsLoad(SoundLoadEvent event)
	{
		try
		{
			//TODO fix sounds
			//event.getResult(null).getSoundPoolEntryLocation().equals(sounds);
			/*event.manager.addSound("nether_plus:Wight.death.ogg");
			event.manager.addSound("nether_plus:Wight.hit1.ogg");
			event.manager.addSound("nether_plus:Wight.hit2.ogg");
			event.manager.addSound("nether_plus:Wight.hit3.ogg"); 
			event.manager.addSound("nether_plus:Wight.hit4.ogg");
			event.manager.addSound("nether_plus:Wight.idle1.ogg");
			event.manager.addSound("nether_plus:Wight.idle2.ogg");
			event.manager.addSound("nether_plus:Wight.idle3.ogg");
			event.manager.addSound("nether_plus:Wight.idle4.ogg");*/
		}
		catch(Exception ex)
		{
			Nether_plus.NPlog.severe("Failed to register one or more sounds.");
		}
		finally
		{
			Nether_plus.NPlog.info("Initialisation des sons terminés!");
		}
	}
}