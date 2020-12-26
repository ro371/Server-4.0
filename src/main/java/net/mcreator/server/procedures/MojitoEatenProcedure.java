package net.mcreator.server.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class MojitoEatenProcedure extends ServerModElements.ModElement {
	public MojitoEatenProcedure(ServerModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MojitoEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"give @p server:vaso 1");
			}
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 200, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 150, (int) 1, (false), (false)));
	}
}
