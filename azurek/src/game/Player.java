package game;
public class Player extends Creature{
	
	int room;
	int serial;
	
	public Player(String _name, int _room, int _serial){
		name = _name;
		room = _room;
		serial = _serial;
        System.out.println("Construct Player name: " + name + " room: " + room + " serial: " + serial);
	}
	
    void setWeapon(Item sword){
        System.out.println("setWeapon Player");
    }

    void setArmor(Item armor){
        System.out.println("setArmor Player");
    }
}