package com.nickdnepr.citadel.screens.gameplay_screens;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nickdnepr.citadel.CitadelGame;
import com.nickdnepr.citadel.screens.AbstractScreen;

public abstract class AbstractGameplayScreen extends AbstractScreen {

    protected World world;
    protected Box2DDebugRenderer renderer;

    public AbstractGameplayScreen(CitadelGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        initWorld();
    }

    protected abstract void initWorld();
}
