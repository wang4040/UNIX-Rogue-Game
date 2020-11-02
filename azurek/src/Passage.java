//package game;
import java.util.ArrayList;

public class Passage extends Structure{
	
	Room room1;
	Room room2;
	ArrayList<Integer> cornersPosX = new ArrayList<>(); //List of corners' PosX coordinates
	ArrayList<Integer> cornersPosY = new ArrayList<>(); //List of corners' PosY coordinates
	
    Passage( ){
		System.out.println("new Passage");
		room1 = new Room("1");
		room2 = new Room("2");
    }

    void setName(String s){
        System.out.println("setName s: " + s);
    }

    void setID(int _room1, int _room2){
		room1.setId(_room1);
		room2.setId(_room2);
        System.out.println("setID room1: " + room1 + " room2: " + room2);
    }
	
	void addCornerPosX(int PosX) {
		cornersPosX.add(PosX);
	}
	
	void addCornerPosY(int PosY) {
		cornersPosY.add(PosY);
	}
	
	public ArrayList<Integer> getCornerPosX( ) {
		return cornersPosX;
	}
	
	public ArrayList<Integer> getCornerPosY( ) {
		return cornersPosY;
	}
}