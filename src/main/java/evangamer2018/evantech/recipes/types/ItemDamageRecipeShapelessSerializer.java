package evangamer2018.evantech.recipes.types;

import com.google.gson.JsonObject;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;

// TODO: Remove this when Fabric adds support for items taking damage when crafting with them.
// Related PR: https://github.com/FabricMC/fabric/pull/1180

// Serializer for ItemDamageRecipe
public class ItemDamageRecipeShapelessSerializer extends ShapelessRecipe.Serializer {
    public static final ItemDamageRecipeShapelessSerializer INSTANCE = new ItemDamageRecipeShapelessSerializer();
    public static final Identifier ID = new Identifier("evantech", "item_damage_shapeless");

    public ShapelessRecipe read(Identifier identifier, JsonObject jsonObject) {
        return new ItemDamageRecipeShapeless(super.read(identifier, jsonObject));
    }

    public ShapelessRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
        return new ItemDamageRecipeShapeless(super.read(identifier, packetByteBuf));
    }
}