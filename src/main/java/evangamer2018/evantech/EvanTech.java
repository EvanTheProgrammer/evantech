package evangamer2018.evantech;

import evangamer2018.evantech.blocks.ModBlocks;
import evangamer2018.evantech.gui.ModGUIs;
import evangamer2018.evantech.items.ModItems;
import evangamer2018.evantech.recipes.types.ItemDamageRecipeShapedSerializer;
import evangamer2018.evantech.recipes.types.ItemDamageRecipeShapelessSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvanTech implements ModInitializer {
    public static final String MOD_ID = "evantech";
    public static final Logger log = LoggerFactory.getLogger("Evan Tech");

    public void onInitialize() {
        // Register Recipe Types
        Registry.register(Registry.RECIPE_SERIALIZER, ItemDamageRecipeShapelessSerializer.ID , ItemDamageRecipeShapelessSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_SERIALIZER, ItemDamageRecipeShapedSerializer.ID , ItemDamageRecipeShapedSerializer.INSTANCE);

        // Register Everything Else
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModBlocks.registerEnergyStorage();
        ModGUIs.registerModGUIs();
        log.info("EvanTech Initialised Successfully");
    }
}