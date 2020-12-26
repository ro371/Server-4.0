package net.mcreator.server.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class AltoPoliciaPotionStartedappliedProcedure extends ServerModElements.ModElement {
	public AltoPoliciaPotionStartedappliedProcedure(ServerModElements instance) {
		super(instance, 40);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AltoPoliciaPotionStartedapplied!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure AltoPoliciaPotionStartedapplied!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure AltoPoliciaPotionStartedapplied!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure AltoPoliciaPotionStartedapplied!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AltoPoliciaPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 400, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 400, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 400, (int) 1, (false), (false)));
		if (!world.getWorld().isRemote) {
			world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("server:policia_en_accion")),
					SoundCategory.NEUTRAL, (float) 100, (float) 1);
		} else {
			world.getWorld().playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("server:policia_en_accion")),
					SoundCategory.NEUTRAL, (float) 100, (float) 1, false);
		}
	}
}
