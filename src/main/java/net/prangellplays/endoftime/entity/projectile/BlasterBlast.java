package net.prangellplays.endoftime.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;

public class BlasterBlast extends ProjectileEntity {
    public BlasterBlast(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {

    }
}
