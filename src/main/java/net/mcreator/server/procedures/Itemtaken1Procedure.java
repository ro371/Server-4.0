package net.mcreator.server.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.QuizasDiskItem;
import net.mcreator.server.item.Coin1Item;
import net.mcreator.server.ServerModElements;

import java.util.Map;
import java.util.HashMap;

@ServerModElements.ModElement.Tag
public class Itemtaken1Procedure extends ServerModElements.ModElement {
	public Itemtaken1Procedure(ServerModElements instance) {
		super(instance, 113);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Itemtaken1!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Itemtaken1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			ShopThisGUIIsOpenedProcedure.executeProcedure($_dependencies);
		}
		if (((entity.getPersistentData().getDouble("coin1")) >= 2)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Coin1Item.block, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 2);
			}
		} else {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(QuizasDiskItem.block, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
		}
	}
}
