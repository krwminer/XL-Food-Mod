package mariot7.xlfoodmod.blocks;

import mariot7.xlfoodmod.Main;
import mariot7.xlfoodmod.init.ItemListxlfoodmod;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Corn extends BlockCrops {
	
	protected String name;
	
	public Corn(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public Item getSeed() {
		return ItemListxlfoodmod.corn_seeds;
	}
	
	public Item getCrop() {
		return ItemListxlfoodmod.raw_corn;
	}
	
	public void registerItemModel(Item itemBlock) {
		Main.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	
}
