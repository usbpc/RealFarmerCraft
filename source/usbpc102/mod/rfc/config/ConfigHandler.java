package usbpc102.mod.rfc.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	
	public static void init(File file) {
		Configuration config = new Configuration(file);
	
		config.load();
		
		//int test = config.get("usless stuff",  "example", 5).getInt();
		
		config.save();
	}

}
