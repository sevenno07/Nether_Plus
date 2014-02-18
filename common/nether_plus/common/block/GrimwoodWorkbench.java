package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import nether_plus.common.Nether_plus;
import nether_plus.common.creativetabs.NetherPlusCreativeTabs;
import nether_plus.common.tileentity.TileEntityGrimwoodWorkbench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrimwoodWorkbench extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconFront;

    protected GrimwoodWorkbench()
    {
        super(Material.wood);
        this.setCreativeTab(NetherPlusCreativeTabs.NPCreativeTabsBlock);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? NPBlockList.NetherPlanks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Nether_plus:workbench_side");
        this.workbenchIconTop = par1IconRegister.registerIcon("Nether_plus:workbench_top");
        this.workbenchIconFront = par1IconRegister.registerIcon("Nether_plus:workbench_front");
    }

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntityGrimwoodWorkbench tileentityworkbench = (TileEntityGrimwoodWorkbench) world.getTileEntity(x, y, z);
		if(tileentityworkbench == null || player.isSneaking())
		{
			return false;
		}
		player.openGui(Nether_plus.instance, 2, world, x, y, z);
		return true;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int j)
	{
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, block, j);
	}
	
	private void dropItems(World world, int x, int y, int z)
	{
		Random rand = new Random();
		TileEntityGrimwoodWorkbench tileentityworkbench = (TileEntityGrimwoodWorkbench) world.getTileEntity(x, y, z);
		if(!(tileentityworkbench instanceof IInventory))
		{
			return;
		}
		IInventory inventory = (IInventory) tileentityworkbench;
		for(int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack item = inventory.getStackInSlot(i);
			if(item != null && item.stackSize > 0)
			{
				float rx = rand.nextFloat() * 0.6F + 0.1F;
				float ry = rand.nextFloat() * 0.6F + 0.1F;
				float rz = rand.nextFloat() * 0.6F + 0.1F;
				EntityItem entity_item = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
				if(item.hasTagCompound())
				{
					entity_item.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}
				float factor = 0.5F;
				entity_item.motionX = rand.nextGaussian() * factor;
				entity_item.motionY = rand.nextGaussian() * factor + 0.2F;
				entity_item.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entity_item);
				item.stackSize = 0;
			}
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityGrimwoodWorkbench();
	}
}