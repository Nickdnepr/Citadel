package com.nickdnepr.citadel.mechanics.map_utils;

import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private ArrayList<MapItem> items;

    public GameMap(ArrayList<MapItem> items) {
        this.items = items;
    }

    public GameMap() {
        items = new ArrayList<MapItem>();
    }

    public List<MapItem> getItems() {
        return items;
    }

    public void addItems(MapItem... items) {
        for (MapItem item : items) {
            this.items.add(item);

        }
    }
}
