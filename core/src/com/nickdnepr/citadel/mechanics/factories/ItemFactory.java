package com.nickdnepr.citadel.mechanics.factories;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.nickdnepr.citadel.mechanics.items.ActorItem;
import com.nickdnepr.citadel.mechanics.items.BasicItem;
import com.nickdnepr.citadel.physics.factories.BodyFactory;

public class ItemFactory {

    public static BasicItem createBasicItem(BasicItemDef itemDef, World world) {
        Body body;
        switch (itemDef.getId()) {

            case BasicItem.ITEM_MAIN_HERO: {
                return createActorItem((ActorItemDef) itemDef, world);
            }
            default: {
                System.out.println("default");
                body = BodyFactory.createRoundedBoxBody(world, itemDef.getPosition().x, itemDef.getPosition().y, 1, 1, 0.02f, BodyDef.BodyType.StaticBody);            }
        }


        return new BasicItem(itemDef.getId(), body);
    }

    public static ActorItem createActorItem(ActorItemDef itemDef, World world) {
        Body body = BodyFactory.createBoxBody(world, itemDef.getPosition().x, itemDef.getPosition().y, 0.95f, 0.95f, BodyDef.BodyType.DynamicBody);
        return new ActorItem(itemDef.getId(), body, itemDef.jumpForce);
    }

}
