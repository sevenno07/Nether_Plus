package nether_plus.client.audio;

import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import nether_plus.common.Nether_plus;

public class NPSounds
{
	private String[] soundNames = {"newsound/death.ogg", "newsound/hit1.ogg", "newsound/hit2.ogg", "newsound/hit3.ogg",  "newsound/hit4.ogg", "newsound/idle1.ogg", "newsound/idle2.ogg", "newsound/idle3.ogg", "newsound/idle4.ogg"};

	@ForgeSubscribe
	public void onSoundsLoad(SoundLoadEvent event)
	{
		SoundManager manager = event.manager;
		try
		{
			for(String soundName : soundNames)
			{
				manager.soundPoolSounds.addSound(soundName, Nether_plus.class.getResource("/nether_plus/client/resources/" + soundName));
			}
		}
		catch(Exception ex)
		{
			Nether_plus.NPlog.severe("Failed to register one or more sounds.");
		}
	}

}