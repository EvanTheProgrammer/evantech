package evangamer2018.evantech.mixin;

import net.minecraft.recipe.ShapelessRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// TODO: Remove this when Fabric adds support for items taking damage when crafting with them.
// Related PR: https://github.com/FabricMC/fabric/pull/1180

// A basic mixin to help add custom shapeless recipes
@Mixin(ShapelessRecipe.class)
public interface ShapelessRecipeMixin {
    @Accessor("group")
    String getGroup();
}