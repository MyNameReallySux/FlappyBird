package com.sux.flappyBird.renderer;

import com.sux.flappyBird.game.FlappyBird;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Shorty on 8/4/2016.
 * By Chris Coppola
 */
public class Renderer extends JPanel {
    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FlappyBird.game.draw(g);
    }
}
