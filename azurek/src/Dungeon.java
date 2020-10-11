package src;
public class Dungeon{

    String name;
    int width;
    int gameHeight;

    public Dungeon(String _name, int _width, int _gameHeight){
        name = _name;
	width = _width;
	gameHeight = _gameHeight;
	System.out.println("construct Dungeon with name: " + name + " width: " + width + " gameHeight: " + gameHeight);
    }

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