package src;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class DungeonXMLHandler extends DefaultHandler {
	
	private StringBuilder data = null;
	
	ArrayList<Room> rooms = new ArrayList<Room>();

	private Dungeon dungeonBeingParsed = null;
	private Room roomBeingParsed = null;
	private Monster monsterBeingParsed = null;
	private Player playerBeingParsed = null;
	
	//booleans to determine which one is parsing
	private boolean bPosX = false;
	private boolean bPosY = false;
	private boolean bType = false;
	private boolean bHp = false;
	private boolean bMaxHit = false;
	private boolean bVisible = false;
	private boolean bHpMoves = false;
	private boolean bWidth = false;
	private boolean bHeight = false;
	
	
	public ArrayList<Room> getRooms() {
        return rooms;
    }
	
	//implicit call to DefaultHandler
	public DungeonXMLHandler() {
	}
	
	@Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Dungeon")) {
			newDungeon = new Dungeon(attributes.getValue("name"), Integer.partInt(attributes.getValue("width")), Integer.partInt(attributes.getValue("gameHeight"));
			dungeonBeingParsed = newDungeon;
		}else if(qName.equalsIgnoreCase("Room") {
			newRoom = new Room(attributes.getValue("room"));
			roomBeingParsed = newRoom;
			rooms.add(room);
		}else if(qName.equalsIgnoreCase("posX") {
			b
		}
	}
	
	@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
		if (
	}
}



