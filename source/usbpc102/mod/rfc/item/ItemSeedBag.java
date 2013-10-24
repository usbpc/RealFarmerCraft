package usbpc102.mod.rfc.item;

import usbpc102.mod.rfc.references.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSeedBag extends Item {

	public ItemSeedBag(int id) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("myFirstItem");
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.ITEMSEEDBAG_TEXTURE);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        return false;
    }
	
	//Wird vom Minecraft aufgerufen, wenn mit meinem Item in der Hand ein Rechtsklick gemacht wird.
    /*public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
    	
    	if(par3EntityPlayer.isSneaking() && par2World.isRemote) {
   		 
    		System.out.println("Sneaklick");
    		par3EntityPlayer.addChatMessage("Sneaking");
    		
    		Gives out a list of all players on server
    		System.out.println(par2World.playerEntities);
    		par2World.playerEntities.size();
    		System.out.println(par2World.playerEntities.get(0));
   		 
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
    } */


}
