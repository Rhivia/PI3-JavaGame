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
                if (key == KeyEvent.VK_W) object.setY(object.getY() - 2);
            }
            
            if (object.getId() == ID.Player2) {
                if (key == KeyEvent.VK_UP) object.setY(object.getY() - 2);
            }
            
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
}
