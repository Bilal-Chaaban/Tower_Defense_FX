package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louis on 28/02/2017.
 */
public class Model {
    private boolean[][] chemin = new boolean[800][700];
    private int[] positionvirage;
    private Tower[][] positionTower = new Tower[800][700];
    private List<Tower> towerList = new ArrayList<>();
    private List<Projectile> projectileList=new ArrayList<>();
    //public List<Ennemi>[][] positionEnnemi= new ArrayList[800][700];
    private List<Ennemi> ennemi = new ArrayList<>();
    //private List[][] rangeTower=new ArrayList[800][700];
    private Group group=null;
    private int tours;
    private boolean test=true;
    public Model() {
        /*this.group=group;*/
    }

    public void generate() {
        positionvirage = new int[7 * 3];
        Tower.nbTower = 0;
        for (int i = 150; i < 200; i++) {
            for (int j = 0; j < 150; j++) {
                chemin[i][j] = true;
                //positionEnnemi[i][j]=new ArrayList<>();

            }
        }
        int y = 0;
        positionvirage[y] = 155;
        y++;
        positionvirage[y] = 105;
        y++;
        positionvirage[y] = 3;
        y++;
        for (int i = 50; i < 200; i++) {
            for (int j = 100; j < 150; j++) {
                chemin[i][j] = true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        positionvirage[y] = 55;
        y++;
        positionvirage[y] = 105;
        y++;
        positionvirage[y] = 2;
        y++;
        for (int i = 50; i < 100; i++) {
            for (int j = 150; j < 550; j++) {
                chemin[i][j] = true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        positionvirage[y] = 55;
        y++;
        positionvirage[y] = 505;
        y++;
        positionvirage[y] = 1;
        y++;
        /*or (int i = 100; i <150 ; i++) {
            for (int j = 100; j <550 ; j++) {
                chemin[i][j]=true;
            }
        }*/
        for (int i = 100; i < 600; i++) {
            for (int j = 500; j < 550; j++) {
                chemin[i][j] = true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        positionvirage[y] = 555;
        y++;
        positionvirage[y] = 505;
        y++;
        positionvirage[y] = 4;
        y++;
        for (int i = 550; i < 600; i++) {
            for (int j = 350; j < 500; j++) {
                chemin[i][j] = true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        positionvirage[y] = 555;
        y++;
        positionvirage[y] = 355;
        y++;
        positionvirage[y] = 3;
        y++;
        for (int i = 200; i < 550; i++) {
            for (int j = 350; j < 400; j++) {
                chemin[i][j] = true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        positionvirage[y] = 205;
        y++;
        positionvirage[y] = 355;
        y++;
        positionvirage[y] = 4;
        y++;
        for (int i = 200; i < 250; i++) {
            for (int j = 200; j < 350; j++) {
                chemin[i][j] = true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }
        positionvirage[y] = 205;
        y++;
        positionvirage[y] = 205;
        y++;
        positionvirage[y] = 1;
        y++;
        for (int i = 250; i < 800; i++) {
            for (int j = 200; j < 250; j++) {
                chemin[i][j] = true;
                //positionEnnemi[i][j]=new ArrayList<>();
            }
        }

    }

    public boolean isPlacableTower(double x, double y) {
        if (x < 0 || x > 760 || y < 0 || y > 660)
            return false;
        for (int i = (int) x; i < x + 40; i++) {
            for (int j = (int) y; j < y + 40; j++) {
                if (chemin[i][j]) {
                    //System.out.println("chemin");
                    return false;
                }
                if (positionTower[i][j] != null) {
                    //System.out.println("tower");
                    return false;
                }
            }
        }
        return true;
    }

    public Tower placeTower(double x, double y, int valueTower, ImageView towerMouvement, Circle range) {
        if (isPlacableTower(x, y)) {

            Tower tower = null;
            switch (valueTower) {
                case 1:
                    tower = new TowerPetite(Tower.nbTower + 1, towerMouvement, x + 20, y + 20);
                    break;
                case 2:
                    tower = new TowerPetite(Tower.nbTower + 1, towerMouvement, x + 20, y + 20);
                    break;
                case 3:
                    tower = new TowerPetite(Tower.nbTower + 1, towerMouvement, x + 20, y + 20);
                    break;
            }
            tower.setR(range);
            for (int i = (int) x; i < x + 40; i++) {
                for (int j = (int) y; j < y + 40; j++) {
                    positionTower[i][j] = tower;
                }
            }
            towerList.add(tower);
            return tower;
        } else
            return null;

    }

    public boolean[][] getChemin() {
        return chemin;
    }

    public synchronized void avance() {

        for (Ennemi e : ennemi) {
            //System.out.println("test");
            //direction(e);
            for (int i = 0; i < positionvirage.length; i += 3) {
                if (e.posX == positionvirage[i] && e.posY == positionvirage[i + 1])
                    e.direction = positionvirage[i + 2];
            }
            e.avance();
            //System.out.println(e.posX+"         "+e.posY);
            /*for (Tower tower:towerList){

            }*/
        }
        for (Tower tower : towerList) {
            boolean stop = true;
            for (int i = 0; i < ennemi.size() && stop; i++) {
                Ennemi e = ennemi.get(i);
                if (Math.pow(e.posX - tower.posX, 2) + Math.pow(e.posY - tower.posY, 2) < Math.pow(tower.r.getRadius(), 2)) {

                    tower.image.setRotate(-getAngle(tower,e));

                    Projectile projectile=null;
                    if (test){
                        projectile=new Projectile(e,tower);
                        projectileList.add(projectile);
                        test=false;
                    }



                    //SceneProjectile sceneProjectile= (SceneProjectile) group.getChildren().get(2);
                    //sceneProjectile.add(projectile);
                    //if (e.perteHp(tower.getDamage()))
                    //  ennemi.remove(e);
                    stop=false;
                    //System.out.println("test");
                }
            }
        }
        for (Projectile p:projectileList){
            p.avance();
        }
            /*for (Ennemi e:ennemi) {
                //System.out.println(tower+.posX);
                if (Math.pow(e.posX-tower.posX,2)+Math.pow(e.posY-tower.posY,2)<Math.pow(tower.r.getRadius(),2)) {
                    if (e.perteHp(tower.getDamage()))
                        ennemi.remove(e);


                    //System.out.println("test");
                }

            }*/
    }


    public float getAngle(Tower tower, Ennemi ennemi) {
        return (float) Math.toDegrees(Math.atan2(tower.posX - (ennemi.posX+20), tower.posY -( ennemi.posY+20)));
    }

    int direction(Ennemi e) {
        //System.out.println(e.direction);

        if (e.posY - 25 < 0) {
            return e.direction;
        } else {
            if (chemin[(int) e.posX + 40][(int) e.posY] && e.direction != 3) {
                System.out.println(e.posX + 25);
                e.direction = 1;
                return 1;
            } else if (chemin[(int) e.posX][(int) e.posY + 40] && e.direction != 4) {
                e.direction = 2;
                return 2;
            } else if (e.posY - 40 > 0 && chemin[(int) e.posX][(int) e.posY - 40] && e.direction != 2) {
                e.direction = 4;
                return 4;
            } else if (e.posX - 40 > 0 && chemin[(int) e.posX - 40][(int) e.posY] && e.direction != 1) {
                e.direction = 3;
                return 3;
            }
        }
        return -1;
    }
    //public List<Ennemi>[][] getPositionEnnemi() {
    //    return positionEnnemi;
    //}

    public List<Ennemi> getEnnemi() {
        return ennemi;
    }
}
