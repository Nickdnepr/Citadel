package com.nickdnepr.citadel.physics.factories;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class FixtureDefFactory {

    public static FixtureDef createBox(float width, float height, Vector2 center, float angleInDegrees, float density, float restitution, float friction) {
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2, height / 2, center, angleInDegrees * MathUtils.degreesToRadians);
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.restitution = restitution;
        fixtureDef.friction = friction;
        return fixtureDef;
    }

    public static FixtureDef createChain(Vector2[] vertices, float density, float restitution, float friction) {
        FixtureDef fixtureDef = new FixtureDef();
        ChainShape shape = new ChainShape();
        shape.createChain(vertices);

        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.restitution = restitution;
        fixtureDef.friction = friction;
        return fixtureDef;
    }

    public static FixtureDef createCircle(Vector2 center, float radius, float density, float restitution, float friction){
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setPosition(center);
        shape.setRadius(radius);
        fixtureDef.shape=shape;
        fixtureDef.density = density;
        fixtureDef.restitution = restitution;
        fixtureDef.friction = friction;
        return fixtureDef;
    }

}
