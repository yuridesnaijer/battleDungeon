package com.morgenmiddag.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.morgenmiddag.game.Actors.Yuri;

public class InputHandler implements InputProcessor {

    private Yuri yuri;

    public InputHandler(Yuri yuri){
        this.yuri = yuri;
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.W) {
            yuri.setUpMove(true);
        }
        if (keycode == Input.Keys.A) {
            yuri.setLeftMove(true);
        }
        if (keycode == Input.Keys.S) {
            yuri.setDownMove(true);
        }
        if (keycode == Input.Keys.D) {
            yuri.setRightMove(true);
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W :
                yuri.setUpMove(false);
                break;

            case Input.Keys.A :
                yuri.setLeftMove(false);
                break;

            case Input.Keys.S :
                yuri.setDownMove(false);
                break;

            case Input.Keys.D :
                yuri.setRightMove(false);
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
