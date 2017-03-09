package com.morgenmiddag.game.Actors.Npc;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.morgenmiddag.game.Game;

public class Enemy {

    // Location properties
    private Vector2 position;
    private final Float movementSpeed = 350.0f;

    // Sprite properties
    private Texture texture;

    public Enemy(Game game) {
        texture = game.assets.get("sprites/badlogic.jpg", Texture.class);

        position = new Vector2(100, 100);
    }

    private void update(){
    }

    public void render(SpriteBatch spriteBatch){
        this.update();
        spriteBatch.draw(texture, position.x, position.y);
    }
}
