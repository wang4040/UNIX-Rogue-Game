package game;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class DungeonXMLHandler extends DefaultHandler {
	
	private StringBuilder data = null;
	
	ArrayList<Room> rooms = new ArrayList<Room>();
	ArrayList<Monster> monsters = new ArrayList<Monster>();
	ArrayList<Dungeon> dungeons = new ArrayList<Dungeon>();
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Passage> passages = new ArrayList<Passage>();
	ArrayList<Scroll> scrolls = new ArrayList<Scroll>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	ArrayList<Sword> swords = new ArrayList<Sword>();

	private Dungeon dungeonBeingParsed = null;
	private Room roomBeingParsed = null;
	private Monster monsterBeingParsed = null;
	private Player playerBeingParsed = null;
	private CreatureAction crtactBeingParsed = null;
	private Item itemBeingParsed = null;
	private ItemAction itmactBeingParsed = null;
	private Passage passageBeingParsed = null;
	
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
	private boolean bItemIntVal = false;
	
	
	public ArrayList<Room> getRooms() {
        return rooms;
    }
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public ArrayList<Dungeon> getDungeons(){
		return dungeons;
	}

	public ArrayList<Item> getItems(){
		return items;
	}

	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public ArrayList<Passage> getPassages() {
		return passages;
	}

	public ArrayList<Scroll> getScrolls() {
		return scrolls;
	}

	public ArrayList<Armor> getArmors(){
		return armors;
	}

	public ArrayList<Sword> getSwords(){
		return swords;
	}
	
	//implicit call to DefaultHandler
	public DungeonXMLHandler() {
	}
	
	Dungeon newDungeon;
	Room newRoom;
	Monster newMonster;
	Player newPlayer;
	CreatureAction newCrtAction;
	Scroll newScroll;
	Armor newArmor;
	Sword newSword;
	ItemAction newItmAction;
	Passage newPassage;

	@Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Dungeon")) {
			newDungeon = new Dungeon(attributes.getValue("name"), Integer.parseInt(attributes.getValue("width")), Integer.parseInt(attributes.getValue("gameHeight")), Integer.parseInt(attributes.getValue("topHeight")), Integer.parseInt(attributes.getValue("bottomHeight")));
			dungeonBeingParsed = newDungeon;
			dungeons.add(newDungeon);
		}else if(qName.equalsIgnoreCase("Room")) {
			newRoom = new Room(attributes.getValue("room"));
			roomBeingParsed = newRoom;
			rooms.add(newRoom);
		}else if(qName.equalsIgnoreCase("Monster")) {
			newMonster = new Monster(attributes.getValue("name"), Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			monsterBeingParsed = newMonster;
			monsters.add(newMonster);
		}else if(qName.equalsIgnoreCase("Player")) {	
			newPlayer = new Player(attributes.getValue("name"), Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			playerBeingParsed = newPlayer;
			players.add(newPlayer);
		}else if(qName.equalsIgnoreCase("CreatureAction")) {
			if(monsterBeingParsed != null) {
				newCrtAction = new CreatureAction(monsterBeingParsed);
				crtactBeingParsed = newCrtAction;
			}else if(playerBeingParsed != null) {
				newCrtAction = new CreatureAction(playerBeingParsed);
				crtactBeingParsed = newCrtAction;
			}
		}else if(qName.equalsIgnoreCase("Scroll")) {
			newScroll = new Scroll(attributes.getValue("name"));
			newScroll.setID(Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			itemBeingParsed = newScroll;
			scrolls.add(newScroll);
		}else if(qName.equalsIgnoreCase("Armor")) {
			newArmor = new Armor(attributes.getValue("name"));
			newArmor.setID(Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			if(playerBeingParsed != null) {
				playerBeingParsed.setArmor(newArmor);
				newArmor.setOwner(playerBeingParsed);
			}
			else {
				
				armors.add(newArmor);
			}
			itemBeingParsed = newArmor;
		}else if(qName.equalsIgnoreCase("Sword")) {
			newSword = new Sword(attributes.getValue("name"));
			newSword.setID(Integer.parseInt(attributes.getValue("room")), Integer.parseInt(attributes.getValue("serial")));
			if(playerBeingParsed != null) {
				playerBeingParsed.setWeapon(newSword);
				newSword.setOwner(playerBeingParsed);
			}
			else {
				
				swords.add(newSword);
			}
			itemBeingParsed = newSword;
		}else if(qName.equalsIgnoreCase("ItemAction")) {
			newItmAction = new ItemAction(itemBeingParsed);
			itmactBeingParsed = newItmAction;
		}else if(qName.equalsIgnoreCase("Passage")) {
			newPassage = new Passage();
			newPassage.setID(Integer.parseInt(attributes.getValue("room1")), Integer.parseInt(attributes.getValue("room2")));
			passages.add(newPassage);
			passageBeingParsed = newPassage;
		}else if(qName.equalsIgnoreCase("posX")) {
			bPosX = true;
		}else if(qName.equalsIgnoreCase("posY")) {
			bPosY = true;
		}else if(qName.equalsIgnoreCase("type")) {
			bType = true;
		}else if(qName.equalsIgnoreCase("visible")) {
			bVisible = true;
		}else if(qName.equalsIgnoreCase("hp")) {
			bHp = true;
		}else if(qName.equalsIgnoreCase("hpMoves")) {
			bHpMoves = true;
		}else if(qName.equalsIgnoreCase("maxhit")) {
			bMaxHit = true;
		}else if(qName.equalsIgnoreCase("width")) {
			bWidth = true;
		}else if(qName.equalsIgnoreCase("height")) {
			bHeight = true;
		}else if(qName.equalsIgnoreCase("ItemIntValue")) {
			bItemIntVal = true;
		}else if(qName.equalsIgnoreCase("actionCharValue")) {
			bActionCharVal = true;
		}else if(qName.equalsIgnoreCase("actionIntValue")){
			bActionIntVal = true;
		}else if(qName.equalsIgnoreCase("actionMessage")) {
			bActionMessage = true;
		}
		data = new StringBuilder();
	}
	
	@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
		//Armor and sword can only be set to the player
		//Scrolls aren't set for anyone
		
		if (bPosX){

			if (itemBeingParsed != null){
				itemBeingParsed.SetPosX(Integer.parseInt(data.toString()));
				bPosX = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.SetPosX(Integer.parseInt(data.toString()));
				bPosX = false;
			}else if (playerBeingParsed != null){
					playerBeingParsed.SetPosX(Integer.parseInt(data.toString()));
					bPosX = false;			
			}else if (roomBeingParsed != null) {
				roomBeingParsed.SetPosX(Integer.parseInt(data.toString()));
				bPosX = false;
			}else if (passageBeingParsed != null) {
				passageBeingParsed.addCornerPosX(Integer.parseInt(data.toString()));
				bPosX = false;
			}
		}else if (bPosY){
			if (itemBeingParsed != null){
				itemBeingParsed.setPosY(Integer.parseInt(data.toString()));
				bPosY = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.setPosY(Integer.parseInt(data.toString()));
				bPosY = false;
			}else if (playerBeingParsed != null){
				playerBeingParsed.setPosY(Integer.parseInt(data.toString()));
				bPosY = false;
			}else if (roomBeingParsed != null) {
				roomBeingParsed.setPosY(Integer.parseInt(data.toString()));
				bPosY = false;
			}else if (passageBeingParsed != null) {
				passageBeingParsed.addCornerPosY(Integer.parseInt(data.toString()));
				bPosY = false;
			}
		}
		else if (bType){
			if (itemBeingParsed != null){
				String str = data.toString();
				itemBeingParsed.setType(str.charAt(0));
				bType = false;
			}else if (playerBeingParsed != null){
				String str = data.toString();
				playerBeingParsed.setType(str.charAt(0));
				bType = false;
			}else if (monsterBeingParsed != null){
				String str = data.toString();
				monsterBeingParsed.setType(str.charAt(0));
				bType = false;
			}else if (roomBeingParsed != null){
				String str = data.toString();
				roomBeingParsed.setType(str.charAt(0));
				bType = false;
			}
		}
		else if (bHp){
			if (playerBeingParsed != null){
				playerBeingParsed.setHp(Integer.parseInt(data.toString()));
				bHp = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.setHp(Integer.parseInt(data.toString()));
				bHp = false;
			}

		}
		else if (bMaxHit){
			if (playerBeingParsed != null){
				playerBeingParsed.setMaxHit(Integer.parseInt(data.toString()));
				bMaxHit = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.setMaxHit(Integer.parseInt(data.toString()));
				bMaxHit = false;
			}

		}
		else if (bVisible){
			if (itemBeingParsed != null){
				itemBeingParsed.setVisible();
				bVisible = false;
			}else if (itemBeingParsed != null){
				playerBeingParsed.setVisible();
				bVisible = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.setVisible();
				bVisible = false;
			}else if (roomBeingParsed != null){
				roomBeingParsed.setVisible();
				bVisible = false;
			}else if (passageBeingParsed != null) {
				passageBeingParsed.setVisible();
				bVisible = false;
			}
		}
		else if (bInvisible){
			if (itemBeingParsed != null){
				itemBeingParsed.setInvisible();
				bInvisible = false;
			}else if (itemBeingParsed != null){
				playerBeingParsed.setInvisible();
				bInvisible = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.setInvisible();
				bInvisible = false;
			}else if (roomBeingParsed != null){
				roomBeingParsed.setInvisible();
				bInvisible = false;
			}
		}
		else if (bHpMoves){
			if (itemBeingParsed != null){
				itemBeingParsed.setHpMove(Integer.parseInt(data.toString()));
				bHpMoves = false;
			}else if (playerBeingParsed != null){
				playerBeingParsed.setHpMove(Integer.parseInt(data.toString()));
				bHpMoves = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.setHpMove(Integer.parseInt(data.toString()));
				bHpMoves = false;
			}else if (roomBeingParsed != null){
				roomBeingParsed.setHpMove(Integer.parseInt(data.toString()));
				bHpMoves = false;
			}
		}
		else if (bWidth){
			if (itemBeingParsed != null){
				itemBeingParsed.SetWidth(Integer.parseInt(data.toString()));
				bWidth = false;
			}else if (playerBeingParsed != null){
				playerBeingParsed.SetWidth(Integer.parseInt(data.toString()));
				bWidth = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.SetWidth(Integer.parseInt(data.toString()));
				bWidth = false;
			}else if (roomBeingParsed != null){
				roomBeingParsed.SetWidth(Integer.parseInt(data.toString()));
				bWidth = false;
			}
		}
		else if (bHeight){
			if (itemBeingParsed != null){
				itemBeingParsed.setHeight(Integer.parseInt(data.toString()));
				bHeight = false;
			}else if (playerBeingParsed != null){
				playerBeingParsed.setHeight(Integer.parseInt(data.toString()));
				bHeight = false;
			}else if (monsterBeingParsed != null){
				monsterBeingParsed.setHeight(Integer.parseInt(data.toString()));
				bHeight = false;
			}else if (roomBeingParsed != null){
				roomBeingParsed.setHeight(Integer.parseInt(data.toString()));
				bHeight = false;
			}
		}
		else if (bActionCharVal){
			if (itmactBeingParsed != null){
				String str = data.toString();
				itmactBeingParsed.setCharValue(str.charAt(0));
				bActionCharVal = false;
			}else if (crtactBeingParsed != null){
				String str = data.toString();
				crtactBeingParsed.setCharValue(str.charAt(0));
				bActionCharVal = false;
			}
		}
		else if (bActionMessage){
			if (itmactBeingParsed != null){
				itmactBeingParsed.setMessage(data.toString());
				bActionMessage = false;
			}else if (crtactBeingParsed != null){
				crtactBeingParsed.setMessage(data.toString());
				bActionMessage = false;
			}
		}
		else if (bActionIntVal){
			if (itmactBeingParsed != null){
				itmactBeingParsed.setIntValue(Integer.parseInt(data.toString()));
				bActionIntVal = false;
			}else if (crtactBeingParsed != null){
				crtactBeingParsed.setIntValue(Integer.parseInt(data.toString()));
				bActionIntVal = false;
			}
		}
		else if (bItemIntVal){
			if (itemBeingParsed != null){
				itemBeingParsed.setIntValue(Integer.parseInt(data.toString()));
				bItemIntVal = false;
			}
		}

		if (qName.equalsIgnoreCase("Room")) {
			roomBeingParsed = null;
		}else if (qName.equalsIgnoreCase("Monster")) {
			monsterBeingParsed = null;
		}else if (qName.equalsIgnoreCase("Player")) {
			playerBeingParsed = null;
		}else if (qName.equalsIgnoreCase("Item")){
			itemBeingParsed = null;
		}else if (qName.equalsIgnoreCase("ItemAction")){
			itmactBeingParsed = null;
		}else if (qName.equalsIgnoreCase("CreatureAction")){
			crtactBeingParsed = null;
		}else if (qName.equalsIgnoreCase("Scroll") || qName.equalsIgnoreCase("Sword") || qName.equalsIgnoreCase("Armor")){
			itemBeingParsed = null;
		}
	}
	@Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}



