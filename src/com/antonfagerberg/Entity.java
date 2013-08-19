package com.antonfagerberg;

import com.badlogic.gdx.math.Rectangle;

public interface Entity {
    public static int
        PLAYER = 0,
        FLOOR = 1,
        WALL = 2;
    public void render();
    public void dispose();
    public int id();
    public Rectangle hitbox();
}
