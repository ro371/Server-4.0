package net.mcreator.server.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class AltoPoliciaPotionExpiresProcedure extends ServerModElements.ModElement {
	public AltoPoliciaPotionExpiresProcedure(ServerModElements instance) {
		super(instance, 41);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AltoPoliciaPotionExpires!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AltoPoliciaPotionExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld)
			((ServerWorld) world).addLightningBolt(
					new LightningBoltEntity(world.getWorld(), (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), false));
	}
}
