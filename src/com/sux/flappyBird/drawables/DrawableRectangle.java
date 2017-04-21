package com.sux.flappyBird.drawables;

import com.sux.utils.DebugLogger;

import java.awt.*;

/**
 * Created by Shorty on 8/4/2016.
 * By Chris Coppola
 */
public abstract class DrawableRectangle extends Rectangle implements DebugLogger, Drawable {
    public DrawableRectangle() {
        super();
    }
    public DrawableRectangle(Rectangle r) {
        super(r);
    }
    public DrawableRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public DrawableRectangle(int width, int height) {
        super(width, height);
    }
    public DrawableRectangle(Point p, Dimension d) {
        super(p, d);
    }
    public DrawableRectangle(Point p) {
        super(p);
    }
    public DrawableRectangle(Dimension d) {
        super(d);
    }
}
