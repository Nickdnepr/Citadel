package com.nickdnepr.citadel.screens.gameplay_screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nickdnepr.citadel.CitadelGame;
import com.nickdnepr.citadel.mechanics.input.OnTheSideInputProcessor;
import com.nickdnepr.citadel.mechanics.items.BasicItem;
import com.nickdnepr.citadel.mechanics.map_utils.MapItem;
import com.nickdnepr.citadel.mechanics.map_utils.MapLoader;
import com.nickdnepr.citadel.physics.factories.ActorFactory;
import com.nickdnepr.citadel.physics.factories.BodyFactory;
import com.nickdnepr.citadel.util.Gravity;

import java.util.HashMap;

public class TestGameplayScreen extends AbstractGameplayScreen {

    private OnTheSideInputProcessor processor;
    private HashMap<Vector2, BasicItem> gameMap;


    public TestGameplayScreen(CitadelGame game) {
        super(game);
    }

    @Override
    protected void initWorld() {
        world = new World(Gravity.GRAVITY_BOTTOM, true);
        renderer = new Box2DDebugRenderer();
    }

    @Override
    public void show() {
        super.show();
        System.out.println("rounded " + Math.round(1.4999));
        BodyFactory.createBoxBody(world, 10, 4, 1, 1, BodyDef.BodyType.DynamicBody);
        BodyFactory.createBoxBody(world, 0, 0, 0.5f, 0.5f, BodyDef.BodyType.StaticBody);
        if (processor != null) {
            Gdx.input.setInputProcessor(processor);
        }
        System.out.println(processor);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        camera.position.set(processor.getActor().getBody().getPosition(), 0);
    }

    @Override
    protected void loadMap() {
        map = MapLoader.getTestMap();
        gameMap = new HashMap<Vector2, BasicItem>();
        for (MapItem item : map.getItems()) {
            BasicItem actor = ActorFactory.createItem(world, item.getX(), item.getY(), item.getId());
            stage.addActor(actor);
            gameMap.put(actor.getBody().getPosition(), actor);
            if (item.getId() == BasicItem.ITEM_MAIN_HERO) {
                processor = new OnTheSideInputProcessor(actor, this);
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        renderer.dispose();
        world.dispose();
    }

    public HashMap<Vector2, BasicItem> getGameMap() {
        return gameMap;
    }
}
