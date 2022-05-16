package evangamer2018.evantech.items;

import evangamer2018.evantech.EvanTech;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class ModItems {
    // Tools
    public static final Item IRON_HAMMER = registerItem("iron_hammer", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH).maxDamage(251)));
    public static final Item IRON_FILE = registerItem("iron_file", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH).maxDamage(251)));
    public static final Item IRON_SCREWDRIVER = registerItem("iron_screwdriver", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH).maxDamage(251)));
    public static final Item IRON_PLIERS = registerItem("iron_pliers", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH).maxDamage(251)));
    // Plates
    public static final Item IRON_PLATE = registerItem("iron_plate", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    public static final Item GOLD_PLATE = registerItem("gold_plate", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    public static final Item COPPER_PLATE = registerItem("copper_plate", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    // Wires
    public static final Item IRON_WIRE = registerItem("iron_wire", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    public static final Item GOLD_WIRE = registerItem("gold_wire", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    public static final Item COPPER_WIRE = registerItem("copper_wire", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    // Wire Coils
    public static final Item IRON_WIRE_COIL = registerItem("iron_wire_coil", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    public static final Item GOLD_WIRE_COIL = registerItem("gold_wire_coil", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    public static final Item COPPER_WIRE_COIL = registerItem("copper_wire_coil", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    // Leads
    public static final Item IRON_LEAD = registerItem("iron_lead", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    public static final Item GOLD_LEAD = registerItem("gold_lead", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    // Misc Components
    public static final Item IRON_STICK = registerItem("iron_stick", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    public static final Item IRON_SCREW = registerItem("iron_screw", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    // Electronic Components
    public static final Item ELECTRON_TUBE = registerItem("electron_tube", new Item(new FabricItemSettings().group(ModItemGroups.EVANTECH)));
    // Batteries
    public static final Item CRUDE_BATTERY = registerItem("crude_battery", new BatteryItem(new FabricItemSettings().group(ModItemGroups.EVANTECH), 50000, 64, 64));

    // Shorthand for registering items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EvanTech.MOD_ID, name), item);
    }

    // Allows main class to register items to the game
    public static void registerModItems() {
        EvanTech.log.info("Registering Items For EvanTech");
    }
}
