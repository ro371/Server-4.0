package net.mcreator.server.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class MediumPizzaFoodEatenProcedure extends ServerModElements.ModElement {
	public MediumPizzaFoodEatenProcedure(ServerModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure MediumPizzaFoodEaten!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ServerMod.LOGGER.warn("Failed to load dependency x for procedure MediumPizzaFoodEaten!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ServerMod.LOGGER.warn("Failed to load dependency y for procedure MediumPizzaFoodEaten!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ServerMod.LOGGER.warn("Failed to load dependency z for procedure MediumPizzaFoodEaten!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure MediumPizzaFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 80, (int) 1, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 150, (int) 1, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 300, (int) 0, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 260, (int) 0, (true), (false)));
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("server:yummy")),
					SoundCategory.NEUTRAL, (float) 100, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("server:yummy")),
					SoundCategory.NEUTRAL, (float) 100, (float) 1, false);
		}
	}
}
