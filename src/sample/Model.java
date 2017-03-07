package sample;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louis on 28/02/2017.
 */
public class Model {
    private boolean[][] chemin = new boolean [800][700];

    private Tower[][] positionTower= new Tower [800][700];

    //public List<Ennemi>[][] positionEnnemi= new ArrayList[800][700];
    private List<Ennemi> ennemiePasSurMap=new ArrayList<>();
    //private List[][] rangeTower=new ArrayList[800][700];
    List<Tower> t=new ArrayList();
    private int tours;
    public void generate(){

        Tower.nbTower=0;
        for (int i = 150; i <200 ; i++) {
            for (int j = 0; j <150 ; j++) {
                chemin[i][j]=true;
                //positionEnnemi[i][j]=new ArrayList<>();

            }
        }
        for (int i = 50; i <200 ; i++) {
            for (int j = 100; j <150 ; j++) {
                chemin[i][j]=true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        for (int i = 50; i <100 ; i++) {
            for (int j = 150; j <550 ; j++) {
                chemin[i][j]=true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        /*or (int i = 100; i <150 ; i++) {
            for (int j = 100; j <550 ; j++) {
                chemin[i][j]=true;
            }
        }*/
        for (int i = 100; i <600 ; i++) {
            for (int j = 500; j <550 ; j++) {
                chemin[i][j]=true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        for (int i = 550; i <600 ; i++) {
            for (int j = 350; j <500 ; j++) {
                chemin[i][j]=true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        for (int i = 200; i <550 ; i++) {
            for (int j = 350; j <400 ; j++) {
                chemin[i][j]=true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        for (int i = 200; i <250 ; i++) {
            for (int j = 200; j <350 ; j++) {
                chemin[i][j]=true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        for (int i = 250; i <800 ; i++) {
            for (int j = 200; j <250 ; j++) {
                chemin[i][j]=true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }

    }
    public boolean isPlacableTower(double x,double y){
        if (x<0||x>760||y<0||y>660)
            return false;
        for (int i =(int) x; i < x+40 ; i++) {
            for (int j =(int) y; j < y+40 ; j++) {
                if (chemin[i][j]) {
                    //System.out.println("chemin");
                    return false;
                }
                if (positionTower[i][j]!=null) {
                    //System.out.println("tower");
                    return false;
                }
            }
        }
        return true;
    }
    public Tower placeTower(double x, double y, int valueTower, ImageView towerMouvement){
        if (isPlacableTower(x,y)){

            Tower tower=null;
            switch (valueTower){
                case 1: tower=new TowerPetite(Tower.nbTower+1,towerMouvement,x+20,y+20);
                    break;
                case 2: tower=new TowerPetite(Tower.nbTower+1,towerMouvement,x+20,y+20);
                    break;
                case 3: tower=new TowerPetite(Tower.nbTower+1,towerMouvement,x+20,y+20);
                    break;
            }
            for (int i = (int) x; i <x+40 ; i++) {
                for (int j =(int) y; j <y+40 ; j++) {
                    positionTower[i][j]=tower;
                }
            }
            t.add(tower);
            return tower;
        }else
            return null;

    }
    public boolean[][] getChemin() {
        return chemin;
    }

    //public List<Ennemi>[][] getPositionEnnemi() {
    //    return positionEnnemi;
    //}

    public List<Ennemi> getEnnemiePasSurMap() {
        return ennemiePasSurMap;
    }
}
