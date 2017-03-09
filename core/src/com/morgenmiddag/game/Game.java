package com.morgenmiddag.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import com.morgenmiddag.game.Actors.Actor;
import com.morgenmiddag.game.screens.MainMenuScreen;
import com.morgenmiddag.game.screens.PlayScreen;

import com.badlogic.gdx.graphics.Color;
import com.morgenmiddag.game.screens.SplashScreen;
import com.morgenmiddag.game.screens.LoadingScreen;

import java.util.ArrayList;

public class Game extends com.badlogic.gdx.Game {

	public static final String TITLE = "Slidez";
	public static final float VERSION = .8f;
	public static final int V_WIDTH = 480;
	public static final int V_HEIGHT = 420;
	public static final boolean DEBUG = true;

	public OrthographicCamera camera;
	public SpriteBatch batch;

	public BitmapFont font24;

	public AssetManager assets;
	public ArrayList<Actor> actorList;

	public LoadingScreen loadingScreen;
	public SplashScreen splashScreen;
	public MainMenuScreen mainMenuScreen;
	public PlayScreen playScreen;
	
	@Override
	public void create () {
		assets = new AssetManager();
		actorList = new ArrayList<Actor>();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, V_WIDTH, V_HEIGHT);
		batch = new SpriteBatch();

		initFonts();

		loadingScreen = new LoadingScreen(this);
		splashScreen = new SplashScreen(this);
		mainMenuScreen = new MainMenuScreen(this);
		playScreen = new PlayScreen(this);

		this.setScreen(loadingScreen);
	}

	@Override
	public void render () {
		super.render();

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font24.dispose();
		assets.dispose();
		loadingScreen.dispose();
		splashScreen.dispose();
		mainMenuScreen.dispose();
		playScreen.dispose();
	}

	private void initFonts() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Arcon.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

		params.size = 24;
		params.color = Color.BLACK;
		font24 = generator.generateFont(params);
	}
}
