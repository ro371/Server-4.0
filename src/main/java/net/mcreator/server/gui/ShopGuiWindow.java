
package net.mcreator.server.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.server.procedures.ShowpreviousProcedure;
import net.mcreator.server.procedures.ShownextProcedure;
import net.mcreator.server.ServerMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class ShopGuiWindow extends ContainerScreen<ShopGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public ShopGuiWindow(ShopGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 337;
		this.ySize = 201;
	}
	private static final ResourceLocation texture = new ResourceLocation("server:textures/shop.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 38, this.guiTop + 15, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/shoptext.png"));
		this.blit(ms, this.guiLeft + 136, this.guiTop + 10, 0, 0, 64, 32, 64, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + 42, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + 69, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + 96, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + 124, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + 150, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + 177, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 280, this.guiTop + 16, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("server:textures/arrow.png"));
		this.blit(ms, this.guiLeft + 280, this.guiTop + 42, 0, 0, 16, 16, 16, 16);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 213, this.guiTop + 15, 35, 20, new StringTextComponent("->"), e -> {
			if (ShownextProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				ServerMod.PACKET_HANDLER.sendToServer(new ShopGui.ButtonPressedMessage(0, x, y, z));
				ShopGui.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (ShownextProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 15, 35, 20, new StringTextComponent("<-"), e -> {
			if (ShowpreviousProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				ServerMod.PACKET_HANDLER.sendToServer(new ShopGui.ButtonPressedMessage(1, x, y, z));
				ShopGui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (ShowpreviousProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
