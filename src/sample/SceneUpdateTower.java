package sample;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;

/**
 * Created by Bilal Chaaban on 19/03/2017.
 */
public class SceneUpdateTower extends Parent {

    public  SceneUpdateTower(){

        Rectangle fond_update = new Rectangle();
        Image fond = new Image("fond_tower.png");
        ImagePattern imagePatternFond = new ImagePattern(fond);
        fond_update.setFill(imagePatternFond);
        ImageView imageViewFond = new ImageView(fond);

        fond_update.setWidth(800);
        fond_update.setHeight(100);

      /*  fond_update.setFill(
                new LinearGradient(0f,0f,0f,1f,true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#333333")),
                        new Stop(1, Color.web("#000000")))
        );
*/
        fond_update.setId("fond_update");
        this.setTranslateY(560);
        this.getChildren().add(fond_update);
    }

}
