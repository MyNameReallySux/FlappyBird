package com.sux.flappyBird.objects;

import com.sux.flappyBird.entities.Column;
import com.sux.flappyBird.game.FlappyBird;

/**
 * Created by Shorty on 8/6/2016.
 * By Chris Coppola
 */

public enum Position implements Interpretable<Integer>, Reversable<Position>{
    TOP(0), BOTTOM(FlappyBird.HEIGHT - FlappyBird.GROUND_HEIGHT);

    public static final int MIN = 0;
    public static final int MAX = FlappyBird.HEIGHT - FlappyBird.GROUND_HEIGHT;

    int pos;

    Position(int pos) {
        this.pos = pos;
    }

    @Override
    public Integer getValue() {
        return pos;
    }

    @Override
    public Position reverse() {
        int value = getValue();
        int reverseValue = Position.MAX - value;
        return (Position)interpret(reverseValue, Position.values());
    }
}
