package src;
public class Armor extends Item{
    Armor(String name){
        System.out.println("Armor name is:" + name);
    }

    void setName(String s){
        System.out.println("setName Armor input is: " + s);
    }

    void setID(int room, int serial){
        System.out.println("SetID Armor room:" + room + "serial: " + serial);
    }
}