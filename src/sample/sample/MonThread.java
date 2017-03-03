package sample;

import sample.Ennemi;
import sample.Party;

import java.util.List;

/**
 * Created by Louis on 02/03/2017.
 */
public class MonThread extends Thread {
    Party party;
    public MonThread(Party p) {
        party=p;
    }

    @Override
    public void run() {
        List<Ennemi> ennemiList=party.model.getEnnemiePasSurMap();
        party.time=0;
        //System.out.println("test");
        party.stop=true;
        while(party.stop){
            try {
                Thread.sleep(10);
                party.time++;
                if (party.time==5)party.time=0;
                if (party.model.positionEnnemi[175][0].isEmpty()&&!ennemiList.isEmpty()){
                    Ennemi e=ennemiList.get(ennemiList.size()-1);
                    e.setX(155);
                    e.setY(-39);
                    party.getChildren().add(e);
                    for (int i = 155; i <195 ; i++) {
                        party.model.positionEnnemi[i][0].add(e);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
