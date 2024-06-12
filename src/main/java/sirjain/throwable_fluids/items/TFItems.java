package sirjain.throwable_fluids.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.entity.TFEntityTypes;
import sirjain.throwable_fluids.items.projectiles.ThrowableLavaItem;
import sirjain.throwable_fluids.items.projectiles.ThrowableWaterItem;
import sirjain.throwable_fluids.ThrowableFluids;

public class TFItems {
	public static Item THROWABLE_WATER;
	public static Item THROWABLE_LAVA;
	public static Item WORM_ESSENCE;
	public static Item SPLASHED_GEL;

	public static void registerModItems() {
		THROWABLE_WATER = registerCustomItem("throwable_water", new ThrowableWaterItem(new Item.Settings().maxCount(16)));
		THROWABLE_LAVA = registerCustomItem("throwable_lava", new ThrowableLavaItem(new Item.Settings().maxCount(16)));
		WORM_ESSENCE = registerCustomItem("worm_essence", new WormEssenceItem(new Item.Settings().fireproof()));
		SPLASHED_GEL = registerBasicItem("splashed_gel", new Item.Settings());
	}

	public static void addItemsToTabs() {
		addItemToTab(ItemGroups.FOOD_AND_DRINK, THROWABLE_WATER);
		addItemToTab(ItemGroups.FOOD_AND_DRINK, THROWABLE_LAVA);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.GHAST_TEAR.getDefaultStack(), WORM_ESSENCE.getDefaultStack()));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(WORM_ESSENCE.getDefaultStack(), SPLASHED_GEL.getDefaultStack()));
	}

	public static Item registerCustomItem(String id, Item item) {
		return Registry.register(
			Registries.ITEM,
			new Identifier(ThrowableFluids.MOD_ID, id),
			item
		);
	}

	public static Item registerBasicItem(String id, Item.Settings settings) {
		return Registry.register(
			Registries.ITEM,
			new Identifier(ThrowableFluids.MOD_ID, id),
			new Item(settings)
		);
	}

	public static void addItemToTab(RegistryKey<ItemGroup> group, Item item) {
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}
}