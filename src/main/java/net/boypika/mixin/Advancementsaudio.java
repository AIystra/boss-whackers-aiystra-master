package net.boypika.mixin;

import net.boypika.sword.SOUNDEVENT;
import net.fabricmc.api.ModInitializer;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.advancement.criterion.CriterionProgress;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerAdvancementTracker.class)
public class Advancementsaudio implements ModInitializer {

    // Identifier pour votre son
    public static final Identifier POWER_ID = new Identifier("MODID", "power"); // Remplacez MODID par l'ID de votre mod

    @Override
    public void onInitialize() {
        // Enregistrement de votre événement sonore
        SoundEvent soundEvent = new SOUNDEVENT(POWER_ID);
        Registry.register(Registries.SOUND_EVENT, POWER_ID, soundEvent);
    }

    @Inject(method = "grantCriterion", at = @At("RETURN"))
    private void grantCriterion(ServerPlayerEntity player, CriterionProgress criterionProgress, CallbackInfo ci) {
        // Vérifier si le critère correspond à l'accomplissement spécifique
        if (criterionProgress.isObtained()) {
            // Récupérer l'événement sonore enregistré
            SoundEvent soundEvent = Registries.SOUND_EVENT.get(POWER_ID);

            // Récupérer le monde associé au joueur
            ServerWorld world = player.getServerWorld();

            // Jouer le son pour le joueur spécifique
            world.playSound(null, player.getX(), player.getY(), player.getZ(), soundEvent, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }
}
