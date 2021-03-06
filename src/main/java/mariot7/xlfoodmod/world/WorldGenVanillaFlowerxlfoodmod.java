package mariot7.xlfoodmod.world;

import java.util.Random;

import mariot7.xlfoodmod.init.BlockListxlfoodmod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenVanillaFlowerxlfoodmod extends WorldGenerator {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) 
	{
		Block grass = rand.nextBoolean() ? BlockListxlfoodmod.vanilla_flower : BlockListxlfoodmod.vanilla_flower;
		int y = 1 + getGroundFromAbove(worldIn, pos.getX(), pos.getZ());
		if(y >= pos.getY())
		{
			BlockPos bushPos = new BlockPos(pos.getX(), y, pos.getZ());
			Block toReplace = worldIn.getBlockState(bushPos).getBlock();
			if(toReplace == Blocks.AIR || toReplace.getMaterial(null) == Material.PLANTS)
			{
				worldIn.setBlockState(bushPos, grass.getDefaultState(), 2);
			}  
		}
		return false;
	}

	public static int getGroundFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 0)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS;
		}

		return y;
	}

}
