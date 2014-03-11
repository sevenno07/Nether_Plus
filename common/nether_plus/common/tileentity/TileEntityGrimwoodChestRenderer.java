package nether_plus.common.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nether_plus.client.IInventoryRender;
import nether_plus.common.block.GrimwoodChest;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.FMLLog;

public class TileEntityGrimwoodChestRenderer extends TileEntitySpecialRenderer implements IInventoryRender
{
	private static final ResourceLocation SINGLE = new ResourceLocation("nether_plus", "textures/items/GrimwoodChest.png");
	private static final ResourceLocation DOUBLE = new ResourceLocation("nether_plus", "textures/items/GrimwoodLargeChest.png");

	private ModelChest chestModel = new ModelChest();

	private ModelChest largeChestModel = new ModelLargeChest();

	public TileEntityGrimwoodChestRenderer()
	{
		this.func_147497_a(TileEntityRendererDispatcher.instance);
	}
	
	public void renderTileEntityGrimwoodChestAt(TileEntityGrimwoodChest te, double x, double y, double z, float tick)
	{
		int i;
		if(te != null)
		{
			if (!te.hasWorldObj())
			{
				i = 0;
			}
			else
			{
				Block block = te.getBlockType();
				i = te.getBlockMetadata();

				if (block instanceof GrimwoodChest && i == 0)
				{
					try
					{
						((GrimwoodChest) block).func_149954_e(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
					} catch (ClassCastException e)
					{
						FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest", te.xCoord, te.yCoord, te.zCoord);
					}
					i = te.getBlockMetadata();
				}
				te.checkForAdjacentChests();
			}

			if (te.adjacentChestZNeg == null && te.adjacentChestXNeg == null)
			{
				ModelChest modelchest;

				if (te.adjacentChestXPos == null && te.adjacentChestZPos == null)
				{
					modelchest = this.chestModel;
					this.bindTexture(SINGLE);
				}
				else
				{
					modelchest = this.largeChestModel;
					this.bindTexture(DOUBLE);
				}

				GL11.glPushMatrix();
				GL11.glEnable(GL12.GL_RESCALE_NORMAL);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
				GL11.glScalef(1.0F, -1.0F, -1.0F);
				GL11.glTranslatef(0.5F, 0.5F, 0.5F);
				short short1 = 0;

				if (i == 2)
				{
					short1 = 180;
				}

				if (i == 3)
				{
					short1 = 0;
				}

				if (i == 4)
				{
					short1 = 90;
				}

				if (i == 5)
				{
					short1 = -90;
				}

				if (i == 2 && te.adjacentChestXPos != null)
				{
					GL11.glTranslatef(1.0F, 0.0F, 0.0F);
				}

				if (i == 5 && te.adjacentChestZPos != null)
				{
					GL11.glTranslatef(0.0F, 0.0F, -1.0F);
				}

				GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
				float f1 = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * tick;
				float f2;

				if (te.adjacentChestZNeg != null)
				{
					f2 = te.adjacentChestZNeg.prevLidAngle + (te.adjacentChestZNeg.lidAngle - te.adjacentChestZNeg.prevLidAngle) * tick;

					if (f2 > f1)
					{
						f1 = f2;
					}
				}

				if (te.adjacentChestXNeg != null)
				{
					f2 = te.adjacentChestXNeg.prevLidAngle + (te.adjacentChestXNeg.lidAngle - te.adjacentChestXNeg.prevLidAngle) * tick;

					if (f2 > f1)
					{
						f1 = f2;
					}
				}

				f1 = 1.0F - f1;
				f1 = 1.0F - f1 * f1 * f1;
				modelchest.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);
				modelchest.renderAll();
				GL11.glDisable(GL12.GL_RESCALE_NORMAL);
				GL11.glPopMatrix();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tick)
	{
		this.renderTileEntityGrimwoodChestAt((TileEntityGrimwoodChest) te, x, y, z, tick);
	}

	@Override
	public void renderInventory(double x, double y, double z)
	{
		ModelChest modelchest;
		modelchest = this.chestModel;
		this.bindTexture(SINGLE);
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5F, y + 1.5F, z + 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		modelchest.renderAll();
		GL11.glPopMatrix();
	}
}