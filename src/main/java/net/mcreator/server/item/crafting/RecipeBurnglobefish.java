
package net.mcreator.server.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.server.item.ItemPoisondrops;
import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class RecipeBurnglobefish extends ElementsServer.ModElement {
	public RecipeBurnglobefish(ElementsServer instance) {
		super(instance, 56);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.FISH, (int) (1), 3), new ItemStack(ItemPoisondrops.block, (int) (2)), 1F);
	}
}
