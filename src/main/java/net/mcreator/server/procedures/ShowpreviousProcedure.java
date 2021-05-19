package net.mcreator.server.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class ShowpreviousProcedure extends ServerModElements.ModElement {
	public ShowpreviousProcedure(ServerModElements instance) {
		super(instance, 137);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure Showprevious!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean isshown = false;
		if ((0 == ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ServerModVariables.PlayerVariables())).menupage))) {
			isshown = (boolean) (false);
		} else {
			isshown = (boolean) (true);
		}
		return (isshown);
	}
}
