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
		String message;
		if(charValue == 'a') {
			if(owner.getArmor() != null) {
				int newVal = owner.getArmor().getIntValue;
				newVal += intValue;
				owner.getArmor().setIntValue(newVal);
				message = owner.getArmor().getName() + " cursed! " + intVal + " taken from its effectiveness"
			}else {
				message = "scroll of cursing does nothing because armor is not being used"
		}else if(charValue == 'w') {
			if(owner.getWeapon() != null) {
				int newVal = owner.getWeapon().getIntValue;
				newVal += intValue;
				owner.getWeapon().setIntValue(newVal);
				message = owner.getWeapon().getName() + " cursed! " + intVal + " taken from its effectiveness"
			}else {
				message = "scroll of cursing does nothing because weapon is not being used"
			}
		}
		Rogue.displayMessageInfo(message);
    }

    void Hallucinate(Creature owner){
        //System.out.println("ItemAction Hallucinate " + owner);
    }
}