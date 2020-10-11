//package src;
public class ItemAction extends Action{
	Item owner;
	
    public ItemAction(Item _owner){
		owner = _owner;
        System.out.println("construct ItemAction with item" + owner);
    }

    void BlessCurseOwner(Creature owner){
        System.out.println("ItemAction BlessCurseOwner " + owner);
    }

    void Hallucinate(Creature owner){
        System.out.println("ItemAction Hallucinate " + owner);
    }
}