package net.prangellplays.endoftime.entity.projectile;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.prangellplays.endoftime.entity.EndOfTimeEntities;
import net.prangellplays.endoftime.registry.EndOfTimeItems;

public class BlasterBlast extends ThrownItemEntity {

    public BlasterBlast(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BlasterBlast(LivingEntity livingEntity, World world) {
        super(EndOfTimeEntities.BLASTER_BLAST, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return EndOfTimeItems.BLASTER_BLAST;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof LivingEntity ? 10 : 0;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)i);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age >= 1000) {
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    public void initFromStack(ItemStack stack) {
    }
}
