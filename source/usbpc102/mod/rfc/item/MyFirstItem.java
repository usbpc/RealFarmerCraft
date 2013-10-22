package usbpc102.mod.rfc.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MyFirstItem extends Item {

	public MyFirstItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("myFirstItem");
	}

}
