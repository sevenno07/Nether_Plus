package nether_plus.common.recipe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nether_plus.common.block.NPBlockList;
import nether_plus.common.item.NPItemList;

public class RecipesFour
	{
	private static final RecipesFour smeltingBase = new RecipesFour();

	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

	public static final RecipesFour smelting()
	{
		return smeltingBase;
	}

	private RecipesFour()
	{
		this.addSmelting(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
		this.addSmelting(Blocks.gold_ore, new ItemStack(Items.gold_ingot), 1.0F);
		this.addSmelting(Blocks.diamond_ore, new ItemStack(Items.diamond), 1.0F);
		this.addSmelting(Blocks.sand, new ItemStack(Blocks.glass), 0.1F);
		this.addSmelting(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.35F);
		this.addSmelting(Items.beef, new ItemStack(Items.cooked_beef), 0.35F);
		this.addSmelting(Items.chicken, new ItemStack(Items.cooked_chicken), 0.35F);
		this.addSmelting(Items.fish, new ItemStack(Items.cooked_fished), 0.35F);
		this.addSmelting(Blocks.cobblestone, new ItemStack(Blocks.stone), 0.1F);
		this.addSmelting(Items.clay_ball, new ItemStack(Items.brick), 0.3F);
		this.addSmelting(Blocks.cactus, new ItemStack(Items.dye, 1, 2), 0.2F);
		this.addSmelting(Blocks.log, new ItemStack(Items.coal, 1, 1), 0.15F);
		this.addSmelting(Blocks.emerald_ore, new ItemStack(Items.emerald), 1.0F);
		this.addSmelting(Items.potato, new ItemStack(Items.baked_potato), 0.35F);
		this.addSmelting(Blocks.netherrack, new ItemStack(Items.netherbrick), 0.1F);
		this.addSmelting(Blocks.coal_ore, new ItemStack(Items.coal), 0.1F);
		this.addSmelting(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7F);
		this.addSmelting(Blocks.lapis_ore, new ItemStack(Items.dye, 1, 4), 0.2F);
		this.addSmelting(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2F);
		this.addSmelting(Blocks.soul_sand, new ItemStack(NPBlockList.soulGlass), 2.0F);
		this.addSmelting(NPBlockList.glowstoneSand, new ItemStack(Blocks.glowstone), 2.0F);
		this.addSmelting(NPBlockList.corruptedGoldOre, new ItemStack(Items.gold_ingot), 2.0F);
		this.addSmelting(NPBlockList.corruptedBlackIronOre, new ItemStack(NPItemList.blackIronIngot), 2.0F);
		this.addSmelting(NPBlockList.corruptedCharoiteOre, new ItemStack(NPItemList.charoiteCrystal), 2.0F);
		this.addSmelting(NPBlockList.corruptedCobblestone, new ItemStack(NPBlockList.corruptionStone), 2.0F);
		this.addSmelting(NPBlockList.infernumOre, new ItemStack(NPItemList.infernumIngot), 2.0F);

	}

	public void addSmelting(Block block, ItemStack par2ItemStack, float par3)
	{
        this.addSmelting(Item.getItemFromBlock(block), par2ItemStack, par3);
	}

	private void addSmelting(Item itemFromBlock, ItemStack par2ItemStack, float par3)
	{
        this.func_151394_a(new ItemStack(itemFromBlock, 1, 32767), par2ItemStack, par3);
	}

	private void func_151394_a(ItemStack itemStack, ItemStack par2ItemStack, float par3)
	{
        this.smeltingList.put(itemStack, par2ItemStack);
        this.experienceList.put(par2ItemStack, Float.valueOf(par3));
	}

	public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}