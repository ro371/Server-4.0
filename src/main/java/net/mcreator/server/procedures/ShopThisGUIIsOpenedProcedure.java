package net.mcreator.server.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;
import java.util.HashMap;

@ServerModElements.ModElement.Tag
public class ShopThisGUIIsOpenedProcedure extends ServerModElements.ModElement {
	public ShopThisGUIIsOpenedProcedure(ServerModElements instance) {
		super(instance, 115);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure ShopThisGUIIsOpened!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure ShopThisGUIIsOpened!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		entity.getPersistentData().putBoolean("guishopopen", (true));
		if (((true) == (entity.getPersistentData().getBoolean("guishopopen")))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				ConstantcheckProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
