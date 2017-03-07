package sample;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;

/**
 * Created by lb685 on 27/11/2016.
 */
public abstract class Ennemi extends Parent{
    private int vie;
    private int vitesse;
    protected ImageView image;
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

    public void perteHp(int degatSubie) {
        vie = vie - degatSubie;
    }

    public void gainHp(int soin){
        vie = vie + soin;
    }
}
