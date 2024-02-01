package net.prangellplays.endoftime.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.function.Predicate;

import static net.minecraft.item.BowItem.getPullProgress;
import static net.minecraft.item.RangedWeaponItem.BOW_PROJECTILES;

public class BlasterRifleItem extends Item {
    public BlasterRifleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {

            ArrowItem itemarrow = (ArrowItem) Items.ARROW;
            PersistentProjectileEntity persistentProjectileEntity = itemarrow.createArrow(world, new ItemStack(Items.ARROW), player);
            persistentProjectileEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 5.0f, 0.0F);
            world.spawnEntity(persistentProjectileEntity);
            player.getItemCooldownManager().set(this, 10);
        }

        return TypedActionResult.success(stack);
    }
}
