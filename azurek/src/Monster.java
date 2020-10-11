package src;
public class Monster extends Creature{
    Monster(){
        System.out.println("Monster");
    }

    void setName(String s){
        System.out.println("setName Monster s: " + s);
    }

    void setID(int room, int serial){
        System.out.println("setID Monster room: " + room + " serial: " + serial);
    }
}