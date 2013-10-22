package usbpc102.mod.rfc.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MyFirstItem extends Item {

	public MyFirstItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("myFirstItem");
	}
	
	

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
    	
    	if(par3EntityPlayer.isSneaking() && par2World.isRemote) {
   		 
    		System.out.println("Sneakklick");
    		par3EntityPlayer.addChatMessage("Sneaking");
    		
    		//Gives out a list of all players on server
    		//System.out.println(par2World.playerEntities);
   		 
   		return par1ItemStack;
   	 }
    	 if(par3EntityPlayer.rayTrace(5.0, 1)!=null) {
             if(par2World.isRemote) {
            	 System.out.println("Player is pointing at a Block");
             }
    	 } else {
    		 System.out.println("Player is not Pointing at a Block");
    	 }
    	 
		return par1ItemStack;
    }


}
