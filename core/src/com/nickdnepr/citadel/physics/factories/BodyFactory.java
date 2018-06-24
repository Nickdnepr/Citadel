package com.nickdnepr.citadel.physics.factories;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.nickdnepr.citadel.util.Constants;

public class BodyFactory {

    public static Body createBoxBody(World world, float x, float y, float width, float height, BodyDef.BodyType type) {
        BodyDef bodyDef = BodyDefFactory.createEmptyBody(x, y, type);
        Body body = world.createBody(bodyDef);
        body.createFixture(FixtureDefFactory.createBox(width, height, new Vector2(0, 0), 0, 0.2f, 0.2f, 0.2f));
        return body;
    }

    public static Body createWalls(World world, float x, float y, float width, float height) {
        BodyDef bodyDef = BodyDefFactory.createEmptyBody(x, y, BodyDef.BodyType.StaticBody);
        Body body = world.createBody(bodyDef);
        Vector2[] vert = new Vector2[]{new Vector2(x + Constants.WALLS_SIZE, y + Constants.WALLS_SIZE), new Vector2(width - Constants.WALLS_SIZE, y + Constants.WALLS_SIZE), new Vector2(width - Constants.WALLS_SIZE, height - Constants.WALLS_SIZE), new Vector2(x + Constants.WALLS_SIZE, height - Constants.WALLS_SIZE), new Vector2(x + Constants.WALLS_SIZE, y + Constants.WALLS_SIZE)};
        body.createFixture(FixtureDefFactory.createChain(vert, 0.2f, 0.2f, 0.2f));
        return body;
    }

    public static Body createRoundedBoxBody(World world, float x, float y, float width, float height, float roundRadius, BodyDef.BodyType type) {
        BodyDef bodyDef = BodyDefFactory.createEmptyBody(x, y, type);
        Body body = world.createBody(bodyDef);

        System.out.println(roundRadius);

        Vector2[] verticies = new Vector2[]
                {
                        new Vector2(-width / 2, -height / 2 + roundRadius)
                        , new Vector2(-width / 2 + roundRadius, -height / 2)
                        , new Vector2(+width / 2 - roundRadius, -height / 2)
                        , new Vector2(+width / 2, -height / 2 + roundRadius)
                        , new Vector2(+width / 2, +height / 2 - roundRadius)
                        , new Vector2(+width / 2 - roundRadius, +height / 2)
                        , new Vector2(-width / 2 + roundRadius, +height / 2)
                        , new Vector2(-width / 2, +height / 2 - roundRadius)
                        , new Vector2(-width / 2, -height / 2 + roundRadius)
                };
        body.createFixture(FixtureDefFactory.createChain(verticies, 0.2f, 0.2f, 0.2f));
        body.createFixture(FixtureDefFactory.createCircle(new Vector2(-width / 2+roundRadius, -height / 2+roundRadius), roundRadius, 0.2f, 0.2f, 0.2f));
        body.createFixture(FixtureDefFactory.createCircle(new Vector2(width / 2-roundRadius, -height / 2+roundRadius), roundRadius, 0.2f, 0.2f, 0.2f));
        body.createFixture(FixtureDefFactory.createCircle(new Vector2(width / 2-roundRadius, height / 2-roundRadius), roundRadius, 0.2f, 0.2f, 0.2f));
        body.createFixture(FixtureDefFactory.createCircle(new Vector2(-width / 2+roundRadius, height / 2-roundRadius), roundRadius, 0.2f, 0.2f, 0.2f));
        return body;
    }

    public static Body createTestChainBody(World world, float x, float y) {
        BodyDef bodyDef = BodyDefFactory.createEmptyBody(x, y, BodyDef.BodyType.StaticBody);
        Body body = world.createBody(bodyDef);

        Vector2[] vert = new Vector2[]{new Vector2(-0.5f, -0.5f), new Vector2(-0.5f, +0.5f), new Vector2(+0.5f, +0.5f), new Vector2(+0.5f, -0.5f), new Vector2(-0.5f, -0.5f)};
        body.createFixture(FixtureDefFactory.createChain(vert, 0.2f, 0.2f, 0.2f));
        body.createFixture(FixtureDefFactory.createBox(0.02f, 0.02f, new Vector2(0, 0), 0, 0.2f, 0.2f, 0.2f));
        return body;
    }
}
