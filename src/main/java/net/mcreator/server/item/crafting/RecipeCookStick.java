
package net.mcreator.server.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.server.item.ItemDoughStick;
import net.mcreator.server.item.ItemCookedDoughStick;
import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class RecipeCookStick extends ElementsServer.ModElement {
	public RecipeCookStick(ElementsServer instance) {
		super(instance, 50);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemDoughStick.block, (int) (1)), new ItemStack(ItemCookedDoughStick.block, (int) (1)), 1F);
	}
}
