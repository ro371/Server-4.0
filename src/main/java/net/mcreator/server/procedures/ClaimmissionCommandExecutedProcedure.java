package net.mcreator.server.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.PergaminoItem;
import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class ClaimmissionCommandExecutedProcedure extends ServerModElements.ModElement {
	public ClaimmissionCommandExecutedProcedure(ServerModElements instance) {
		super(instance, 254);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure ClaimmissionCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ServerModVariables.PlayerVariables())).missions) > 0)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(PergaminoItem.block, (int) (1));
				_setstack.setCount((int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ServerModVariables.PlayerVariables())).missions));
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else {
			{
				double _setval = (double) 0;
				entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.missions = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
