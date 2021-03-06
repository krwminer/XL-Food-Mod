package mariot7.xlfoodmod.blocks;

import java.util.ArrayList;
import java.util.Random;
import mariot7.xlfoodmod.Main;
import mariot7.xlfoodmod.XLFoodModTab;
import mariot7.xlfoodmod.init.ItemListxlfoodmod;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Grass extends BlockBush {
	
	protected String name;
	
	public Grass(String name, Material material, float hardness, float resistance) {
		super(material);
		this.setCreativeTab(XLFoodModTab.tabXLFoodMod);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(SoundType.PLANT);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}

    public boolean isFullCube()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean shouldSideBeRendered()
    {
    	return false;
    }
    
    public void registerItemModel(Item itemBlock) {
		Main.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
    
	@Override
	public ArrayList getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
	    ArrayList drops = new ArrayList();
	    if (RANDOM.nextFloat() < 0.35F)
	    drops.add(new ItemStack(ItemListxlfoodmod.rice_seeds));
	    if (RANDOM.nextFloat() < 0.35F)
	    drops.add(new ItemStack(ItemListxlfoodmod.pepper_seeds));
	    if (RANDOM.nextFloat() < 0.35F)
	    drops.add(new ItemStack(ItemListxlfoodmod.corn_seeds));
	    if (RANDOM.nextFloat() < 0.35F)
	    drops.add(new ItemStack(ItemListxlfoodmod.cucumber_seeds));
	    if (RANDOM.nextFloat() < 0.35F)
		drops.add(new ItemStack(ItemListxlfoodmod.lettuce_seeds));
	    if (RANDOM.nextFloat() < 0.35F)
		drops.add(new ItemStack(ItemListxlfoodmod.tomato_seeds));
	    if (RANDOM.nextFloat() < 0.35F)
	    drops.add(new ItemStack(ItemListxlfoodmod.strawberry_seeds));
	    return drops;
	}
	
	
}
      