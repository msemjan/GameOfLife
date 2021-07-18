import javax.swing.*;
import java.awt.*;

public class AnimateGameOfLife {
    private JFrame frame;

    public AnimateGameOfLife(GameOfLife model) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new MyJPanel(model);

        panel.setDoubleBuffered(true);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    void refresh() {
        frame.repaint();
    }

    public static void main(String[] args) throws InterruptedException {
        int cols = 80;
        int rows = 80;
        final int delay = 250;
        Controller controller = new Controller(rows, cols, delay);
        controller.animateWithTimer();
    }
}
