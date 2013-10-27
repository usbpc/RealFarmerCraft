package usbpc102.mod.rfc.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import usbpc102.mod.rfc.common.RealFarmerCraft;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(RealFarmerCraft.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
			default: return null;
			case 0: return new ContainerSeedBag(player);
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
			default: return null;
			case 0: return new GuiSeedBag(player);
		}
	}
	
	

}
