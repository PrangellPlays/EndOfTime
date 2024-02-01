package net.prangellplays.endoftime;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.prangellplays.endoftime.callbacks.EndOfTimeCallbacks;
import net.prangellplays.endoftime.effect.EndOfTimeEffects;
import net.prangellplays.endoftime.particle.EndOfTimeParticles;
import net.prangellplays.endoftime.registry.EndOfTimeItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class EndOfTime implements ModInitializer {
	public static final String MOD_ID = "endoftime";
	public static final Logger LOGGER = LoggerFactory.getLogger("endoftime");

	@Override
	public void onInitialize() {

		EndOfTimeItems.registerEndOfTimeItems();
		EndOfTimeCallbacks.registerCallbacks();
		EndOfTimeEffects.registerEffects();
		EndOfTimeParticles.registerParticles();
	}
	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}