package src;
public class Sword extends Item{
    Sword(String name){
        System.out.println("Sword name: " + name);
    }

    void setID(int room, int serial){
        System.out.println("setID Sword room: " + room + " serial: " + serial);
    }
}