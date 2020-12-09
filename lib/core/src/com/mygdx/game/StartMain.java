package com.mygdx.game;

import com.badlogic.gdx.Game;

public class StartMain extends Game{

    private StartScreen startScreen;
    private GameScreen gameScreen;

    @Override
    public void create() {
        startScreen = new StartScreen(this);
        gameScreen = new GameScreen();
        setScreen(startScreen);
    }

    public void showGameScreen() {
        setScreen(gameScreen);
        startScreen.dispose();
        startScreen = null;
    }

    @Override
    public void dispose() {
        super.dispose();

        startScreen.dispose();
        startScreen = null;
        gameScreen.dispose();
        gameScreen = null;
    }
}
