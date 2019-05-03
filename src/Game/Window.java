package Game;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author martin.akretzschmar
 */
public class Window extends JFrame {
    private static final long serialVersionUID = -240840600533728354L;
    
    public Window(int width, int height, String title, Game game, Handler handler) {        
        setTitle("Ballzeroth!");
        
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        
        this.requestFocus();
        this.addKeyListener(new KeyInput(handler));
        
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        game.start();
    }
}
