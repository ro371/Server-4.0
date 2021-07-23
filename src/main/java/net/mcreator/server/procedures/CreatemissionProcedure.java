package net.mcreator.server.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
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

import java.util.concurrent.atomic.AtomicReference;
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
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ServerMod.LOGGER.warn("Failed to load dependency x for procedure Createmission!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ServerMod.LOGGER.warn("Failed to load dependency y for procedure Createmission!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ServerMod.LOGGER.warn("Failed to load dependency z for procedure Createmission!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure Createmission!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double num = 0;
		double perg = 0;
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(PergaminoItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		num = (double) Math.random();
		perg = (double) 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((new ItemStack(PergaminoItem.block, (int) (1)).getItem() == (itemstackiterator).getItem())) {
						perg = (double) ((perg) + (((itemstackiterator)).getCount()));
					}
				}
			}
		}
		if (((perg) >= 1)) {
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
		} else {
			if (((num) < 0.125)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(MisionItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (((num) < 0.25)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(MisionwheatItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				} else {
					if (((num) < 0.375)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(MisionpumpkinItem.block, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else {
						if (((num) < 0.5)) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(MisionSeedsItem.block, (int) (1)));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						} else {
							if (((num) < 0.625)) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
											new ItemStack(MisionmelonItem.block, (int) (1)));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							} else {
								if (((num) < 0.75)) {
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
												new ItemStack(MisionsugarItem.block, (int) (1)));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
								} else {
									if (((num) < 0.875)) {
										if (world instanceof World && !world.isRemote()) {
											ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
													new ItemStack(MisionstoneItem.block, (int) (1)));
											entityToSpawn.setPickupDelay((int) 10);
											world.addEntity(entityToSpawn);
										}
									} else {
										if (((num) < 1)) {
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
														new ItemStack(MisionfishItem.block, (int) (1)));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
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
}
