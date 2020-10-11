package src;
public class Creature extends Displayable{
    Creature(){
        System.out.println("Creature");
    }

    void setHp(int h){
        System.out.println("setHp Creature h: " + h);
    }

    void setHpMoves(int hpm){
        System.out.println("setHpMoves Creature hmp: " + hpm);
    }

    void setDeathAction(CreatureAction da){
        System.out.println("setDeathAction Creature");
    }

    void setHitAction(CreatureAction ha){
        System.out.println("setHitAction Creature");
    }
}