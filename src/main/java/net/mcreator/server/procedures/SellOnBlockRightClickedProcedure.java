package net.mcreator.server.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import net.mcreator.server.gui.SellguiGui;
import net.mcreator.server.gui.BuyguiGui;
import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

import io.netty.buffer.Unpooled;

@ServerModElements.ModElement.Tag
public class SellOnBlockRightClickedProcedure extends ServerModElements.ModElement {
	public SellOnBlockRightClickedProcedure(ServerModElements instance) {
		super(instance, 158);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure SellOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ServerMod.LOGGER.warn("Failed to load dependency x for procedure SellOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ServerMod.LOGGER.warn("Failed to load dependency y for procedure SellOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ServerMod.LOGGER.warn("Failed to load dependency z for procedure SellOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure SellOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			double _setval = (double) (Math.floor(x));
			entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.x = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) (Math.floor(y));
			entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.y = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) (Math.floor(z));
			entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.z = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (((world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z)))))
				.getBlock() == Blocks.HOPPER.getDefaultState().getBlock())) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"tell @p De momento las tiendas no son compatibles con tolvas.");
			}
		} else {
			if (((world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z)))))
					.getBlock() == Blocks.RAIL.getDefaultState().getBlock())) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tell @p Quite el ra\u00EDl para evitar fallos accidentales.");
				}
			} else {
				if ((((entity.getDisplayName().getString())).equals((new Object() {
					public String getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "name"))))) {
					{
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
							NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
								@Override
								public ITextComponent getDisplayName() {
									return new StringTextComponent("Sellgui");
								}

								@Override
								public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
									return new SellguiGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
							NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
								@Override
								public ITextComponent getDisplayName() {
									return new StringTextComponent("Buygui");
								}

								@Override
								public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
									return new BuyguiGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				}
			}
		}
	}
}
