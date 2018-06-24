package com.nickdnepr.citadel.physics.factories;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class BodyDefFactory {


    public static BodyDef createEmptyBody(float x, float y, BodyDef.BodyType type) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(x, y);
        return bodyDef;
    }

}
