package com.sux.flappyBird.drawables;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Shorty on 8/6/2016.
 * By Chris Coppola
 */
public class DrawableList<T extends DrawableRectangle> extends ArrayList<T> {
    public void drawAll(Graphics g){
        for(T element : this){
            element.draw(g);
        }
    }
}
