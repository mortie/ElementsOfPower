package gigaherz.elementsofpower.analyzer;

import gigaherz.elementsofpower.ElementsOfPower;
import gigaherz.elementsofpower.gui.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemAnalyzer extends Item
{
    public ItemAnalyzer()
    {
        setMaxStackSize(1);
        setUnlocalizedName(ElementsOfPower.MODID + ".analyzer");
        setCreativeTab(ElementsOfPower.tabMagic);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        pos = playerIn.getPosition();
        if (!worldIn.isRemote)
            playerIn.openGui(ElementsOfPower.instance, GuiHandler.GUI_ANALYZER, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        BlockPos pos = playerIn.getPosition();
        if (!worldIn.isRemote)
            playerIn.openGui(ElementsOfPower.instance, GuiHandler.GUI_ANALYZER, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }
}