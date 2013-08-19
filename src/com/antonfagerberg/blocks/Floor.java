package com.antonfagerberg.blocks;

import com.antonfagerberg.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Floor implements Entity {
    private final SpriteBatch spriteBatch;
    private final Texture texture;
    private Rectangle hitbox;
    private final float x, y;

    public Floor(SpriteBatch spriteBatch, Texture texture, int x, int y, Entity[][] level) {
        this.spriteBatch = spriteBatch;
        this.texture = texture;
        level[x][y] = this;
        this.x = x * 32f;
        this.y = y * 32f;
        hitbox = new Rectangle(this.x, this.y, 32f, 32f);
    }

    @Override
    public void render() {
        spriteBatch.draw(texture, x, y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    @Override
    public int id() {
        return Entity.FLOOR;
    }

    @Override
    public com.badlogic.gdx.math.Rectangle hitbox() {
        return hitbox;
    }
}
