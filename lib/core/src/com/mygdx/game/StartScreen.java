package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class StartScreen implements Screen{

    private StartMain mainGame;
    private Texture logoTexture;
    private Texture gameTexture;
    private Stage stage;
    private MyActor logoActor;
    private MyActor gameActor;
    private BitmapFont bitmapFont;
    private SpriteBatch batch;
    // 渲染时间步累计变量（当前场景被展示的时间总和）
    private float deltaSum;
    private int r = (int)(System.currentTimeMillis() % 5);


    public StartScreen(StartMain mainGame) {
        batch = new SpriteBatch();
        bitmapFont = new BitmapFont(Gdx.files.internal("font/longshu.fnt"));
        bitmapFont.getData().setScale(0.5f);
        bitmapFont.setColor((float) 205/255, 0,0, 1);

        this.mainGame = mainGame;

        logoTexture = new Texture(Gdx.files.internal("logo.png"));
        gameTexture = new Texture(Gdx.files.internal("iblis.png"));
        stage = new Stage(new StretchViewport(960, 720));

        logoActor = new MyActor(new TextureRegion(logoTexture));
        gameActor = new MyActor(new TextureRegion(gameTexture));
        gameActor.setScale(0.6f);
        logoActor.setPosition(stage.getWidth() / 2 - logoActor.getWidth() / 2,
                              stage.getHeight() / 2 - logoActor.getHeight() / 2);
        gameActor.setPosition((float) (stage.getWidth() / 2 - gameActor.getWidth() * 0.3),
                              (float) (stage.getHeight() / 2 - gameActor.getHeight() * 0.3));

        stage.addActor(logoActor);

    }

    @Override
    public void show() {
        deltaSum = 0;
    }

    @Override
    public void render(float delta) {
        // 累计渲染时间步
        deltaSum += delta;
        if (deltaSum >= 2.0F){
            logoTexture.dispose();
            stage.addActor(gameActor);
        }
        if (deltaSum >= 8.0F) {
            if (mainGame != null) {
                mainGame.showGameScreen();
                return;
            }
        }
        Gdx.gl.glClearColor(0.75F, 1, 0.98F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (deltaSum >= 2.0F){
            Gdx.gl.glClearColor((float) 0 / 255, (float) 0 / 255,
                                (float) 25 / 255, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            if(r == 0)
                bitmapFont.draw(batch, "Do You Know?\n" +
                                           "        The name 'Iblis' comes from Koran", 240, 120);
            if(r == 1)
                bitmapFont.draw(batch, "Do You Know?\n" +
                                           "        Muslims call dissidents 'Iblis', in real life", 240, 120);
            if(r == 2)
                bitmapFont.draw(batch, "Do You Know?\n" +
                                           "        'Iblis' often not commit crimes by itself, but seduce humanity to do so", 200, 120);
            if(r == 3)
                bitmapFont.draw(batch, "Do You Know?\n" +
                                           "        'Iblis' is made by Allah, using fire", 240, 120);
            if(r == 4)
                bitmapFont.draw(batch, "Do You Know?\n" +
                                           "        In the Bible, 'Iblis' is another name of Satan", 240, 120);
            batch.end();
        }

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
        logoTexture.dispose();
    }

}
