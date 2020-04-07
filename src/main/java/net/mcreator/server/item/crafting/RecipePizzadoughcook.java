
package net.mcreator.server.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.server.item.ItemPizzaDough;
import net.mcreator.server.item.ItemDough;
import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class RecipePizzadoughcook extends ElementsServer.ModElement {
	public RecipePizzadoughcook(ElementsServer instance) {
		super(instance, 19);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemDough.block, (int) (1)), new ItemStack(ItemPizzaDough.block, (int) (1)), 1F);
	}
}
