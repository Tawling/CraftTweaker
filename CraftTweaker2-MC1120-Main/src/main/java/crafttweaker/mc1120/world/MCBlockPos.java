package crafttweaker.mc1120.world;

import crafttweaker.api.util.Position3f;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IFacing;
import crafttweaker.mc1120.util.MCPosition3f;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;


public class MCBlockPos implements IBlockPos{
	
	private BlockPos blockPos;

    public MCBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }
    
    public MCBlockPos(int x, int y, int z) {
    	this.blockPos = new BlockPos(x, y, z);
    }

    @Override
    public int getX() {
		return blockPos.getX();
	}

    @Override
	public int getY() {
		return blockPos.getY();
	}

    @Override
	public int getZ() {
		return blockPos.getZ();
	}

    @Override
	public IBlockPos getOffset(IFacing direction, int offset) {
		return new MCBlockPos(blockPos.offset((EnumFacing) direction.getInternal(), offset));
	}
	

    @Override
	public Position3f asPosition3f() {
		return new MCPosition3f(getX(), getY(), getZ());
	}

	@Override
	public Object getInternal() {
		return blockPos;
	}
	

}
