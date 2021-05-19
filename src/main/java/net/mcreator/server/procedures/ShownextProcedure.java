package net.mcreator.server.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class ShownextProcedure extends ServerModElements.ModElement {
	public ShownextProcedure(ServerModElements instance) {
		super(instance, 136);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure Shownext!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean truecheck = false;
		if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ServerModVariables.PlayerVariables())).menupage) == 2)) {
			truecheck = (boolean) (false);
		} else {
			truecheck = (boolean) (true);
		}
		return (truecheck);
	}
}
