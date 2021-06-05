package net.mcreator.server.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.PergaminoItem;
import net.mcreator.server.item.MisionwheatItem;
import net.mcreator.server.item.MisionsugarItem;
import net.mcreator.server.item.MisionstoneItem;
import net.mcreator.server.item.MisionpumpkinItem;
import net.mcreator.server.item.MisionmelonItem;
import net.mcreator.server.item.MisionfishItem;
import net.mcreator.server.item.MisionSeedsItem;
import net.mcreator.server.item.MisionItem;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class CreatemissionProcedure extends ServerModElements.ModElement {
	public CreatemissionProcedure(ServerModElements instance) {
		super(instance, 138);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure Createmission!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double num = 0;
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(PergaminoItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		num = (double) Math.random();
		if (((num) < 0.125)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MisionItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else {
			if (((num) < 0.25)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(MisionwheatItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else {
				if (((num) < 0.375)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(MisionpumpkinItem.block, (int) (1));
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
				} else {
					if (((num) < 0.5)) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(MisionSeedsItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (((num) < 0.625)) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(MisionmelonItem.block, (int) (1));
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else {
							if (((num) < 0.75)) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(MisionsugarItem.block, (int) (1));
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							} else {
								if (((num) < 0.875)) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(MisionstoneItem.block, (int) (1));
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
								} else {
									if (((num) < 1)) {
										if (entity instanceof PlayerEntity) {
											ItemStack _setstack = new ItemStack(MisionfishItem.block, (int) (1));
											_setstack.setCount((int) 1);
											ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
