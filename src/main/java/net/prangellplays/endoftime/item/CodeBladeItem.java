package net.prangellplays.endoftime.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.prangellplays.endoftime.registry.EndOfTimeItems;
import net.prangellplays.endoftime.effect.EndOfTimeEffects;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CodeBladeItem extends SwordItem {
    public CodeBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.takeKnockback(1.0F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        target.disablesShield();
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).isOf(EndOfTimeItems.CODE_BLADE)) {
                player.addStatusEffect(new StatusEffectInstance(EndOfTimeEffects.CODE, 2, 0, false, true));
            }
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EndOfTimeItems.CODE_BLADE)) {
                player.addStatusEffect(new StatusEffectInstance(EndOfTimeEffects.CODE, 2, 0, false, true));
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        {
            stack.addHideFlag(ItemStack.TooltipSection.MODIFIERS);
            tooltip.add(Text.literal("It seems to have an unstable amount of power...").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.literal(" ").formatted(Formatting.RESET));
            tooltip.add(Text.literal("When in Main Hand:").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("14 Attack Damage").formatted(Formatting.DARK_GREEN));
        }
    }
}