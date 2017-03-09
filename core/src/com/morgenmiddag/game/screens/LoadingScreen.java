package com.morgenmiddag.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.morgenmiddag.game.Game;

public class LoadingScreen implements Screen {

    private final Game game;

    private ShapeRenderer shapeRenderer;
    private float progress;

    public LoadingScreen(final Game game) {
        this.game = game;
        this.shapeRenderer = new ShapeRenderer();
    }

    private void queueAssets() {
        game.assets.load("img/splash.png", Texture.class);
        game.assets.load("ui/uiskin.atlas", TextureAtlas.class);
        game.assets.load("sprites/badlogic.jpg", Texture.class);
    }

    @Override
    public void show() {
        System.out.println("LOADING");
        shapeRenderer.setProjectionMatrix(game.camera.combined);
        this.progress = 0f;
        queueAssets();
    }

    private void update(float delta) {
        progress = MathUtils.lerp(progress, game.assets.getProgress(), .1f);
        if (game.assets.update() && progress >= game.assets.getProgress() - .001f) {
            if (Game.DEBUG) {
                game.setScreen(game.playScreen);
                return;
            }

            game.setScreen(game.splashScreen);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(32, game.camera.viewportHeight / 2 - 8, game.camera.viewportWidth - 64, 16);

        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(32, game.camera.viewportHeight / 2 - 8, progress * (game.camera.viewportWidth - 64), 16);

        shapeRenderer.end();
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
        shapeRenderer.dispose();
    }
}