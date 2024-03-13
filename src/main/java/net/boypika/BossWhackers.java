package net.boypika;

import net.boypika.config.ModConfig;
import net.boypika.item.ModFoods;
import net.boypika.sword.*;
import net.boypika.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.sound.Sound;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import top.offsetmonkey538.monkeyconfig538.ConfigManager;

public class BossWhackers implements ModInitializer {
	public static String MOD_ID = "bosswhackers";
	public static SwordItem WITHER_WHACKER;
	public static SwordItem DRAGON_WHACKER;
	public static SwordItem WARDEN_WHACKER;
	public static SwordItem GUARDIAN_WHACKER;

	public static Item WARDEN_HORN ;
	public static Item DRAGON_CELL ;
	public static Item WITHER_STAR ;
	public static Item GUARDIAN_SUSHI ;

	public static Item WARDEN_WHACKER_HANDLE ;
	public static Item WITHER_WHACKER_HANDLE ;
	public static Item DRAGON_WHACKER_HANDLE ;
	public static Item GUARDIAN_WHACKER_HANDLE ;

	public static Identifier POWER = new Identifier(MOD_ID, "power");


	public static void registerItems() {

		WARDEN_WHACKER = new WardenWhacker(ToolMaterials.NETHERITE, 7, -2.7f, new FabricItemSettings().fireproof().rarity(Rarity.RARE));
		DRAGON_WHACKER = new DragonWhacker(ToolMaterials.NETHERITE, 5,-1.4f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
		WITHER_WHACKER = new WitherWhacker(ToolMaterials.NETHERITE, 6, -2.1f, new FabricItemSettings().rarity(Rarity.UNCOMMON));
		GUARDIAN_WHACKER = new GuardianWhacker(ToolMaterials.NETHERITE, 4, -2.4f, new FabricItemSettings().rarity(Rarity.COMMON));

		WARDEN_HORN = new Item(new Item.Settings().food(ModFoods.WARDEN_HORN).rarity(Rarity.RARE));
		DRAGON_CELL = new Item(new Item.Settings().food(ModFoods.DRAGON_CELL).rarity(Rarity.EPIC));
		WITHER_STAR = new Item(new Item.Settings().food(ModFoods.WITHER_STAR).rarity(Rarity.UNCOMMON));
		GUARDIAN_SUSHI = new Item(new Item.Settings().food(ModFoods.GUARDIAN_SUSHI).rarity(Rarity.UNCOMMON));

		WARDEN_WHACKER_HANDLE = new Item(new Item.Settings().rarity(Rarity.RARE));
		DRAGON_WHACKER_HANDLE = new Item(new Item.Settings().rarity(Rarity.EPIC));
		WITHER_WHACKER_HANDLE = new Item(new Item.Settings().rarity(Rarity.UNCOMMON));
		GUARDIAN_WHACKER_HANDLE = new Item(new Item.Settings().rarity(Rarity.COMMON));
	}


	public static void registerALL() {
	}

	@Override
	public void onInitialize() {
        SoundEvent SOUNDEVENT = new SOUNDEVENT(POWER);
		Registry.register(Registries.SOUND_EVENT, POWER, SOUNDEVENT);
        ConfigManager.init(new ModConfig(), MOD_ID);
		registerItems();



		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "guardian_whacker"), GUARDIAN_WHACKER);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(Items.NETHERITE_SWORD, GUARDIAN_WHACKER));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "wither_whacker"), WITHER_WHACKER);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(GUARDIAN_WHACKER, WITHER_WHACKER));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dragon_whacker"), DRAGON_WHACKER);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(WITHER_WHACKER, DRAGON_WHACKER));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "warden_whacker"), WARDEN_WHACKER);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(DRAGON_WHACKER, WARDEN_WHACKER));

		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "warden_horn"), WARDEN_HORN);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.addAfter(Items.GOLDEN_APPLE, WARDEN_HORN));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dragon_cell"), DRAGON_CELL);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.addAfter(BossWhackers.WARDEN_HORN, DRAGON_CELL));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "wither_star"), WITHER_STAR);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.addAfter(BossWhackers.DRAGON_CELL, WITHER_STAR));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "guardian_sushi"), GUARDIAN_SUSHI);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.addAfter(BossWhackers.WITHER_STAR, GUARDIAN_SUSHI));

		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "wither_whacker_handle"), WITHER_WHACKER_HANDLE);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(Items.EGG, WITHER_WHACKER_HANDLE));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dragon_whacker_handle"), DRAGON_WHACKER_HANDLE);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(BossWhackers.WITHER_WHACKER_HANDLE, DRAGON_WHACKER_HANDLE));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "warden_whacker_handle"), WARDEN_WHACKER_HANDLE);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(BossWhackers.DRAGON_WHACKER_HANDLE, WARDEN_WHACKER_HANDLE));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "guardian_whacker_handle"), GUARDIAN_WHACKER_HANDLE);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(BossWhackers.WARDEN_WHACKER_HANDLE, GUARDIAN_WHACKER_HANDLE));


		ModLootTableModifiers.modifyLootTables();
		System.out.println("[1.19.3 - 1.20.2] Boss Whackers Init");
	}
	public static ModConfig config() {
		return (ModConfig) ConfigManager.get(MOD_ID);
	}
}