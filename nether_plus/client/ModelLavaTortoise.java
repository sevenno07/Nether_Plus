package nether_plus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLavaTortoise extends ModelBase
{
	  ModelRenderer Bottem;
	  ModelRenderer Top;
	  ModelRenderer Body;
	  ModelRenderer Eye1;
	  ModelRenderer Eye2;
	  ModelRenderer Leg1;
	  ModelRenderer Leg2;
	  ModelRenderer Leg3;
	  ModelRenderer Leg4;
	  ModelRenderer Neck;
	  ModelRenderer Head;
	  ModelRenderer Tall;
  
  public ModelLavaTortoise()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Bottem = new ModelRenderer(this, 0, 1);
      Bottem.addBox(0F, 0F, 0F, 24, 3, 24);
      Bottem.setRotationPoint(-12F, 15F, -12F);
      Bottem.setTextureSize(128, 64);
	  Bottem.mirror = true;
      setRotation(Bottem, 0F, 0F, 0F);    
      Top = new ModelRenderer(this, 0, 1);
      Top.addBox(0F, 0F, 0F, 24, 3, 24);
      Top.setRotationPoint(-12F, 0F, -12F);
      Top.setTextureSize(128, 64);
	  Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);    
      Body = new ModelRenderer(this, 0, 25);
      Body.addBox(-1F, 0F, 0F, 28, 12, 27);
      Body.setRotationPoint(-13F, 3F, -14F);
      Body.setTextureSize(128, 64);
	  Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);    
      Eye1 = new ModelRenderer(this, 6, 13);
      Eye1.addBox(0F, 0F, 0F, 1, 3, 3);
      Eye1.setRotationPoint(6F, 10F, -28F);
      Eye1.setTextureSize(128, 64);
	  Eye1.mirror = true;
      setRotation(Eye1, 0F, 0F, 0F);    
      Eye2 = new ModelRenderer(this, 6, 13);
      Eye2.addBox(0F, 0F, 0F, 1, 3, 3);
      Eye2.setRotationPoint(-6F, 10F, -28F);
      Eye2.setTextureSize(128, 64);
	  Eye2.mirror = true;
      setRotation(Eye2, 0F, 0F, 0F);    
      Leg1 = new ModelRenderer(this, 1, 35);
      Leg1.addBox(-2F, 0F, -2F, 6, 10, 6);
      Leg1.setRotationPoint(14F, 14F, 13F);
      Leg1.setTextureSize(128, 64);
	  Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);    
      Leg2 = new ModelRenderer(this, 1, 35);
      Leg2.addBox(-4F, 0F, -2F, 6, 10, 6);
      Leg2.setRotationPoint(-14F, 14F, 13F);
      Leg2.setTextureSize(128, 64);
	  Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);    
      Leg3 = new ModelRenderer(this, 1, 35);
      Leg3.addBox(-2F, 0F, -4F, 6, 10, 6);
      Leg3.setRotationPoint(14F, 14F, -14F);
      Leg3.setTextureSize(128, 64);
	  Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);    
      Leg4 = new ModelRenderer(this, 1, 35);
      Leg4.addBox(-4F, 0F, -4F, 6, 10, 6);
      Leg4.setRotationPoint(-14F, 14F, -14F);
      Leg4.setTextureSize(128, 64);
	  Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);    
      Neck = new ModelRenderer(this, 90, 2);
      Neck.addBox(0F, 0F, 0F, 8, 3, 11);
      Neck.setRotationPoint(-4F, 15F, -23F);
      Neck.setTextureSize(128, 64);
	  Neck.mirror = true;
      setRotation(Neck, 0F, 0F, 0F);    
      Head = new ModelRenderer(this, 83, 30);
      Head.addBox(-5F, -9F, -7F, 11, 11, 11);
      Head.setRotationPoint(0F, 17F, -23F);
      Head.setTextureSize(128, 64);
	  Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);    
      Tall = new ModelRenderer(this, 72, 9);
      Tall.addBox(-2F, -2F, 0F, 4, 4, 10);
      Tall.setRotationPoint(0F, 13F, 11F);
      Tall.setTextureSize(128, 64);
	  Tall.mirror = true;
      setRotation(Tall, 0F, 0F, 0F);    
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
	  Bottem.render(f5);
	  Top.render(f5);
	  Body.render(f5);
	  Eye1.render(f5);
	  Eye2.render(f5);
	  Leg1.render(f5);
	  Leg2.render(f5);
	  Leg3.render(f5);
	  Leg4.render(f5);
	  Neck.render(f5);
	  Head.render(f5);
	  Tall.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
	  Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	  Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
	  Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
	  Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}