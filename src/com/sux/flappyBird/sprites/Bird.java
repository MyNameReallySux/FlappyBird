package com.sux.flappyBird.sprites;

import java.awt.*;

/**
 * Created by Shorty on 8/4/2016.
 * By Chris Coppola
 */
public class Bird extends Sprite {
    public static final int WIDTH = 20,
                            HEIGHT = 20,

                            MAX_SPEED = 12;

    public static final Color COLOR = Color.red;

    public float yVelocity = 0f;

    public Bird(int x, int y) {
        super(x - (WIDTH / 2),
              y - (HEIGHT / 2),
              WIDTH, HEIGHT);
        yVelocity = 0;
    }

    public void draw(Graphics g){
        g.setColor(COLOR);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void update(int ticks) {
        if(yVelocity > MAX_SPEED) yVelocity = MAX_SPEED;
        else yVelocity += 0.5f;
        y += Math.floor(yVelocity);

    }
}
