package usbpc102.mod.rfc.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import usbpc102.mod.rfc.block.MyFirstBlock;
import usbpc102.mod.rfc.references.BlockNames;
import net.minecraft.block.Block;

public class Blocks {
	public static Block myFirstBlock;
	
	public static void init() {
		myFirstBlock = new MyFirstBlock(BlockNames.MYFIRSTBLOCK_ID);
		GameRegistry.registerBlock(myFirstBlock, BlockNames.MYFIRSTBLOCK_KEY);
		
	}
	
	public static void addNames() {
		LanguageRegistry.addName(myFirstBlock, BlockNames.MYFIRSTBLOCK_NAME);
		
	}
}
