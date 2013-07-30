package com.antonfagerberg.blocks;

import com.antonfagerberg.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Wall implements Entity {
    private final SpriteBatch spriteBatch;
    private final Texture texture;
    private final float x, y;

    public Wall(SpriteBatch spriteBatch, Texture texture, int x, int y, Entity[][] level) {
        this.spriteBatch = spriteBatch;
        this.texture = texture;
        level[x][y] = this;
        this.x = x * 32f;
        this.y = y * 32f;
    }

    @Override
    public void render() {
        spriteBatch.draw(texture, x, y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
