package Game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author felipe.amnunes1
 */
public class Player extends GameObject { //Classe de herança que executa as devidas alterações no objeto que foi chamado.

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
}
