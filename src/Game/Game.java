package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author martin.akretzschmar
 */
public class Game extends Canvas implements Runnable {
  
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9; // 1280 por 720, numa resolução 16 por 9;
    private final Handler handler;
    private Random r;
    private HUD hud;
    BufferStrategy bs;
    
    private Thread thread = new Thread(this);
    private boolean running = false;

    public Game(){
        handler = new Handler();
        
        new Window(WIDTH, HEIGHT, "Ballzeroth!", this, handler);
        
        hud = new HUD();
        
        r = new Random();
        
        handler.addObject( new Player( WIDTH/2-32, HEIGHT/2-32, ID.Player ));
        for (int i = 0; i < 20; i++) {
            handler.addObject( new BasicEnemy( r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy ));
        }
        // handler.addObject( new Player( WIDTH/2-64, HEIGHT/2-64, ID.Player ));
    } 

    public synchronized void start(){
        running = true;
        thread.start();
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            
            if(running) render();
            frames++;
                
            if(System.currentTimeMillis() - timer > 1000){
                timer = System.currentTimeMillis();
                // System.out.println("FPS: " + frames);
                frames = 0;
            }
        } 
        stop();
    }
 
    private void tick(){
        handler.tick();
        hud.tick();
    }
 
    private void render(){
        
 
        Graphics g = bs.getDrawGraphics();
 
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);
        
        g.dispose();
        bs.show();
    }
 
    public static int clamp(int var, int min, int max) {
        if(var >= max) return var = max;
        if(var <= min) return var = min;
        
        return var;
    }
    
    public static void main(String args[]){
        new Game(); 
    }
}