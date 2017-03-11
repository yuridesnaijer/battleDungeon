package com.morgenmiddag.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.morgenmiddag.game.Actors.Npc.Enemy;
import com.morgenmiddag.game.Actors.Yuri;
import com.morgenmiddag.game.Game;
import com.morgenmiddag.game.InputHandler;

public class PlayScreen implements Screen{



    private Game game;
    private TiledMap map;
    private Yuri yuri;
    private Enemy enemy;

    private SpriteBatch spriteBatch;
    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    public PlayScreen(final Game game){
        this.game = game;
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        map = game.assets.get("maps/map.tmx");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Game.V_WIDTH, Game.V_HEIGHT);
        camera.translate(Game.V_WIDTH / 2, Game.V_HEIGHT / 2);

        yuri = new Yuri(this.game, map);
        enemy = new Enemy(this.game);
        game.actorList.add(enemy);

        mapRenderer = new OrthogonalTiledMapRenderer(map, 1f);
        mapRenderer.setView(camera);
        Gdx.input.setInputProcessor(new InputHandler(yuri));
    }

    @Override
    public void render(float delta) {
        camera.position.set(yuri.getPosition(), 0);
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mapRenderer.setView(camera);
        mapRenderer.render();

        spriteBatch.begin();
        yuri.render(spriteBatch);
        enemy.render(spriteBatch);
        spriteBatch.end();

    }

    @Override
    public void resize(int width, int height) {
        camera.viewportHeight = height;
        camera.viewportWidth = width;
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
        spriteBatch.dispose();
        mapRenderer.dispose();
    }
}