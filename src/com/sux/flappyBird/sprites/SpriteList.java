package com.sux.flappyBird.sprites;

import com.sux.flappyBird.drawables.DrawableList;

/**
 * Created by Shorty on 8/6/2016.
 * By Chris Coppola
 */
public class SpriteList extends DrawableList<Sprite> {
    public void updateAll(int ticks){
        for(Sprite element : this){
            element.update(ticks);
        }
    }
}
