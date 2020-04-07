package net.mcreator.server.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class ProcedureGinTonicFoodEaten extends ElementsServer.ModElement {
	public ProcedureGinTonicFoodEaten(ElementsServer instance) {
		super(instance, 11);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GinTonicFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Drunk = 0;
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, (int) 16, (int) 2, (true), (true)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) ((Drunk) + 150), (int) 3, (true), (true)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) (((Drunk) / 2) + 50), (int) 1, (true), (true)));
		Drunk = (double) ((Drunk) + 20);
		if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) == 0)) {
			Drunk = (double) 0;
		}
	}
}
