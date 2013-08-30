package nether_plus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelRedMogus extends ModelBase
{
	//fields
	
    public ModelRenderer cap;
    public ModelRenderer top_cap;
    public ModelRenderer body;
    public ModelRenderer left_leg;
    public ModelRenderer right_leg;
    public ModelRenderer right_arm;
    public ModelRenderer left_arm;
  
    public ModelRedMogus()
    {
	    float scale = 0F;
	    
    	cap = new ModelRenderer(this, 0, 0);
    	cap.addBox(-2F, 0F, -2F, 5, 1, 5);
    	cap.setRotationPoint(-1F, 18F, 0F);

    	top_cap = new ModelRenderer(this, 20, 0);
    	top_cap.addBox(-1F, -1F, -1F, 3, 1, 3);
    	top_cap.setRotationPoint(-1F, 18F, 0F);

    	body = new ModelRenderer(this, 0, 6);
    	body.addBox(-2F, 1F, -1F, 3, 4, 3);
    	body.setRotationPoint(0F, 18F, 0F);

    	left_leg = new ModelRenderer(this, 12, 11);
    	left_leg.addBox(0F, 0F, 0F, 1, 1, 1);
    	left_leg.setRotationPoint(0F, 23F, 0F);

    	right_leg = new ModelRenderer(this, 12, 11);
    	right_leg.addBox(-1F, 0F, 0F, 1, 1, 1);
    	right_leg.setRotationPoint(-1F, 23F, 0F);

    	right_arm = new ModelRenderer(this, 16, 10);
    	right_arm.addBox(-1F, 0F, 0F, 1, 2, 1);
    	right_arm.setRotationPoint(-2F, 20F, 0F);

    	left_arm = new ModelRenderer(this, 16, 10);
    	left_arm.addBox(0F, 0F, 0F, 1, 2, 1);
    	left_arm.setRotationPoint(1F, 20F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5);
    	cap.render(f5);
    	top_cap.render(f5);
    	body.render(f5);
    	left_leg.render(f5);
    	right_leg.render(f5);
    	right_arm.render(f5);
    	left_arm.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
    	right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    	left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
    	right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
    	left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }
}