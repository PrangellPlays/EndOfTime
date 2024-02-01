package net.prangellplays.endoftime.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.prangellplays.endoftime.effect.EndOfTimeEffects;
import net.prangellplays.endoftime.registry.EndOfTimeItems;

public class LightsaberItem extends SwordItem {
    public LightsaberItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(7);
        return super.postHit(stack, target, attacker);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).isOf(EndOfTimeItems.LIGHTSABER)) {
                player.addStatusEffect(new StatusEffectInstance(EndOfTimeEffects.THE_FORCE, 2, 0, false, true));
            }
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EndOfTimeItems.LIGHTSABER)) {
                player.addStatusEffect(new StatusEffectInstance(EndOfTimeEffects.THE_FORCE, 2, 0, false, true));
            }
        }
    }
}
