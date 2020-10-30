package game;
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
        default: System.out.println("java Test <xmlfilename>");
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
            ArrayList<Room> rooms = handler.getRooms();
            ArrayList<Dungeon> dungeons = handler.getDungeons();
            ArrayList<Item> items = hander.getItems();
            ArrayList<Monster> monsters = handler.getMonsters();
			ArrayList<Player> players = handler.getPlayers();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace(System.out);
        }
		
		int width = dungeons[0].getwidth();
		int gameHeight = dungeons[0].getGameHeight();
		int topHeight = dungeons[0].getTopHeight();
		int bottomHeight = dungeons[0].getBottomHeight();
		
		Rogue rogue = new Rogue(width, topHeight, gameHeight, bottomHeight);
		//ObjectDisplayGrid gameGrid = rogue.getDisplayGrid();
		
		//Below used to read inputs
		//test.keyStrokePrinter = new Thread(new KeyStrokePrinter(displayGrid));
        //test.keyStrokePrinter.start();
		
		
		
		
		//BELOW IS TEST CODE TO DISPLAY EVERYTHING
		displayGrid.initializeDisplay();
		int i, j, m, n;
		Char dash = new Char('-');
		Char wall = new Char('|');
		Char hash = new Char('#');
		Char plus = new Char('+');
		
		//print all rooms
		for (i = 0; i < rooms.size(); i++) {
			//basically just for loop across to print '-', and for loop down to print '|', super easy
			for(m = rooms[i].getPosX(); m < (rooms[i].getPosX() + rooms[i].getWidth); m++) {
				displayGrid.addObjectToDisplay(dash, m, rooms[i].getPosY());
				displayGrid.addObjectToDisplay(dash, m, rooms[i].getPosY() + rooms[i].getHeight);
			}
			for(n = rooms[i].getPosY(); n < (rooms[i].getPosY() + rooms[i].getHeight); n++) {
				displayGrid.addObjectToDisplay(dash, rooms[i].getPosX(), n);
				displayGrid.addObjectToDisplay(dash, rooms[i].getPosX() + rooms[i].getWidth, n);
			}
		}
		//print all items
		for (i = 0; i < items.size(); i++) {
			Char ch = new Char(items[i].getType());
			displayGrid.addObjectToDisplay(ch, items[i].getPosX(), items[i].getPosY());
		}
		//print all monsters
		for (i = 0; i < monsters.size(); i++) {
			Char ch = new Char(monsters[i].getType());
			displayGrid.addObjectToDisplay(ch, monsters[i].getPosX(), monsters[i].getPosY());
		}
		//print all passages
		for (i = 0; i < passages.size(); i++) {
			ArrayList<int> cornersPosX = passages[i].getCornerPosX();
			ArrayList<int> cornerPosY = passages[i].getCornerPosY();
			numCorners = cornerPosX.size();

			//Use for loop to display passage such that beginning and end are +, and everything in between is #, connecting all the corners
			displayGrid.addObjectToDisplay(plus, cornersPosX[0], cornersPosY[0]); //prints first corner as plus
			for (j = 0; j < (numCorners - 1); j++) { //for loop that doesn't print current corner, but the next corner and the path towards it
				if (cornersPosX[j] < cornersPosX[j + 1]) {
					for (m = cornersPosX[j] + 1; m < cornersPosX[j + 1]; m++) {
						displayGrid.addObjectToDisplay(hash, m, cornersPosY[j]);
					}
				}else if (cornersPosX[j] > cornersPosX[j + 1]) {
					for (m = cornersPosX[j] - 1; m > cornersPosX[j + 1]; m--) {
						displayGrid.addObjectToDisplay(hash, m, cornersPosY[j]);
					}
				}else if (cornersPosY[j] < cornersPosY[j + 1]) {
					for (n = cornersPosY[j] + 1; n < cornersPosY[j + 1]; n++) {
						displayGrid.addObjectToDisplay(hash, cornersPosX[j], n);
					}
				}else if (cornersPosY[j] > cornersPosY[j + 1]) {
					for (n = cornersPosY[j] - 1; n > cornersPosY[j + 1]; n--) {
						displayGrid.addObjectToDisplay(hash, cornersPosX[j], n);
					}
				}
				if (j == (numCorners - 2)) { //if the next corner is the final one, print plus instead
					displayGrid.addObjectToDisplay(plus, cornersPosX[j + 1], cornersPosY[j + 1]);
				}else {
					displayGrid.addObjectToDisplay(hash, cornersPosX[j + 1], cornersPosY[j + 1]);
				}
			}
		}
		//Finally, print player
		displayGrid.addObjectToDisplay(new Char('@'), player[0].getPosX(), player[0].getPosY());
    }
}