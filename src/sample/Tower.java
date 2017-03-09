package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by lb685 on 27/11/2016.
 */
public abstract class Tower{
    private int range;
    private int damage;
    private int attaqueSpeed;
    private int id;
    ImageView image;
    double posX,posY;
    public static int nbTower;
    Circle r;
    Tower(int id){
        this.id = id;
        range =0;
        damage = 0;
        attaqueSpeed = 0;
        nbTower+=1;
    }

    public void setR(Circle r) {
        this.r = r;
    }

    Tower(int range, int damage, int attaqueSpeed, int id, ImageView image, double posX, double posY){
        this.range = range;
        this.damage = damage;
        this.attaqueSpeed = attaqueSpeed;
        this.id=id;
        this.image=image;
       // this.getChildren().add(image);
        this.image.setOnMousePressed(onMousePressedEventHandler);
        this.posX=posX;
        this.posY=posY;
        nbTower+=1;
        System.out.println(nbTower);
    }

    void setRange(int range){this.range=range;}

    void setDamage(int damage){this.damage=damage;}

    void setAttaqueSpeed(int attaqueSpeed){this.attaqueSpeed=attaqueSpeed;}

    void setId(int id){this.id=id;}

    int getRange(){return range;}

    int getDamage(){return damage;}

    int getAttaqueSpeed(){return attaqueSpeed;}

    int getTowerId(){return id;}

    public void levelUp() {
        range++;
        damage++;
        attaqueSpeed++;
    }
    EventHandler<MouseEvent> onMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    System.out.println(t.getSceneX()+"  "+t.getSceneY());





                }
            };
}
