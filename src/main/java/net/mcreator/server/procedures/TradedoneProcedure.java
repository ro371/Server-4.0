package net.mcreator.server.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@ServerModElements.ModElement.Tag
public class TradedoneProcedure extends ServerModElements.ModElement {
	public TradedoneProcedure(ServerModElements instance) {
		super(instance, 164);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure Tradedone!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure Tradedone!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(
					(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ServerModVariables.PlayerVariables())).x),
					(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ServerModVariables.PlayerVariables())).y),
					(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ServerModVariables.PlayerVariables())).z)));
			if (_ent != null) {
				final int _sltid = (int) (0);
				final ItemStack _setstack = (new Object() {
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
						(int) (0)));
				_setstack.setCount((int) ((new Object() {
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
						(int) (0))) - (new Object() {
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
								(int) (1)))));
				_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(
					(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ServerModVariables.PlayerVariables())).x),
					(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ServerModVariables.PlayerVariables())).y),
					(int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ServerModVariables.PlayerVariables())).z)));
			if (_ent != null) {
				final int _sltid = (int) (4);
				final ItemStack _setstack = (new Object() {
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
				_setstack.setCount((int) ((new Object() {
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
						(int) (2))) + (new Object() {
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
								(int) (4)))));
				_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = (new Object() {
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
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) (new Object() {
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
					(int) (2))), ((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
