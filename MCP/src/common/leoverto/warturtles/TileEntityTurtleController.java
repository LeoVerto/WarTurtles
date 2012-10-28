package leoverto.warturtles;

import dan200.computer.api.IComputerAccess;
import dan200.computer.api.IPeripheral;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;

public class TileEntityTurtleController extends TileEntity implements IPeripheral {

	@Override
	public String getType() 
	{
		return "TurtleController";
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
	
}