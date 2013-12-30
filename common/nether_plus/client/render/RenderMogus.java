package nether_plus.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import nether_plus.client.model.ModelMogus;
import nether_plus.common.entity.Mogus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMogus extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nether_plus", "textures/entity/Mogus.png");
	
	private ModelBase ModelMogus = new ModelMogus();
	
	public RenderMogus(ModelMogus par1ModelMogus, float par2)
	{
		super(new ModelMogus(), 0.5F);
	}
	
	public void rendermogus(Mogus entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
		rendermogus((Mogus) par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
 		rendermogus((Mogus)par1Entity, par2, par4, par6, par8, par9);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTexture((Mogus)entity);
	}

	protected ResourceLocation getTexture(Mogus mogus)
	{
		return texture;
	}
}