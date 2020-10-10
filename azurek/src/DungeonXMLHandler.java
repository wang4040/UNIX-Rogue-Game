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
	
	//implicit call to DefaultHandler
	public DungeonXMLHandler() {
	}
	
	@Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	
	}
	
	@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
	
	}
}