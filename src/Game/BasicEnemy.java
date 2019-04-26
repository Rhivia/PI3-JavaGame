package Game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author martin.akretzschmar
 */
public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y, ID id){
        super(x, y, id);
        
        // velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        if ( y <= 0 || y >= Game.HEIGHT - 16 ) {
            velY *= -1;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
}
