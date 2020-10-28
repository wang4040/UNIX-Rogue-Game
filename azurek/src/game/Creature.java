package src;
public class Creature extends Displayable{
	
	int hp;
	int hpm;
	CreatureAction da;
	CreatureAction ha;
	
    public Creature(){
        System.out.println("Construct Creature");
    }

    void setHp(int h){
		hp = h;
        System.out.println("setHp Creature h: " + hp);
    }

    void setHpMoves(int _hpm){
		hpm = _hpm;
        System.out.println("setHpMoves Creature hmp: " + hpm);
    }

    void setDeathAction(CreatureAction _da){
		da = _da;
        System.out.println("setDeathAction Creature");
    }

    void setHitAction(CreatureAction _ha){
		ha = _ha;
        System.out.println("setHitAction Creature");
    }
}