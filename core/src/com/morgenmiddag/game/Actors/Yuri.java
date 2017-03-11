package com.morgenmiddag.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.morgenmiddag.game.Game;
import com.morgenmiddag.game.Hud;

public class Yuri extends Actor{

    private final Game game;
    private final TiledMap map;
    private Hud hud;

    // Character properties
    private int hitPoints = 120;
    private Float movementSpeed = 350.0f;

    // Input properties
    boolean leftMove = false;
    boolean rightMove = false;
    boolean upMove = false;
    boolean downMove = false;

    // Sprite properties
    private Texture texture;


    public Yuri(Game _game, TiledMap _map){
        super();

        game = _game;
        map = _map;
        texture = game.assets.get("sprites/playerSprite.png", Texture.class);
        position = new Vector2();
        bounds = new Rectangle(position.x, position.y, texture.getHeight(), texture.getWidth());
    }

    private void updateMotion() {

        // Check collision with other actors
        for(Actor actor : game.actorList) {
            if(bounds.overlaps(actor.getBounds())) {
                Gdx.app.log("Collision", "Collision!" + actor.getClass().toString());
                changeHitPoints(-5);

            }
        }

        if (leftMove && !tileCollides("left")) {
            position.x -= movementSpeed * Gdx.graphics.getDeltaTime();
        }
        if (rightMove && !tileCollides("right"))
        {
            position.x += movementSpeed * Gdx.graphics.getDeltaTime();
        }
        if (upMove && !tileCollides("up"))
        {
            position.y += movementSpeed * Gdx.graphics.getDeltaTime();
        }
        if (downMove && !tileCollides("down"))
        {
            position.y -= movementSpeed * Gdx.graphics.getDeltaTime();
        }

        bounds.setPosition(position);
    }

    public void setLeftMove(boolean t)
    {
        if(leftMove && t) leftMove = false;
        leftMove = t;
    }

    public void setUpMove(boolean t)
    {
        if(upMove && t) upMove = false;
        upMove = t;
    }

    public void setDownMove(boolean t)
    {
        if(downMove && t) downMove = false;
        downMove = t;
    }

    public void setRightMove(boolean t)
    {
        if(rightMove && t) rightMove = false;
        rightMove = t;
    }

    public void attachHud(Hud _hud){
        hud = _hud;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void changeHitPoints(int modifier){
        hitPoints += modifier;
        hud.setHitPoints(hitPoints);
    }

    private void update(){
        updateMotion();
    }

    /**
     * This method checks if the tile you are heading to you collides
     * @param side
     * @return
     */
    private boolean tileCollides(String side){
        // TODO: Use bounds instead of position
        TiledMapTileLayer mapLayer = (TiledMapTileLayer) map.getLayers().get(0);
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();

        if(side.equals("left")) {
            cell = mapLayer.getCell((int) (position.x / mapLayer.getTileWidth()), (int) (position.y / mapLayer.getTileHeight()));
        }
        if(side.equals("right")) {
            cell = mapLayer.getCell((int) ((position.x + bounds.width) / mapLayer.getTileWidth()), (int) ((position.y + bounds.height) / mapLayer.getTileHeight()));
        }
        if(side.equals("up")) {
            cell = mapLayer.getCell((int) ((position.x) / mapLayer.getTileWidth()), (int) ((position.y + bounds.height) / mapLayer.getTileHeight()));
        }
        if(side.equals("down")) {
            cell = mapLayer.getCell((int) ((position.x) / mapLayer.getTileWidth()), (int) ((position.y) / mapLayer.getTileHeight()));
        }

        if(cell != null) {
            Gdx.app.log("Tile collision:", "" + cell.getTile().getProperties().containsKey("collision"));
            return cell.getTile().getProperties().containsKey("collision");
        }
        return true;
    }

    public void render(SpriteBatch spriteBatch){
        this.update();
        spriteBatch.draw(texture, position.x, position.y);
    }
}
