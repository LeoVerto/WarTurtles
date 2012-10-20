package leoverto.warturtles;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class RemoteController extends Item {

	public RemoteController(int id) {
		super(id);
		
		// Constructor Configuration
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabTools);
		setIconIndex(0);
		setItemName("remoteController");
	}
	
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}
}