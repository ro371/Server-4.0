package net.mcreator.server.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.server.item.PergaminoItem;
import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;

@ServerModElements.ModElement.Tag
public class ClaimmissionCommandExecutedProcedure extends ServerModElements.ModElement {
	public ClaimmissionCommandExecutedProcedure(ServerModElements instance) {
		super(instance, 254);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure ClaimmissionCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ServerMod.LOGGER.warn("Failed to load dependency x for procedure ClaimmissionCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ServerMod.LOGGER.warn("Failed to load dependency y for procedure ClaimmissionCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ServerMod.LOGGER.warn("Failed to load dependency z for procedure ClaimmissionCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure ClaimmissionCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ServerModVariables.PlayerVariables())).missions) > 0)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(PergaminoItem.block, (int) (1));
				_setstack.setCount((int) ((entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ServerModVariables.PlayerVariables())).missions));
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(ServerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.missions = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"tell @p \u00A1Las misiones han sido reclamadas!");
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"tell @p \u00A1Todav\u00EDa no tienes una misi\u00F3n, te toca esperar!");
			}
		}
	}
}
