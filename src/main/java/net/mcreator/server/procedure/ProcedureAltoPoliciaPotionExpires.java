package net.mcreator.server.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.Entity;

import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class ProcedureAltoPoliciaPotionExpires extends ElementsServer.ModElement {
	public ProcedureAltoPoliciaPotionExpires(ElementsServer instance) {
		super(instance, 41);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AltoPoliciaPotionExpires!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AltoPoliciaPotionExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		world.addWeatherEffect(new EntityLightningBolt(world, (int) (entity.posX), (int) (entity.posY), (int) (entity.posZ), false));
	}
}
