package com.sux.flappyBird.objects;

import com.sux.utils.DebugLogger;

/**
 * Created by Shorty on 8/6/2016.
 * By Chris Coppola
 */
public interface Interpretable<V> extends DebugLogger {
    default Interpretable interpret(V value, Interpretable[] collection) {
        for (Interpretable type : collection) {
            if (value.equals(type.getValue())) {
                return type;
            }
        }
        return null;
    }

    default Interpretable interpret(Interpretable[] collection){
        for (Interpretable type : collection) {
            if (getValue().equals(type.getValue())) {
                return type;
            }
        }
        return null;
    }

    V getValue();
}
