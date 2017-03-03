package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * Created by Louis on 02/03/2017.
 */
public class Party extends Parent {
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
}
