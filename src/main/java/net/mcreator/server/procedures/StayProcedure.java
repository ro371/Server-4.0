package net.mcreator.server.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.PergaminoItem;
import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;
import java.util.HashMap;

@ServerModElements.ModElement.Tag
public class StayProcedure extends ServerModElements.ModElement {
	public StayProcedure(ServerModElements instance) {
		super(instance, 174);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure Stay!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure Stay!");
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
					double _setval = (double) (((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ServerModVariables.PlayerVariables())).time) + 1);
					entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.time = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ServerModVariables.PlayerVariables())).time) >= 90)) {
					{
						double _setval = (double) 0;
						entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.time = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((Math.random() < 0.9)) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(PergaminoItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					StayProcedure.executeProcedure($_dependencies);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 1200);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
