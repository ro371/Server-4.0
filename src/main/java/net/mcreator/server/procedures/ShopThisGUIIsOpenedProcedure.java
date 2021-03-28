package net.mcreator.server.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.server.item.Coin1Item;
import net.mcreator.server.ServerModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@ServerModElements.ModElement.Tag
public class ShopThisGUIIsOpenedProcedure extends ServerModElements.ModElement {
	public ShopThisGUIIsOpenedProcedure(ServerModElements instance) {
		super(instance, 115);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ShopThisGUIIsOpened!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ShopThisGUIIsOpened!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		entity.getPersistentData().putDouble("coin1", 0);
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((new ItemStack(Coin1Item.block, (int) (1)).getItem() == (itemstackiterator).getItem())) {
						entity.getPersistentData().putDouble("coin1",
								((entity.getPersistentData().getDouble("coin1")) + (((itemstackiterator)).getCount())));
					}
				}
			}
		}
	}
}
