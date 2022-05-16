package evangamer2018.evantech.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleBatteryItem;

public class BatteryItem extends Item implements SimpleBatteryItem {
    final int capacity;
    final int maxInput;
    final int maxOutput;

    public BatteryItem(Settings settings, int cap, int maxIn, int maxOut) {
        super(settings.maxDamage(cap));

        capacity = cap;
        maxInput = maxIn;
        maxOutput = maxOut;
    }

    public long getEnergyCapacity() {
        return capacity;
    }

    public long getEnergyMaxInput() {
        return maxInput;
    }

    public long getEnergyMaxOutput() {
        return maxOutput;
    }

    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if (stack.getNbt() != null) {
            stack.getNbt().putInt("Damage", capacity - stack.getNbt().getInt("energy"));
        }
    }

    public void postProcessNbt(NbtCompound nbt) {
        nbt.putInt("Damage", capacity - nbt.getInt("energy"));
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new LiteralText(stack.getOrCreateNbt().getLong("energy") + "/" + getEnergyCapacity()).formatted(Formatting.WHITE));
    }
}