package com.morgenmiddag.game.Actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Actor {

    // Location properties
    protected Vector2 position;
    protected Rectangle bounds;

    public Actor(){

    }

    protected Rectangle getBounds() {
        return this.bounds;
    }

}
