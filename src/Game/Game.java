package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author martin.akretzschmar
 */
public class Game extends Canvas implements Runnable{
  
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9; // 1280 por 720, numa resolução 16 por 9;
    private final Handler handler;
    
    private Thread thread;
    private boolean running = false;

    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        
        new Window(WIDTH, HEIGHT, "Ballzeroth!", this);
        
        handler.addObject( new Player( WIDTH/2-32, HEIGHT/2-32, ID.Player ));
        handler.addObject( new Player( WIDTH/2-64, HEIGHT/2-64, ID.Player ));
    } 

    public synchronized void start(){
        thread = new Thread(this);
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
    }
 
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
 
        Graphics g = bs.getDrawGraphics();
 
        g.setColor(Color.green);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        
        g.dispose();
        bs.show();
    }
 
    public static void main(String args[]){
        new Game(); 
    }
}