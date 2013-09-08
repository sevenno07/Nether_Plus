package nether_plus.common.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import nether_plus.common.item.NPItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RizC extends Crops
{
	@SideOnly(Side.CLIENT)
    private Icon[] iconArray;
	
	public RizC(int id)
	{
		super(id);
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
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

    protected int getSeedItem()
    {
        return NPItemList.Riz.itemID;
    }

    protected int getCropItem()
    {
        return NPItemList.Riz.itemID;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[4];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("rizs_" + i);
        }
    }
}