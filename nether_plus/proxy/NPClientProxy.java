package nether_plus.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import nether_plus.client.ModelSalamander;
import nether_plus.client.RenderSalamander;
import nether_plus.common.entity.Salamander;

public class NPClientProxy extends NPCommonProxy
{
	
	@Override
	public void registerRender()
	{

	}
	
	public void registerRenderEntity()
	{
	     RenderingRegistry.registerEntityRenderingHandler(Salamander.class, new RenderSalamander(new ModelSalamander(), 0.5F));
	}
}
