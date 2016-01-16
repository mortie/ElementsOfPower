package gigaherz.elementsofpower.spells.cast.effects;

import gigaherz.elementsofpower.ElementsOfPower;
import gigaherz.elementsofpower.blocks.BlockCushion;
import gigaherz.elementsofpower.spells.cast.Spellcast;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class CushionEffect extends SpellEffect
{
    @Override
    public int getColor(Spellcast cast)
    {
        return 0x000000;
    }

    @Override
    public int getBeamDuration(Spellcast cast)
    {
        return 20 * 5;
    }

    @Override
    public int getBeamInterval(Spellcast cast)
    {
        return 10;
    }

    @Override
    public void processDirectHit(Spellcast cast, Entity e)
    {

    }

    @Override
    public boolean processEntitiesAroundBefore(Spellcast cast, Vec3 hitVec)
    {
        return true;
    }

    @Override
    public void processEntitiesAroundAfter(Spellcast cast, Vec3 hitVec)
    {

    }

    @Override
    public void processBlockWithinRadius(Spellcast cast, BlockPos blockPos, IBlockState currentState, int layers)
    {
        Block block = currentState.getBlock();

        if (block == Blocks.air)
        {
            cast.world.setBlockState(blockPos, ElementsOfPower.cushion.getDefaultState().withProperty(BlockCushion.DENSITY, 16));
        }
    }

    @Override
    public void spawnBallParticles(Spellcast cast, MovingObjectPosition mop)
    {
        for (int i = 0; i < 8; ++i)
        {
            cast.spawnRandomParticle(EnumParticleTypes.WATER_SPLASH,
                    mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord);
        }
    }
}