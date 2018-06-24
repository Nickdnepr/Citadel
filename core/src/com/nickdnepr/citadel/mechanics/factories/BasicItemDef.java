package com.nickdnepr.citadel.mechanics.factories;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class BasicItemDef {
    private int id;
    private Vector2 position;

    public BasicItemDef() {
    }

    public BasicItemDef(int id, Vector2 position) {
        this.id = id;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

}
