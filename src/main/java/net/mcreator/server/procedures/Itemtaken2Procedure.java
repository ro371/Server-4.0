package net.mcreator.server.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.SufreMamonDiskItem;
import net.mcreator.server.item.Coin1Item;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class Itemtaken2Procedure extends ServerModElements.ModElement {
	public Itemtaken2Procedure(ServerModElements instance) {
		super(instance, 118);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure Itemtaken2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getDouble("coin1")) >= 3)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Coin1Item.block, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 3);
			}
		} else {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(SufreMamonDiskItem.block, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
		}
	}
}
