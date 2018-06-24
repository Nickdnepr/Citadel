package com.nickdnepr.citadel.mechanics.map_utils;

public class MapItem {

    private int id;

    private float x;
    private float y;

    public MapItem(int id, float x, float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
