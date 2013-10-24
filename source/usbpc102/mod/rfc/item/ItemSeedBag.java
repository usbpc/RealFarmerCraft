package usbpc102.mod.rfc.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import usbpc102.mod.rfc.references.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSeedBag extends Item {

	public ItemSeedBag(int id) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setHasSubtypes(true);
		setUnlocalizedName("myFirstItem");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	//Hier wird die Texture für mein Item Seed Bag geladen
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.ITEMSEEDBAG_TEXTURE);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 1024));
		list.add(new ItemStack(id, 1, 0));
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		boolean set = false;
		if (!world.isRemote) {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					int dmg = stack.getItemDamage();
					if (world.getBlockId(x + i, y, z + j) == Block.tilledField.blockID && world.isAirBlock(x + i, y + 1, z + j) && dmg > 0) {
						world.setBlock(x + i, y + 1, z + j, Block.crops.blockID);
						stack.setItemDamage(dmg - 1);
						set = true;
					}
				}
			}
		}	
		return set;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		//stack.setItemDamage(stack.getItemDamage() + 1);
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	//Wird automatisch aufgerufen um den Item Tooltip zu erzeugen
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		
		StringBuilder strb = new StringBuilder();
		strb.append(stack.getItemDamage());
		
		list.add(strb.toString());
		
	}
	@Override
	//TODO: Make Item delete, and other stuff in a diffrent class to use it easy.
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
		if(!world.isRemote && world.getWorldTime() % 5 == 0 &&itemStack.getItemDamage() < 1024 && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			IInventory inventory = player.inventory;
			for(int i = inventory.getSizeInventory() - 1; i > 0; i--) {
				ItemStack stack = inventory.getStackInSlot(i);
				if(stack != null && stack.itemID == Item.seeds.itemID) {
					int size = stack.stackSize;
					int damage = itemStack.getItemDamage();
					if (damage + size > 1024) {
						itemStack.setItemDamage(1024);
						stack.stackSize = size + damage - 1024;
						break;
					}
					itemStack.setItemDamage(damage + size);
					inventory.setInventorySlotContents(i, null);
					if(inventory.getStackInSlot(i) != null && inventory.getStackInSlot(i).stackSize < 0 ) {
						inventory.setInventorySlotContents(i, null);
					}
				}
			}
		}
	}
	/*@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		ItemStack stackInSlot;
		if(entity instanceof EntityPlayer && !world.isRemote && stack.getItemDamage() < 1025 && world.getWorldTime() % 20 == 0) {
			System.out.println("Update!");
			EntityPlayer player = (EntityPlayer) entity;
			for (int i = 0; i < player.inventory.getSizeInventory() + 4; i++) {
				if (player.inventoryContainer.getSlot(i) != null) {
					stackInSlot = player.inventoryContainer.getSlot(i).getStack();
					if (stackInSlot != null && stackInSlot.itemID == Item.seeds.itemID) {
						int size = stackInSlot.stackSize;
						removeItem(player, stackInSlot);
						stack.setItemDamage(stack.getItemDamage() + size);	
					}
				}
			}	
		}	
	}
	
	
	private void removeItem(EntityPlayer ep, ItemStack removeitem) {
		IInventory inv = ep.inventory;
		for(int i=0; i < inv.getSizeInventory(); i++) {
			ItemStack j = inv.getStackInSlot(i);
			if(j != null) {
				if(j.getItem() == removeitem.getItem()) {
					inv.setInventorySlotContents(i, null);
				}
			}
		}
	}*/
	//Wird vom Minecraft aufgerufen, wenn mit meinem Item in der Hand ein Rechtsklick gemacht wird
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
