
package net.mcreator.server.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.server.item.ItemAcarbon;
import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class RecipeCarbonA extends ElementsServer.ModElement {
	public RecipeCarbonA(ElementsServer instance) {
		super(instance, 4);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.COAL, (int) (1), 0), new ItemStack(ItemAcarbon.block, (int) (1)), 2F);
	}
}
