//package src;
public class Scroll extends Item{
	
	String name;
	int room;
	int serial;
	
    public Scroll(String _name){
		name = _name;
        System.out.println("Construct Scroll name: " + name);
    }

    void setID(int _room, int _serial){
		room = _room;
		serial = _serial;
        System.out.println("setID Scroll room: " + room + " serial: " + serial);
    }
}