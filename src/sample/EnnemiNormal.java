package sample;

import javafx.scene.image.ImageView;

/**
 * Created by bilel on 01/01/17.
 */
public class EnnemiNormal extends Ennemi {


    EnnemiNormal(){
        super(100,100);
        this.setImage(new ImageView("EnnemiNormal.png"));
    }

}
