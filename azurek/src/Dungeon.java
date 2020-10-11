package src;
public class Dungeon{

    void getDungeon(String name, int width, int gameHeight){
        System.out.println("getDungeon name: " + name + " width: " + width + " gameHeight: " + gameHeight);
    }

    void addRoom(Room r){
        System.out.println("addRoom r: " + r);
    }

    void addCreature(Creature c){
        System.out.println("addCreature");
    }

    void addPassage(Passage passage){
        System.out.println("addPassage");
    }

    void addItem(Item item){
        System.out.println("addItem");
    }

}