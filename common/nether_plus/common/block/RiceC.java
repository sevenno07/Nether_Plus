package nether_plus.common.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RiceC extends Crops
{
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
	public RiceC()
	{
		super();
	}
	
    protected boolean canPlaceBlockOn(Block Par1)
    {
        return Par1 == NPBlockList.Nether_Farm;
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        if (par2 < 7)
        {
            if (par2 == 6)
            {
                par2 = 5;
            }

            return this.iconArray[par2 >> 1];
        }
        else
        {
            return this.iconArray[3];
        }
    }

    protected Item getSeedItem()
    {
        return NPItemList.Rice;
    }

    protected Item getCropItem()
    {
        return NPItemList.Rice;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.iconArray = new IIcon[4];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("nether_plus:rices_" + i);
        }
    }
}