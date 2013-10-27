package usbpc102.mod.rfc.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import usbpc102.mod.rfc.references.GuiInfo;

public class GuiSeedBag extends GuiScreen {
	
	ResourceLocation texture = new ResourceLocation(GuiInfo.TEXTURE_LOCATION, GuiInfo.SEEDBAG_GUI_TEXTURE);
	
	public final int ySizeOfTexture = 176;
	public final int xSizeOfTexture = 166;
	public GuiSeedBag(EntityPlayer player) {
		
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		drawDefaultBackground();
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		
		drawTexturedModalRect(posX, posY, 0, 0, ySizeOfTexture, ySizeOfTexture);
		
		super.drawScreen(x, y, f);
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
