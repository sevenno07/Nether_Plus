package nether_plus.common.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

class ContainerIronSheep extends Container
{
    final IronSheep field_90034_a;

    ContainerIronSheep(IronSheep par1IronSheep)
    {
        this.field_90034_a = par1IronSheep;
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return false;
    }
}