package com.nickdnepr.citadel;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nickdnepr.citadel.screens.menu_screens.StartupScreen;

public class CitadelGame extends Game {

	@Override
	public void create() {
		setScreen(new StartupScreen(this));
	}
}
