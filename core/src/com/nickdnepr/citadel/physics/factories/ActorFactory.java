package com.nickdnepr.citadel.physics.factories;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.nickdnepr.citadel.mechanics.items.BasicItem;


public class ActorFactory {


    public static BasicItem createItem(World world, float x, float y, int id) {
        Body body;

        switch (id) {
            case BasicItem.ITEM_GROUND: {
                body = BodyFactory.createRoundedBoxBody(world, x, y, 1, 1, 0.02f, BodyDef.BodyType.StaticBody);
                return new BasicItem(id, body);
            }

            case BasicItem.ITEM_MAIN_HERO: {
                body = BodyFactory.createBoxBody(world, x, y, 0.95f, 0.95f, BodyDef.BodyType.DynamicBody);
//                body = BodyFactory.createRoundedBoxBody(world,x,y,1,1,0.2f, BodyDef.BodyType.DynamicBody);
                return new BasicItem(id, body);
            }

            default: {
                body = BodyFactory.createRoundedBoxBody(world, x, y, 1, 1, 0.02f, BodyDef.BodyType.StaticBody);
                return new BasicItem(id, body);
            }
        }

    }
}
