package nether_plus.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import nether_plus.client.model.ModelRedMogus;
import nether_plus.common.entity.RedMogus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRedMogus extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nether_plus", "textures/entity/RedMogus.png");

	private ModelBase ModelRedMogus = new ModelRedMogus();
	
	public RenderRedMogus(ModelRedMogus modelRedMogus, float par2)
	{
		super(new ModelRedMogus(), 0.5F);
	}
	
	public void renderredmogus(RedMogus entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
		renderredmogus((RedMogus) par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
 		renderredmogus((RedMogus)par1Entity, par2, par4, par6, par8, par9);
    }
 	
 	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTexture((RedMogus)entity);
	}

	protected ResourceLocation getTexture(RedMogus redMogus)
	{
		return texture;
	}
}