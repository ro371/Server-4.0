
package net.mcreator.server.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.server.item.ItemVaso;
import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class RecipeVasocraft extends ElementsServer.ModElement {
	public RecipeVasocraft(ElementsServer instance) {
		super(instance, 27);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.GLASS_BOTTLE, (int) (1)), new ItemStack(ItemVaso.block, (int) (1)), 1F);
	}
}
