package net.mcreator.server.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class ProcedureMojitoEaten extends ElementsServer.ModElement {
	public ProcedureMojitoEaten(ElementsServer instance) {
		super(instance, 34);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MojitoEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!entity.world.isRemote && entity.world.getMinecraftServer() != null) {
			entity.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
				@Override
				public String getName() {
					return "";
				}

				@Override
				public boolean canUseCommand(int permission, String command) {
					return true;
				}

				@Override
				public World getEntityWorld() {
					return entity.world;
				}

				@Override
				public MinecraftServer getServer() {
					return entity.world.getMinecraftServer();
				}

				@Override
				public boolean sendCommandFeedback() {
					return false;
				}

				@Override
				public BlockPos getPosition() {
					return entity.getPosition();
				}

				@Override
				public Vec3d getPositionVector() {
					return new Vec3d(entity.posX, entity.posY, entity.posZ);
				}

				@Override
				public Entity getCommandSenderEntity() {
					return entity;
				}
			}, "give @p server:vaso 1");
		}
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, (int) 200, (int) 1, (false), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, (int) 150, (int) 1, (false), (false)));
	}
}
