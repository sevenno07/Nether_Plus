package nether_plus.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import nether_plus.common.entity.Wight;

@SideOnly(Side.CLIENT)
public class RenderWight extends RenderLiving
{
	private ModelBase ModelWight = new ModelWight();
	
	public RenderWight(ModelWight par1ModelWight, float par2)
	{
		super(new ModelWight(), 0.5F);
	}
	
	public void renderWight(Wight entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderWight((Wight) par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderWight((Wight)par1Entity, par2, par4, par6, par8, par9);
    }

}