package com.sux.flappyBird.drawables;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shorty on 8/4/2016.
 * By Chris Coppola
 */
public class DrawableMap<K extends String, V extends DrawableRectangle> extends HashMap<K, V> {
    public void drawAll(Graphics g){
        for (Map.Entry<K, V> entry : entrySet()) {
            entry.getValue().draw(g);
        }
    }
}
