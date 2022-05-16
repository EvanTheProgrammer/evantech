package evangamer2018.evantech.items;

import evangamer2018.evantech.EvanTech;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup EVANTECH = FabricItemGroupBuilder.build(new Identifier(EvanTech.MOD_ID, "evantech"),
            () -> new ItemStack(ModItems.ELECTRON_TUBE));
}
