package nether_plus.common.block;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFour extends GuiContainer
{
	private static final ResourceLocation field_110410_t = new ResourceLocation("MOD_ID:textures/gui/container/guiFour.png");
	private TileEntityFour furnaceInventory;
	
	 public GuiFour(InventoryPlayer par1InventoryPlayer, TileEntityFour par2TileEntityFour)
	 {
	 super(new ContainerFurnace(par1InventoryPlayer, par2TileEntityFour));
	 this.furnaceInventory = par2TileEntityFour;
	 }
	 
	 protected void drawGuiContainerForegroundLayer(int par1, int par2)
	 {
		 String s = this.furnaceInventory.isInvNameLocalized() ? this.furnaceInventory.getInvName() : I18n.func_135053_a(this.furnaceInventory.getInvName());
		 this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		 this.fontRenderer.drawString(I18n.func_135053_a("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	 }

	 protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	 {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		 this.mc.func_110434_K().func_110577_a(field_110410_t);
		 int k = (this.width - this.xSize) / 2;
		 int l = (this.height - this.ySize) / 2;
		 this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		 int i1;

		 if (this.furnaceInventory.isBurning())
		 {
			 i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
			 this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		 }

		 i1 = this.furnaceInventory.getCookProgressScaled(24);
		 this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	 }
}