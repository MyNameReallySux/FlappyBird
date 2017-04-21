package com.sux.flappyBird.game;

import com.sux.flappyBird.drawables.DrawableList;
import com.sux.flappyBird.drawables.DrawableMap;
import com.sux.flappyBird.entities.*;
import com.sux.flappyBird.renderer.Renderer;
import com.sux.flappyBird.sprites.Bird;
import com.sux.flappyBird.sprites.Sprite;
import com.sux.flappyBird.sprites.SpriteList;
import com.sux.utils.DebugLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlappyBird implements DebugLogger, ActionListener, MouseListener, KeyListener {

    public static FlappyBird game;
    public JFrame window;
    public Renderer renderer;
    public Timer timer;

    public Bird bird;
    public ColumnList columns;
    public DrawableList<Entity> entities;
    public SpriteList sprites;

    private int ticks;
    public boolean running;
    public boolean playing;
    public boolean gameOver;

    public static final int WIDTH = 480,
                            HEIGHT = 640,

                            CENTER_X = WIDTH / 2,
                            CENTER_Y = HEIGHT / 2,

                            GROUND_HEIGHT = 120,
                            GRASS_HEIGHT = 20;

    public FlappyBird(){
        game = this;
        columns = initializeColumns();
        entities = initializeEntities();
        sprites = initializeSprites();
        renderer = initializeRenderer();
        window = initializeWindow(renderer);
        timer = initializeTimer(20);

        running = true;
        playing = false;
        gameOver = false;
    }

    public JFrame initializeWindow(Renderer renderer){
        JFrame window = new JFrame("Flappy Bird | by MyNameReallySux");
        window.add(renderer);
        window.setResizable(true);
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addMouseListener(this);
        window.addKeyListener(this);
        window.setVisible(true);
        return window;
    }

    public Renderer initializeRenderer(){
        return new Renderer();
    }

    public Timer initializeTimer(int time){
        Timer timer = new Timer(time, this);
        timer.start();
        return timer;
    }

    public ColumnList initializeColumns() {
        ColumnList columns = new ColumnList();
        columns.clear();
        columns.addColumns();
        return columns;
    }

    public DrawableList<Entity> initializeEntities(){
        DrawableList<Entity> entities = new DrawableList<>();

        entities.add(new Entity(Color.ORANGE, 0, HEIGHT - GROUND_HEIGHT, WIDTH, GROUND_HEIGHT));
        entities.add(new Entity(Color.GREEN, 0, HEIGHT - GROUND_HEIGHT, WIDTH, GRASS_HEIGHT));
        entities.add(new Entity(Color.CYAN, 0, (int)Math.floor(HEIGHT * -0.2), WIDTH, 5));

        return entities;
    }

    public SpriteList initializeSprites(){
        bird = new Bird(CENTER_X / 2, CENTER_Y);
        SpriteList sprites = new SpriteList();
        sprites.clear();
        sprites.add(bird);
        sprites.addAll(columns);
        return sprites;
    }

    public void draw(Graphics g){
        clear(g);
        entities.drawAll(g);
        columns.drawAll(g);
        sprites.drawAll(g);
        if(!playing){
            drawStringInCenter("Click to Start", 25, g);
        } else if(gameOver) {
            drawStringInCenter("Game Over", 32, g);
        }
    }

    public void clear(Graphics g){
        // g.clearRect(0, 0, DEFAULT_WIDTH, HEIGHT);
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticks++;
        renderer.repaint();
        handleInput();
        if(playing) {
            update(ticks);
            if(gameOver){
                updateGameOver();
            }
        }
    }

    public void update(int ticks){
        sprites.updateAll(ticks);

        for(Entity entity : entities){
            if(bird.intersects(entity)) {
                gameOver = true;

                bird.yVelocity = 0;
                bird.y = (entity.y - bird.height);
            }
        }

        for(int i = 0; i < columns.size(); i += 2){
            Column column = columns.get(i);
            Column match = columns.get(i+1);
            if(column.x + column.width < 0){
                columns.remove(column);
                columns.remove(match);

                sprites.remove(column);
                sprites.remove(match);
            }

            if(columns.size() <= 0 && !gameOver){
                columns.addColumns();
                sprites.addAll(columns);
            }
        }

        for(Column column : columns) {
            if(bird.intersects(column)){
                gameOver = true;
            }
        }
    }

    public void updateGameOver(){
        bird.x -= Column.SPEED;
    }

    public void drawStringInCenter(String string, int size, Graphics g){
        Font arial = new Font("Arial", Font.BOLD, size);
        FontMetrics metrics = g.getFontMetrics(arial);
        int x = WIDTH / 2 - metrics.stringWidth(string) / 2;
        int y = HEIGHT / 2 - 50;

        g.setColor(Color.WHITE);
        g.setFont(arial);
        g.drawString(string, x, y);
    }



    public void handleInput(){

    }

    public void jump(){
        if(!running){
            running = true;
        }
        if(!playing){
            playing = true;
        }
        if(gameOver){
            reset();
        } else {
            if(bird.yVelocity > 0){
                bird.yVelocity = 0;
            }
            bird.yVelocity -= 7.5;
        }
    }

    public void reset(){
        gameOver = false;
        columns.clear();
        sprites.clear();

        bird = new Bird(CENTER_X / 2, CENTER_Y);
        columns.addColumns();
        sprites.add(bird);
        sprites.addAll(columns);
    }


    public static void main(String[] args) {
        game = new FlappyBird();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jump();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
