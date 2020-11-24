package game;

import java.util.ArrayList;

public class Creature extends Displayable{
	
	int hp;
	int hpm;
	ArrayList<CreatureAction> da = new ArrayList<CreatureAction>();
    ArrayList<CreatureAction> ha = new ArrayList<CreatureAction>();
	
    public Creature(){
        //System.out.println("Construct Creature");
    }

    void setHp(int h){
		hp = h;
        //System.out.println("setHp Creature h: " + hp);
    }

    void setHpMoves(int _hpm){
		hpm = _hpm;
        //System.out.println("setHpMoves Creature hmp: " + hpm);
    }

    void addDeathAction(CreatureAction _da){
		da.add(_da);
        //System.out.println("setDeathAction Creature");
    }

    void addHitAction(CreatureAction _ha){
		ha.add(_ha);
        //System.out.println("setHitAction Creature");
    }

    void doHitAction(){
        if (ha.isEmpty() == true)
            return;
        
        for (int i = 0; i < ha.size(); i++){
            if (ha.get(i).action == "ChangeDisplayType")
                ha.get(i).ChangeDisplayType("Useless", ha.get(i).creature);
            else if (ha.get(i).action == "Remove")
                ha.get(i).Remove("Useless", ha.get(i).creature);
            else if (ha.get(i).action == "Teleport")
                ha.get(i).Teleport("Useless", ha.get(i).creature);
            else if (ha.get(i).action == "UpdateDisplay")
                ha.get(i).UpdateDisplay("Useless", ha.get(i).creature);
            else if (ha.get(i).action == "YouWin")
                ha.get(i).UpdateDisplay("Useless", ha.get(i).creature);
            
        }

    }

    void doDeathAction(){
        if (da.isEmpty() == true)
            return;
        
        for (int i = 0; i < da.size(); i++){
            if (da.get(i).action == "ChangeDisplayType")
                da.get(i).ChangeDisplayType("Useless", da.get(i).creature);
            else if (da.get(i).action == "Remove")
                da.get(i).Remove("Useless", da.get(i).creature);
            else if (da.get(i).action == "Teleport")
                da.get(i).Teleport("Useless", da.get(i).creature);
            else if (da.get(i).action == "UpdateDisplay")
                da.get(i).UpdateDisplay("Useless", da.get(i).creature);
            else if (da.get(i).action == "YouWin")
                da.get(i).UpdateDisplay("Useless", da.get(i).creature);
            
        }
    }

    int getHp(){
        return hp;
    }
}