package sample;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Louis on 28/02/2017.
 */
public class SceneJeu extends Parent {
    Model model;
    public SceneJeu(Model m){
        super();
        model=m;
        model.generate();
        boolean[][] boul=model.getChemin();
        for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 700; j++) {
                Rectangle r = new Rectangle(i, j, 1, 1);
                r.setVisible(true);
                if (boul[i][j]){
                    r.setFill(Color.BLACK);
                }else
                    r.setFill(Color.GREEN);
                this.getChildren().add(r);
            }
        }
    }
}
