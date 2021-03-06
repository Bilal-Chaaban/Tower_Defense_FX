package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louis on 28/02/2017.
 */
public class SceneTower extends Parent {
    double orgSceneX, orgSceneY;
    double mouvPosX, mouvPosY;
    ImageView towerMouvement=null;
    Model model;
    Circle range;
    Rectangle fond_Tower = new Rectangle();

    public SceneTower(Model m){

        super();
        model=m;
        fond_Tower.setWidth(100);
        fond_Tower.setHeight(660);
        fond_Tower.setTranslateX(800);

        Image fond = new Image("fond_tower_verticale.png");
        ImagePattern imagePatternFond = new ImagePattern(fond);
        fond_Tower.setFill(imagePatternFond);
        ImageView imageViewFond = new ImageView(fond);
        ImageView towerPetite=new ImageView("towerPetite.png");
        ImageView towerMoyen=new ImageView("towerMoyen.png");
        ImageView towerGrosse=new ImageView("towerGrosse.png");
        towerPetite.setX(800);
        towerPetite.setY(20);

        towerMoyen.setX(800);
        towerGrosse.setX(800);
        towerMoyen.setY(120);
        towerGrosse.setY(220);
        //towerPetite.getOn;
        towerPetite.setOnMousePressed(petiteTowerOnMousePressedEventHandler);
        towerPetite.setOnMouseDragged(petiteTowerOnMouseDraggedEventHandler);
        towerPetite.setOnMouseReleased(petiteTowerOnMouseReleasedEventHandler);

        towerMoyen.setOnMousePressed(petiteTowerOnMousePressedEventHandler);
        towerMoyen.setOnMouseDragged(petiteTowerOnMouseDraggedEventHandler);
        towerMoyen.setOnMouseReleased(petiteTowerOnMouseReleasedEventHandler);

        towerGrosse.setOnMousePressed(petiteTowerOnMousePressedEventHandler);
        towerGrosse.setOnMouseDragged(petiteTowerOnMouseDraggedEventHandler);
        towerGrosse.setOnMouseReleased(petiteTowerOnMouseReleasedEventHandler);








        this.getChildren().add(fond_Tower);
        this.getChildren().add(towerPetite);
        this.getChildren().add(towerMoyen);
        this.getChildren().add(towerGrosse);
    }
    public int mouvement(double x,double y){
        int ret=-1;
        if (x>800&&x<840&&y>20&&y<60){
            towerMouvement=new ImageView("towerPetite.png");
            towerMouvement.setX(800);
            towerMouvement.setY(20);
            range.setRadius(TowerPetite.RANGE);
            range.setCenterX(820);
            range.setCenterY(40);
            mouvPosX=800;
            mouvPosY=20;
        }else if (x>800&&x<840&&y>120&&y<160){
            towerMouvement=new ImageView("towerMoyen.png");
            towerMouvement.setX(800);
            towerMouvement.setY(120);
            range.setRadius(TowerMoyenne.RANGE);
            range.setCenterX(820);
            range.setCenterY(140);
            mouvPosX=800;
            mouvPosY=120;
        }else if (x>800&&x<840&&y>220&&y<260){
            towerMouvement=new ImageView("towerGrosse.png");
            towerMouvement.setX(800);
            towerMouvement.setY(220);
            range.setRadius(TowerGrosse.RANGE);
            range.setCenterX(820);
            range.setCenterY(240);
            mouvPosX=800;
            mouvPosY=220;
        }

        this.getChildren().add(range);
        this.getChildren().add(towerMouvement);
        return ret;
    }
    public void addProjectile(List<ImageView> l){
        for (ImageView imageView:l){
            this.getChildren().add(imageView);
        }
    }
    EventHandler<MouseEvent> petiteTowerOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    //orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                    //orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
                    range=new Circle();
                    mouvement(orgSceneX,orgSceneY );


                    range.setFill(Color.TRANSPARENT);
                    range.setStroke(Color.RED);


                }
            };
    EventHandler<MouseEvent> petiteTowerOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = offsetX;
                    double newTranslateY =offsetY;
                    if (model.isPlacableTower(towerMouvement.getTranslateX()+mouvPosX,towerMouvement.getTranslateY()+mouvPosY)){
                        range.setStroke(Color.WHITE);
                    }else
                        range.setStroke(Color.RED);
                    range.setTranslateX(newTranslateX);
                    range.setTranslateY(newTranslateY);
                    towerMouvement.setTranslateX(newTranslateX);
                    towerMouvement.setTranslateY(newTranslateY);

                }
            };
    EventHandler<MouseEvent> petiteTowerOnMouseReleasedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    Tower tower =model.placeTower(towerMouvement.getTranslateX()+mouvPosX,towerMouvement.getTranslateY()+mouvPosY,1,towerMouvement,range);
                    //System.out.println((towerMouvement.getTranslateX()+800)+"       "+(towerMouvement.getTranslateY()+20));

                    List<ImageView> projectileList=new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        ImageView imageView=new ImageView("flechette.png");
                        imageView.setVisible(false);
                        projectileList.add(imageView);
                    }
                    addProjectile(projectileList);
                    tower.projectile=projectileList;
                    //towerMouvement.setTranslateX(0);
                   // towerMouvement.setTranslateY(0);
                    if(tower==null) {
                        towerMouvement.setVisible(false);
                    }
                    range.setVisible(false);
                }
            };


}
