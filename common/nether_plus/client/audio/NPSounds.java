package nether_plus.client.audio;

import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import nether_plus.common.Nether_plus;

public class NPSounds
{
	private String[] soundNames = {"Wight/death.ogg", "Wight/hit1.ogg", "Wight/hit2.ogg", "Wight/hit3.ogg",  "Wight/hit4.ogg", "Wight/idle1.ogg", "Wight/idle2.ogg", "Wight/idle3.ogg", "Wight/idle4.ogg"};

	@ForgeSubscribe
	public void onSoundsLoad(SoundLoadEvent event)
	{
		SoundManager manager = event.manager;
		try
		{
			for(String soundName : soundNames)
			{
				manager.soundPoolSounds.addSound(soundName, Nether_plus.class.getResource("/mods/nether_plus/sounds/" + soundName));
			}
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