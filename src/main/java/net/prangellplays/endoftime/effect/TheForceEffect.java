package net.prangellplays.endoftime.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class TheForceEffect extends StatusEffect {
    protected TheForceEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7cd4a1f4-62ba-4dba-a569-08fb9be88f94",
                0.04, EntityAttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "7cd4a1f4-63ba-4dba-a569-08fb9be88f94",
                0.02, EntityAttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, "7cd4a1f4-64ba-4dba-a569-08fb9be88f94",
                0.01, EntityAttributeModifier.Operation.ADDITION);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 0, false, false));
    }


    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
