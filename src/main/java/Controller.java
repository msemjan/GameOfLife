import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//"wires" gui and model
class Controller{

    private GameOfLife model;
    private AnimateGameOfLife view;
    private final int delay;

    Controller(int rows, int cols, int delay){
        model = new GameOfLife(rows, cols);
        view = new AnimateGameOfLife(model);
        this.delay = delay;
    }

    void animateWithTimer(){
        new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.updateGameOfLife();
                view.refresh();
            }
        }).start();
    }


}
