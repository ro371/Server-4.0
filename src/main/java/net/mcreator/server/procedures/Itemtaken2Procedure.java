package net.mcreator.server.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.Coin1Item;
import net.mcreator.server.ServerModElements;

import java.util.function.Supplier;
import java.util.Map;

@ServerModElements.ModElement.Tag
public class Itemtaken2Procedure extends ServerModElements.ModElement {
	public Itemtaken2Procedure(ServerModElements instance) {
		super(instance, 80);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Itemtaken2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (2))) >= 1)) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Coin1Item.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayerEntity) {
									Container _current = ((ServerPlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
											if (stack != null)
												return stack.getCount();
										}
									}
								}
								return 0;
							}
						}.getAmount((int) (3))) + 5));
						((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		}
	}
}
