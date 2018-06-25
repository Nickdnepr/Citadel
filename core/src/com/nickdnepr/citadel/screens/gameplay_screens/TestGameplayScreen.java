package com.nickdnepr.citadel.screens.gameplay_screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nickdnepr.citadel.CitadelGame;
import com.nickdnepr.citadel.mechanics.factories.BasicItemDef;
import com.nickdnepr.citadel.mechanics.factories.ItemFactory;
import com.nickdnepr.citadel.mechanics.input.OnTheSideInputProcessor;
import com.nickdnepr.citadel.mechanics.items.BasicItem;
import com.nickdnepr.citadel.mechanics.map_utils.MapItem;
import com.nickdnepr.citadel.mechanics.map_utils.MapLoader;
import com.nickdnepr.citadel.physics.factories.ActorFactory;
import com.nickdnepr.citadel.physics.factories.BodyFactory;
import com.nickdnepr.citadel.util.Gravity;

import java.util.ArrayList;
import java.util.HashMap;

public class TestGameplayScreen extends AbstractGameplayScreen {

    private OnTheSideInputProcessor processor;
    private HashMap<Vector2, BasicItem> gameMap;
    private ArrayList<Body> garbage;
    private boolean needCleaning = false;


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
        garbage = new ArrayList<Body>();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
//        System.out.println(1/delta);
        camera.position.set(processor.getActor().getBody().getPosition(), 0);
        if (needCleaning) {
            cleanMap();
        }
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
    protected void cleanMap() {
        System.out.println("started cleaning");
        for (Body body : garbage) {
            world.destroyBody(body);
        }
        needCleaning = false;
        garbage.clear();
        System.out.println(gameMap.size());
    }


    @Override
    public void addItemsToMap(BasicItemDef... items) {
        for (BasicItemDef itemDef : items) {
            BasicItem item = ItemFactory.createBasicItem(itemDef, world);
            System.out.println("adding");
            gameMap.put(item.getBody().getPosition(), item);
            System.out.println(gameMap.size());
            stage.addActor(item);
        }
    }

    @Override
    public void removeItemsFromMap(Vector2... positions) {
        for (Vector2 vector2 : positions) {
            BasicItem item = gameMap.get(vector2);
            if (item == null) {
                continue;
            }
            stage.getActors().removeValue(item, false);
            garbage.add(item.getBody());
            gameMap.remove(item.getBody().getPosition());
            needCleaning = true;
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
