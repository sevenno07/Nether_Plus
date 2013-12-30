package nether_plus.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import nether_plus.client.model.ModelPordenfer;
import nether_plus.common.entity.Pordenfer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPordenfer extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nether_plus", "textures/entity/pordenfer.png");
	
	private ModelBase ModelPordenfer = new ModelPordenfer();
	
	public RenderPordenfer(ModelPordenfer par1ModelPordenfer, float par2)
	{
		super(new ModelPordenfer(), 0.5F);
	}
	
	public void renderPordenfer(Pordenfer entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
		renderPordenfer((Pordenfer) par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
 		renderPordenfer((Pordenfer)par1Entity, par2, par4, par6, par8, par9);
    }
 	
 	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTexture((Pordenfer)entity);
	}

	protected ResourceLocation getTexture(Pordenfer pordenfer)
	{
		return texture;
	}
}