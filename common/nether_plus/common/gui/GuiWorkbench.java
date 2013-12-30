package nether_plus.common.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import nether_plus.common.block.container.ContainerWorkbench;
import nether_plus.common.tileentity.TileEntityGrimwoodWorkbench;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiWorkbench extends GuiContainer
{
    private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");

	private TileEntityGrimwoodWorkbench WorkbenchInventory;

	public GuiWorkbench(InventoryPlayer player_inventory, TileEntityGrimwoodWorkbench tileEntityGrimwoodWorkbench, World world)
	{
		super(new ContainerWorkbench(player_inventory, tileEntityGrimwoodWorkbench, world));
		this.WorkbenchInventory = tileEntityGrimwoodWorkbench;
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	 {
		 String s = this.WorkbenchInventory.isInvNameLocalized() ? this.WorkbenchInventory.getInvName() : StatCollector.translateToLocal(this.WorkbenchInventory.getInvName());
		 this.fontRenderer.drawString(s, 28, 6, 4210752);
		 this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	 }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(craftingTableGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}