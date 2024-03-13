package net.boypika.sword;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.server.ServerMetadata;
import net.minecraft.server.command.EffectCommand;
import net.minecraft.text.Text;
import net.minecraft.entity.effect.StatusEffects;
import org.w3c.dom.Entity;

public class WitherWhacker extends SwordItem {
    public WitherWhacker(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 75, 1), attacker);
        if (target instanceof WitherEntity) {
            target.damage(target.getRecentDamageSource(), 13f);
        };
        return super.postHit(stack, target, attacker);
    }
}
