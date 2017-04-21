package com.sux.flappyBird.entities;

import com.sux.flappyBird.game.FlappyBird;
import com.sux.flappyBird.objects.Position;
import com.sux.flappyBird.objects.Reversable;
import com.sux.flappyBird.objects.Size;
import com.sux.flappyBird.sprites.Sprite;

import java.awt.*;

/**
 * Created by Shorty on 8/4/2016.
 * By Chris Coppola
 */
public class Column extends Sprite implements Reversable<Column> {
    public static final Color       COLOR =             Color.GREEN.darker();
    public static final Position    DEFAULT_POSITION =  Position.TOP;
    public static final Size        DEFAULT_SIZE =      Size.NONE;

    public static final int DEFAULT_WIDTH =         100,
                            DEFAULT_GAP_HEIGHT =    (FlappyBird.HEIGHT - FlappyBird.GROUND_HEIGHT) / 2,
                            OFFSET_X =              100,
                            START_X =               FlappyBird.WIDTH + OFFSET_X,
                            PADDING_Y =             800,
                            SPEED =                 5;


    private Position pos;
    private Size size;

    public Column(){
        this(Position.TOP, Size.NONE);
    }

    public Column(Column column){
        this(column.getColumnPos(), column.getColumnSize());
    }

    public Column(Position pos, Size size){
        super(START_X, pos.getValue(), DEFAULT_WIDTH, size.getValue());
        this.pos = pos;
        this.size = size;

        print(height);
        print(height);
        if(pos == Position.BOTTOM) {
            y -= height;
        }
        if(pos == Position.TOP) {
            height += PADDING_Y;
            y -= PADDING_Y;
        }

    }

    public Position getColumnPos(){
        return pos;
    }

    public Size getColumnSize(){
        return size;
    }

    @Override
    public Column reverse() {
        print(pos + " " + size);
        return new Column(pos.reverse(), size.reverse());
    }

    @Override
    public void draw(Graphics g){
        g.setColor(COLOR);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update(int ticks) {
        x -= SPEED;
    }


}
