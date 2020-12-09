package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AfterAction;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;

import static java.lang.Math.sqrt;

public class GameScreen extends ScreenAdapter {
    //Texture canvas
    private Stage stage;
    //Texture
    private Texture texture;
    //Actor
    private MyActor actor;
    //IDK, but necessary for inputting
    private static final String TAG = MyGdxGame.class.getSimpleName();


    public GameScreen() {
        Viewport stretchViewport = new StretchViewport(240*4, 240*3);
        stage = new Stage(stretchViewport);
        //stage = new Stage();//without stretch
        //Should be located in assets folder
        texture = new Texture("badlogic.jpg");
        actor = new MyActor(new TextureRegion(texture));
        actor.setPosition(0, 0);
        actor.setScale(0.5f);
        //actor.setRotation(-45); rotate 45° clockwise
        stage.addActor(actor);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.input.setInputProcessor(stage);
        stage.addListener(new StageInputListener());
        actor.addListener(new ActorInputListener());
    }

    @Override
    public void render(float delta) {
        //set clear screen color
        Gdx.gl.glClearColor(0, 0, 0.1f, 0);
        //Clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        texture.dispose();
        stage.dispose();
    }

    public class InputDetect extends ApplicationAdapter{

    }

    private class ActorInputListener extends InputListener {

        @Override
        public boolean keyDown(InputEvent event, int keycode) {
            switch (keycode) {

                case Input.Keys.NUM_1: {
                    Gdx.app.log(TAG, "Drink potion 1");
                    break;
                }
                case Input.Keys.NUM_2: {
                    Gdx.app.log(TAG, "Drink potion 2");
                    break;
                }
                case Input.Keys.NUM_3: {
                    Gdx.app.log(TAG, "Drink potion 3");
                    break;
                }
                case Input.Keys.F: {
                    Gdx.app.log(TAG, "Pick things up");
                    break;
                }
                case Input.Keys.J: {
                    Gdx.app.log(TAG, "Cast spell 1");
                    break;
                }
                case Input.Keys.K: {
                    Gdx.app.log(TAG, "Cast spell 2");
                    break;
                }
                case Input.Keys.L: {
                    Gdx.app.log(TAG, "Cast spell 3");
                    break;
                }
                case Input.Keys.U: {
                    Gdx.app.log(TAG, "Cast spell 4");
                    break;
                }
                case Input.Keys.I: {
                    Gdx.app.log(TAG, "Cast spell 5");
                    break;
                }
                case Input.Keys.O: {
                    Gdx.app.log(TAG, "Cast spell 6");
                    break;
                }
                default: {
                    Gdx.app.log(TAG, "Useless key pressed: " + keycode);
                    break;
                }
            }
            return false;
        }

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            Gdx.app.log(TAG, "touchDown: " + x + ", " + y + "; pointer: " + pointer);
            return true;
        }
    }

    private class StageInputListener extends InputListener {

        @Override
        public boolean keyDown(InputEvent event, int keycode) {
            switch (keycode) {
                case Input.Keys.W: {
                    Gdx.app.log(TAG, "Move up");
                    moveUp();
                    break;
                }
                case Input.Keys.A: {
                    Gdx.app.log(TAG, "Move left ");
                    moveLeft();
                    break;
                }
                case Input.Keys.S: {
                    Gdx.app.log(TAG, "Move down");
                    moveDown();
                    break;
                }
                case Input.Keys.D: {
                    Gdx.app.log(TAG, "Move right");
                    moveRight();
                    break;
                }
                case Input.Keys.Z: {
                    Gdx.app.log(TAG, "Show attribute panel");
                    break;
                }
                case Input.Keys.C: {
                    Gdx.app.log(TAG, "Show skill tree ");
                    break;
                }
                case Input.Keys.UP: {
                    Gdx.app.log(TAG, "Volume up");
                    break;
                }
                case Input.Keys.DOWN: {
                    Gdx.app.log(TAG, "Volume down");
                    break;
                }
                default: {
                    Gdx.app.log(TAG, "Useless key pressed: " + keycode);
                    break;
                }
            }
            return false;
        }

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            Gdx.app.log(TAG, "touchDown: " + x + ", " + y + "; pointer: " + pointer);
            moveTo(x, y);
            return true;
        }

    }
    private void moveTo(float xDim, float yDim){
        float pathLength = (float)(sqrt((xDim- actor.getX())*(xDim- actor.getX())
                                  +(yDim-actor.getY())*(yDim-actor.getY())));
        MoveToAction action = Actions.moveTo(xDim, yDim, pathLength / 200);
        actor.addAction(action);
    }
    private void moveUp() {
        // 2 秒内, 在演员在原位置基础上, 水平方向移动 100, 竖直方向移动 -200
        MoveByAction action = Actions.moveBy(0, 10, 0.05F);
        // 将动作附近在演员身上, 执行动作
        actor.addAction(action);
    }
    private void moveDown() {
        MoveByAction action = Actions.moveBy(0, -10, 0.05F);
        actor.addAction(action);
    }
    private void moveRight() {
        MoveByAction action = Actions.moveBy(10, 0, 0.05F);
        actor.addAction(action);
    }
    private void moveLeft() {
        MoveByAction action = Actions.moveBy(-10, 0, 0.05F);
        actor.addAction(action);
    }
}
