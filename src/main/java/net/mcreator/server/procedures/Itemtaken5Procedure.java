package net.mcreator.server.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.Coin1Item;
import net.mcreator.server.item.AloneItem;
import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class Itemtaken5Procedure extends ServerModElements.ModElement {
	public Itemtaken5Procedure(ServerModElements instance) {
		super(instance, 124);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure Itemtaken5!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ServerModVariables.PlayerVariables())).menupage) == 0)) {
			if (((entity.getPersistentData().getDouble("coin1")) >= 4)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Coin1Item.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 4,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(AloneItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
		}
	}
}
