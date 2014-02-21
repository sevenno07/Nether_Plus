package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import nether_plus.common.item.NPItemList;

public class CorruptedCharoiteOre extends Block
{
	public CorruptedCharoiteOre() 
	{
		super(Material.rock);
		this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
	}
	
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, par2Random, par1))
        {
            int j = par2Random.nextInt(par1 + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }
	
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
      return NPItemList.charoiteCrystal;
    }
	
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        	int var8 = 0;
        	if (this == NPBlockList.CorruptedCharoiteOre)
        	{
        		var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 15, 20);
        	}
        this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);  
        {}
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.getItemDropped(par5, par1World.rand, par7) != Item.getItemFromBlock(this))
        {
            int j1 = 0;

            if (this == NPBlockList.CorruptedCharoiteOre)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
        }
    }
}