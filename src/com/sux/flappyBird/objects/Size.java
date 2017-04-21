package com.sux.flappyBird.objects;

/**
 * Created by Shorty on 8/6/2016.
 * By Chris Coppola
 */

import com.sux.flappyBird.entities.Column;
import com.sux.flappyBird.game.FlappyBird;

public enum Size implements Interpretable<Integer>, Reversable<Interpretable> {
    NONE(                     Size.MIN),
    TINY(    (int)Math.round((Size.MAX) * 0.1)),
    XXSMALL( (int)Math.round((Size.MAX) * 0.2)),
    XSMALL(  (int)Math.round((Size.MAX) * 0.3)),
    SMALL(   (int)Math.round((Size.MAX) * 0.4)),
    MEDIUM(  (int)Math.round((Size.MAX) * 0.5)),
    LARGE(   (int)Math.round((Size.MAX) * 0.6)),
    XLARGE(  (int)Math.round((Size.MAX) * 0.7)),
    XXLARGE( (int)Math.round((Size.MAX) * 0.8)),
    HUGE(    (int)Math.round((Size.MAX) * 0.9)),
    FULL(                     Size.MAX);

    private int size;
    public static final int MIN = 0;
    public static final int MAX = FlappyBird.HEIGHT - FlappyBird.GROUND_HEIGHT - (Column.DEFAULT_GAP_HEIGHT / 2);

    Size(int size) {
        this.size = size;
        print(MAX);
    }

    @Override
    public Integer getValue() {
        return this.size;
    }

    @Override
    public Size reverse() {
        int value = getValue();
        int reverseValue = Size.MAX - value;
        return (Size)interpret(reverseValue, Size.values());
    }
}