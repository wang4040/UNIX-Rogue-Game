package game;
public class Scroll extends Item{
	int room;
    int serial;
    char type;
	
    public Scroll(String _name){
		name = _name;
		type = 'R';
        System.out.println("Construct Scroll name: " + name);
    }

    void setID(int _room, int _serial){
		room = _room;
		serial = _serial;
        System.out.println("setID Scroll room: " + room + " serial: " + serial);
    }
}