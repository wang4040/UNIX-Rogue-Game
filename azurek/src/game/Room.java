package game;
public class Room extends Structure{
    Room(String s){
        System.out.println("Room s: " + s);
    }

    void setId(int room){
        System.out.println("Room room: " + room);
    }

    void setCreature(Creature monster){
        System.out.println("setCreature");  
    }
}