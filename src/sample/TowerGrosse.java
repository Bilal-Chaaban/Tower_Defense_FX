package sample;

import javafx.scene.image.ImageView;

/**
 * Created by quent on 04/01/2017.
 */
public class TowerGrosse extends Tower {
    static final int RANGE=200;
    static final int DAMAGE=30;
    static final int ATTACKSPEED=10;
    TowerGrosse(int id, ImageView imageView,double posX,double posY){super(RANGE,DAMAGE,ATTACKSPEED,id,imageView,posX,posY);}
}
