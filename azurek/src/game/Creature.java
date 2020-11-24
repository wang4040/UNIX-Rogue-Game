package game;
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

    void setDeathAction(CreatureAction _da){
		da.add(_da);
        //System.out.println("setDeathAction Creature");
    }

    void setHitAction(CreatureAction _ha){
		ha.add(_ha);
        //System.out.println("setHitAction Creature");
    }



    int getHp(){
        return hp;
    }
}