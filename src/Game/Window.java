package Game;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author martin.akretzschmar
 */
public class Window {
    private static final long serialVersionUID = -240840600533728354L;
    
    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
