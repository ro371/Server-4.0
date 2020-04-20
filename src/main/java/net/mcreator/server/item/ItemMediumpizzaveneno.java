
package net.mcreator.server.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.server.procedure.ProcedureDaiquiriVenenoFoodEaten;
import net.mcreator.server.ElementsServer;

@ElementsServer.ModElement.Tag
public class ItemMediumpizzaveneno extends ElementsServer.ModElement {
	@GameRegistry.ObjectHolder("server:mediumpizzaveneno")
	public static final Item block = null;
	public ItemMediumpizzaveneno(ElementsServer instance) {
		super(instance, 69);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("server:mediumpizzaveneno", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(8, 0.6f, false);
			setUnlocalizedName("mediumpizzaveneno");
			setRegistryName("mediumpizzaveneno");
			setAlwaysEdible();
			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(32);
		}

		@Override
		public int getMaxItemUseDuration(ItemStack stack) {
			return 38;
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureDaiquiriVenenoFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
