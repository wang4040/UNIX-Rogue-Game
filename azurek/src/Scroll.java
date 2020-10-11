package src;
public class Scroll extends Item{
    Scroll(String name){
        System.out.println("Scroll name: " + name);
    }

    void setID(int room, int serial){
        System.out.println("setID Scroll room: " + room + " serial: " + serial);
    }
}