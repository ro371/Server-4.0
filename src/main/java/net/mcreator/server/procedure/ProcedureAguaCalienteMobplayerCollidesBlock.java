package net.mcreator.server.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class ProcedureAguaCalienteMobplayerCollidesBlock extends ElementsServer.ModElement {
	public ProcedureAguaCalienteMobplayerCollidesBlock(ElementsServer instance) {
		super(instance, 6);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AguaCalienteMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.HOT_FLOOR, (float) 1);
	}
}
