package net.mcreator.server.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;
import java.util.Collection;

@ServerModElements.ModElement.Tag
public class GinTonicFoodEatenProcedure extends ServerModElements.ModElement {
	public GinTonicFoodEatenProcedure(ServerModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure GinTonicFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Drunk = 0;
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) (((new Object() {
				int check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.POISON)
								return effect.getDuration();
						}
					}
					return 0;
				}
			}.check(entity)) * 2) + 40), (int) 2, (true), (true)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) (((new Object() {
				int check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.NAUSEA)
								return effect.getDuration();
						}
					}
					return 0;
				}
			}.check(entity)) * 2) + 100), (int) 3, (true), (true)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) (((new Object() {
				int check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.BLINDNESS)
								return effect.getDuration();
						}
					}
					return 0;
				}
			}.check(entity)) * 2) + 60), (int) 0, (true), (true)));
	}
}
