
package net.mcreator.server.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.server.block.BlockAguaCaliente;
import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class RecipeHotwater extends ElementsServer.ModElement {
	public RecipeHotwater(ElementsServer instance) {
		super(instance, 7);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.WATER_BUCKET, (int) (1)), new ItemStack(BlockAguaCaliente.block, (int) (1)), 0F);
	}
}
