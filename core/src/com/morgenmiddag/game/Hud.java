package com.morgenmiddag.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.morgenmiddag.game.Actors.Yuri;

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private Yuri yuri;

    private int hitPoints;

    public Hud(SpriteBatch spriteBatch, Yuri _yuri){
        yuri = _yuri;
        viewport = new FitViewport(Game.V_WIDTH, Game.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, spriteBatch);

        hitPoints = yuri.getHitPoints();

        Table table = new Table();
        table.bottom();
        table.setFillParent(true);

        table.add(new Label("HP: " + hitPoints, new Label.LabelStyle(new BitmapFont(), Color.BLUE)))
            .expandX()
            .left()
            .pad(10);
        table.row();
        table.add(new Label("SP", new Label.LabelStyle(new BitmapFont(), Color.BLUE)))
            .expandX()
            .left()
            .pad(0, 10, 10, 10);//top, left, bottom, right

        stage.addActor(table);
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
