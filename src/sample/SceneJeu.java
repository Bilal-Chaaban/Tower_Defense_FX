package sample;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Louis on 28/02/2017.
 */
public class SceneJeu extends Parent {
    Model model;
    public SceneJeu(Model m){
        super();
        model=m;
        model.generate();
        Rectangle r;
        boolean[][] boul=model.getChemin();
        int i=0,j=0;
        /*for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 700; j++) {
                r = new Rectangle(i, j, 1, 1);
                if (boul[i][j]){
                    r.setFill(Color.BLACK);
                    this.getChildren().add(r);
                }

            }
        }*/
        while(!boul[i][j]){
            i++;
        }
        boolean fin=false;
        int last=-1;
        while(!fin){
            r=new Rectangle(i,j,50,50);
            r.setFill(Color.BLACK);
            this.getChildren().add(r);
            if (i+50<800&&boul[i+50][j]&&last!=3){
                i+=50;
                last=1;
            }else if (j+50<700&&boul[i][j+50]&&last!=4){
                j+=50;
                last=2;
            }else if (boul[i-50][j]&&last!=1){
                i-=50;
                last=3;
            }else if (boul[i][j-50]&&last!=2){
                j-=50;
                last=4;
            }else
                fin=true;

        }
    }
}
