
package net.mcreator.server.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.server.ServerModElements;

@ServerModElements.ModElement.Tag
public class Montero3Painting extends ServerModElements.ModElement {
	public Montero3Painting(ServerModElements instance) {
		super(instance, 214);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 32).setRegistryName("montero_3"));
	}
}
