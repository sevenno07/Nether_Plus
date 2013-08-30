package nether_plus.common.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ShapedRecipesWorkbench implements IRecipe
{

	private int recipeWidth;
	private int recipeHeight;
	private ItemStack[] recipeItems;
	private ItemStack recipeOutput;
	public final int recipeOutputItemID;
	
	public ShapedRecipesWorkbench(int var5, int var6, ItemStack[] var15, ItemStack itemstack)
	{
		this.recipeOutputItemID = itemstack.itemID;
        this.recipeWidth = var5;
        this.recipeHeight = var6;
        this.recipeItems = var15;
        this.recipeOutput = itemstack;
	}

	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world)
	{
		for (int var3 = 0; var3 <=  3 - this.recipeWidth; ++var3)	 
        {
            for (int var4 = 0; var4 <= 3 - this.recipeHeight; ++var4)
            {
                if (this.checkMatch(inventorycrafting, var3, var4, true))
                {
                    return true;
                }
                if (this.checkMatch(inventorycrafting, var3, var4, false))
                {
                    return true;
                }
            }
        }
        return false;
    }

	private boolean checkMatch(InventoryCrafting par1InventoryCrafting, int par2, int par3, boolean par4)
    {
        for (int var5 = 0; var5 < 3; ++var5)
        {
            for (int var6 = 0; var6 < 3; ++var6)
            {
                int var7 = var5 - par2;
                int var8 = var6 - par3;
                ItemStack var9 = null;
                if (var7 >= 0 && var8 >= 0 && var7 < this.recipeWidth && var8 < this.recipeHeight)
                {
                    if (par4)
                    {
                        var9 = this.recipeItems[this.recipeWidth - var7 - 1 + var8 * this.recipeWidth];
                    }
                    else
                    {
                        var9 = this.recipeItems[var7 + var8 * this.recipeWidth];
                    }
                }
                ItemStack var10 = par1InventoryCrafting.getStackInRowAndColumn(var5, var6);
                if (var10 != null || var9 != null)
                {
                    if (var10 == null && var9 != null || var10 != null && var9 == null)
                    {
                        return false;
                    }
                    if (var9.itemID != var10.itemID)
                    {
                        return false;
                    }
                    if (var9.getItemDamage() != -1 && var9.getItemDamage() != var10.getItemDamage())
                    {
                        return false;
                    }
                }
            }
        }
 
        return true;
    }

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting)
	{
        return this.getRecipeOutput().copy();
	}

	@Override
	public int getRecipeSize()
	{
        return this.recipeWidth * this.recipeHeight;
	}

	@Override
	public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

}
