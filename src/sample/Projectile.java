package sample;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;


/**
 * Created by lb685 on 10/03/2017.
 */
public class Projectile /*extends Parent*/ {
    ImageView imageView;
    Ennemi ennemi;
    Tower tower;
    double posX;
    double posY;
    //static SceneProjectile sceneProjectile=null;
    Translate translate;
    int nb = 0;

    public Projectile(Ennemi ennemi, Tower tower) {
        this.ennemi = ennemi;
        this.tower = tower;
        boolean ok = true;

        for (int j = 0; j < 5 && ok; j++) {
            if (!tower.proj[j]) {
                imageView = tower.getProjectile(j);
                ok = false;
                tower.proj[j] = false;
            }
        }

        imageView.setX(tower.posX);
        imageView.setY(tower.posY);
        imageView.setVisible(true);
        posX = tower.posX;
        posX = tower.posY;
        //getChildren().add(imageView);

    }

    public synchronized void avance() {
        //if (nb==0)
        System.out.println(1);
        if (nb>50){
            imageView.setVisible(false);   //le projectile est arriver au bout donc on le fait disparaitre
                                            //TODO enlever les point de vie de l'ennemi
            return;
        }else {
            nb++;
            posX = ((-tower.posX + ennemi.posX) / 50) * nb;     //on fait une translation en fonction de la position de l'ennemi et de la tourelle
            posY = ((-tower.posY + ennemi.posY) / 50) * nb;
            imageView.setTranslateX(posX);
            imageView.setTranslateY(posY);
            System.out.println(tower.posX+"     "+  ennemi.posX  + "   " + tower.posY +"    "+ ennemi.posY);
            imageView.setRotate(getAngle(tower, ennemi));       //la rotation pour orienter le projectile mais ne fonctionne pas

        }
    }

    public float getAngle(Tower tower, Ennemi ennemi) {
        return (float) Math.toDegrees(Math.atan2(ennemi.posX - (tower.posX + 20), ennemi.posY - (tower.posY + 20)));
    }
}
