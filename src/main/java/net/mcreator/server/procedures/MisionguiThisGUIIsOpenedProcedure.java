package net.mcreator.server.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.server.item.AcarbonItem;
import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.function.Supplier;
import java.util.Map;

@ServerModElements.ModElement.Tag
public class MisionguiThisGUIIsOpenedProcedure extends ServerModElements.ModElement {
	public MisionguiThisGUIIsOpenedProcedure(ServerModElements instance) {
		super(instance, 139);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure MisionguiThisGUIIsOpened!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure MisionguiThisGUIIsOpened!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;
			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ServerModVariables.PlayerVariables())).misionchosen) == 0)) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(AcarbonItem.block, (int) (1));
								_setstack.setCount((int) 64);
								((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else {
					if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ServerModVariables.PlayerVariables())).misionchosen) == 1)) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.WHEAT, (int) (1));
									_setstack.setCount((int) 192);
									((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else {
						if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ServerModVariables.PlayerVariables())).misionchosen) == 2)) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Blocks.PUMPKIN, (int) (1));
										_setstack.setCount((int) 128);
										((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else {
							if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ServerModVariables.PlayerVariables())).misionchosen) == 3)) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.WHEAT_SEEDS, (int) (1));
											_setstack.setCount((int) 256);
											((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							}
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 6);
	}
}
