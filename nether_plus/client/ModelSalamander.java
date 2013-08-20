package nether_plus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSalamander extends ModelBase
{
	//fields
	ModelRenderer RfrontLeg;
	ModelRenderer LfrontLeg;
	ModelRenderer Ltooth;
	ModelRenderer Rtooth;
	ModelRenderer LowerJaw;
	ModelRenderer UpperJaw;
	ModelRenderer Body1;
	ModelRenderer Body2;
	ModelRenderer Tail;
	ModelRenderer RhindLeg;
	ModelRenderer LhindLeg;
	
	public ModelSalamander()
	 {
			float scale = 0F;
			RfrontLeg = new ModelRenderer(this, 0, 18);
			RfrontLeg.addBox(-1.5F, -1.5F, -1.5F, 3, 6, 3, scale);
			RfrontLeg.setRotationPoint(-6F, 19.5F, -4.5F);

			LfrontLeg = new ModelRenderer(this, 0, 18);
			LfrontLeg.addBox(-1.5F, -1.5F, -1.5F, 3, 6, 3, scale);
			LfrontLeg.setRotationPoint(6F, 19.5F, -4.5F);

			Ltooth = new ModelRenderer(this, 0, 27);
			Ltooth.addBox(1.5F, -6.5F, -1F, 1, 1, 1, scale);
			Ltooth.setRotationPoint(0F, 20.5F, -7.5F);
			Ltooth.rotateAngleX = 1.5708F;

			Rtooth = new ModelRenderer(this, 0, 27);
			Rtooth.addBox(-2.5F, -6.5F, -1F, 1, 1, 1, scale);
			Rtooth.setRotationPoint(0F, 20.5F, -7.5F);
			Rtooth.rotateAngleX = 1.5708F;

			LowerJaw = new ModelRenderer(this, 0, 9);
			LowerJaw.addBox(-3F, -7F, -2.5F, 6, 7, 2, scale);
			LowerJaw.setRotationPoint(0F, 20.5F, -7.5F);
			LowerJaw.rotateAngleX = 1.5708F;

			UpperJaw = new ModelRenderer(this, 0, 0);
			UpperJaw.addBox(-2.5F, -6.5F, 0F, 5, 6, 3, scale);
			UpperJaw.setRotationPoint(0F, 20.5F, -7.5F);
			UpperJaw.rotateAngleX = 1.5708F;

			Body1 = new ModelRenderer(this, 16, 0);
			Body1.addBox(-4.5F, -5F, -3F, 9, 10, 6, scale);
			Body1.setRotationPoint(0F, 20F, -3F);
			Body1.rotateAngleX = 1.5708F;

			Body2 = new ModelRenderer(this, 16, 16);
			Body2.addBox(-3.5F, -3.5F, -2.5F, 7, 7, 5, scale);
			Body2.setRotationPoint(0F, 20F, 5.5F);
			Body2.rotateAngleX = 1.5708F;

			Tail = new ModelRenderer(this, 46, 0);
			Tail.addBox(-2.5F, -3.5F, -1.5F, 5, 7, 3, scale);
			Tail.setRotationPoint(0F, 20F, 12.5F);
			Tail.rotateAngleX = 1.5708F;

			RhindLeg = new ModelRenderer(this, 0, 18);
			RhindLeg.addBox(-1.5F, -1.5F, -1.5F, 3, 6, 3, scale);
			RhindLeg.setRotationPoint(-5F, 19.5F, 5.5F);

			LhindLeg = new ModelRenderer(this, 0, 18);
			LhindLeg.addBox(-1.5F, -1.5F, -1.5F, 3, 6, 3, scale);
			LhindLeg.setRotationPoint(5F, 19.5F, 5.5F);


	}
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{

		super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
		RfrontLeg.render(f5);
		LfrontLeg.render(f5);
		Ltooth.renderWithRotation(f5);
		Rtooth.renderWithRotation(f5);
		LowerJaw.renderWithRotation(f5);
		UpperJaw.renderWithRotation(f5);
		Body1.renderWithRotation(f5);
		Body2.renderWithRotation(f5);
		Tail.renderWithRotation(f5);
		RhindLeg.render(f5);
		LhindLeg.render(f5);
	}
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{

		RfrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		LfrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
		RhindLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
		LhindLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	}
	
}
