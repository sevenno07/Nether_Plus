package nether_plus.common.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nether_plus.common.block.GrimwoodChest;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.FMLLog;

public class TileEntityGrimwoodChestRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation SINGLE = new ResourceLocation("nether_plus", "textures/items/GrimwoodChest.png");
    private static final ResourceLocation DOUBLE = new ResourceLocation("nether_plus", "textures/items/GrimwoodLargeChest.png");
	
    private ModelChest chestModel = new ModelChest();

    private ModelChest largeChestModel = new ModelLargeChest();
    
    public void renderTileEntityGrimwoodChestAt(TileEntityGrimwoodChest par1TileEntityGrimwoodChest, double par2, double par4, double par6, float par8)
    {
    int i;

    if (!par1TileEntityGrimwoodChest.hasWorldObj())
    {
        i = 0;
    }
    else
    {
        Block block = par1TileEntityGrimwoodChest.getBlockType();
        i = par1TileEntityGrimwoodChest.getBlockMetadata();

        if (block instanceof GrimwoodChest && i == 0)
        {
            try
            {
                ((GrimwoodChest)block).unifyAdjacentChests(par1TileEntityGrimwoodChest.getWorldObj(), par1TileEntityGrimwoodChest.xCoord, par1TileEntityGrimwoodChest.yCoord, par1TileEntityGrimwoodChest.zCoord);
            }
            catch (ClassCastException e)
            {
                FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest",
                        par1TileEntityGrimwoodChest.xCoord, par1TileEntityGrimwoodChest.yCoord, par1TileEntityGrimwoodChest.zCoord);
            }
            i = par1TileEntityGrimwoodChest.getBlockMetadata();
        }

        par1TileEntityGrimwoodChest.checkForAdjacentChests();
    }

    if (par1TileEntityGrimwoodChest.adjacentChestZNeg == null && par1TileEntityGrimwoodChest.adjacentChestXNeg == null)
    {
        ModelChest modelchest;

        if (par1TileEntityGrimwoodChest.adjacentChestXPos == null && par1TileEntityGrimwoodChest.adjacentChestZPosition == null)
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
        GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
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

        if (i == 2 && par1TileEntityGrimwoodChest.adjacentChestXPos != null)
        {
            GL11.glTranslatef(1.0F, 0.0F, 0.0F);
        }

        if (i == 5 && par1TileEntityGrimwoodChest.adjacentChestZPosition != null)
        {
            GL11.glTranslatef(0.0F, 0.0F, -1.0F);
        }

        GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        float f1 = par1TileEntityGrimwoodChest.prevLidAngle + (par1TileEntityGrimwoodChest.lidAngle - par1TileEntityGrimwoodChest.prevLidAngle) * par8;
        float f2;

        if (par1TileEntityGrimwoodChest.adjacentChestZNeg != null)
        {
            f2 = par1TileEntityGrimwoodChest.adjacentChestZNeg.prevLidAngle + (par1TileEntityGrimwoodChest.adjacentChestZNeg.lidAngle - par1TileEntityGrimwoodChest.adjacentChestZNeg.prevLidAngle) * par8;

            if (f2 > f1)
            {
                f1 = f2;
            }
        }

        if (par1TileEntityGrimwoodChest.adjacentChestXNeg != null)
        {
            f2 = par1TileEntityGrimwoodChest.adjacentChestXNeg.prevLidAngle + (par1TileEntityGrimwoodChest.adjacentChestXNeg.lidAngle - par1TileEntityGrimwoodChest.adjacentChestXNeg.prevLidAngle) * par8;

            if (f2 > f1)
            {
                f1 = f2;
            }
        }

        f1 = 1.0F - f1;
        f1 = 1.0F - f1 * f1 * f1;
        modelchest.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
        modelchest.renderAll();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
	@Override
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityGrimwoodChestAt((TileEntityGrimwoodChest)par1TileEntity, par2, par4, par6, par8);
    }

}
