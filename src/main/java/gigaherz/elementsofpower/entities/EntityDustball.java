package gigaherz.elementsofpower.entities;

import gigaherz.elementsofpower.ElementsOfPower;
import gigaherz.elementsofpower.blocks.BlockDust;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityDustball extends EntityBallBase {

    public EntityDustball(World worldIn)
    {
        super(ElementsOfPower.earth, worldIn);
    }
    public EntityDustball(World worldIn, EntityLivingBase p_i1774_2_)
    {
        super(ElementsOfPower.earth, worldIn, p_i1774_2_);
    }
    public EntityDustball(World worldIn, double x, double y, double z)
    {
        super(ElementsOfPower.earth, worldIn, x, y, z);
    }
    public EntityDustball(World worldIn, int force, EntityLivingBase p_i1774_2_)
    {
        super(ElementsOfPower.earth, worldIn, force, p_i1774_2_);
    }

    @Override
    protected void spawnBallParticles()
    {
        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX, this.posY, this.posZ,
                    getRandomForParticle(), getRandomForParticle(), getRandomForParticle());
        }
    }

    @Override
    protected void processBlockWithinRadius(BlockPos blockPos, IBlockState currentState, int layers)
    {
        Block block = currentState.getBlock();

        if (block == Blocks.air) {
            worldObj.setBlockState(blockPos, ElementsOfPower.dust.getDefaultState().withProperty(BlockDust.DENSITY, 16));
        }
    }
}