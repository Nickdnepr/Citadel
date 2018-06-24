package com.nickdnepr.citadel.mechanics.items;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class ActorItem extends BasicItem{

    public ActorItem(int id, Body body) {
        super(id, body);
    }

    public void jump(){
        body.applyLinearImpulse(new Vector2(0,5), new Vector2(0,0), true);
    }

    public void goLeft(){

    }

    public void goRight(){
        
    }

}
