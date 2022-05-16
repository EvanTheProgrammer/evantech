package evangamer2018.evantech.recipes.types;

import com.google.gson.JsonObject;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;

// TODO: Remove this when Fabric adds support for items taking damage when crafting with them.
// Related PR: https://github.com/FabricMC/fabric/pull/1180

// Serializer for ItemDamageRecipe
public class ItemDamageRecipeShapedSerializer extends ShapedRecipe.Serializer {
    public static final ItemDamageRecipeShapedSerializer INSTANCE = new ItemDamageRecipeShapedSerializer();
    public static final Identifier ID = new Identifier("evantech", "item_damage_shaped");

    public ShapedRecipe read(Identifier identifier, JsonObject jsonObject) {
        return new ItemDamageRecipeShaped(super.read(identifier, jsonObject));
    }

    public ShapedRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
        return new ItemDamageRecipeShaped(super.read(identifier, packetByteBuf));
    }
}