/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author martin.akretzschmar
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;
    
    public KeyInput(Handler handler) {
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject object = handler.object.get(i);
            
            if (object.getId() == ID.Player) {  // Key events for Player
                if (key == KeyEvent.VK_W)       object.setVelY( -5 );
                if (key == KeyEvent.VK_S)       object.setVelY(  5 );
                if (key == KeyEvent.VK_D)       object.setVelX(  5 );
                if (key == KeyEvent.VK_A)       object.setVelX( -5 );
            }
            
//            if (object.getId() == ID.Player2) {
//                if (key == KeyEvent.VK_UP)      object.setVelY( -5 );
//                if (key == KeyEvent.VK_DOWN)    object.setVelY(  5 );
//                if (key == KeyEvent.VK_RIGHT)   object.setVelX( -5 );
//                if (key == KeyEvent.VK_LEFT)    object.setVelX(  5 );
//            }
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject object = handler.object.get(i);
            
            if (object.getId() == ID.Player) {  // Key events for Player
                if (key == KeyEvent.VK_W)       object.setVelY( 0 );
                if (key == KeyEvent.VK_S)       object.setVelY( 0 );
                if (key == KeyEvent.VK_D)       object.setVelX( 0 );
                if (key == KeyEvent.VK_A)       object.setVelX( 0 );
            }
            
//            if (object.getId() == ID.Player2) {
//                if (key == KeyEvent.VK_UP)      object.setVelY( 0 );
//                if (key == KeyEvent.VK_DOWN)    object.setVelY( 0 );
//                if (key == KeyEvent.VK_RIGHT)   object.setVelX( 0 );
//                if (key == KeyEvent.VK_LEFT)    object.setVelX( 0 );
//            }
        }
    }
}
