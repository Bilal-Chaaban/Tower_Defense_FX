package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * Created by Louis on 02/03/2017.
 */
public class Party extends Parent implements Runnable {
    public Model model;
    public boolean stop;
    public int time;
    public Party(Model model) {
        this.model = model;
        stop=false;
    }

    public ObservableList<Node> getChildren(){
        return this.getChildren();
    }

    @Override
    public void run() {
        while (true) {
            model.avance();
            //System.out.println("run");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
