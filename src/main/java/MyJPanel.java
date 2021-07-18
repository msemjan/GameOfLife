import javax.swing.*;
import java.awt.*;

class MyJPanel extends JPanel {

    private GameOfLife model;

    public MyJPanel(GameOfLife model) {
        this.model = model;
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        int width = getWidth();
        int height = getHeight();

        int cellWidth = width / model.getColumnCount();
        int cellHeight = height / model.getRowCount();

        int xOffset = (width - (model.getColumnCount() * cellWidth)) / 2;
        int yOffset = (height - (model.getRowCount() * cellHeight)) / 2;

        for (int row = 0; row < model.getRowCount(); row++){
            for (int col = 0; col < model.getColumnCount(); col++){
                Rectangle cell = new Rectangle(
                        xOffset + (col * cellWidth),
                        yOffset + (row * cellHeight),
                        cellWidth,
                        cellHeight);
                if(model.getCell(row, col)){
                    g2d.setColor(Color.BLACK);
                }else{
                    g2d.setColor(Color.WHITE);
                }
                g2d.fill(cell);
            }
        }
    }
}
