package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.StartMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 240 * 4;
		config.height = 240 * 3;

		config.resizable = false;

		new LwjglApplication(new StartMain(), config);
		//new LwjglApplication(new MyGdxGame(), config);
	}
}
