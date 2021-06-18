package net.mcreator.server.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.function.Supplier;
import java.util.Map;

@ServerModElements.ModElement.Tag
public class BuyguiThisGUIIsClosedProcedure extends ServerModElements.ModElement {
	public BuyguiThisGUIIsClosedProcedure(ServerModElements instance) {
		super(instance, 163);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure BuyguiThisGUIIsClosed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			Container _current = ((ServerPlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (5))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
		if (entity instanceof ServerPlayerEntity) {
			Container _current = ((ServerPlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (6))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
		{
			boolean _setval = (boolean) (false);
			entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.guishopopen = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
