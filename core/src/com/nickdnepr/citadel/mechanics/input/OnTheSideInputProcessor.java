package com.nickdnepr.citadel.mechanics.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nickdnepr.citadel.mechanics.factories.BasicItemDef;
import com.nickdnepr.citadel.mechanics.items.BasicItem;
import com.nickdnepr.citadel.screens.gameplay_screens.TestGameplayScreen;

public class OnTheSideInputProcessor implements InputProcessor {

    private BasicItem actor;
    private TestGameplayScreen screen;

    public OnTheSideInputProcessor(BasicItem actor, TestGameplayScreen screen) {
        this.actor = actor;
        this.screen = screen;
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("KeyDown " + keycode);
        switch (keycode) {
            case Input.Keys.SPACE: {
                actor.getBody().applyLinearImpulse(new Vector2(0, 1f), new Vector2(actor.getBody().getPosition()), true);
                break;
            }
            case Input.Keys.A: {
                actor.startMoving(new Vector2(-2, 0));
                break;
            }
            case Input.Keys.D: {
                actor.startMoving(new Vector2(2, 0));
                break;
            }

        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        switch (keycode) {


            default: {
                actor.stopMoving();
            }
        }
        return false;
    }


    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        Vector3 vector3 = screen.getCamera().unproject(new Vector3(screenX, screenY, 0));
//        System.out.println(vector3.x + " " + vector3.y);
        Vector2 vector2 = new Vector2(Math.round(vector3.x), Math.round(vector3.y));

        switch (button) {
            case Input.Buttons.LEFT: {
                System.out.println("Left");
                screen.addItemsToMap(new BasicItemDef(BasicItem.ITEM_WOODEN_BOX, vector2));
                break;
            }
            case Input.Buttons.RIGHT: {
                System.out.println("Right");
                screen.removeItemsFromMap(vector2);
                break;
            }
        }
        System.out.println("Clicked");
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Vector3 vector3 = screen.getCamera().unproject(new Vector3(screenX, screenY, 0));
//        System.out.println(vector3.x + " " + vector3.y);
        Vector2 vector2 = new Vector2(Math.round(vector3.x), Math.round(vector3.y));
        if (screen.getGameMap().containsKey(vector2)) {
            System.out.println("is here");
        }

        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public BasicItem getActor() {
        return actor;
    }

    public void setActor(BasicItem actor) {
        this.actor = actor;
    }
}
