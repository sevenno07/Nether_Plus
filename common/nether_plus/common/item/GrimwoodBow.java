package nether_plus.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import nether_plus.common.entity.EntityGrimwoodArrow;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrimwoodBow extends ItemBow
{
	private  IIcon[] iconBuffer;
	private static String[] bowAnimation = new String[] {"_pull1", "_pull2", "_pull3"};
	
	public GrimwoodBow()
	{
		super();
		this.setFull3D();
		this.maxStackSize = 1;
		this.setMaxDamage(434);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int par4)
    {
        int j = this.getMaxItemUseDuration(itemStack) - par4;

        ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

        if (flag || player.inventory.hasItem(NPItemList.grimwoodArrow))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityGrimwoodArrow grimwoodArrow = new EntityGrimwoodArrow(world, player, f * 2.0F);

            if (f == 1.0F)
            {
            	grimwoodArrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack);

            if (k > 0)
            {
            	grimwoodArrow.setDamage(grimwoodArrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);

            if (l > 0)
            {
            	grimwoodArrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0)
            {
            	grimwoodArrow.setFire(100);
            }

            itemStack.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
            	grimwoodArrow.canBePickedUp = 2;
            }
            else
            {
                player.inventory.consumeInventoryItem(NPItemList.grimwoodArrow);
            }

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(grimwoodArrow);
            }
        }
    }
	
	/**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(NPItemList.grimwoodArrow))
        {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        return itemStack;
	}
	
	@Override
	public int getItemEnchantability()
    {
        return 1;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		iconBuffer = new IIcon[bowAnimation.length];
		itemIcon = iconRegister.registerIcon(this.getIconString() + "_standby");
		for(int i = 0; i < bowAnimation.length; i++)
		{
			iconBuffer[i] = iconRegister.registerIcon(this.getIconString() + bowAnimation[i]);
		}
	}
}