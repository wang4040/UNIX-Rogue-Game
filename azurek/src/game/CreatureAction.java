package game;
public class CreatureAction extends Action{
    String action;
    Creature creature;
    CreatureAction(Creature owner){
        creature = owner;
    }

    void setAction(String _action){
        action = _action;
    }


    void Remove(String name, Creature owner){
        //System.out.println("Remove CreatureAction name: " + name);
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

        Rogue.displayMessageInfo(message);
    }

    void Teleport(String name, Creature owner){
        //System.out.println("Teleport Creature Action name: " + name);

        Rogue.displayMessageInfo(message);
    }

    void ChangedDisplayedType(String name, Creature owner){
        //System.out.println("ChangedDisplayedType CreatureAction name: " + name);

        Rogue.displayMessageInfo(message);
    }

    void EndGame(String name, Creature owner){
        //System.out.println("EndGame CreatureAction name: " + name);

        Rogue.displayMessageInfo(message);
    }

    void DropPack(String name, Creature owner){
        //System.out.println("DropPack CreatureAction name: " + name);

        Rogue.displayMessageInfo(message);
    } 

    void EmptyPack(String name, Creature owner){


        Rogue.displayMessageInfo(message);
    }
}