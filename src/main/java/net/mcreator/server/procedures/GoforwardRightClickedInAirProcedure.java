package net.mcreator.server.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.GoforwardItem;
import net.mcreator.server.ServerModElements;
import net.mcreator.server.ServerMod;

import java.util.Map;
import java.util.Collections;

@ServerModElements.ModElement.Tag
public class GoforwardRightClickedInAirProcedure extends ServerModElements.ModElement {
	public GoforwardRightClickedInAirProcedure(ServerModElements instance) {
		super(instance, 185);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ServerMod.LOGGER.warn("Failed to load dependency entity for procedure GoforwardRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ServerMod.LOGGER.warn("Failed to load dependency x for procedure GoforwardRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ServerMod.LOGGER.warn("Failed to load dependency y for procedure GoforwardRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ServerMod.LOGGER.warn("Failed to load dependency z for procedure GoforwardRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (((entity.rotationYaw) < 0)) {
			if ((((entity.rotationYaw) >= (-30)) || ((entity.rotationYaw) <= (-330)))) {
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(x, y, (z + 6));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, (z + 6), _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
			} else {
				if (((entity.rotationYaw) >= (-60))) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x + 3), y, (z + 3));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 3), y, (z + 3), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
				} else {
					if (((entity.rotationYaw) <= (-300))) {
						{
							Entity _ent = entity;
							_ent.setPositionAndUpdate((x - 3), y, (z + 3));
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 3), y, (z + 3), _ent.rotationYaw, _ent.rotationPitch,
										Collections.emptySet());
							}
						}
					} else {
						if (((entity.rotationYaw) >= (-120))) {
							{
								Entity _ent = entity;
								_ent.setPositionAndUpdate((x + 6), y, z);
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 6), y, z, _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
						} else {
							if (((entity.rotationYaw) <= (-240))) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate((x - 6), y, z);
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 6), y, z, _ent.rotationYaw, _ent.rotationPitch,
												Collections.emptySet());
									}
								}
							} else {
								if (((entity.rotationYaw) >= (-150))) {
									{
										Entity _ent = entity;
										_ent.setPositionAndUpdate((x + 3), y, (z - 3));
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 3), y, (z - 3), _ent.rotationYaw,
													_ent.rotationPitch, Collections.emptySet());
										}
									}
								} else {
									if (((entity.rotationYaw) <= (-210))) {
										{
											Entity _ent = entity;
											_ent.setPositionAndUpdate((x - 3), y, (z - 3));
											if (_ent instanceof ServerPlayerEntity) {
												((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 3), y, (z - 3), _ent.rotationYaw,
														_ent.rotationPitch, Collections.emptySet());
											}
										}
									} else {
										if ((((entity.rotationYaw) >= (-210)) || ((entity.rotationYaw) <= (-150)))) {
											{
												Entity _ent = entity;
												_ent.setPositionAndUpdate(x, y, (z - 6));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, (z - 6), _ent.rotationYaw,
															_ent.rotationPitch, Collections.emptySet());
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
		} else {
			if ((((entity.rotationYaw) < 30) || ((entity.rotationYaw) >= 330))) {
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(x, y, (z + 6));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, (z + 6), _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
			} else {
				if (((entity.rotationYaw) < 60)) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x - 3), y, (z + 3));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 3), y, (z + 3), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
				} else {
					if (((entity.rotationYaw) > 300)) {
						{
							Entity _ent = entity;
							_ent.setPositionAndUpdate((x + 3), y, (z + 3));
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 3), y, (z + 3), _ent.rotationYaw, _ent.rotationPitch,
										Collections.emptySet());
							}
						}
					} else {
						if (((entity.rotationYaw) < 120)) {
							{
								Entity _ent = entity;
								_ent.setPositionAndUpdate((x - 6), y, z);
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 6), y, z, _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
						} else {
							if (((entity.rotationYaw) > 240)) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate((x + 6), y, z);
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 6), y, z, _ent.rotationYaw, _ent.rotationPitch,
												Collections.emptySet());
									}
								}
							} else {
								if (((entity.rotationYaw) < 150)) {
									{
										Entity _ent = entity;
										_ent.setPositionAndUpdate((x - 3), y, (z - 3));
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 3), y, (z - 3), _ent.rotationYaw,
													_ent.rotationPitch, Collections.emptySet());
										}
									}
								} else {
									if (((entity.rotationYaw) > 210)) {
										{
											Entity _ent = entity;
											_ent.setPositionAndUpdate((x + 3), y, (z - 3));
											if (_ent instanceof ServerPlayerEntity) {
												((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 3), y, (z - 3), _ent.rotationYaw,
														_ent.rotationPitch, Collections.emptySet());
											}
										}
									} else {
										if ((((entity.rotationYaw) < 210) || ((entity.rotationYaw) > 150))) {
											{
												Entity _ent = entity;
												_ent.setPositionAndUpdate(x, y, (z - 6));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, (z - 6), _ent.rotationYaw,
															_ent.rotationPitch, Collections.emptySet());
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
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(GoforwardItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
