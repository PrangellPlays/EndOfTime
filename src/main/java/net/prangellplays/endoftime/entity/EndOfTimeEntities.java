package net.prangellplays.endoftime.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.prangellplays.endoftime.EndOfTime;
import net.prangellplays.endoftime.entity.projectile.BlasterBlast;

public class EndOfTimeEntities {
    public static final EntityType<BlasterBlast> BLASTER_BLAST = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(EndOfTime.MOD_ID, "blaster_projectile"), FabricEntityTypeBuilder.<BlasterBlast>create(SpawnGroup.MISC, BlasterBlast::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
}
