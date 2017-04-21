package com.sux.flappyBird.entities;

import com.sux.flappyBird.drawables.DrawableRectangle;

import java.awt.*;

/**
 * Created by Shorty on 8/4/2016.
 * By Chris Coppola
 */
public class Entity extends DrawableRectangle {
    private Color color;

    public Entity(Color color, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
