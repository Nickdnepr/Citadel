package com.nickdnepr.citadel.mechanics.factories;

import com.badlogic.gdx.math.Vector2;

public class ActorItemDef extends BasicItemDef{

    protected int jumpForce;

    public ActorItemDef(int id, Vector2 position, int jumpForce) {
        super(id, position);
        this.jumpForce = jumpForce;
    }

    public int getJumpForce() {
        return jumpForce;
    }

    public void setJumpForce(int jumpForce) {
        this.jumpForce = jumpForce;
    }
}
