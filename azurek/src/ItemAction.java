package src;
public class ItemAction extends Action{
    ItemAction(Item owner){
        System.out.println("ItemAction");
    }

    void BlessCurseOwner(Creature owner){
        System.out.println("BlessCurseOwner ItemAction");
    }

    void Hallucinate(Creature owner){
        System.out.println("Hallucinate ItemAction");
    }
}