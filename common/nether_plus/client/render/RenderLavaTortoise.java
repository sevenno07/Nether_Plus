package nether_plus.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import nether_plus.client.model.ModelLavaTortoise;
import nether_plus.common.entity.LavaTortoise;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLavaTortoise extends RenderLiving
{
	private ModelBase ModelLavaTortoise = new ModelLavaTortoise();
	
	public RenderLavaTortoise(ModelLavaTortoise par1ModelLavaTortoise, float par2)
	{
		super(new ModelLavaTortoise(), 0.5F);
	}
	
	public void renderLavaTortoise(LavaTortoise entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
		renderLavaTortoise((LavaTortoise) par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
 		renderLavaTortoise((LavaTortoise)par1Entity, par2, par4, par6, par8, par9);
    }

}