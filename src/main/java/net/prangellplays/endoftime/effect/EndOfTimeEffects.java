package net.prangellplays.endoftime.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.prangellplays.endoftime.EndOfTime;

public class EndOfTimeEffects {

    public static StatusEffect CODE;
    public static StatusEffect CPV2;
    public static StatusEffect THE_FORCE;

    public static StatusEffect registerCODEEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EndOfTime.MOD_ID, name),
                new CodeEffect(StatusEffectCategory.BENEFICIAL, 1476624));
    }
    public static StatusEffect registerCPV2Effect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EndOfTime.MOD_ID, name),
                new CPV2Effect(StatusEffectCategory.BENEFICIAL, 1476624));
    }
    public static StatusEffect registerTheForceEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EndOfTime.MOD_ID, name),
                new TheForceEffect(StatusEffectCategory.BENEFICIAL, 18010050));
    }

    public static void registerEffects(){
        CODE = registerCODEEffect("code");
        CPV2 = registerCPV2Effect("cpv2");
        THE_FORCE = registerTheForceEffect("the_force");
    }

}