
package net.mcreator.server.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.server.ServerModElements;

@ServerModElements.ModElement.Tag
public class AloneItem extends ServerModElements.ModElement {
	@ObjectHolder("server:alone")
	public static final Item block = null;
	public AloneItem(ServerModElements instance) {
		super(instance, 103);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ServerModElements.sounds.get(new ResourceLocation("server:alone")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("alone");
		}
	}
}
