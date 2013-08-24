package nether_plus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelPordenfer extends ModelBase
{
	public ModelRenderer Leg3;
	public ModelRenderer Leg2;
	public ModelRenderer Leg1;
	public ModelRenderer Leg6;
	public ModelRenderer Leg5;
	public ModelRenderer Leg4;
	public ModelRenderer Tail;
	public ModelRenderer Body;
	public ModelRenderer Mouth;
	
	public 	ModelPordenfer()
	{
	    float scale = 1F;
		Leg3 = new ModelRenderer(this, 10, 27);
		Leg3.addBox(-0.5F, -0.5F, -0.5F, 4, 4, 1, scale);
		Leg3.setRotationPoint(4F, 19F, 3F);
		
		Leg2 = new ModelRenderer(this, 10, 27);
		Leg2.addBox(-0.5F, -0.5F, -0.5F, 4, 4, 1, scale);
		Leg2.setRotationPoint(4F, 19F, 0F);
		
		Leg1 = new ModelRenderer(this, 10, 27);
		Leg1.addBox(-0.5F, -0.5F, -0.5F, 4, 4, 1, scale);
		Leg1.setRotationPoint(4F, 19F, -3F);
		
		Leg6 = new ModelRenderer(this, 0, 27);
		Leg6.addBox(-3.5F, -0.5F, -0.5F, 4, 4, 1, scale);
		Leg6.setRotationPoint(-4F, 19F, 3F);
		
		Leg5 = new ModelRenderer(this, 0, 27);
		Leg5.addBox(-3.5F, -0.5F, -0.5F, 4, 4, 1, scale);
		Leg5.setRotationPoint(-4F, 19F, 0F);
		
		Leg4 = new ModelRenderer(this, 0, 27);
		Leg4.addBox(-3.5F, -0.5F, -0.5F, 4, 4, 1, scale);
		Leg4.setRotationPoint(-4F, 19F, -3F);
		
		Tail = new ModelRenderer(this, 0, 16);
		Tail.addBox(-2F, -1F, -0.5F, 4, 2, 6, scale);
		Tail.setRotationPoint(0F, 19F, 5.5F);
		
		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(-4F, -2F, -6F, 8, 4, 12, scale);
		Body.setRotationPoint(0F, 19F, 0F);
		
		Mouth = new ModelRenderer(this, 0, 24);
		Mouth.addBox(-2.5F, -1F, -0.5F, 5, 2, 1, scale);
		Mouth.setRotationPoint(0F, 19F, -6F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Leg3.render(f5);
		Leg2.render(f5);
		Leg1.render(f5);
		Leg6.render(f5);
		Leg5.render(f5);
		Leg4.render(f5);
		Tail.render(f5);
		Body.render(f5);
		Mouth.render(f5);
		
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
		Leg3.rotateAngleY = 0.2617994F;
		Leg2.rotateAngleY = 0.2617994F;
		Leg1.rotateAngleY = 0.2617994F;
		Leg6.rotateAngleY = -0.2617994F;
		Leg5.rotateAngleY = -0.2617994F;
		Leg4.rotateAngleY = -0.2617994F;
		Tail.rotateAngleX = 0.6108652F;
		
		Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		Leg6.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
		Leg5.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
		Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;	
	}
}