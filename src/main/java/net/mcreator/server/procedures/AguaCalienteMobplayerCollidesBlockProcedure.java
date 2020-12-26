package net.mcreator.server.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class AguaCalienteMobplayerCollidesBlockProcedure extends ServerModElements.ModElement {
	public AguaCalienteMobplayerCollidesBlockProcedure(ServerModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AguaCalienteMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.HOT_FLOOR, (float) 1);
	}
}
