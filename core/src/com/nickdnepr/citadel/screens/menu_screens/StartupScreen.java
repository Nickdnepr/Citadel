package com.nickdnepr.citadel.screens.menu_screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.nickdnepr.citadel.CitadelGame;
import com.nickdnepr.citadel.actors.DebugSquareActor;

public class StartupScreen extends AbstractMenuScreen{

    public StartupScreen(CitadelGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        DebugSquareActor actor = new DebugSquareActor();
        actor.addAction(Actions.fadeIn(10));
        stage.addActor(new DebugSquareActor());

    }

    @Override
    protected void initCamera() {
        super.initCamera();

    }

    @Override
    public void render(float delta) {
        super.render(delta);
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