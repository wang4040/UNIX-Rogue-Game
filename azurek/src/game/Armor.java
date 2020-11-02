package game;
public class Armor extends Item{
	
	int room;
    int serial;
    char type;
	
    public Armor(String _name){
		name = _name;
		type = ']';
        System.out.println("Construct Armor name is:" + name);
    }

    void setName(String s){
		name = s;
        System.out.println("setName Armor input is: " + s);
    }

    void setID(int _room, int _serial){
		room = _room;
		serial = _serial;
        System.out.println("SetID Armor room:" + room + "serial: " + serial);
    }

    int getRoom(){
        return room;
    }

    char getType(){
        return type;
    }
}