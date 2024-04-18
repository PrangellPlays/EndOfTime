package net.prangellplays.endoftime.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.prangellplays.endoftime.entity.projectile.BlasterBlast;

public class BlasterBlastItem extends Item {
    public BlasterBlastItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            BlasterBlast blasterBlast = new BlasterBlast(user, world);
            blasterBlast.setItem(itemStack);
            blasterBlast.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            blasterBlast.hasNoGravity();
            blasterBlast.setNoGravity(true);
            world.spawnEntity(blasterBlast);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    public BlasterBlast createBlasterBlast(World world, ItemStack stack, LivingEntity shooter) {
        BlasterBlast blasterBlast = new BlasterBlast(shooter, world);
        blasterBlast.initFromStack(stack);
        return blasterBlast;
    }
}
