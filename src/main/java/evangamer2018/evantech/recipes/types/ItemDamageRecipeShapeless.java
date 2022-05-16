package evangamer2018.evantech.recipes.types;

import evangamer2018.evantech.mixin.ShapelessRecipeMixin;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.collection.DefaultedList;


// TODO: Remove this when Fabric adds support for items taking damage when crafting with them.
// Related PR: https://github.com/FabricMC/fabric/pull/1180

public class ItemDamageRecipeShapeless extends ShapelessRecipe {
    // Set some basic info for the recipe.
    public ItemDamageRecipeShapeless(ShapelessRecipe original) {
        super(
                original.getId(),
                ((ShapelessRecipeMixin) original).getGroup(),
                original.getOutput(),
                original.getIngredients()
        );
    }

    // A function to get the serializer for this recipe type.
    public RecipeSerializer<?> getSerializer() {
        return ItemDamageRecipeShapelessSerializer.INSTANCE;
    }

    // Sets a custom remainder that allows item tools to be damaged when crafting.
    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        return Helpers.getRemainder(inventory);
    }
}