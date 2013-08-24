package nether_plus.proxy;

import nether_plus.client.ModelLavaTortoise;
import nether_plus.client.ModelMogus;
import nether_plus.client.ModelRedMogus;
import nether_plus.client.ModelSalamander;
import nether_plus.client.ModelWight;
import nether_plus.client.RenderLavaTortoise;
import nether_plus.client.RenderMogus;
import nether_plus.client.RenderRedMogus;
import nether_plus.client.RenderSalamander;
import nether_plus.client.RenderWight;
import nether_plus.common.entity.LavaTortoise;
import nether_plus.common.entity.Mogus;
import nether_plus.common.entity.RedMogus;
import nether_plus.common.entity.Salamander;
import nether_plus.common.entity.Wight;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class NPClientProxy extends NPCommonProxy
{
	
	@Override
	public void registerRender()
	{

	}
	
	public void registerRenderEntity()
	{
	     RenderingRegistry.registerEntityRenderingHandler(Salamander.class, new RenderSalamander(new ModelSalamander(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(Wight.class, new RenderWight(new ModelWight(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(Mogus.class, new RenderMogus(new ModelMogus(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(RedMogus.class, new RenderRedMogus(new ModelRedMogus(), 0.5F));
	     RenderingRegistry.registerEntityRenderingHandler(LavaTortoise.class, new RenderLavaTortoise(new ModelLavaTortoise(), 0.5F));

	}
}