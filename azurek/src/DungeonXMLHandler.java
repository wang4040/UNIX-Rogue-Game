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
	
	//booleans to determine which one is parsing
	private boolean bRoom = false;
	
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
			
		}
	}
	
	@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
	
	}
}



