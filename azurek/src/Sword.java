package src;
public class Sword extends Item{
	
	String name;
	int room;
	int serial;
	
    public Sword(String _name){
		name = _name;
        System.out.println("Construct Sword name: " + name);
    }

    void setID(int _room, int _serial){
		room = _room;
		serial = _serial;
        System.out.println("setID Sword room: " + room + " serial: " + serial);
    }
}