
package net.mcreator.server.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.server.ServerModElements;

@ServerModElements.ModElement.Tag
public class ShowerdiskItem extends ServerModElements.ModElement {
	@ObjectHolder("server:showerdisk")
	public static final Item block = null;
	public ShowerdiskItem(ServerModElements instance) {
		super(instance, 227);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ServerModElements.sounds.get(new ResourceLocation("server:shower")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("showerdisk");
		}
	}
}
