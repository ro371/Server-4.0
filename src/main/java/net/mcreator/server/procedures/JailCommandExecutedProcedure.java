package net.mcreator.server.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.server.ServerModVariables;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;
import java.util.HashMap;

@ServerModElements.ModElement.Tag
public class JailCommandExecutedProcedure extends ServerModElements.ModElement {
	public JailCommandExecutedProcedure(ServerModElements instance) {
		super(instance, 243);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure JailCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				ServerMod.LOGGER.warn("Failed to load dependency cmdparams for procedure JailCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ServerMod.LOGGER.warn("Failed to load dependency x for procedure JailCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ServerMod.LOGGER.warn("Failed to load dependency y for procedure JailCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ServerMod.LOGGER.warn("Failed to load dependency z for procedure JailCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ServerMod.LOGGER.warn("Failed to load dependency world for procedure JailCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getDisplayName().getString())).equals((ServerModVariables.MapVariables.get(world).police1)))) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						(("tp ") + "" + ((((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("0");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())) + "" + (" 31 71 -258")))));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						(("spawnpoint ") + "" + ((((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("0");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())) + "" + (" 31 71 -258")))));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						(("title ") + "" + ((((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("0");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())) + "" + (" times 20 200 20")))));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						(("title ") + "" + ((((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("0");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())) + "" + (" subtitle {\"text\":\"encarcelado\"}")))));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						(("title ") + "" + ((((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("0");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())) + "" + (" title {\"text\":\"Has sido \"}")))));
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) 31, (int) 71, (int) (-258)),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("server:musicatristenaruto")),
						SoundCategory.NEUTRAL, (float) 10, (float) 1);
			} else {
				((World) world).playSound(31, 71, (-258),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("server:musicatristenaruto")),
						SoundCategory.NEUTRAL, (float) 10, (float) 1, false);
			}
		} else {
			if ((((entity.getDisplayName().getString())).equals((ServerModVariables.MapVariables.get(world).police2)))) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(("tp ") + "" + ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + (" 31 71 -258")))));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(("spawnpoint ") + "" + ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + (" 31 71 -258")))));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(("title ") + "" + ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + (" times 20 200 20")))));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(("title ") + "" + ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + (" subtitle {\"text\":\"encarcelado\"}")))));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(("title ") + "" + ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + (" title {\"text\":\"Has sido \"}")))));
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) 31, (int) 71, (int) (-258)),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("server:musicatristenaruto")),
							SoundCategory.NEUTRAL, (float) 10, (float) 1);
				} else {
					((World) world).playSound(31, 71, (-258),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("server:musicatristenaruto")),
							SoundCategory.NEUTRAL, (float) 10, (float) 1, false);
				}
			} else {
				if (((((entity.getDisplayName().getString())).equals((ServerModVariables.MapVariables.get(world).judge)))
						|| (((entity.getDisplayName().getString())).equals((ServerModVariables.MapVariables.get(world).judge2))))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								(("tp ") + "" + ((((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("0");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText())) + "" + (" 31 71 -258")))));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								(("spawnpoint ") + "" + ((((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("0");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText())) + "" + (" 31 71 -258")))));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								(("title ") + "" + ((((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("0");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText())) + "" + (" times 20 200 20")))));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								(("title ") + "" + ((((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("0");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText())) + "" + (" subtitle {\"text\":\"encarcelado\"}")))));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								(("title ") + "" + ((((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("0");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText())) + "" + (" title {\"text\":\"Has sido \"}")))));
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) 31, (int) 71, (int) (-258)),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("server:musicatristenaruto")),
										SoundCategory.NEUTRAL, (float) 10, (float) 1);
					} else {
						((World) world).playSound(31, 71, (-258),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("server:musicatristenaruto")),
								SoundCategory.NEUTRAL, (float) 10, (float) 1, false);
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tell @p No tienes permisos");
					}
				}
			}
		}
	}
}
