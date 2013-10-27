package usbpc102.mod.rfc.common;

import usbpc102.mod.rfc.config.ConfigHandler;
import usbpc102.mod.rfc.gui.GuiHandler;
import usbpc102.mod.rfc.network.PacketHandler;
import usbpc102.mod.rfc.proxy.CommonProxy;
import usbpc102.mod.rfc.references.ModInfo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)


public class RealFarmerCraft {

@Instance(ModInfo.ID)
public static RealFarmerCraft instance;

@SidedProxy(clientSide = "usbpc102.mod.rfc.proxy.ClientProxy", serverSide = "usbpc102.mod.rfc.proxy.CommonProxy")
public static CommonProxy proxy;


    /***
	* This is code that is executed prior to your mod being initialized into of Minecraft
	* Examples of code that could be run here;
	*
	* Initializing your items/blocks (you must do this here)
	* Setting up your own custom logger for writing log data to
	* Loading your language translations for your mod (if your mod has translations for other languages)
	* Registering your mod's key bindings and sounds
	*
	* @param event The Forge ModLoader pre-initialization event
	*/
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	ConfigHandler.init(event.getSuggestedConfigurationFile());
    	Blocks.init();
    	Items.init();
    
    }
    
    /***
* This is code that is executed when your mod is being initialized in Minecraft
* Examples of code that could be run here;
*
* Registering your GUI Handler
* Registering your different event listeners
* Registering your different tile entities
* Adding in any recipes you have
*
* @param event The Forge ModLoader initialization event
*/
    @EventHandler
    public void init(FMLInitializationEvent event) {
        new GuiHandler();
        Blocks.addNames();
        Items.addNames();
        
        Items.addRecipies();
    }
    
    /***
* This is code that is executed after all mods are initialized in Minecraft
* This is a good place to execute code that interacts with other mods (ie, loads an addon module
* of your mod if you find a particular mod).
*
* @param event The Forge ModLoader post-initialization event
*/
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}