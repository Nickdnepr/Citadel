package com.nickdnepr.citadel.mechanics.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BasicItem extends Actor {

    public static final int ITEM_GROUND = 0;
    public static final int ITEM_MAIN_HERO = 1;
    public static final int ITEM_WOODEN_BOX = 2;

    protected int type;
    protected Body body;
    protected Sprite sprite;
    protected Vector2 movingDirectionForce;
    protected boolean isMoving;
    protected long id;


    public BasicItem(int type, Body body) {
        this.type = type;
        this.body = body;
        body.setFixedRotation(true);
        initSprite();
        movingDirectionForce = new Vector2(0, 0);
        isMoving = false;
        id = System.currentTimeMillis();
    }

    public int getType() {
        return type;
    }

    protected void initSprite() {
        Texture texture;

        switch (type) {
            case ITEM_GROUND: {
                texture = new Texture("ground.jpeg");
                sprite = new Sprite(texture);
                sprite.setSize(1, 1);
                break;
            }
            case ITEM_MAIN_HERO: {
                texture = new Texture("person.jpeg");
                sprite = new Sprite(texture);
                sprite.setSize(1, 1);
                break;
            }
            case ITEM_WOODEN_BOX:{
                texture = new Texture("box.jpg");
                sprite = new Sprite(texture);
                sprite.setSize(1, 1);
                break;
            }
            default: {
                texture = new Texture("badlogic.jpg");
                sprite = new Sprite(texture);
                sprite.setSize(1, 1);
            }
        }

        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setPosition(body.getPosition().x, body.getPosition().y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        sprite.setPosition(getX(), getY());
        sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);

//        System.out.println();

        if (isMoving) {
            body.applyForce(movingDirectionForce, body.getPosition(), true);
        }

        super.act(delta);
    }

    public Body getBody() {
        return body;
    }

    public void startMoving(Vector2 movingDirectionForce) {
        this.movingDirectionForce = movingDirectionForce;
        isMoving = true;
    }

    public void stopMoving() {
        isMoving = false;
    }
}
