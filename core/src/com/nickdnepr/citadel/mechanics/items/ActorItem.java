package com.nickdnepr.citadel.mechanics.items;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class ActorItem extends BasicItem{

    protected int jumpForce;

    public ActorItem(int id, Body body, int jumpForce) {
        super(id, body);
        this.jumpForce = jumpForce;
    }

    public void jump(){
        body.applyLinearImpulse(new Vector2(0,jumpForce), new Vector2(0,0), true);
    }

    public void goLeft(){

    }

    public void goRight(){
        
    }

}
