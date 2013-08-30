package nether_plus.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockGrimwoodDoor extends Block
{
	private static final String[] doorIconNames = new String[] {"doorWood_lower", "doorWood_upper"};
	
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
	
	public BlockGrimwoodDoor(int id, Material material)
	{
		super(id, material);
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[doorIconNames.length * 2];

        for (int i = 0; i < doorIconNames.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(doorIconNames[i]);
            this.iconArray[i + doorIconNames.length] = new IconFlipped(this.iconArray[i], true, false);
        }
    }
}
