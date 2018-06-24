package com.nickdnepr.citadel.screens.menu_screens;

import com.badlogic.gdx.Gdx;
import com.nickdnepr.citadel.CitadelGame;
import com.nickdnepr.citadel.mechanics.actors.DebugSquareActor;
import com.nickdnepr.citadel.screens.gameplay_screens.TestGameplayScreen;

public class StartupScreen extends AbstractMenuScreen {

    public StartupScreen(CitadelGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        DebugSquareActor actor = new DebugSquareActor();
        stage.addActor(actor);
    }

    @Override
    protected void initCamera() {
        super.initCamera();
        System.out.println(camera.viewportWidth + " " + camera.viewportHeight);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (Gdx.input.isTouched()) {
            game.setScreen(new TestGameplayScreen(game));
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
    }
}
