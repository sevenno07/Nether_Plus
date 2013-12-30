package nether_plus.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import nether_plus.client.model.ModelSalamander;
import nether_plus.common.entity.Salamander;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSalamander extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nether_plus", "textures/entity/salamander_orange.png");
	
	private ModelBase ModelSalamander = new ModelSalamander();
	
	public RenderSalamander(ModelSalamander par1ModelSalamander, float par2)
	{
		super(new ModelSalamander(), 0.5F);
	}
	
	public void renderSalamander(Salamander entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderSalamander((Salamander) par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderSalamander((Salamander)par1Entity, par2, par4, par6, par8, par9);
    }
 	
 	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTexture((Salamander)entity);
	}

	protected ResourceLocation getTexture(Salamander salamander)
	{
		return texture;
	}
}