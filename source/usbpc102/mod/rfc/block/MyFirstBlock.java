package usbpc102.mod.rfc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import usbpc102.mod.rfc.references.BlockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MyFirstBlock extends Block {

	public MyFirstBlock(int id) {
		super(id, Material.iron);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2);
		setStepSound(Block.soundGlassFootstep);
		setUnlocalizedName(BlockInfo.MYFIRSTBLOCK_UNLOCALIZED_NAME);
		
	}
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	@SideOnly(Side.CLIENT)
	private Icon disabledIcon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MYFIRSTBLOCK_TOP);
		bottomIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MYFIRSTBLOCK_BOTTOM);
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MYFIRSTBLOCK_SIDE);
		disabledIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MYFIRSTBLOCK_DISABLED);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	//Bestimmt welche Seite welche Texture bekommen soll. 
	public Icon getIcon(int side, int meta) {
		if (side == 0) {
			return bottomIcon;
		} else if(side == 1) {
			return topIcon;
		} else {
			return isDisabled(meta) ? disabledIcon : sideIcon;
		}	
	}
	
	//Selbsterstellte Methode um zu überprüfen ob MyFirstBlock gerade Deaktiviert ist oder nicht.
	private boolean isDisabled(int meta) {
		return meta % 2 == 1;
	}
	
	@Override
	//Wird von Minecraft aufgerufen, wenn ein Entity auf meinem Block läuft.
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		if (!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z))) {
			spawnAnvil(world, x, y + 20, z);
			
		}
	}
	
	@Override
	//Wird von Minecraft aufgerufen, wenn ein  Block neben meinem Block ein Blockupdate sendet.
	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		int meta = world.getBlockMetadata(x, y, z);
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && !isDisabled(meta) && meta / 2 == 0) {
			for (int i = -2; i <= 2; i++) {
				for (int j = -2; j <=2; j++) {
					spawnAnvil(world, x + i, y + 20, z + j);
				}
			}
			world.setBlockMetadataWithNotify(x, y, z, meta + 2, 3);
			
		} else if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z) && meta > 1){
			world.setBlockMetadataWithNotify(x, y, z, meta - 2, 3);	
		}
	}
	
	//Selbst erstellte Methode um einen Anvil in der Welt zu erstellen.
	private void spawnAnvil(World world, int x, int y, int z) {
		if (world.isAirBlock(x, y, z)) {
			world.setBlock(x, y, z, Block.anvil.blockID);
		}
	}
	
	@Override
	//Wird von Minecraft Aufgerufen, wenn ein Spieler einen Rechtsklich auf meinen Block macht.
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			int meta = world.getBlockMetadata(x, y, z);
			int newMeta = meta % 2 == 0 ? meta + 1 : meta - 1;
			
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
		}
		return true;
	}
	
	
	
}
