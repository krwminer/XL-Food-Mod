package mariot7.xlfoodmod.items;

import java.util.List;

import javax.annotation.Nullable;

import mariot7.xlfoodmod.Main;
import mariot7.xlfoodmod.XLFoodModTab;
import mariot7.xlfoodmod.init.ItemListxlfoodmod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StealthyEnergyDrink extends ItemFood {
	
	protected String name;
	
	public StealthyEnergyDrink(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
		this.setCreativeTab(XLFoodModTab.tabXLFoodMod);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public StealthyEnergyDrink(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
    }
	
	public void registerItemModel() {
		Main.proxy.registerItemRenderer(this, 0, name);
	}
	
	protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 2400, 0));
		player.inventory.addItemStackToInventory(new ItemStack(ItemListxlfoodmod.empty_can));
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Night Vision");
		tooltip.add("Speed");
		tooltip.add("Invisibility (2:00)");
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
	return EnumAction.DRINK;
	}

	
}
