public class CreatureAction extends Action{
    CreatureAction(Creature owner){
        System.out.println("CreatureAction");
    }

    void Remove(String name, Creature owner){
        System.out.println("Remove CreatureAction");
    }

    void YouWin(String name, Creature owner){
        System.out.println("YouWin CreatureAction");
    }

    void UpdateDisplay(String name, Creature owner){
        System.out.println("UpdateDisplay CreatureAction");
    }

    void Teleport(String name, Creature owner){
        System.out.println("Teleport Creature Action");
    }

    void ChangedDisplayedType(String name, Creature owner){
        System.out.println("ChangedDisplayedType CreatureAction");
    }

    void EndGame(String name, Creature owner){
        System.out.println("EndGame CreatureAction");
    }

    void DropPack(String name, Creature owner){
        System.out.println("DropPack CreatureAction");
    }
}