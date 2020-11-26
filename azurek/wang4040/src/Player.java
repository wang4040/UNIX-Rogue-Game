package src;
public class Player extends Creature{
	
	
    int serial;
    int maxHit;
	Item weapon;
	Item armor;
	
	public Player(String _name, int _room, int _serial){
		name = _name;
		room = _room;
		serial = _serial;
        //System.out.println("Construct Player name: " + name + " room: " + room + " serial: " + serial);
	}
	
    void setWeapon(Item _sword){
        weapon = _sword;
    }

    void setArmor(Item _armor){
        armor = _armor;
    }
	
	Item getWeapon( ){
		return weapon;
	}
	
	Item getArmor( ){
		return armor;
	}

    void setMaxHit(int _maxHit){
        maxHit = _maxHit;
    }

    int getMaxHit(){
        return maxHit;
    }
}