package net.prangellplays.endoftime.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.prangellplays.endoftime.EndOfTime;

public class EndOfTimeParticles {
    public static final DefaultParticleType CODE_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType CPV2_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType THE_FORCE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(EndOfTime.MOD_ID, "code_particle"),
                CODE_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(EndOfTime.MOD_ID, "cpv2_particle"),
                CPV2_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(EndOfTime.MOD_ID, "the_force_particle"),
                THE_FORCE_PARTICLE);
    }
}
