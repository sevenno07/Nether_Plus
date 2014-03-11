package nether_plus.common.block.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryGrimwoodLargeChest implements IInventory
{
    private String name;

    private IInventory upperChest;

    private IInventory lowerChest;

    public InventoryGrimwoodLargeChest(String string, IInventory inventory, IInventory inventory2)
    {
        this.name = string;

        if (inventory == null)
        {
            inventory = inventory2;
        }

        if (inventory2 == null)
        {
            inventory2 = inventory;
        }

        this.upperChest = inventory;
        this.lowerChest = inventory2;
    }

    public int getSizeInventory()
    {
        return this.upperChest.getSizeInventory() + this.lowerChest.getSizeInventory();
    }

    public boolean isPartOfLargeChest(IInventory par1IInventory)
    {
        return this.upperChest == par1IInventory || this.lowerChest == par1IInventory;
    }

    public String getInventoryName()
    {
        return this.upperChest.hasCustomInventoryName() ? this.upperChest.getInventoryName() : (this.lowerChest.hasCustomInventoryName() ? this.lowerChest.getInventoryName() : this.name);
    }

    public boolean hasCustomInventoryName()
    {
        return this.upperChest.hasCustomInventoryName() || this.lowerChest.hasCustomInventoryName();
    }

    public ItemStack getStackInSlot(int par1)
    {
        return par1 >= this.upperChest.getSizeInventory() ? this.lowerChest.getStackInSlot(par1 - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlot(par1);
    }

    public ItemStack decrStackSize(int par1, int par2)
    {
        return par1 >= this.upperChest.getSizeInventory() ? this.lowerChest.decrStackSize(par1 - this.upperChest.getSizeInventory(), par2) : this.upperChest.decrStackSize(par1, par2);
    }

    public ItemStack getStackInSlotOnClosing(int par1)
    {
        return par1 >= this.upperChest.getSizeInventory() ? this.lowerChest.getStackInSlotOnClosing(par1 - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlotOnClosing(par1);
    }

    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        if (par1 >= this.upperChest.getSizeInventory())
        {
            this.lowerChest.setInventorySlotContents(par1 - this.upperChest.getSizeInventory(), par2ItemStack);
        }
        else
        {
            this.upperChest.setInventorySlotContents(par1, par2ItemStack);
        }
    }

    public int getInventoryStackLimit()
    {
        return this.upperChest.getInventoryStackLimit();
    }

    public void markDirty()
    {
        this.upperChest.markDirty();
        this.lowerChest.markDirty();
    }

    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.upperChest.isUseableByPlayer(player) && this.lowerChest.isUseableByPlayer(player);
    }

    public void openInventory()
    {
        this.upperChest.openInventory();
        this.lowerChest.openInventory();
    }

    public void closeInventory()
    {
        this.upperChest.closeInventory();
        this.lowerChest.closeInventory();
    }

    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return true;
    }
}