package net.mcreator.server.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class GinTonicFoodEatenProcedure extends ServerModElements.ModElement {
	public GinTonicFoodEatenProcedure(ServerModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure GinTonicFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Drunk = 0;
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 16, (int) 2, (true), (true)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) ((Drunk) + 150), (int) 3, (true), (true)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) (((Drunk) / 2) + 50), (int) 1, (true), (true)));
		Drunk = (double) ((Drunk) + 20);
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) == 0)) {
			Drunk = (double) 0;
		}
	}
}
