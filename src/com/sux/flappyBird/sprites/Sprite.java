package com.sux.flappyBird.sprites;

import com.sux.flappyBird.drawables.DrawableRectangle;

/**
 * Created by Shorty on 8/4/2016.
 * By Chris Coppola
 */
public abstract class Sprite extends DrawableRectangle {
    public Sprite(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    abstract public void update(int ticks);
}
