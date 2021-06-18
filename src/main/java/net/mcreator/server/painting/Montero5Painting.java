
package net.mcreator.server.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.server.ServerModElements;

@ServerModElements.ModElement.Tag
public class Montero5Painting extends ServerModElements.ModElement {
	public Montero5Painting(ServerModElements instance) {
		super(instance, 216);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(48, 48).setRegistryName("montero_5"));
	}
}
