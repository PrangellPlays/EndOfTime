package net.prangellplays.endoftime;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.prangellplays.endoftime.particle.CODEParticle;
import net.prangellplays.endoftime.particle.CPV2Particle;
import net.prangellplays.endoftime.particle.EndOfTimeParticles;

public class EndOfTimeClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ParticleFactoryRegistry.getInstance().register(EndOfTimeParticles.CODE_PARTICLE, CODEParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(EndOfTimeParticles.CPV2_PARTICLE, CPV2Particle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(EndOfTimeParticles.THE_FORCE_PARTICLE, CPV2Particle.Factory::new);
	}
}