package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    Button b;
    Rectangle r;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Group g=new Group();
        Scene scene=new Scene(g);
        Model model=new Model();
        
        SceneJeu sceneJeu=new SceneJeu(model);

        SceneTower sceneTower=new SceneTower(model);

        g.getChildren().add(sceneJeu);
        g.getChildren().add(sceneTower);
        /*
        Chemin c=new Chemin();
        c.generate();
        boolean[][] boul=c.getChemin();
        for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 700; j++) {
                r=new Rectangle(i,j,1,1);
                r.setVisible(true);
                if (boul[i][j]){
                    r.setFill(Color.BLACK);
                }else
                    r.setFill(Color.GREEN);
                g.getChildren().add(r);
            }
        }*/



        scene.setFill(Color.AQUA);
        primaryStage.setScene(scene);
        primaryStage.show();
        Ennemi e;
        //for (int i = 0; i < 10; i++) {
            e=new EnnemiNormal();
            e.posY=-10;
            e.posX=155;
            e.direction=2;
            g.getChildren().add(e);
            model.getEnnemi().add(e);
        //}
        Party party=new Party(model);
        Thread thread=new Thread(party);
        thread.start();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
