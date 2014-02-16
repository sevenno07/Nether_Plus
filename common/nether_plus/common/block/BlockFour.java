package nether_plus.common.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import nether_plus.common.Nether_plus;
import nether_plus.common.tileentity.TileEntityFour;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFour extends BlockContainer
{
@SideOnly(Side.CLIENT)
private Icon furnaceIconTop;
@SideOnly(Side.CLIENT)
private Icon furnaceIconFront;
private static boolean keepFurnaceInventory = false;
private final Random furnaceRand = new Random();
	
	private final boolean isActive;

	public BlockFour(int par1, boolean par2)
	{
		super(par1, Material.rock);
		this.isActive = par2;
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return NPBlockList.fourOff.blockID;
	}
	
	 @SideOnly(Side.CLIENT)
	 public Icon getIcon(int side, int metadata)
	 {
		 return side == 1 ? this.furnaceIconTop : (side == 0 ? this.furnaceIconTop : (metadata == 2 && side == 2 ? this.furnaceIconFront : (metadata == 3 && side == 5 ? this.furnaceIconFront : (metadata == 0 && side == 3 ? this.furnaceIconFront : (metadata == 1 && side == 4 ? this.furnaceIconFront : this.blockIcon)))));
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister par1IconRegister)
	 {
		 this.blockIcon = par1IconRegister.registerIcon("Nether_Plus:CorruptedFurnace_side");
		 this.furnaceIconFront = par1IconRegister.registerIcon(this.isActive ? "Nether_Plus:CorruptedFurnace_on" : "Nether_Plus:CorruptedFurnace_off");
		 this.furnaceIconTop = par1IconRegister.registerIcon("Nether_Plus:CorruptedFurnace_top");
	 }
	 
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	 {
		 if (par1World.isRemote)
	 {
	 return true;
	 }
		 else
	 {
	 TileEntityFour tileentityfour = (TileEntityFour)par1World.getBlockTileEntity(par2, par3, par4);

	 if (tileentityfour != null)
	 	{
		 par5EntityPlayer.openGui(Nether_plus.instance, 1, par1World, par2, par3, par4);
	 	}

	 	return true;
	 	}
	 }
	 
	 public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	 {
		 int l = par1World.getBlockMetadata(par2, par3, par4);
		 TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		 keepFurnaceInventory = true;

		 if (par0)
		 {
			 par1World.setBlock(par2, par3, par4, NPBlockList.fourOn.blockID);
		 }
		 else
		 {
			 par1World.setBlock(par2, par3, par4, NPBlockList.fourOff.blockID);
		 }

		 keepFurnaceInventory = false;
		 par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		 if (tileentity != null)
		 {
			 tileentity.validate();
			 par1World.setBlockTileEntity(par2, par3, par4, tileentity);
		 }
	 }
	 
	 @SideOnly(Side.CLIENT)

	 public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	 {
		 if (this.isActive)
		 {
			 int l = par1World.getBlockMetadata(par2, par3, par4);
			 float f = (float)par2 + 0.5F;
			 float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
			 float f2 = (float)par4 + 0.5F;
			 float f3 = 0.52F;
			 float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

			 if (l == 1)
			 {
				 par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				 par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			 }
			 else if (l == 3)
			 {
				 par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				 par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			 }
			 else if (l == 2)
			 {
				 par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
				 par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
			 }
			 else if (l == 0)
			 {
				 par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
				 par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
			 }
		 }
	 }

	 public TileEntity createNewTileEntity(World par1World)
	 {
		 return new TileEntityFour();
	 }

	 public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving living, ItemStack stack)
	 {
		 int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		 world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	 }
	 
	 public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	 {
		 if (!keepFurnaceInventory)
		 {
			 TileEntityFour tileentityfurnace = (TileEntityFour)par1World.getBlockTileEntity(par2, par3, par4);

			 if (tileentityfurnace != null)
			 {
				 for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
				 {
					 ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

					 if (itemstack != null)
					 {
						 float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						 float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						 float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						 while (itemstack.stackSize > 0)
						 {
							 int k1 = this.furnaceRand.nextInt(21) + 10;

							 if (k1 > itemstack.stackSize)
							 {
								 k1 = itemstack.stackSize;
							 }

							 itemstack.stackSize -= k1;
							 EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

							 if (itemstack.hasTagCompound())
							 {
								 entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							 }

							 float f3 = 0.05F;
							 entityitem.motionX = (double)((float)this.furnaceRand.nextGaussian() * f3);
							 entityitem.motionY = (double)((float)this.furnaceRand.nextGaussian() * f3 + 0.2F);
							 entityitem.motionZ = (double)((float)this.furnaceRand.nextGaussian() * f3);
							 par1World.spawnEntityInWorld(entityitem);
						 }
					 }
				 }

				 par1World.func_96440_m(par2, par3, par4, par5);
			 }
		 }

		 super.breakBlock(par1World, par2, par3, par4, par5, par6);
	 }
	 
	 public boolean hasComparatorInputOverride()
	 {
	 return true;
	 }

	 public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
	 {
	 return Container.calcRedstoneFromInventory((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
	 }

	 @SideOnly(Side.CLIENT)
	 public int idPicked(World par1World, int par2, int par3, int par4)
	 {
	 return NPBlockList.fourOff.blockID;
	 }
}