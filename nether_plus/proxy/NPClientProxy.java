package nether_plus.proxy;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.common.MinecraftForge;
import nether_plus.client.ModelBlackSalamander;
import nether_plus.client.ModelFireSlime;
import nether_plus.client.ModelLavaTortoise;
import nether_plus.client.ModelMogus;
import nether_plus.client.ModelPordenfer;
import nether_plus.client.ModelRedMogus;
import nether_plus.client.ModelSalamander;
import nether_plus.client.ModelWight;
import nether_plus.client.RenderBlackSalamander;
import nether_plus.client.RenderFireSlime;
import nether_plus.client.RenderLavaTortoise;
import nether_plus.client.RenderMogus;
import nether_plus.client.RenderPordenfer;
import nether_plus.client.RenderRedMogus;
import nether_plus.client.RenderSalamander;
import nether_plus.client.RenderWight;
import nether_plus.client.audio.NPSounds;
import nether_plus.common.entity.BlackSalamander;
import nether_plus.common.entity.FireSlime;
import nether_plus.common.entity.LavaTortoise;
import nether_plus.common.entity.Mogus;
import nether_plus.common.entity.Pordenfer;
import nether_plus.common.entity.RedMogus;
import nether_plus.common.entity.Salamander;
import nether_plus.common.entity.Wight;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class NPClientProxy extends NPCommonProxy
{
	
	private int i;
	private ModelBase ModelBase;
	
	public static int shouldRenderPass;


	@Override
	public void registerRender()
	{

	}
	
	public void initSound()
	{
		MinecraftForge.EVENT_BUS.register(new NPSounds());
	}
	
	public void registerRenderEntity()
	{
	     RenderingRegistry.registerEntityRenderingHandler(Salamander.class, new RenderSalamander(new ModelSalamander(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(BlackSalamander.class, new RenderBlackSalamander(new ModelBlackSalamander(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(Wight.class, new RenderWight(new ModelWight(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(Mogus.class, new RenderMogus(new ModelMogus(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(RedMogus.class, new RenderRedMogus(new ModelRedMogus(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(LavaTortoise.class, new RenderLavaTortoise(new ModelLavaTortoise(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(Pordenfer.class, new RenderPordenfer(new ModelPordenfer(), 0.5F));
//	     RenderingRegistry.registerEntityRenderingHandler(FireSlime.class, new RenderFireSlime(new ModelFireSlime(i), ModelBase, 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(FireSlime.class, new RenderFireSlime(new ModelFireSlime(i), new ModelFireSlime(0), 0.5F));

	}
}