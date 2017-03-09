package sample;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;

/**
 * Created by lb685 on 27/11/2016.
 */
public abstract class Ennemi extends Parent{
    protected int vie;
    protected int vitesse;
    protected ImageView image;
    protected double posX,posY;
    protected int direction;
    Ennemi()
    {
        vie=0;
        vitesse=0;
    }
    Ennemi(int vie, int vitesse)
    {
        this.vie=vie;
        this.vitesse=vitesse;
    }

    void setVie(int vie){
        this.vie=vie;
    }

    void setVitesse(int vitesse){
        this.vitesse = vitesse;
    }

    public void setX(double value){
        image.setX(value);
    }
    public void setY(double value){
        image.setY(value);
    }

    int getVie(){
        return vie;
    }

    int getVitesse(){
        return vitesse;
    }

    public boolean perteHp(int degatSubie) {
        vie = vie - degatSubie;
        //System.out.println(vie);
        if (vie<=0) {
            image.setVisible(false);
            return true;
        }
        return false;
    }

    public void avance(){
        switch (direction){
            case 1: posX++;
                break;
            case 2: posY++;
                break;
            case 3: posX--;
                break;
            case 4: posY--;
                break;
        }
        if (posY>=0){

            image.setTranslateX(posX);
            image.setTranslateY(posY);
            image.setVisible(true);
        }
    }

    public void gainHp(int soin){
        vie = vie + soin;
    }

    public void setImage(ImageView image) {
        this.image = image;
        image.setVisible(false);
        image.setX(0);
        image.setY(0);
        this.getChildren().add(image);
    }
}
