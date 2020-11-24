package game;
public class ItemAction extends Action{
    Item owner;
    String action;
	
    public ItemAction(Item _owner){
		owner = _owner;
        //System.out.println("construct ItemAction with item" + owner);
    }

    void setAction(String _action){
        action = _action;
    }

    void BlessCurseOwner(Creature owner){
        //System.out.println("ItemAction BlessCurseOwner " + owner);
    }

    void Hallucinate(Creature owner){
        //System.out.println("ItemAction Hallucinate " + owner);
    }
}