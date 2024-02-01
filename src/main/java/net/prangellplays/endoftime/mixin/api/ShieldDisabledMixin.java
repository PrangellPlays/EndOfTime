package net.prangellplays.endoftime.mixin.api;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.prangellplays.endoftime.events.EndOfTimeEvents;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class ShieldDisabledMixin {

    private void shieldDisabledEvent(LivingEntity attacker, CallbackInfo ci) {
        EndOfTimeEvents.SHIELD_DISABLED.invoker().shieldDisabled(PlayerEntity.class.cast(this), attacker);
    }
}
