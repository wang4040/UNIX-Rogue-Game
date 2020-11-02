//package game;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.*;

import org.xml.sax.SAXException;
public class Rogue implements Runnable{

	private static final int DEBUG = 0;
    private boolean isRunning;
    public static final int FRAMESPERSECOND = 60;
    public static final int TIMEPERLOOP = 1000000000 / FRAMESPERSECOND;
    private static ObjectDisplayGrid displayGrid = null;
    private Thread keyStrokePrinter;

    public Rogue(int width, int topHeight, int gameHeight, int bottomHeight){
		displayGrid = new ObjectDisplayGrid(width, topHeight, gameHeight, bottomHeight);
    }

	public ObjectDisplayGrid getDisplayGrid( ) {
		return displayGrid;
	}

    public void run(){ //This is used when threads are used and inputs are read
		//displayGrid.initializeDisplay();
    }

    public static void main(String[] args){
        // check if a filename is passed in.  If not, print a usage message.
        // If it is, open the file
        String fileName = null;
        switch (args.length) {
        // note that the relative file path may depend on what IDE you are
		// using.  This worked for NetBeans.
        case 1: fileName = "xmlfiles/" + args[0];
			break;
        default: System.out.println("java Rogue <xmlfilename>");
			return;
        }

		// Create a saxParserFactory, that will allow use to create a parser
		// Use this line unchanged
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DungeonXMLHandler handler = new DungeonXMLHandler();
            saxParser.parse(new File(fileName), handler);
			// This will change depending on what kind of XML we are parsing

			// This will change depending on what kind of XML we are parsing
			ArrayList<Room> rooms = handler.getRooms();
			ArrayList<Dungeon> dungeons = handler.getDungeons();
			ArrayList<Item> items = handler.getItems();
			ArrayList<Monster> monsters = handler.getMonsters();
			ArrayList<Player> players = handler.getPlayers();	
			ArrayList<Passage> passages = handler.getPassages();	
			int width = dungeons.get(0).getWidth();
			int gameHeight = dungeons.get(0).getGameHeight();
			int topHeight = dungeons.get(0).getTopHeight();
			int bottomHeight = dungeons.get(0).getBottomHeight();
			
			Rogue rogue = new Rogue(width, topHeight, gameHeight, bottomHeight);
			//ObjectDisplayGrid gameGrid = rogue.getDisplayGrid();
			
			//Below used to read inputs
			//test.keyStrokePrinter = new Thread(new KeyStrokePrinter(displayGrid));
			//test.keyStrokePrinter.start();
			
			
			
			//BELOW IS TEST CODE TO DISPLAY EVERYTHING
			displayGrid.initializeDisplay();
			int i, j, m, n, k;
			Char dash = new Char('X');
			Char dot = new Char('.');
			Char hash = new Char('#');
			Char plus = new Char('+');
			
			//print all rooms
			for (i = 0; i < rooms.size(); i++) {
				//basically just for loop across to print '-', and for loop down to print '|', super easy
				for(m = rooms.get(i).getPosX(); m < (rooms.get(i).getPosX() + rooms.get(i).getWidth() - 1); m++) {
					displayGrid.addObjectToDisplay(dash, m, topHeight + rooms.get(i).getPosY());
					displayGrid.addObjectToDisplay(dash, m, topHeight + rooms.get(i).getPosY() + rooms.get(i).getHeight() - 1);
				}
				for(n = rooms.get(i).getPosY(); n <= (rooms.get(i).getPosY() + rooms.get(i).getHeight() - 1); n++) {
					displayGrid.addObjectToDisplay(dash, rooms.get(i).getPosX(), topHeight + n);
					displayGrid.addObjectToDisplay(dash, rooms.get(i).getPosX() + rooms.get(i).getWidth() - 1, topHeight + n);
				}
				for(j = rooms.get(i).getPosX() + 1; j < (rooms.get(i).getPosX() + rooms.get(i).getWidth() - 1); j++) {
					for(k = rooms.get(i).getPosY() + 1; k < (rooms.get(i).getPosY() + rooms.get(i).getHeight() - 1); k++){
						displayGrid.addObjectToDisplay(dot, j, topHeight + k);
					}
				}
			}

			//print all items
			int roomX = 0;
			int roomY = 0;
			for (i = 0; i < items.size(); i++) {
				Char ch = new Char(items.get(i).getType());
				for (j = 0; j < rooms.size(); j++){
					if (rooms.get(j).getId() == monsters.get(i).getRoom()){
						roomX = rooms.get(j).getPosX();
						roomY = rooms.get(j).getPosY(); 
					}
				}
				displayGrid.addObjectToDisplay(ch, items.get(i).getPosX() + roomX, topHeight + items.get(i).getPosY() + roomY);
			}
			//print all monsters
			for (i = 0; i < monsters.size(); i++) {
				Char ch = new Char(monsters.get(i).getType());
				for (j = 0; j < rooms.size(); j++){
					if (rooms.get(j).getId() == monsters.get(i).getRoom()){
						roomX = rooms.get(j).getPosX();
						roomY = rooms.get(j).getPosY(); 
					}
				}
				displayGrid.addObjectToDisplay(ch, monsters.get(i).getPosX() + roomX, topHeight + monsters.get(i).getPosY() + roomY);
			}
			//print all passages
			for (i = 0; i < passages.size(); i++) {
				ArrayList<Integer> cornersPosX = passages.get(i).getCornerPosX();
				ArrayList<Integer> cornersPosY = passages.get(i).getCornerPosY();
				int numCorners = cornersPosX.size();

				//Use for loop to display passage such that beginning and end are +, and everything in between is #, connecting all the corners
				displayGrid.addObjectToDisplay(plus, cornersPosX.get(0), topHeight + cornersPosY.get(0)); //prints first corner as plus
				for (j = 0; j < (numCorners - 1); j++) { //for loop that doesn't print current corner, but the next corner and the path towards it
					if (cornersPosX.get(j) < cornersPosX.get(j + 1)) {
						for (m = cornersPosX.get(j) + 1; m < cornersPosX.get(j + 1); m++) {
							displayGrid.addObjectToDisplay(hash, m, topHeight + cornersPosY.get(j));
						}
					}else if (cornersPosX.get(j) > cornersPosX.get(j + 1)) {
						for (m = cornersPosX.get(j) - 1; m > cornersPosX.get(j + 1); m--) {
							displayGrid.addObjectToDisplay(hash, m, topHeight + cornersPosY.get(j));
						}
					}else if (cornersPosY.get(j) < cornersPosY.get(j + 1)) {
						for (n = cornersPosY.get(j) + 1; n < cornersPosY.get(j + 1); n++) {
							displayGrid.addObjectToDisplay(hash, cornersPosX.get(j), topHeight + n);
						}
					}else if (cornersPosY.get(j) > cornersPosY.get(j + 1)) {
						for (n = cornersPosY.get(j) - 1; n > cornersPosY.get(j + 1); n--) {
							displayGrid.addObjectToDisplay(hash, cornersPosX.get(j), topHeight + n);
						}
					}
					if (j == (numCorners - 2)) { //if the next corner is the final one, print plus instead
						displayGrid.addObjectToDisplay(plus, cornersPosX.get(j + 1), topHeight + cornersPosY.get(j + 1));
					}else {
						displayGrid.addObjectToDisplay(hash, cornersPosX.get(j + 1), topHeight + cornersPosY.get(j + 1));
					}
				}
			}
			//Finally, print player
			for (j = 0; j < rooms.size(); j++){
				if (rooms.get(j).getId() == monsters.get(i).getRoom()){
					roomX = rooms.get(j).getPosX();
					roomY = rooms.get(j).getPosY(); 
				}
			}
			displayGrid.addObjectToDisplay(new Char('@'), players.get(0).getPosX() + roomX, topHeight + players.get(0).getPosY() + roomY);
			
		}catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace(System.out);
		}
    }
}