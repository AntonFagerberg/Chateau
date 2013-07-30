package com.antonfagerberg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements Entity {
    private SpriteBatch spriteBatch;
    private Texture playerTexture;
    private float
        x           = 32f,
        y           = 32f;
    private final float
        moveSpeed   = 1.8f;

    public Player(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        playerTexture = new Texture(Gdx.files.internal("assets/sprites/block.png"));
    }

    @Override
    public void render() {
        spriteBatch.draw(playerTexture, x, y);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += moveSpeed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= moveSpeed;
        } else {
            y = (((int) y + 16) / 32) * 32;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += moveSpeed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= moveSpeed;
        } else {
            x = (((int) x + 16) / 32) * 32;
        }
    }

    @Override
    public void dispose() {
        playerTexture.dispose();
    }
}
