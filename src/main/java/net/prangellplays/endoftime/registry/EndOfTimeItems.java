package net.prangellplays.endoftime.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.prangellplays.endoftime.EndOfTime;
import net.prangellplays.endoftime.item.*;

public class EndOfTimeItems {
    public static final Item LIGHTSABER = registerItem("lightsaber", new LightsaberItem(EndOfTimeToolMaterials.LIGHTSABER, 8, -2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item BLASTER_RIFLE = registerItem("blaster_rifle", new BlasterRifleItem(new FabricItemSettings().maxDamage(0).maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item CPV2 = registerItem("cpv2", new CPV2Item(new FabricItemSettings().maxDamage(0).maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item CODE_BLADE = registerItem("code_blade", new CodeBladeItem(EndOfTimeToolMaterials.CODE, 10, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

        private static void addItemsToBuildingItemGroup(FabricItemGroupEntries entries){
        }
        private static void addItemsToColoredItemGroup(FabricItemGroupEntries entries){
        }
        private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries){
        }
        private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries){
        }
        private static void addItemsToRedstoneItemGroup(FabricItemGroupEntries entries){
        }
        private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        }
        private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
            entries.add(LIGHTSABER);
            entries.add(CPV2);
            entries.add(CODE_BLADE);
            entries.add(BLASTER_RIFLE);
        }
        private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries){
        }
        private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
        }
        private static void addItemsToSpawnItemGroup(FabricItemGroupEntries entries){
        }
        private static void addItemsToOperatorItemGroup(FabricItemGroupEntries entries){
        }

        private static Item registerItem(String name, Item item) {
            return Registry.register(Registries.ITEM, new Identifier(EndOfTime.MOD_ID, name), item);
        }

        public static void registerEndOfTimeItems() {
            EndOfTime.LOGGER.info("Registering Mod Items for " + EndOfTime.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(EndOfTimeItems::addItemsToBuildingItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(EndOfTimeItems::addItemsToColoredItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(EndOfTimeItems::addItemsToNaturalItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(EndOfTimeItems::addItemsToFunctionalItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(EndOfTimeItems::addItemsToRedstoneItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(EndOfTimeItems::addItemsToToolsItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(EndOfTimeItems::addItemsToCombatItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(EndOfTimeItems::addItemsToFoodItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(EndOfTimeItems::addItemsToIngredientsItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(EndOfTimeItems::addItemsToSpawnItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(EndOfTimeItems::addItemsToOperatorItemGroup);
        }
}
