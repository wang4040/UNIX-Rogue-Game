package src;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class DungeonXMLHandler extends DefaultHandler {
	
	private StringBuilder data = null;
	
	ArrayList<Room> rooms = new ArrayList<Room>();
	ArrayList<Monster> monsters = new ArrayList<Monsters>();

	private Dungeon dungeonBeingParsed = null;
	private Room roomBeingParsed = null;
	private Monster monsterBeingParsed = null;
	private Player playerBeingParsed = null;
	private CreatureAction crtactBeingParsed = null;
	private Item itemBeingParsed = null;
	private ItemAction itmactBeingParsed = null;
	
	//booleans to determine which one is parsing
	private boolean bPosX = false;
	private boolean bPosY = false;
	private boolean bType = false;
	private boolean bHp = false;
	private boolean bMaxHit = false;
	private boolean bVisible = false;
	private boolean bInvisible = false;
	private boolean bHpMoves = false;
	private boolean bWidth = false;
	private boolean bHeight = false;
	private boolean bActionCharVal = false;
	private boolean bActionMessage = false;
	private boolean bActionIntVal = false;
	private boolean bItemIntVal = false
	
	
	public ArrayList<Room> getRooms() {
        return rooms;
    }
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	//implicit call to DefaultHandler
	public DungeonXMLHandler() {
	}
	
	@Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Dungeon")) {
			newDungeon = new Dungeon(attributes.getValue("name"), Integer.parseInt(attributes.getValue("width")), Integer.parseInt(attributes.getValue("gameHeight"));
			dungeonBeingParsed = newDungeon;
		}else if(qName.equalsIgnoreCase("Room") {
			newRoom = new Room(attributes.getValue("room"));
			roomBeingParsed = newRoom;
			rooms.add(newRoom);
		}else if(qName.equalsIgnoreCase("Monster") {
			newMonster = new Monster(attribute.getValue("name"), Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			monsterBeingParsed = newMonster;
			monsters.add(newMonster);
		}else if(qName.equalsIgnoreCase("Player") {	
			newPlayer = new Player(attribute.getValue("name"), Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			playerBeingParsed = newPlayer;
		}else if(qName.equalsIgnoreCase("CreatureAction") {
			if(monsterBeingParsed != null) {
				newCrtAction = new CreatureAction(monsterBeingParsed);
				crtactBeingParsed = newCrtAction;
			}else if(playerBeingParsed != null) {
				newCrtAction = new CreatureAction(playerBeingParsed);
				crtactBeingParsed = newCrtAction;
			}
		}else if(qName.equalsIgnoreCase("Scroll") {
			newScroll = new Scroll(attribute.getValue("name"));
			newScroll.setID(Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			itemBeingParsed = newScroll;
		}else if(qName.equalsIgnoreCase("Armor") {
			newArmor = new Armor(attribute.getValue("name"));
			newArmor.setID(Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			itemBeingParsed = newArmor;
		}else if(qName.equalsIgnoreCase("Sword") {
			newSword = new Sword(attribute.getValue("name"));
			newSword.setID(Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			itemBeingParsed = newSword;
		}else if(qName.equalsIgnoreCase("ItemAction") {
			newItmAction = new ItemAction(itemBeingParsed);
			itmactBeingParsed = newItmAction;
		}
		}else if(qName.equalsIgnoreCase("posX") {
			bPosX = true;
		}else if(qName.equalsIgnoreCase("posY") {
			bPosY = true;
		}else if(qName.equalsIgnoreCase("type") {
			bType = true;
		}else if(qName.equalsIgnoreCase("visible") {
			bVisible = true;
		}else if(qName.equalsIgnoreCase("hp") {
			bHp = true;
		}else if(qName.equalsIgnoreCase("hpMoves") {
			bHpMoves = true;
		}else if(qName.equalsIgnoreCase("maxhit") {
			bMaxHit = true;
		}else if(qName.equalsIgnoreCase("width") {
			bWidth = true;
		}else if(qName.equalsIgnoreCase("height") {
			bHeight = true;
		}else if(qName.equalsIgnoreCase("ItemIntValue") {
			bItemIntVal = true;
		}else if(qName.equalsIgnoreCase("actionCharValue") {
			bActionCharVal = true;
		}else if(qName.equalsIgnoreCase("actionIntValue") {
			bActionIntVal = true;
		}else if(qName.equalsIgnoreCase("actionMessage") {
			bActionMessage = true;
		}
	}
	
	@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
		//Armor and sword can only be set to the player
		//Scrolls aren't set for anyone
		
		if (bPosX){
			if (playerBeingParsed != null){
				playerBeingParsed.SetPosX(Integer.parseInt(data.toString()));
				bPosX = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.SetPosX(Integer.parseInt(data.toString()));
				bPosX = false;
			}else if (roomBeingParsed != null) {
				roomBeingParsed.SetPosX(Integer.parseInt(data.toString()));
				bPosX = false;
			}
		}else if (bPosY){
			if (playerBeingParsed != null){
				playerBeingParsed.SetPosY(Integer.parseInt(data.toString()));
				bPosX = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.SetPosY(Integer.parseInt(data.toString()));
				bPosX = false;
			}else if (roomBeingParsed != null) {
				roomBeingParsed.SetPosY(Integer.parseInt(data.toString()));
				bPosX = false;
			}
		}
		else if (bType){
			String str = data.toString();
			playerBeingParsed.setType(str.charAt(0));
			bType = false;
		}
		else if (bHp){
			playerBeingParsed.setHp(Integer.parseInt(data.toString()));
			bHp = false;
		}
		else if (bMaxHit){
			playerBeingParsed.setMaxHit(Integer.parseInt(data.toString()));
			bMaxHit = false;
		}
		else if (bVisible){
			playerBeingParsed.setVisible();
			bVisible = false;
		}
		else if (bInvisible){
			playerBeingParsed.setInvisible();
			bInvisible = false;
		}
		else if (bHpMoves){
			playerBeingParsed.setHpMoves(Integer.parseInt(data.toString()));
		}
		else if (bWidth){
			playerBeingParsed.SetWidth(Integer.parseInt(data.toString()));
		}
		else if (bHeight){
			playerBeingParsed.setHeight(Integer.parseInt(data.toString()));
		}
		else if (bHeight){
			playerBeingParsed.setHeight(Integer.parseInt(data.toString()));
		}
		else if (bHeight){
			playerBeingParsed.setHeight(Integer.parseInt(data.toString()));
		}
		else if (bHeight){
			playerBeingParsed.setHeight(Integer.parseInt(data.toString()));
		}
		else if (bHeight){
			playerBeingParsed.setHeight(Integer.parseInt(data.toString()));
		}
		else if (bHeight){
			playerBeingParsed.setHeight(Integer.parseInt(data.toString()));
		}	
		
		
		if (qName.equalsIgnoreCase("Room")) {
			roomBeingParsed = null;
		}else if (qName.equalsIgnoreCase("Monster") {
			monsterBeingParsed = null;
		}else if (qName.equalsIgnoreCase("Player") {
			playerBeingParsed = null;
		}
	}
}



