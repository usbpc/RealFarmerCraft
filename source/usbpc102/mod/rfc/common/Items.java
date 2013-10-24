package usbpc102.mod.rfc.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import usbpc102.mod.rfc.item.ItemSeedBag;
import usbpc102.mod.rfc.references.ItemInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
	
	public static void addRecipies() {
		GameRegistry.addRecipe(new ItemStack(itemSeedBag), new Object[] {"WWW", "WSW", "WWW", 'W', Block.cloth, 'S', Item.seeds});
		
	}
}
