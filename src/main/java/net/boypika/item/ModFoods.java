package net.boypika.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModFoods extends FoodComponents {
    public static final FoodComponent WARDEN_HORN =
            (new FoodComponent.Builder()).hunger(3).saturationModifier(0.0F).snack()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 600, 1), 0.9F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 2), 1.0F)
                    .alwaysEdible().build();

    public static final FoodComponent WITHER_STAR =
            (new FoodComponent.Builder()).hunger(3).saturationModifier(0.0F).snack()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 600, 2), 0.9F)
                    .alwaysEdible().build();

    public static final FoodComponent DRAGON_CELL =
            (new FoodComponent.Builder()).hunger(3).saturationModifier(0.0F).snack()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 1), 0.9F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 2), 1.0F)
                    .alwaysEdible().build();

    public static final FoodComponent GUARDIAN_SUSHI =
            (new FoodComponent.Builder()).hunger(3).saturationModifier(0.0F).snack()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 1), 0.9F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 2), 1.0F)
                    .alwaysEdible().build();
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

}
