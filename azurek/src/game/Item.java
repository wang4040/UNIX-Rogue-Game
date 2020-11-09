package game;
public class Item extends Displayable{

	int uniPosX;
	int uniPosY;
	int serial;

    void setOwner(Creature owner){
        //System.out.println("setOwner Creature for item: " + owner);
    }
	
	void setUniPosX(int x) {
		uniPosX = x;
	}
	
	void setUniPosY(int y) {
		uniPosY = y;
	}
	
	int getUniPosX(int x) {
		return uniPosX;
	}
	
	int getUniPosY(int y) {
		return uniPosY;
	}
	
	int getSerial() {
		return serial;
	}
}