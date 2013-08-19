package com.antonfagerberg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player implements Entity {
    private SpriteBatch spriteBatch;
    private Texture playerTexture;
    private Entity[][] level;
    private final float
        moveSpeed = 1.8f,
        hitboxMargin = 6f;
    private final int
        blockSize = 32;
    private float
        x = 32f,
        y = 32f,
        newX = x,
        newY = y;
    private int
        positionX = (int) x / blockSize,
        positionY = (int) y / blockSize;
    private Rectangle hitBox;
    private Entity ur, uu, ul, ll, dl, dd, dr, rr;


    public Player(SpriteBatch spriteBatch, Entity[][] level) {
        playerTexture = new Texture(Gdx.files.internal("assets/sprites/block.png"));
        this.spriteBatch = spriteBatch;
        this.level = level;
        hitBox = new Rectangle(x + hitboxMargin, y + hitboxMargin, playerTexture.getWidth() - 2f * hitboxMargin, playerTexture.getHeight() - 2f * hitboxMargin);
    }

    @Override
    public void render() {
        positionX = ((int) x + blockSize / 2) / blockSize;
        positionY = ((int) y + blockSize / 2) / blockSize;

        try { ul = level[positionX - 1][positionY + 1]; } catch (IndexOutOfBoundsException e) { ul = null; }
        try { uu = level[positionX][positionY + 1]; } catch (IndexOutOfBoundsException e) { uu = null; }
        try { ur = level[positionX + 1][positionY + 1]; } catch (IndexOutOfBoundsException e) { ur = null; }
        try { rr = level[positionX + 1][positionY]; } catch (IndexOutOfBoundsException e) { rr = null; }
        try { ll = level[positionX - 1][positionY]; } catch (IndexOutOfBoundsException e) { ll = null; }
        try { dl = level[positionX - 1][positionY - 1]; } catch (IndexOutOfBoundsException e) { dl = null; }
        try { dd = level[positionX][positionY - 1]; } catch (IndexOutOfBoundsException e) { dd = null; }
        try { dr = level[positionX + 1][positionY - 1]; } catch (IndexOutOfBoundsException e) { dr = null; }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            newY = y + moveSpeed;
            hitBox.setY(newY + hitboxMargin);

            if (!collision(ul, hitBox) && !collision(uu, hitBox) && !collision(ur, hitBox)) {
                y = newY;
            } else {
                hitBox.setY(y + hitboxMargin);
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            newY = y - moveSpeed;
            hitBox.setY(newY + hitboxMargin);

            if (!collision(dl, hitBox) && !collision(dd, hitBox) && !collision(dr, hitBox)) {
                y = newY;
            } else {
                hitBox.setY(y + hitboxMargin);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            newX = x + moveSpeed;
            hitBox.setX(newX + hitboxMargin);

            if (!collision(ur, hitBox) && !collision(rr, hitBox) && !collision(dr, hitBox)) {
                x = newX;
            } else {
                hitBox.setX(x + hitboxMargin);
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            newX = x - moveSpeed;
            hitBox.setX(newX + hitboxMargin);

            if (!collision(ul, hitBox) && !collision(ll, hitBox) && !collision(dl, hitBox)) {
                x = newX;
            } else {
                hitBox.setX(x + hitboxMargin);
            }
        }

        spriteBatch.draw(playerTexture, x, y);
    }

    public boolean collision(Entity entity, Rectangle hitbox) {
        return entity != null && entity.id() == Entity.WALL && hitbox.overlaps(entity.hitbox());
    }

    @Override
    public void dispose() {
        playerTexture.dispose();
    }

    @Override
    public int id() {
        return Entity.PLAYER;
    }

    @Override
    public Rectangle hitbox() {
        return hitBox;
    }
}
