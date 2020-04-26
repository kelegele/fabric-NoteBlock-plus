package com.kelegele.NoteBlockPlus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {

    public static final String MODID = "nbp";

    public static final Item FABRIC_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));//将fabric_item物品注册到杂项组

    public static final Block FABRIC_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).build());


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "fabric_item"), FABRIC_ITEM);//非本地化物品至fabric_item

        Registry.register(Registry.BLOCK, new Identifier(MODID, "fabric_block"), FABRIC_BLOCK);//注册方块
        Registry.register(Registry.ITEM, new Identifier(MODID, "fabric_block"), new BlockItem(FABRIC_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));//将方块注册到ItemGroup中

        System.out.println("Hello Fabric world!");
    }
}
