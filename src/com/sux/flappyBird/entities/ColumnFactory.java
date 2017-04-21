package com.sux.flappyBird.entities;

import com.sux.flappyBird.game.FlappyBird;
import com.sux.flappyBird.objects.Position;
import com.sux.flappyBird.objects.Size;

/**
 * Created by Shorty on 8/4/2016.
 * By Chris Coppola
 */
public class ColumnFactory {
    public static Column generateColumn(Position pos,Size size){
        return new Column(pos, size);
    }

    public static Column generateColumn(Column column){
        return new Column(column);
    }

    public static Column generateMatchingColumn(Position pos, Size size){
        return generateColumn(pos.reverse(), size.reverse());
    }

    public static Column generateMatchingColumn(Column column){
        return new Column(column.reverse());
    }
}
