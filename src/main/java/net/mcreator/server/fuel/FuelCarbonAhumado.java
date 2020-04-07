
package net.mcreator.server.fuel;

import net.minecraft.item.ItemStack;

import net.mcreator.server.item.ItemAcarbon;
import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class FuelCarbonAhumado extends ElementsServer.ModElement {
	public FuelCarbonAhumado(ElementsServer instance) {
		super(instance, 2);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(ItemAcarbon.block, (int) (1)).getItem())
			return 2600;
		return 0;
	}
}
