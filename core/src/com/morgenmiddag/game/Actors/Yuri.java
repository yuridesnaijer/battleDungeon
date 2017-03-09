package com.morgenmiddag.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.morgenmiddag.game.Game;

public class Yuri {

    // Location properties
    private Vector2 position;
    private final Float movementSpeed = 350.0f;

    // Input properties
    boolean leftMove = false;
    boolean rightMove = false;
    boolean upMove = false;
    boolean downMove = false;

    // Sprite properties
    private Texture texture;


    public Yuri(Game game){
        texture = game.assets.get("sprites/badlogic.jpg", Texture.class);

        position = new Vector2();
    }


    private void updateMotion() {
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
