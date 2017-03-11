package com.morgenmiddag.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.morgenmiddag.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Game.V_WIDTH;
		config.height = Game.V_HEIGHT;
		config.title = Game.TITLE;

		new LwjglApplication(new Game(), config);
	}
}
