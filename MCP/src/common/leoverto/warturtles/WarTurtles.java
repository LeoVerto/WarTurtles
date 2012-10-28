package leoverto.warturtles;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="WarTurtles", name="WarTurtles", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class WarTurtles {

    @Instance("WarTurtles")
	public static WarTurtles instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="leoverto.warturtles.ClientProxy", serverSide="leoverto.warturtles.CommonProxy")
	public static CommonProxy proxy;

	public static int turtleControllerID;
	public static int remoteControllerID;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
        turtleControllerID = config.getOrCreateIntProperty("TurtleControllerID", Configuration.CATEGORY_BLOCK, 2750).getInt(2750);
		remoteControllerID = config.getOrCreateIntProperty("RemoteControllerID", Configuration.CATEGORY_ITEM, 6750).getInt(6750);
		config.save();
	}
	
	private final static Block turtleController = new BlockTurtleController(turtleControllerID);
	private final static Item remoteController = new RemoteController(remoteControllerID);
	
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		
		GameRegistry.registerBlock(turtleController);
		GameRegistry.registerTileEntity(TileEntityTurtleController.class, "turleController");
		
		LanguageRegistry.addName(turtleController, "Turtle Controller");
		LanguageRegistry.addName(remoteController, "Remote Controller");
		
		ItemStack stoneStack = new ItemStack(Block.stone);
		ItemStack redstoneStack = new ItemStack(Item.redstone);
		ItemStack diamondStack = new ItemStack(Item.diamond);
		ItemStack remoteControllerStack = new ItemStack(remoteController);

		GameRegistry.addRecipe(new ItemStack(remoteController), "s s", "rdr", "srs",
		        's', stoneStack, 'r', redstoneStack, 'd', diamondStack);}
	
		//GameRegistry.addRecipe(new ItemStack(turtleController), "srs", "rcr", "srs",
	    //    's', stoneStack, 'r', redstoneStack, 'c', remoteControllerStack);
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
