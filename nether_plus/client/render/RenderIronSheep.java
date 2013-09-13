package nether_plus.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import nether_plus.common.entity.IronSheep;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderIronSheep extends RenderLiving
{
    public RenderIronSheep(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.setRenderPassModel(par2ModelBase);
    }

    protected int setWoolColorAndRender(IronSheep par1IronSheep, int par2, float par3)
    {
        if (par2 == 0 && !par1IronSheep.getSheared())
        {
            this.loadTexture("/mods/nether_plus/textures/entity/ironsheep_fur.png");
            float f1 = 1.0F;
            int j = par1IronSheep.getFleeceColor();
            GL11.glColor3f(f1 * IronSheep.fleeceColorTable[j][0], f1 * IronSheep.fleeceColorTable[j][1], f1 * IronSheep.fleeceColorTable[j][2]);
            return 1;
        }
        else
        {
            return -1;
        }
    }

    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.setWoolColorAndRender((IronSheep)par1EntityLiving, par2, par3);
    }
}