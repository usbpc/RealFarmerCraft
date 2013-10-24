package usbpc102.mod.rfc.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	
	public static void init(File file) {
		Configuration config = new Configuration(file);
	
		config.load();
		//Würde einen Integer aus meine Config File in der Kategorie "usless Stuff" mit dem Namen "example" und dem Standart wert 5.
		//int test = config.get("usless stuff",  "example", 5).getInt();
		
		config.save();
	}

}
