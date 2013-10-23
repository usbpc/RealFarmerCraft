package usbpc102.mod.rfc.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import usbpc102.mod.rfc.item.MyFirstItem;
import usbpc102.mod.rfc.references.ItemInfo;

public class Items {

	private static Item myFirstItem;
	
	public static void init() {
		myFirstItem =  new MyFirstItem(ItemInfo.MYFIRSTITEM_ID);
		GameRegistry.registerItem(myFirstItem, ItemInfo.MYFIRSTITEM_KEY);
		
	}
	
	public static void addNames() {
		LanguageRegistry.addName(myFirstItem, ItemInfo.MYFIRSTITEM_NAME);
		
	}
}
