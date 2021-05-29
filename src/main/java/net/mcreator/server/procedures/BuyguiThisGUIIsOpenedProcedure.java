package net.mcreator.server.procedures;

import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.function.Supplier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.HashMap;

@ServerModElements.ModElement.Tag
public class BuyguiThisGUIIsOpenedProcedure extends ServerModElements.ModElement {
	public BuyguiThisGUIIsOpenedProcedure(ServerModElements instance) {
		super(instance, 160);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure BuyguiThisGUIIsOpened!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure BuyguiThisGUIIsOpened!");
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
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.guishopopen = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = (new Object() {
								public ItemStack getItemStack(BlockPos pos, int sltid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).copy());
										});
									}
									return _retval.get();
								}
							}.getItemStack(new BlockPos(
									(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ServerModVariables.PlayerVariables())).x),
									(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ServerModVariables.PlayerVariables())).y),
									(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ServerModVariables.PlayerVariables())).z)),
									(int) (3)));
							_setstack.setCount((int) (new Object() {
								public int getAmount(IWorld world, BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(world,
									new BlockPos(
											(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new ServerModVariables.PlayerVariables())).x),
											(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new ServerModVariables.PlayerVariables())).y),
											(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new ServerModVariables.PlayerVariables())).z)),
									(int) (2))));
							((Slot) ((Map) invobj).get((int) (6))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					CheckupdateProcedure.executeProcedure($_dependencies);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 4);
	}
}
