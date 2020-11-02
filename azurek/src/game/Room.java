package game;
public class Room extends Structure{
    int id;
    Room(String s){
        System.out.println("Room s: " + s);
        id = Integer.parseInt(s);
    }

    void setId(int room){
        System.out.println("Room room: " + room);
        id = room;
    }

    void setCreature(Creature monster){
        System.out.println("setCreature");  
    }

    int getId(){
        return id;
    }
}