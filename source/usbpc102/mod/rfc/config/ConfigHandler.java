package usbpc102.mod.rfc.config;

import java.io.File;

import usbpc102.mod.rfc.references.ItemInfo;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	
	public static void init(File file) {
		Configuration config = new Configuration(file);
	
		config.load();
		//Läd die ItemID von meinem Item Seed Bag, setzt den wert falls nicht vorganden auf 6000
		ItemInfo.ITEMSEEDBAG_ID = config.getItem(ItemInfo.ITEMSEEDBAG_KEY, ItemInfo.ITEMSEEDBAG_DEFAULT).getInt() - 256;
		
		config.save();
	}

}
