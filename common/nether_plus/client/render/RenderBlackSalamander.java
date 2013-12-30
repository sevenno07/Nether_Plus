package nether_plus.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import nether_plus.client.model.ModelBlackSalamander;
import nether_plus.common.entity.BlackSalamander;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlackSalamander extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nether_plus", "textures/entity/salamander_black.png");
	
	private ModelBase ModelBlackSalamander = new ModelBlackSalamander();

	public RenderBlackSalamander(ModelBlackSalamander par1ModelBlackSalamander, float par2)
	{
		super(new ModelBlackSalamander(), 0.5F);
	}
	
	public void renderBlackSalamander(BlackSalamander entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderBlackSalamander((BlackSalamander) par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderBlackSalamander((BlackSalamander)par1Entity, par2, par4, par6, par8, par9);
    }
 	
 	protected ResourceLocation getTextures(BlackSalamander blackSalamander)
	{
		return texture;
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTextures((BlackSalamander)entity);
	}
}