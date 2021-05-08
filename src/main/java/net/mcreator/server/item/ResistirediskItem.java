
package net.mcreator.server.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.server.ServerModElements;

@ServerModElements.ModElement.Tag
public class ResistirediskItem extends ServerModElements.ModElement {
	@ObjectHolder("server:resistiredisk")
	public static final Item block = null;
	public ResistirediskItem(ServerModElements instance) {
		super(instance, 122);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ServerModElements.sounds.get(new ResourceLocation("server:resistiresound")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("resistiredisk");
		}
	}
}
