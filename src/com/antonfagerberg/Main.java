package com.antonfagerberg;

import com.antonfagerberg.blocks.Floor;
import com.antonfagerberg.blocks.Wall;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private Player player;
    private Texture
                background,
                wallTexture,
                floorTexture;
    private Entity[][] level;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1024f, 576f);
        spriteBatch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("assets/sprites/background.png"));
        player = new Player(spriteBatch);
        wallTexture = new Texture(Gdx.files.internal("assets/sprites/wall.png"));
        floorTexture = new Texture(Gdx.files.internal("assets/sprites/floor.png"));
        level  = new Entity[18][32];
        createLevel();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0);
        for (Entity[] levelRow: level) {
            for (Entity block : levelRow) {
                if (block != null)
                    block.render();
            }
        }
        player.render();
        spriteBatch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void pause() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        player.dispose();
        background.dispose();
        spriteBatch.dispose();
    }

    public void createLevel() {
        // Column 1
        new Wall(spriteBatch, wallTexture, 0, 0, level);
        new Wall(spriteBatch, wallTexture, 0, 1, level);
        new Floor(spriteBatch, floorTexture, 0, 2, level);
        new Wall(spriteBatch, wallTexture, 0, 3, level);
        new Wall(spriteBatch, wallTexture, 0, 4, level);
        new Wall(spriteBatch, wallTexture, 0, 5, level);
        new Wall(spriteBatch, wallTexture, 0, 6, level);
        new Wall(spriteBatch, wallTexture, 0, 7, level);
        new Wall(spriteBatch, wallTexture, 0, 8, level);
        new Floor(spriteBatch, floorTexture, 0, 9, level);
        new Wall(spriteBatch, wallTexture, 0, 10, level);
        new Wall(spriteBatch, wallTexture, 0, 11, level);
        new Wall(spriteBatch, wallTexture, 0, 12, level);
        new Wall(spriteBatch, wallTexture, 0, 13, level);
        new Wall(spriteBatch, wallTexture, 0, 14, level);
        new Wall(spriteBatch, wallTexture, 0, 15, level);
        new Wall(spriteBatch, wallTexture, 0, 16, level);
        new Wall(spriteBatch, wallTexture, 0, 17, level);
        // Column 2
        new Wall(spriteBatch, wallTexture, 1, 0, level);
        new Floor(spriteBatch, floorTexture, 1, 1, level);
        new Floor(spriteBatch, floorTexture, 1, 2, level);
        new Floor(spriteBatch, floorTexture, 1, 3, level);
        new Wall(spriteBatch, wallTexture, 1, 4, level);
        new Floor(spriteBatch, floorTexture, 1, 5, level);
        new Floor(spriteBatch, floorTexture, 1, 6, level);
        new Floor(spriteBatch, floorTexture, 1, 7, level);
        new Wall(spriteBatch, wallTexture, 1, 8, level);
        new Floor(spriteBatch, floorTexture, 1, 9, level);
        new Wall(spriteBatch, wallTexture, 1, 10, level);
        new Floor(spriteBatch, floorTexture, 1, 11, level);
        new Floor(spriteBatch, floorTexture, 1, 12, level);
        new Floor(spriteBatch, floorTexture, 1, 13, level);
        new Floor(spriteBatch, floorTexture, 1, 14, level);
        new Floor(spriteBatch, floorTexture, 1, 15, level);
        new Floor(spriteBatch, floorTexture, 1, 16,level);
        new Wall(spriteBatch, wallTexture, 1, 17, level);
        // Column 3
        new Wall(spriteBatch, wallTexture, 2, 0, level);
        new Floor(spriteBatch, floorTexture, 2, 1, level);
        new Wall(spriteBatch, wallTexture, 2, 2, level);
        new Floor(spriteBatch, floorTexture, 2, 3, level);
        new Wall(spriteBatch, wallTexture, 2, 4, level);
        new Floor(spriteBatch, floorTexture, 2, 5, level);
        new Wall(spriteBatch, wallTexture, 2, 6, level);
        new Floor(spriteBatch, floorTexture, 2, 7, level);
        new Wall(spriteBatch, wallTexture, 2, 8, level);
        new Floor(spriteBatch, floorTexture, 2, 9, level);
        new Wall(spriteBatch, wallTexture, 2, 10, level);
        new Floor(spriteBatch, floorTexture, 2, 11, level);
        new Wall(spriteBatch, wallTexture, 2, 12, level);
        new Wall(spriteBatch, wallTexture, 2, 13, level);
        new Wall(spriteBatch, wallTexture, 2, 14, level);
        new Wall(spriteBatch, wallTexture, 2, 15, level);
        new Floor(spriteBatch, floorTexture, 2, 16, level);
        new Wall(spriteBatch, wallTexture, 2, 17, level);

        new Wall(spriteBatch, wallTexture, 3, 0, level);
        new Floor(spriteBatch, floorTexture, 3, 1, level);
        new Wall(spriteBatch, wallTexture, 3, 2, level);
        new Floor(spriteBatch, floorTexture, 3, 3, level);
        new Wall(spriteBatch, wallTexture, 3, 4, level);
        new Floor(spriteBatch, floorTexture, 3, 5, level);
        new Floor(spriteBatch, floorTexture, 3, 6, level);
        new Floor(spriteBatch, floorTexture, 3, 7, level);
        new Floor(spriteBatch, floorTexture, 3, 8, level);
        new Floor(spriteBatch, floorTexture, 3, 9, level);
        new Floor(spriteBatch, floorTexture, 3, 10, level);
        new Floor(spriteBatch, floorTexture, 3, 11, level);
        new Wall(spriteBatch, wallTexture, 3, 12, level);
        new Wall(spriteBatch, wallTexture, 3, 13, level);
        new Wall(spriteBatch, wallTexture, 3, 14, level);
        new Wall(spriteBatch, wallTexture, 3, 15, level);
        new Floor(spriteBatch, floorTexture, 3, 16, level);
        new Wall(spriteBatch, wallTexture, 3, 17, level);

        new Wall(spriteBatch, wallTexture, 4, 0, level);
        new Floor(spriteBatch, floorTexture, 4, 1, level);
        new Wall(spriteBatch, wallTexture, 4, 2, level);
        new Floor(spriteBatch, floorTexture, 4, 3, level);
        new Wall(spriteBatch, wallTexture, 4, 4, level);
        new Floor(spriteBatch, floorTexture, 4, 5, level);
        new Wall(spriteBatch, wallTexture, 4, 6, level);
        new Floor(spriteBatch, floorTexture, 4, 7, level);
        new Wall(spriteBatch, wallTexture, 4, 8, level);
        new Floor(spriteBatch, floorTexture, 4, 9, level);
        new Wall(spriteBatch, wallTexture, 4, 10, level);
        new Floor(spriteBatch, floorTexture, 4, 11, level);
        new Wall(spriteBatch, wallTexture, 4, 12, level);
        new Wall(spriteBatch, wallTexture, 4, 13, level);
        new Wall(spriteBatch, wallTexture, 4, 14, level);
        new Wall(spriteBatch, wallTexture, 4, 15, level);
        new Floor(spriteBatch, floorTexture, 4, 16, level);
        new Wall(spriteBatch, wallTexture, 4, 17, level);

        new Wall(spriteBatch, wallTexture, 5, 0, level);
        new Floor(spriteBatch, floorTexture, 5, 1, level);
        new Wall(spriteBatch, wallTexture, 5, 2, level);
        new Floor(spriteBatch, floorTexture, 5, 3, level);
        new Floor(spriteBatch, floorTexture, 5, 4, level);
        new Floor(spriteBatch, floorTexture, 5, 5, level);
        new Floor(spriteBatch, floorTexture, 5, 6, level);
        new Floor(spriteBatch, floorTexture, 5, 7, level);
        new Wall(spriteBatch, wallTexture, 5, 8, level);
        new Floor(spriteBatch, floorTexture, 5, 9, level);
        new Wall(spriteBatch, wallTexture, 5, 10, level);
        new Floor(spriteBatch, floorTexture, 5, 11, level);
        new Floor(spriteBatch, floorTexture, 5, 12, level);
        new Floor(spriteBatch, floorTexture, 5, 13, level);
        new Floor(spriteBatch, floorTexture, 5, 14, level);
        new Floor(spriteBatch, floorTexture, 5, 15, level);
        new Floor(spriteBatch, floorTexture, 5, 16, level);
        new Wall(spriteBatch, wallTexture, 5, 17, level);

        new Wall(spriteBatch, wallTexture, 6, 0, level);
        new Floor(spriteBatch, floorTexture, 6, 1, level);
        new Wall(spriteBatch, wallTexture, 6, 2, level);
        new Wall(spriteBatch, wallTexture, 6, 3, level);
        new Wall(spriteBatch, wallTexture, 6, 4, level);
        new Wall(spriteBatch, wallTexture, 6, 5, level);
        new Wall(spriteBatch, wallTexture, 6, 6, level);
        new Wall(spriteBatch, wallTexture, 6, 7, level);
        new Wall(spriteBatch, wallTexture, 6, 8, level);
        new Floor(spriteBatch, floorTexture, 6, 9, level);
        new Wall(spriteBatch, wallTexture, 6, 10, level);
        new Wall(spriteBatch, wallTexture, 6, 11, level);
        new Wall(spriteBatch, wallTexture, 6, 12, level);
        new Wall(spriteBatch, wallTexture, 6, 13, level);
        new Floor(spriteBatch, floorTexture, 6, 14, level);
        new Wall(spriteBatch, wallTexture, 6, 15, level);
        new Wall(spriteBatch, wallTexture, 6, 16, level);
        new Wall(spriteBatch, wallTexture, 6, 17, level);

        new Wall(spriteBatch, wallTexture, 7, 0, level);
        new Floor(spriteBatch, floorTexture, 7, 1, level);
        new Floor(spriteBatch, floorTexture, 7, 2, level);
        new Floor(spriteBatch, floorTexture, 7, 3, level);
        new Floor(spriteBatch, floorTexture, 7, 4, level);
        new Floor(spriteBatch, floorTexture, 7, 5, level);
        new Floor(spriteBatch, floorTexture, 7, 6, level);
        new Floor(spriteBatch, floorTexture, 7, 7, level);
        new Wall(spriteBatch, wallTexture, 7, 8, level);
        new Floor(spriteBatch, floorTexture, 7, 9, level);
        new Wall(spriteBatch, wallTexture, 7, 10, level);
        new Floor(spriteBatch, floorTexture, 7, 11, level);
        new Floor(spriteBatch, floorTexture, 7, 12, level);
        new Floor(spriteBatch, floorTexture, 7, 13, level);
        new Floor(spriteBatch, floorTexture, 7, 14, level);
        new Floor(spriteBatch, floorTexture, 7, 15, level);
        new Floor(spriteBatch, floorTexture, 7, 16, level);
        new Wall(spriteBatch, wallTexture, 7, 17, level);

        new Wall(spriteBatch, wallTexture, 8, 0, level);
        new Wall(spriteBatch, wallTexture, 8, 1, level);
        new Wall(spriteBatch, wallTexture, 8, 2, level);
        new Wall(spriteBatch, wallTexture, 8, 3, level);
        new Wall(spriteBatch, wallTexture, 8, 4, level);
        new Wall(spriteBatch, wallTexture, 8, 5, level);
        new Wall(spriteBatch, wallTexture, 8, 6, level);
        new Wall(spriteBatch, wallTexture, 8, 7, level);
        new Wall(spriteBatch, wallTexture, 8, 8, level);
        new Floor(spriteBatch, floorTexture, 8, 9, level);
        new Wall(spriteBatch, wallTexture, 8, 10, level);
        new Wall(spriteBatch, wallTexture, 8, 11, level);
        new Floor(spriteBatch, floorTexture, 8, 12, level);
        new Wall(spriteBatch, wallTexture, 8, 13, level);
        new Wall(spriteBatch, wallTexture, 8, 14, level);
        new Wall(spriteBatch, wallTexture, 8, 15, level);
        new Wall(spriteBatch, wallTexture, 8, 16, level);
        new Wall(spriteBatch, wallTexture, 8, 17, level);

        new Floor(spriteBatch, floorTexture, 9, 0, level);
        new Floor(spriteBatch, floorTexture, 9, 1, level);
        new Floor(spriteBatch, floorTexture, 9, 2, level);
        new Floor(spriteBatch, floorTexture, 9, 3, level);
        new Floor(spriteBatch, floorTexture, 9, 4, level);
        new Floor(spriteBatch, floorTexture, 9, 5, level);
        new Floor(spriteBatch, floorTexture, 9, 6, level);
        new Floor(spriteBatch, floorTexture, 9, 7, level);
        new Floor(spriteBatch, floorTexture, 9, 8, level);
        new Floor(spriteBatch, floorTexture, 9, 9, level);
        new Floor(spriteBatch, floorTexture, 9, 10, level);
        new Floor(spriteBatch, floorTexture, 9, 11, level);
        new Floor(spriteBatch, floorTexture, 9, 12, level);
        new Floor(spriteBatch, floorTexture, 9, 13, level);
        new Floor(spriteBatch, floorTexture, 9, 14, level);
        new Floor(spriteBatch, floorTexture, 9, 15, level);
        new Floor(spriteBatch, floorTexture, 9, 16, level);
        new Wall(spriteBatch, wallTexture, 9, 17, level);

        new Wall(spriteBatch, wallTexture, 10, 0, level);
        new Floor(spriteBatch, floorTexture, 10, 1, level);
        new Wall(spriteBatch, wallTexture, 10, 2, level);
        new Wall(spriteBatch, wallTexture, 10, 3, level);
        new Wall(spriteBatch, wallTexture, 10, 4, level);
        new Wall(spriteBatch, wallTexture, 10, 5, level);
        new Wall(spriteBatch, wallTexture, 10, 6, level);
        new Wall(spriteBatch, wallTexture, 10, 7, level);
        new Floor(spriteBatch, floorTexture, 10, 8, level);
        new Wall(spriteBatch, wallTexture, 10, 9, level);
        new Wall(spriteBatch, wallTexture, 10, 10, level);
        new Wall(spriteBatch, wallTexture, 10, 11, level);
        new Wall(spriteBatch, wallTexture, 10, 12, level);
        new Wall(spriteBatch, wallTexture, 10, 13, level);
        new Wall(spriteBatch, wallTexture, 10, 14, level);
        new Wall(spriteBatch, wallTexture, 10, 15, level);
        new Wall(spriteBatch, wallTexture, 10, 16, level);
        new Wall(spriteBatch, wallTexture, 10, 17, level);

        new Wall(spriteBatch, wallTexture, 11, 0, level);
        new Floor(spriteBatch, floorTexture, 11, 1, level);
        new Wall(spriteBatch, wallTexture, 11, 2, level);
        new Floor(spriteBatch, floorTexture, 11, 3, level);
        new Floor(spriteBatch, floorTexture, 11, 4, level);
        new Floor(spriteBatch, floorTexture, 11, 5, level);
        new Floor(spriteBatch, floorTexture, 11, 6, level);
        new Wall(spriteBatch, wallTexture, 11, 7, level);
        new Floor(spriteBatch, floorTexture, 11, 8, level);
        new Wall(spriteBatch, wallTexture, 11, 9, level);
        new Floor(spriteBatch, floorTexture, 11, 10, level);
        new Floor(spriteBatch, floorTexture, 11, 11, level);
        new Floor(spriteBatch, floorTexture, 11, 12, level);
        new Floor(spriteBatch, floorTexture, 11, 13, level);
        new Floor(spriteBatch, floorTexture, 11, 14, level);
        new Wall(spriteBatch, wallTexture, 11, 15, level);
        new Floor(spriteBatch, floorTexture, 11, 16, level);
        new Wall(spriteBatch, wallTexture, 11, 17, level);

        new Wall(spriteBatch, wallTexture, 12, 0, level);
        new Floor(spriteBatch, floorTexture, 12, 1, level);
        new Floor(spriteBatch, floorTexture, 12, 2, level);
        new Floor(spriteBatch, floorTexture, 12, 3, level);
        new Floor(spriteBatch, floorTexture, 12, 4, level);
        new Floor(spriteBatch, floorTexture, 12, 5, level);
        new Floor(spriteBatch, floorTexture, 12, 6, level);
        new Wall(spriteBatch, wallTexture, 12, 7, level);
        new Floor(spriteBatch, floorTexture, 12, 8, level);
        new Wall(spriteBatch, wallTexture, 12, 9, level);
        new Floor(spriteBatch, floorTexture, 12, 10, level);
        new Wall(spriteBatch, wallTexture, 12, 11, level);
        new Wall(spriteBatch, wallTexture, 12, 12, level);
        new Wall(spriteBatch, wallTexture, 12, 13, level);
        new Floor(spriteBatch, floorTexture, 12, 14, level);
        new Wall(spriteBatch, wallTexture, 12, 15, level);
        new Floor(spriteBatch, floorTexture, 12, 16, level);
        new Wall(spriteBatch, wallTexture, 12, 17, level);

        new Wall(spriteBatch, wallTexture, 13, 0, level);
        new Wall(spriteBatch, wallTexture, 13, 1, level);
        new Wall(spriteBatch, wallTexture, 13, 2, level);
        new Floor(spriteBatch, floorTexture, 13, 3, level);
        new Wall(spriteBatch, wallTexture, 13, 4, level);
        new Wall(spriteBatch, wallTexture, 13, 5, level);
        new Wall(spriteBatch, wallTexture, 13, 6, level);
        new Wall(spriteBatch, wallTexture, 13, 7, level);
        new Floor(spriteBatch, floorTexture, 13, 8, level);
        new Wall(spriteBatch, wallTexture, 13, 9, level);
        new Floor(spriteBatch, floorTexture, 13, 10, level);
        new Wall(spriteBatch, wallTexture, 13, 11, level);
        new Floor(spriteBatch, floorTexture, 13, 12, level);
        new Wall(spriteBatch, wallTexture, 13, 13, level);
        new Floor(spriteBatch, floorTexture, 13, 14, level);
        new Wall(spriteBatch, wallTexture, 13, 15, level);
        new Floor(spriteBatch, floorTexture, 13, 16, level);
        new Wall(spriteBatch, wallTexture, 13, 17, level);

        new Wall(spriteBatch, wallTexture, 14, 0, level);
        new Floor(spriteBatch, floorTexture, 14, 1, level);
        new Floor(spriteBatch, floorTexture, 14, 2, level);
        new Floor(spriteBatch, floorTexture, 14, 3, level);
        new Floor(spriteBatch, floorTexture, 14, 4, level);
        new Floor(spriteBatch, floorTexture, 14, 5, level);
        new Floor(spriteBatch, floorTexture, 14, 6, level);
        new Wall(spriteBatch, wallTexture, 14, 7, level);
        new Floor(spriteBatch, floorTexture, 14, 8, level);
        new Floor(spriteBatch, floorTexture, 14, 9, level);
        new Floor(spriteBatch, floorTexture, 14, 10, level);
        new Floor(spriteBatch, floorTexture, 14, 11, level);
        new Floor(spriteBatch, floorTexture, 14, 12, level);
        new Floor(spriteBatch, floorTexture, 14, 13, level);
        new Floor(spriteBatch, floorTexture, 14, 14, level);
        new Floor(spriteBatch, floorTexture, 14, 15, level);
        new Floor(spriteBatch, floorTexture, 14, 16, level);
        new Wall(spriteBatch, wallTexture, 14, 17, level);
    }

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Château";
        config.width = 1440;
        config.height = 900;
        new LwjglApplication(new Main(), config);
    }
}
