package sample;

import javafx.scene.image.ImageView;

/**
 * Created by quent on 04/01/2017.
 */
public class TowerMoyenne extends Tower {
    static final int RANGE=100;
    static final int DAMAGE=20;
    static final int ATTACKSPEED=20;
    TowerMoyenne(int id, ImageView imageView,double posX,double posY){super(RANGE,DAMAGE,ATTACKSPEED,id,imageView,posX,posY);}
}
