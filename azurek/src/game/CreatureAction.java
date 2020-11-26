package game;
import java.util.Random;

public class CreatureAction extends Action{
    String action;
    Creature creature;
    CreatureAction(Creature owner){
        creature = owner;
    }

    void setAction(String _action){
        action = _action;
    }

    String getAction(){
        return action;
    }


    void Remove(String name, Creature owner){
        //System.out.println("Remove CreatureAction type: " + owner.getType());
        int roomX = 0;
        int roomY = 0;
        Monster monster = (Monster) owner;
        int j;
        for (j = 0; j < Rogue.rooms.size(); j++){
            if (Rogue.rooms.get(j).getId() == monster.getRoom()){
                roomX = Rogue.rooms.get(j).getPosX();
                roomY = Rogue.rooms.get(j).getPosY();
            }
        }
        Rogue.monsterDeath(monster, roomX, roomY);
        Rogue.displayMessageInfo(message);
    }

    void YouWin(String name, Creature owner){
        //System.out.println("YouWin CreatureAction name: " + name);

        Rogue.displayMessageInfo(message);
    }

    void UpdateDisplay(String name, Creature owner){
        //System.out.println("UpdateDisplay CreatureAction name: " + name);
		if(owner.getType() == '@') {
			Rogue.updateTopDisplay();
		}
        if (message != null)
            Rogue.displayMessageInfo(message);
    }

    void Teleport(String name, Creature owner){
        //System.out.println("Teleport Creature Action name: " + name);
		Random rand = new Random();
		int newX = rand.nextInt(Rogue.getW());
		int newY = rand.nextInt(Rogue.getGH());
		int roomX = 0;
        int roomY = 0;
        int i;
        for(i = 0; i < Rogue.rooms.size(); i++){
            if (Rogue.rooms.get(i).getId() == owner.getRoom()){
                roomX = Rogue.rooms.get(i).getPosX();
                roomY = Rogue.rooms.get(i).getPosY();
            }
        }
		Char c = Rogue.getDisplayGrid().getTop( roomX + owner.getPosX(), roomY + owner.getPosY() + Rogue.getTopHeight() );
		Rogue.getDisplayGrid().removeObjectToDisplay( roomX + owner.getPosX(), roomY + owner.getPosY() + Rogue.getTopHeight() );
		
		while(true) {
			if(Rogue.getDisplayGrid().getTop(newX, newY+Rogue.getTopHeight()).getChar() == '.') {
				owner.setUniPosX(newX);
				owner.setUniPosY(newY+Rogue.getTopHeight());
				owner.SetPosX(newX - roomX);
				owner.setPosY(newY - roomY);
				Rogue.getDisplayGrid().addObjectToDisplay(c, newX, newY+Rogue.getTopHeight());
				break;
			}else {
				newX = rand.nextInt(Rogue.getW());
				newY = rand.nextInt(Rogue.getGH());
			}
		}
		
        Rogue.displayMessageInfo(message);
    }

    void ChangedDisplayedType(String name, Creature owner){
        //System.out.println("ChangedDisplayedType CreatureAction name: " + name);
        int roomX = 0;
        int roomY = 0;
        int i;
        for(i = 0; i < Rogue.rooms.size(); i++){
            if (Rogue.rooms.get(i).getId() == owner.getRoom()){
                roomX = Rogue.rooms.get(i).getPosX();
                roomY = Rogue.rooms.get(i).getPosY();
            }
        }
        ObjectDisplayGrid displayGrid = Rogue.getDisplayGrid();
        displayGrid.removeObjectToDisplay(owner.getPosX() + roomX, owner.getPosY() + roomY + Rogue.getTopHeight());
        displayGrid.addObjectToDisplay(new Char(charValue), owner.getPosX() + roomX, owner.getPosY() + roomY + Rogue.getTopHeight());
        Rogue.displayMessageInfo(message);
    }

    void EndGame(String name, Creature owner){
        //System.out.println("EndGame CreatureAction name: " + name);
        KeyStrokePrinter.setDead();
        Rogue.displayMessageInfo(message);
    }

    void DropPack(String name, Creature owner){
        //System.out.println("DropPack CreatureAction name: " + name);
		Rogue.dropItem(0);
        Rogue.displayMessageInfo(message);
    } 

    void EmptyPack(String name, Creature owner){
		
		Rogue.emptyPack();
        Rogue.displayMessageInfo(message);
    }
}