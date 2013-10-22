package usbpc102.mod.rfc.block;

import usbpc102.mod.rfc.references.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MyFirstBlock extends Block {

	public MyFirstBlock(int id) {
		super(id, Material.iron);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2);
		setStepSound(Block.soundGlassFootstep);
		setUnlocalizedName(BlockNames.MYFIRSTBLOCK_UNLOCALIZED_NAME);
		
	}

}
