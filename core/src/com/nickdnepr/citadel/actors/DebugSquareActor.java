package com.nickdnepr.citadel.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DebugSquareActor extends Actor {

    private Sprite sprite = new Sprite(new Texture("badlogic.jpg"));

    public DebugSquareActor() {
        setBounds(2, 2, 2, 2);
        sprite.setBounds(2, 2, 2, 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
        //System.out.println("Actor draw");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
