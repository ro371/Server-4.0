
package net.mcreator.server.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.server.item.AcarbonItem;
import net.mcreator.server.ServerModElements;

@ServerModElements.ModElement.Tag
public class CarbonAhumadoFuel extends ServerModElements.ModElement {
	public CarbonAhumadoFuel(ServerModElements instance) {
		super(instance, 2);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(AcarbonItem.block, (int) (1)).getItem())
			event.setBurnTime(2600);
	}
}
