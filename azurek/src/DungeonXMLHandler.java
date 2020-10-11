package src;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class DungeonXMLHandler extends DefaultHandler {
	
	private StringBuilder data = null;
	
	List<Dungeon> dungeons = new ArrayList<Dungeon>();

	private Dungeon dungeonBeingParsed = null;
	private Room roomBeingParsed = null;
	
	//booleans to determine which one is parsing
	private boolean bRooms = false;
	
	public ArrayList<Dungeon> getDungeon() {
        return dungeons;
    }
	
	//implicit call to DefaultHandler
	public DungeonXMLHandler() {
	}
	
	@Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Dungeon")) {
			dung = new Dungeon(attributes.getValue("name"), Integer.partInt(attributes.getValue("width")), Integer.partInt(attributes.getValue("gameHeight"));
			dungeons.add(dung);
		}else if(qName.equalsIgnoreCase("Rooms") {
			
		}
	}
	
	@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
	
	}
}



