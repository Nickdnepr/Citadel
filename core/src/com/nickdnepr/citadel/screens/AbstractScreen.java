package com.nickdnepr.citadel.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.nickdnepr.citadel.CitadelGame;
import com.nickdnepr.citadel.util.Constants;

public abstract class AbstractScreen implements Screen {

    protected CitadelGame game;
    protected OrthographicCamera camera;
    protected Stage stage;

    public AbstractScreen(CitadelGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        initCamera();
        initStage();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        camera.update();
        stage.act(delta);
        stage.draw();
    }

    protected void initCamera() {
        initCamera(Constants.DEFAULT_CAMERA_WIDTH);
    }


    //Height of camera viewport is calculated automatically
    protected void initCamera(float width) {
        float height = width * Constants.CAMERA_WIDTH_TO_HEIGHT_COEFFICIENT;
        camera = new OrthographicCamera(width, height);
    }

    protected void initStage() {
        stage = new Stage(new FitViewport(camera.viewportWidth, camera.viewportHeight, camera));
    }


}
