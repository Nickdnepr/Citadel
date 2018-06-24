package com.nickdnepr.citadel.mechanics.map_utils;

import com.nickdnepr.citadel.mechanics.items.BasicItem;

public class MapLoader {


    public static GameMap getTestMap() {
        GameMap map = new GameMap();
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 1, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 2, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 3, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 4, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 5, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 6, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 7, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 8, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 9, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 10, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 11, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 12, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 13, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 14, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 14, 2));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 14, 3));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 14, 0));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 15, 1));
        map.addItems(new MapItem(BasicItem.ITEM_GROUND, 16, 1));
        map.addItems(new MapItem(BasicItem.ITEM_WOODEN_BOX, 16, 2));
        map.addItems(new MapItem(BasicItem.ITEM_MAIN_HERO, 2, 7));
        return map;
    }

    @Deprecated
    public static GameMap loadMapFromMemory() {
        return null;
    }
}
