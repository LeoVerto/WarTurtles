    package leoverto.warturtles;
     
    import net.minecraft.src.EntityArrow;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;
import dan200.computer.api.IComputerAccess;
import dan200.turtle.api.ITurtleAccess;
import dan200.turtle.api.ITurtlePeripheral;
import dan200.turtle.api.ITurtleUpgrade;
import dan200.turtle.api.TurtleSide;
import dan200.turtle.api.TurtleUpgradeType;
import dan200.turtle.api.TurtleVerb;
     
    public class TurtleArcher implements ITurtleUpgrade {
            private static class Peripheral
            implements ITurtlePeripheral
            {
           
     
                    @Override
                    public String getType()
                    {
                            return "Archer";
                    }
                    @Override
                    public String[] getMethodNames()
                    {
                            return new String[] {"test", "test1"};
                    }
                    @Override
                    public Object[] callMethod(IComputerAccess computer, int method, Object[] arguments) throws Exception {
                            switch (method)
                            {
                                    case 0:
                                            computer.queueEvent("test", new Object[] { "test", 1, 2, 3 }); // queue event
                                            return null;
                                    case 1:
                                            return new Object[] {"test1", 1, 2, 3, "blah" }; // return stuff
                                    default:
                                            return null;
                            }
                    }
                    @Override
                    public boolean canAttachToSide(int side)
                    {
                            return true;
                    }
     
                    @Override
                    public void attach(IComputerAccess computer, String computerSide)
                    {
                    }
     
                    @Override
                    public void detach(IComputerAccess computer)
                    {      
                    }
     
                    @Override
                    public void update()
                    {
                            // called once per tick
                    }
                   
            }
            @Override
            public int getUpgradeID()
            {
                    return 233;
            }
           
           
            @Override
            public ItemStack getCraftingItem()
            {
                    return new ItemStack(Item.bow);
            }
           
            @Override
            public TurtleUpgradeType getType()
            {
                    return TurtleUpgradeType.Peripheral;
            }
            @Override
            public String getAdjective()
            {
                    return "Archer";
            }
           
            @Override
            public boolean useTool(ITurtleAccess turtle, TurtleSide side, TurtleVerb verb, int direction) {
                
            	World world = turtle.getWorld();
            	Vec3 pos = turtle.getPosition();
            	double xPos = pos.xCoord;
            	double yPos = pos.yCoord;
            	double zPos = pos.zCoord;
            	
            	EntityArrow arrow = new EntityArrow(world, xPos, yPos, zPos);
            	
            	world.spawnEntityInWorld(arrow);
            	
                 return true;
            }
           
            @Override
            public ITurtlePeripheral createPeripheral(ITurtleAccess turtle,
                            TurtleSide side) {
                    return new Peripheral();
            }
           
            @Override
            public String getIconTexture( ITurtleAccess turtle, TurtleSide side )
            {
                    return "/dan200/computer/client/terrain.png";
            }
           
            @Override
            public int getIconIndex( ITurtleAccess turtle, TurtleSide side )
            {
                    return 128;
            }
           
            @Override
            public boolean isSecret()
            {
                    return false;
            }
                   
    }
