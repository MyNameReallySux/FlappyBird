package com.sux.flappyBird.entities;

import com.sux.flappyBird.objects.Position;
import com.sux.flappyBird.objects.Size;
import com.sux.utils.DebugLogger;
import javafx.geometry.Pos;

import java.util.Random;

/**
 * Created by Shorty on 8/6/2016.
 * By Chris Coppola
 */
public class ColumnBuilder implements DebugLogger{
    public Position pos;
    public Size size;
    public Column last;
    public Column matching;

    public ColumnBuilder(){
        this.last = new Column();
        this.matching = last.reverse();
    }

    public ColumnBuilder setPos(Position pos){
        this.pos = pos;
        return this;
    }

    public ColumnBuilder setSize(Size size){
        this.size = size;
        return this;
    }

    public Column build(){
        Column column = new Column(pos, size);
        Column matching = column.reverse();

        this.last = column;
        this.matching = matching;

        return last;
    }

    public Column buildRandom(){
        Random random = new Random();
        int posNum = random.nextInt(2);
        int sizeNum = random.nextInt(9) + 1;

        Position pos = Column.DEFAULT_POSITION;
        Size size = Column.DEFAULT_SIZE;

        switch (posNum){
            case 0: pos = Position.TOP; break;
            case 1: pos = Position.BOTTOM; break;
        }

        switch (sizeNum){
            case 0: size = Size.NONE; break; // sizeNum is never 0;
            case 1: size = Size.TINY; break;
            case 2: size = Size.XXSMALL; break;
            case 3: size = Size.XSMALL; break;
            case 4: size = Size.SMALL; break;
            case 5: size = Size.MEDIUM; break;
            case 6: size = Size.LARGE; break;
            case 7: size = Size.XLARGE; break;
            case 8: size = Size.XXLARGE; break;
            case 9: size = Size.HUGE; break;
            case 10: size = Size.MEDIUM; break; // sizeNum is never 10;
        }

        setPos(pos);
        setSize(size);
        return build();
    }

    public Column getLastColumn(){
        return this.last;
    }

    public Column getMatchingColumn(){
        return this.matching;
    }
}
