package sample;

import javafx.scene.image.ImageView;

/**
 * Created by quent on 03/01/2017.
 */
public class TowerPetite extends Tower {
    static final int RANGE=200;
    static final int DAMAGE=20;
    static final int ATTACKSPEED=30;
    TowerPetite(int id, ImageView imageView,double posX,double posY) {
        super(RANGE,DAMAGE,ATTACKSPEED,id,imageView,posX,posY);
    }
}
