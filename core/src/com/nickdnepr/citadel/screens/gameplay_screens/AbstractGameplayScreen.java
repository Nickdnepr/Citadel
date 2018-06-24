package com.nickdnepr.citadel.screens.gameplay_screens;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nickdnepr.citadel.CitadelGame;
import com.nickdnepr.citadel.mechanics.factories.BasicItemDef;
import com.nickdnepr.citadel.mechanics.items.BasicItem;
import com.nickdnepr.citadel.mechanics.map_utils.GameMap;
import com.nickdnepr.citadel.screens.AbstractScreen;

public abstract class AbstractGameplayScreen extends AbstractScreen {

    protected World world;
    protected Box2DDebugRenderer renderer;
    protected GameMap map;

    public AbstractGameplayScreen(CitadelGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        initWorld();
        loadMap();
    }

    @Override
    public void render(float delta) {
        world.step(delta, 16, 16);
        super.render(delta);
        renderer.render(world, camera.combined);
    }

    protected abstract void loadMap();

    protected abstract void cleanMap();

    public abstract void addItemsToMap(BasicItemDef... items);

    public abstract void removeItemsFromMap(Vector2... positions);

    protected abstract void initWorld();
}
