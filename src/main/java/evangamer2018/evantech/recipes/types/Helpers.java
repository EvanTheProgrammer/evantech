package evangamer2018.evantech.recipes.types;

import evangamer2018.evantech.items.ModItems;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class Helpers {
    public static DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);
        // Go through all the items in the crafting table and damage the items that match the tools.
        for (int i = 0; i < defaultedList.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            Item item = stack.getItem();

            if (item == ModItems.IRON_HAMMER || item == ModItems.IRON_PLIERS || item == ModItems.IRON_SCREWDRIVER || item == ModItems.IRON_FILE) {
                int newDamage = stack.getDamage() + 1;
                if (newDamage < stack.getMaxDamage()) {
                    stack = stack.copy();
                    stack.setDamage(newDamage);
                    defaultedList.set(i, stack);
                }
            } else if (item.hasRecipeRemainder()) {
                defaultedList.set(i, new ItemStack(item.getRecipeRemainder()));
            }
        }
        return defaultedList;
    }
}
