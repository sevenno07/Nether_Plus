package nether_plus.client;

/*import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelFireSlime extends ModelBase
{
    ModelRenderer slimeBodies;

    ModelRenderer slimeRightEye;

    ModelRenderer slimeLeftEye;

    ModelRenderer slimeMouth;

    public ModelFireSlime(int par1)
    {
        this.slimeBodies = new ModelRenderer(this, 0, par1);
        this.slimeBodies.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8);

        if (par1 > 0)
        {
            this.slimeBodies = new ModelRenderer(this, 0, par1);
            this.slimeBodies.addBox(-3.0F, 17.0F, -3.0F, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer(this, 32, 0);
            this.slimeRightEye.addBox(-3.25F, 18.0F, -3.5F, 2, 2, 2);
            this.slimeLeftEye = new ModelRenderer(this, 32, 4);
            this.slimeLeftEye.addBox(1.25F, 18.0F, -3.5F, 2, 2, 2);
            this.slimeMouth = new ModelRenderer(this, 32, 8);
            this.slimeMouth.addBox(0.0F, 21.0F, -3.5F, 1, 1, 1);
        }
    }
    
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.slimeBodies.render(par7);

        if (this.slimeRightEye != null)
        {
            this.slimeRightEye.render(par7);
            this.slimeLeftEye.render(par7);
            this.slimeMouth.render(par7);
        }
    }
}*/

/**import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelFireSlime extends ModelBase
{
    ModelRenderer slimeBodies;
    ModelRenderer slimeRightEye;
    ModelRenderer slimeLeftEye;
    ModelRenderer slimeMouth;
    
    public ModelFireSlime(int i)
    {
    	this.slimeBodies = new ModelRenderer(this, 0, 0);
    	this.slimeBodies.addBox(-4F, 16F, -4F, 8, 8, 8);
    	
        if (i > 0)
        {
            this.slimeBodies = null;
        	
        	this.slimeBodies = new ModelRenderer(this, 0, 16);
        	this.slimeBodies.addBox(-3F, 17F, -3F, 6, 6, 6);
        	this.slimeRightEye = new ModelRenderer(this, 32, 0);
        	this.slimeRightEye.addBox(-3.25F, 18F, -3.5F, 2, 2, 2);
        	this.slimeLeftEye = new ModelRenderer(this, 32, 4);
        	this.slimeLeftEye.addBox(1.25F, 18F, -3.5F, 2, 2, 2);
        	this.slimeMouth = new ModelRenderer(this, 32, 8);
        	this.slimeMouth.addBox(0.0F, 21F, -3.5F, 1, 1, 1);
        }
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.slimeBodies.render(f5);
        if(slimeRightEye != null)
        {
        	this.slimeRightEye.render(f5);
        	this.slimeLeftEye.render(f5);
        	this.slimeMouth.render(f5);
        }
    }
}*/