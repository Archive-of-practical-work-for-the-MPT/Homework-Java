package net.sebezhko.genesis.block;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropperBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.crafting.conditions.TrueCondition;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sebezhko.genesis.genesis;
import net.sebezhko.genesis.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, genesis.MOD_ID);

    public static final RegistryObject<Block> ANTHILL = registryBlock("anthill",
            () -> new FallingBlock(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.SAND)
                    .strength(0.2F, 8.0F).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> TERMITE_TREE = registryBlock("termite_tree",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(1F, 8.0F).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> SNAIL_BLOCK = registryBlock("snail_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).sound(SoundType.SLIME_BLOCK)
                    .strength(0.4F, 8.0F).requiresCorrectToolForDrops().jumpFactor(2)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> CHITIN_BLOCK = registryBlock("chitin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.BONE_BLOCK)
                    .strength(1.5F, 50.0F).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC);

    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }

    public static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
