package com.morgenmiddag.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.morgenmiddag.game.Game;

public class Yuri extends Actor{

    private final Float movementSpeed = 350.0f;
    private final Game game;

    // Input properties
    boolean leftMove = false;
    boolean rightMove = false;
    boolean upMove = false;
    boolean downMove = false;

    // Sprite properties
    private Texture texture;


    public Yuri(Game _game){
        super();

        game = _game;
        texture = game.assets.get("sprites/badlogic.jpg", Texture.class);
        position = new Vector2();
        bounds = new Rectangle(position.x, position.y, texture.getHeight(), texture.getWidth());;
    }

    private void updateMotion() {

        for(Actor actor : game.actorList) {
            if(bounds.overlaps(actor.getBounds())) {
                Gdx.app.log("Collision", "Collision!" + actor.getClass().toString());

            }
        }


        if (leftMove)
        {
            position.x -= movementSpeed * Gdx.graphics.getDeltaTime();
        }
        if (rightMove)
        {
            position.x += movementSpeed * Gdx.graphics.getDeltaTime();
        }
        if (upMove)
        {
            position.y += movementSpeed * Gdx.graphics.getDeltaTime();
        }
        if (downMove)
        {
            position.y -= movementSpeed * Gdx.graphics.getDeltaTime();
        }

        bounds.setPosition(position);
    }

    public void setLeftMove(boolean t)
    {
        if(rightMove && t) rightMove = false;
        leftMove = t;
    }

    public void setUpMove(boolean t)
    {
        if(rightMove && t) rightMove = false;
        upMove = t;
    }

    public void setDownMove(boolean t)
    {
        if(rightMove && t) rightMove = false;
        downMove = t;
    }

    public void setRightMove(boolean t)
    {
        if(leftMove && t) leftMove = false;
        rightMove = t;
    }

    private void update(){
        updateMotion();
    }

    public void render(SpriteBatch spriteBatch){
        this.update();
        spriteBatch.draw(texture, position.x, position.y);
    }
}
