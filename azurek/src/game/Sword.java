package game;
public class Sword extends Item{
	
	int room;
    int serial;
    char type;
	
    public Sword(String _name){
		name = _name;
		type = 'W';
        System.out.println("Construct Sword name: " + name);
    }

    void setID(int _room, int _serial){
		room = _room;
		serial = _serial;
        System.out.println("setID Sword room: " + room + " serial: " + serial);
    }
}