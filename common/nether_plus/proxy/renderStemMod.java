package nether_plus.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import nether_plus.common.block.ChiliC;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class renderStemMod implements ISimpleBlockRenderingHandler {

    public IBlockAccess blockAccess;
    public double renderMaxY;
    public IIcon overrideBlockTexture;
    
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
		ChiliC blockstem = (ChiliC)world;
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(blockstem.getMixedBrightnessForBlock(this.blockAccess, x, y, z));
        int l = blockstem.colorMultiplier(this.blockAccess, x, y, z);
        float f = (float)(l >> 16 & 255) / 255.0F;
        float f1 = (float)(l >> 8 & 255) / 255.0F;
        float f2 = (float)(l & 255) / 255.0F;

        if (EntityRenderer.anaglyphEnable)
        {
            float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
            float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }

        tessellator.setColorOpaque_F(f, f1, f2);
        blockstem.setBlockBoundsBasedOnState(this.blockAccess, x, y, z);
        int i1 = blockstem.getState(this.blockAccess, x, y, z);

        if (i1 < 0)
        {
            this.renderBlockStemSmall(blockstem, this.blockAccess.getBlockMetadata(x, y, z), this.renderMaxY, (double)x, (double)((float)y - 0.0625F), (double)z);
        }
        else
        {
            this.renderBlockStemSmall(blockstem, this.blockAccess.getBlockMetadata(x, y, z), 0.5D, (double)x, (double)((float)y - 0.0625F), (double)z);
            this.renderBlockStemBig(blockstem, this.blockAccess.getBlockMetadata(x, y, z), i1, this.renderMaxY, (double)x, (double)((float)y - 0.0625F), (double)z);
        }

        return true;
    }

	private void renderBlockStemBig(ChiliC blockstem, int blockMetadata, int i1, double renderMaxY2, double x, double d, double z)
    {
        Tessellator tessellator = Tessellator.instance;
        IIcon iicon = blockstem.getStemIcon();

        if (this.hasOverrideBlockTexture())
        {
            iicon = this.overrideBlockTexture;
        }

        double d4 = (double)iicon.getMinU();
        double d5 = (double)iicon.getMinV();
        double d6 = (double)iicon.getMaxU();
        double d7 = (double)iicon.getMaxV();
        double d8 = x + 0.5D - 0.5D;
        double d9 = x + 0.5D + 0.5D;
        double d10 = z + 0.5D - 0.5D;
        double d11 = z + 0.5D + 0.5D;
        double d12 = x + 0.5D;
        double d13 = z + 0.5D;

        if ((i1 + 1) / 2 % 2 == 1)
        {
            double d14 = d6;
            d6 = d4;
            d4 = d14;
        }

        if (i1 < 2)
        {
            tessellator.addVertexWithUV(d8, d + renderMaxY2, d13, d4, d5);
            tessellator.addVertexWithUV(d8, d + 0.0D, d13, d4, d7);
            tessellator.addVertexWithUV(d9, d + 0.0D, d13, d6, d7);
            tessellator.addVertexWithUV(d9, d + renderMaxY2, d13, d6, d5);
            tessellator.addVertexWithUV(d9, d + renderMaxY2, d13, d6, d5);
            tessellator.addVertexWithUV(d9, d + 0.0D, d13, d6, d7);
            tessellator.addVertexWithUV(d8, d + 0.0D, d13, d4, d7);
            tessellator.addVertexWithUV(d8, d + renderMaxY2, d13, d4, d5);
        }
        else
        {
            tessellator.addVertexWithUV(d12, d + renderMaxY2, d11, d4, d5);
            tessellator.addVertexWithUV(d12, d + 0.0D, d11, d4, d7);
            tessellator.addVertexWithUV(d12, d + 0.0D, d10, d6, d7);
            tessellator.addVertexWithUV(d12, d + renderMaxY2, d10, d6, d5);
            tessellator.addVertexWithUV(d12, d + renderMaxY2, d10, d6, d5);
            tessellator.addVertexWithUV(d12, d + 0.0D, d10, d6, d7);
            tessellator.addVertexWithUV(d12, d + 0.0D, d11, d4, d7);
            tessellator.addVertexWithUV(d12, d + renderMaxY2, d11, d4, d5);
        }
    }

	private void renderBlockStemSmall(ChiliC blockstem, int blockMetadata, double d, double x, double e, double z)
    {
        Tessellator tessellator = Tessellator.instance;
        IIcon iicon = this.getBlockIconFromSideAndMetadata(blockstem, 0, blockMetadata);

        if (this.hasOverrideBlockTexture())
        {
            iicon = this.overrideBlockTexture;
        }

        double d4 = (double)iicon.getMinU();
        double d5 = (double)iicon.getMinV();
        double d6 = (double)iicon.getMaxU();
        double d7 = (double)iicon.getInterpolatedV(d * 16.0D);
        double d8 = x + 0.5D - 0.44999998807907104D;
        double d9 = x + 0.5D + 0.44999998807907104D;
        double d10 = z + 0.5D - 0.44999998807907104D;
        double d11 = z + 0.5D + 0.44999998807907104D;
        tessellator.addVertexWithUV(d8, e + d, d10, d4, d5);
        tessellator.addVertexWithUV(d8, e + 0.0D, d10, d4, d7);
        tessellator.addVertexWithUV(d9, e + 0.0D, d11, d6, d7);
        tessellator.addVertexWithUV(d9, e + d, d11, d6, d5);
        tessellator.addVertexWithUV(d9, e + d, d11, d6, d5);
        tessellator.addVertexWithUV(d9, e + 0.0D, d11, d6, d7);
        tessellator.addVertexWithUV(d8, e + 0.0D, d10, d4, d7);
        tessellator.addVertexWithUV(d8, e + d, d10, d4, d5);
        tessellator.addVertexWithUV(d8, e + d, d11, d4, d5);
        tessellator.addVertexWithUV(d8, e + 0.0D, d11, d4, d7);
        tessellator.addVertexWithUV(d9, e + 0.0D, d10, d6, d7);
        tessellator.addVertexWithUV(d9, e + d, d10, d6, d5);
        tessellator.addVertexWithUV(d9, e + d, d10, d6, d5);
        tessellator.addVertexWithUV(d9, e + 0.0D, d10, d6, d7);
        tessellator.addVertexWithUV(d8, e + 0.0D, d11, d4, d7);
        tessellator.addVertexWithUV(d8, e + d, d11, d4, d5);
    }

	private IIcon getBlockIconFromSideAndMetadata(ChiliC blockstem, int i, int blockMetadata)
	{
        return this.getIconSafe(blockstem.getIcon(i, blockMetadata));
	}

	private IIcon getIconSafe(IIcon icon)
    {
        if (icon == null)
        {
        	icon = ((TextureMap)Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
        }
        return (IIcon)icon;
    }
	
    public boolean hasOverrideBlockTexture()
    {
        return this.overrideBlockTexture != null;
    }

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return NPClientProxy.renderStemModID;
	}
}