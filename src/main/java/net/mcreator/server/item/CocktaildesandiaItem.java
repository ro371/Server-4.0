
package net.mcreator.server.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.server.procedures.CocktaildesandiaFoodEatenProcedure;
import net.mcreator.server.ServerModElements;

import java.util.Map;
import java.util.HashMap;

@ServerModElements.ModElement.Tag
public class CocktaildesandiaItem extends ServerModElements.ModElement {
	@ObjectHolder("server:cocktaildesandia")
	public static final Item block = null;
	public CocktaildesandiaItem(ServerModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(32).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.1f).setAlwaysEdible().build()));
			setRegistryName("cocktaildesandia");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 24;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				CocktaildesandiaFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
