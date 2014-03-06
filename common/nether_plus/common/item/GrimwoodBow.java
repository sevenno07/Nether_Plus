package nether_plus.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
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