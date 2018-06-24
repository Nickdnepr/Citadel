package com.nickdnepr.citadel.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.nickdnepr.citadel.mechanics.actors.DebugPhysicsSquareActor;
import com.nickdnepr.citadel.physics.factories.BodyFactory;

public class SeparateScreen implements Screen {

    private OrthographicCamera camera;
    private World world;
    private Box2DDebugRenderer renderer;
    private Stage stage;

    @Override
    public void show() {
        camera = new OrthographicCamera(20, 11.25f);

        world = new World(new Vector2(0, -10), true);
        renderer = new Box2DDebugRenderer();
        stage = new com.badlogic.gdx.scenes.scene2d.Stage(new FitViewport(camera.viewportWidth, camera.viewportHeight, camera));
        stage.addActor(new DebugPhysicsSquareActor(BodyFactory.createBoxBody(world, 5, 5, 1, 1, BodyDef.BodyType.DynamicBody)));
        BodyFactory.createWalls(world, 0, 0, 20, 11.25f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        world.step(delta, 8, 8);
        renderer.render(world, camera.combined);
        camera.update();
        stage.act(delta);
        stage.draw();


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

    }
}
