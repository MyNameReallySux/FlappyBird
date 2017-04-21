package com.sux.flappyBird.entities;

import com.sux.flappyBird.drawables.DrawableList;

/**
 * Created by Shorty on 8/6/2016.
 * By Chris Coppola
 */
public class ColumnList extends DrawableList<Column> {
    public static ColumnBuilder builder = new ColumnBuilder();

    public void addColumns(){
        add(builder.buildRandom());
        add(builder.getMatchingColumn());
    }
}
