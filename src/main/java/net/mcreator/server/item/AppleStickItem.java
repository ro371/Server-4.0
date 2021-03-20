
package net.mcreator.server.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.server.ServerModElements;

@ServerModElements.ModElement.Tag
public class AppleStickItem extends ServerModElements.ModElement {
	@ObjectHolder("server:apple_stick")
	public static final Item block = null;
	public AppleStickItem(ServerModElements instance) {
		super(instance, 90);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(16).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.4f).build()));
			setRegistryName("apple_stick");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 26;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
