package evangamer2018.evantech.blocks;

import evangamer2018.evantech.gui.ChargerScreenHandler;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class ChargerBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {
    public ChargerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.CRUDE_CHARGER_BLOCK_ENTITY, pos, state);
    }

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public void readNbt(NbtCompound nbt) {
        energyStorage.amount = nbt.getInt("energy");
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("energy", Math.toIntExact(energyStorage.amount));
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ChargerScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            if(index == 0) {
                return Math.toIntExact(energyStorage.amount);
            } else if(index == 1) {
                return Math.toIntExact(energyStorage.capacity);
            }
            return -1;
        }

        @Override
        public void set(int index, int value) {
        }

        @Override
        public int size() {
            return 2;
        }
    };

    @SuppressWarnings("UnstableApiUsage")
    public SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(100000, 64, 64) {
        protected void onFinalCommit() {
            markDirty();
        }
    };

    @SuppressWarnings({"UnstableApiUsage", "unused"})
    public static void tick(World world, BlockPos ignoredPos, BlockState ignoredState, ChargerBlockEntity blockEntity) {
        if (world == null || world.isClient) {
            return;
        }

        EnergyStorageUtil.move(
                blockEntity.energyStorage,
                ContainerItemContext.ofSingleSlot(InventoryStorage.of(blockEntity, null).getSlots().get(0)).find(EnergyStorage.ITEM),
                blockEntity.energyStorage.maxExtract,
                null
        );
    }
}
