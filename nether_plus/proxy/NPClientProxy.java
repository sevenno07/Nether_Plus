package nether_plus.proxy;

import net.minecraftforge.common.MinecraftForge;
import nether_plus.client.audio.NPSounds;
import nether_plus.client.model.ModelBlackSalamander;
import nether_plus.client.model.ModelFireSlime;
import nether_plus.client.model.ModelLavaTortoise;
import nether_plus.client.model.ModelMogus;
import nether_plus.client.model.ModelPordenfer;
import nether_plus.client.model.ModelRedMogus;
import nether_plus.client.model.ModelSalamander;
import nether_plus.client.model.ModelWight;
import nether_plus.client.render.RenderBlackSalamander;
import nether_plus.client.render.RenderFireSlime;
import nether_plus.client.render.RenderLavaTortoise;
import nether_plus.client.render.RenderMogus;
import nether_plus.client.render.RenderPordenfer;
import nether_plus.client.render.RenderRedMogus;
import nether_plus.client.render.RenderSalamander;
import nether_plus.client.render.RenderWight;
import nether_plus.common.entity.BlackSalamander;
import nether_plus.common.entity.FireSlime;
import nether_plus.common.entity.LavaTortoise;
import nether_plus.common.entity.Mogus;
import nether_plus.common.entity.Pordenfer;
import nether_plus.common.entity.RedMogus;
import nether_plus.common.entity.Salamander;
import nether_plus.common.entity.Wight;
import nether_plus.common.tileentity.TileEntityGrimwoodChest;
import nether_plus.common.tileentity.TileEntityGrimwoodChestRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class NPClientProxy extends NPCommonProxy
{
	
	public static int shouldRenderPass;


	@Override
	public void registerRender()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrimwoodChest.class, new TileEntityGrimwoodChestRenderer());
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
	     RenderingRegistry.registerEntityRenderingHandler(FireSlime.class, new RenderFireSlime(new ModelFireSlime(1), new ModelFireSlime(0), 0.5F));

	}
}