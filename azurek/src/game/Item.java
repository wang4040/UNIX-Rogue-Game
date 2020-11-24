package game;
public class Item extends Displayable{

	int uniPosX;
	int uniPosY;
	int serial;
	ArrayList<ItemAction> ia = new ArrayList<ItemAction>();

    void setOwner(Creature owner){
        //System.out.println("setOwner Creature for item: " + owner);
	}
	
	void setUniPosX(int x) {
		uniPosX = x;
	}
	
	void setUniPosY(int y) {
		uniPosY = y;
	}
	
	int getUniPosX() {
		return uniPosX;
	}
	
	int getUniPosY() {
		return uniPosY;
	}
	
	int getSerial() {
		return serial;
	}

	void addItemAction(ItemAction _ia){
		ia.add(_ia);
	}

}