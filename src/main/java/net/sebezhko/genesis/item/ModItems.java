package net.sebezhko.genesis.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sebezhko.genesis.genesis;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, genesis.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> BUTTERFLY = ITEMS.register("butterfly",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(ModFood.BUTTERFLY)));

    public static final RegistryObject<Item> CHITIN = ITEMS.register("chitin",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> COWBUG = ITEMS.register("cowbug",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SNAIL = ITEMS.register("snail",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(ModFood.SNAIL)));
}
