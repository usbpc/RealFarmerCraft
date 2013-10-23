package usbpc102.mod.rfc.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import usbpc102.mod.rfc.block.MyFirstBlock;
import usbpc102.mod.rfc.references.BlockInfo;
import net.minecraft.block.Block;

public class Blocks {
	public static Block myFirstBlock;
	
	public static void init() {
		myFirstBlock = new MyFirstBlock(BlockInfo.MYFIRSTBLOCK_ID);
		GameRegistry.registerBlock(myFirstBlock, BlockInfo.MYFIRSTBLOCK_KEY);
		
	}
	
	public static void addNames() {
		LanguageRegistry.addName(myFirstBlock, BlockInfo.MYFIRSTBLOCK_NAME);
		
	}
}
