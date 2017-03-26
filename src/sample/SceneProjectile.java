package sample;

import javafx.application.Platform;
import javafx.scene.Parent;

/**
 * Created by lb685 on 18/03/2017.
 */
public class SceneProjectile extends Parent {
    public SceneProjectile(){

    }
    public synchronized void add(Projectile p){

        //Platform.runLater(() -> .getChildren().add(p););


    }
}
