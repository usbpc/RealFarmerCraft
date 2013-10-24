package usbpc102.mod.rfc.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import usbpc102.mod.rfc.item.ItemSeedBag;
import usbpc102.mod.rfc.references.ItemInfo;

public class Items {

	private static Item itemSeedBag;
	
	public static void init() {
		//Erstellt eine Instanz von meinem Item(die einzige) und registriert es.
		itemSeedBag =  new ItemSeedBag(ItemInfo.ITEMSEEDBAG_ID);
		GameRegistry.registerItem(itemSeedBag, ItemInfo.ITEMSEEDBAG_KEY);
		
	}
	
	public static void addNames() {
		//Sagt Minecraft wie mein Item ingame heiﬂen soll.
		LanguageRegistry.addName(itemSeedBag, ItemInfo.ITEMSEEDBAG_NAME);
		
	}
}
