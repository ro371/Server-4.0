package net.mcreator.server.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.server.ServerModElements;

import java.util.Map;
import java.util.HashMap;

@ServerModElements.ModElement.Tag
public class AltopoliciadetenerCommandExecutedProcedure extends ServerModElements.ModElement {
	public AltopoliciadetenerCommandExecutedProcedure(ServerModElements instance) {
		super(instance, 42);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				System.err.println("Failed to load dependency cmdparams for procedure AltopoliciadetenerCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure AltopoliciadetenerCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure AltopoliciadetenerCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure AltopoliciadetenerCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AltopoliciadetenerCommandExecuted!");
			return;
		}
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							(("effect ") + "" + ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + (((" 2 ") + "" + ("400 ")))))));
		}
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							(("effect ") + "" + ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + (((" 4 ") + "" + ("400 ")))))));
		}
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							(("effect ") + "" + ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + (((" 18 ") + "" + ("400 ")))))));
		}
	}
}
