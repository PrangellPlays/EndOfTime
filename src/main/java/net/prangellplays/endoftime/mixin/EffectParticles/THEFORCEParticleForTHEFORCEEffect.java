package net.prangellplays.endoftime.mixin.EffectParticles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.prangellplays.endoftime.effect.EndOfTimeEffects;
import net.prangellplays.endoftime.particle.EndOfTimeParticles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class THEFORCEParticleForTHEFORCEEffect {



    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Inject(method="tickStatusEffects", at=@At(value="INVOKE", target="Lnet/minecraft/world/World;addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)V", shift= At.Shift.BEFORE), cancellable = true)
    private void useBurnParticle(CallbackInfo info) {

        Entity entity = ((Entity) (Object) this);

        double yVelocity = Math.random()*0.1;

        if(this.hasStatusEffect(EndOfTimeEffects.THE_FORCE)) {
            ((Entity) (Object) this).getWorld().addParticle(EndOfTimeParticles.THE_FORCE_PARTICLE, entity.getParticleX(0.5), entity.getRandomBodyY(), entity.getParticleZ(0.5), 0, yVelocity, 0);
            info.cancel();
        }
    }
}
