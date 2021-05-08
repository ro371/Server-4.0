package net.mcreator.server.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class ShopThisGUIIsClosedProcedure extends ServerModElements.ModElement {
	public ShopThisGUIIsClosedProcedure(ServerModElements instance) {
		super(instance, 119);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure ShopThisGUIIsClosed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("guishopopen", (false));
	}
}
