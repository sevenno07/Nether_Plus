package nether_plus.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;

public class Riz extends ItemFood implements IPlantable
{
	private int cropId;
	
	private int soilId;
	
	public Riz(int par1, int par2, float par3, int par4, int par5)
	{
		super(par1, par2, par3, false);
		this.cropId = par4;
        this.soilId = par5;
        this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsFood);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
        {
            int i1 = par3World.getBlockId(par4, par5, par6);
            Block soil = Block.blocksList[i1];

            if (soil != null && soil.blockID == NPBlockList.Nether_Farm.blockID && par3World.isAirBlock(par4, par5 + 1, par6))
            {
                par3World.setBlock(par4, par5 + 1, par6, this.cropId);
                --par1ItemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z)
	{
		return cropId;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z)
	{
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("nether_plus:Riz");
 	}
}