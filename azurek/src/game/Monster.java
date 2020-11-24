package game;
public class Monster extends Creature{
	
	
    int serial;
    int maxHit;
	
    public Monster(String _name, int _room, int _serial){
		name = _name;
		room = _room;
		serial = _serial;
        //System.out.println("Construct Monster name: " + name + " room: " + room + " serial: " + serial);
    }

    void setName(String s){
        //System.out.println("setName Monster s: " + s);
    }

    void setID(int _room, int _serial){
        room = _room;
        serial = _serial;
        //System.out.println("setID Monster room: " + room + " serial: " + serial);
    }



    void setMaxHit(int _maxHit){
        maxHit = _maxHit;
    }

    int getMaxHit(){
        return maxHit;
    }

    int getID(){
        return serial;
    }
}