package nether_plus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import nether_plus.common.entity.FireSlime;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFireSlime extends RenderLiving
{
    private ModelBase scaleAmount;

    public RenderFireSlime(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.scaleAmount = par2ModelBase;
    }
 	
    protected int shouldFireSlimeRenderPass(FireSlime par1FireSlime, int par2, float par3)
    {
        if (par1FireSlime.isInvisible())
        {
            return 0;
        }
        else if (par2 == 0)
        {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
        }
        else
        {
            if (par2 == 1)
            {
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            return -1;
        }
    }

    protected void scaleFireSlime(FireSlime FireSlime, float par2)
    {
        float f1 = (float)FireSlime.getFireSlimeSize();
        float f2 = (FireSlime.field_70812_c + (FireSlime.field_70811_b - FireSlime.field_70812_c) * par2) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    protected void preRenderCallback(EntityLiving entityLiving, float par2)
    {
        this.scaleFireSlime((FireSlime)entityLiving, par2);
    }

    protected int shouldRenderPass(EntityLiving entityLiving, int par2, float par3)
    {
        return this.shouldFireSlimeRenderPass((FireSlime)entityLiving, par2, par3);
    }

}
