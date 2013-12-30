package nether_plus.common.recipe;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;

public class RecipeSorterWorkbench implements Comparator
{
	final RecipesWorkbench recipesWorkbench;
	
	RecipeSorterWorkbench(RecipesWorkbench crafting)
	{
         this.recipesWorkbench = crafting;
	}
	
	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
	{
 
         return par1IRecipe instanceof ShapelessRecipes && par2IRecipe instanceof ShapedRecipesWorkbench ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipesWorkbench? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
 
	}
	
	@Override
	public int compare(Object arg0, Object arg1)
	{
        return this.compareRecipes((IRecipe)arg0, (IRecipe)arg1);
	}

}
