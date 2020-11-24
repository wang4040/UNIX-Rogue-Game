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

    /*void Remove(String name, Creature owner){
        System.out.println("Remove CreatureAction name: " + name);
    }

    void YouWin(String name, Creature owner){
        System.out.println("YouWin CreatureAction name: " + name);
    }

    void UpdateDisplay(String name, Creature owner){
        System.out.println("UpdateDisplay CreatureAction name: " + name);
    }

    void Teleport(String name, Creature owner){
        System.out.println("Teleport Creature Action name: " + name);
    }

    void ChangedDisplayedType(String name, Creature owner){
        System.out.println("ChangedDisplayedType CreatureAction name: " + name);
    }

    void EndGame(String name, Creature owner){
        System.out.println("EndGame CreatureAction name: " + name);
    }

    void DropPack(String name, Creature owner){
        System.out.println("DropPack CreatureAction name: " + name);
    } */
}