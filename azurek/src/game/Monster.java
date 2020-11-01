//package game;
public class Monster extends Creature{
	
	int room;
    int serial;
	
    public Monster(String _name, int _room, int _serial){
		name = _name;
		room = _room;
		serial = _serial;
        System.out.println("Construct Monster name: " + name + " room: " + room + " serial: " + serial);
    }

    void setName(String s){
        System.out.println("setName Monster s: " + s);
    }

    void setID(int room, int serial){
        System.out.println("setID Monster room: " + room + " serial: " + serial);
    }

    int getRoom(){
        return room;
    }
}