package evangamer2018.evantech.blocks;

import evangamer2018.evantech.EvanTech;
import evangamer2018.evantech.items.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.reborn.energy.api.EnergyStorage;

public class ModBlocks {
    public static final Block CRUDE_CHARGER_BLOCK = registerBlock("crude_charger", new ChargerBlock(FabricBlockSettings.of(Material.METAL).resistance(8f).hardness(8f)), ModItemGroups.EVANTECH);
    @SuppressWarnings("unchecked")
    public static final BlockEntityType<ChargerBlockEntity> CRUDE_CHARGER_BLOCK_ENTITY = registerBlockEntity("crude_charger_block_entity", FabricBlockEntityTypeBuilder.create(ChargerBlockEntity::new, CRUDE_CHARGER_BLOCK).build(null));

    @SuppressWarnings("SameParameterValue")
    private static Block registerBlock(@SuppressWarnings("SameParameterValue") String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(EvanTech.MOD_ID, name), block);
    }

    @SuppressWarnings({"rawtypes", "SameParameterValue"})
    private static BlockEntityType registerBlockEntity(String name, BlockEntityType blockEntity) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EvanTech.MOD_ID, name), blockEntity);
    }

    public static void registerEnergyStorage() {
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, CRUDE_CHARGER_BLOCK_ENTITY);
    }

    private static void registerBlockItem(String name, Block block, ItemGroup group) {
        Registry.register(Registry.ITEM, new Identifier(EvanTech.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        EvanTech.log.info("Registering Blocks For EvanTech");
    }
}