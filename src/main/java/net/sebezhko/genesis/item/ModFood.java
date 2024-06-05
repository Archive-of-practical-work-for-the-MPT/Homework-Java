package net.sebezhko.genesis.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    public static final FoodProperties SNAIL = (new FoodProperties.Builder()).nutrition(2)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,100,1),1f).build();
    public static final FoodProperties BUTTERFLY = (new FoodProperties.Builder()).nutrition(1)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION,100,1),1f).build();
}
