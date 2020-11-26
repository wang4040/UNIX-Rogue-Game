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
		
		Player player = Rogue.getPlayers().get(0);
		if(charValue == 'a') {
			if(player.getArmor() != null) {
				int newVal = player.getArmor().getIntValue();
				newVal += intValue;
				player.getArmor().setIntValue(newVal);
				message = player.getArmor().getName() + " cursed! " + intValue + " taken from its effectiveness";
				System.out.println(player.getArmor().getIntValue());
			}else {
				message = "scroll of cursing does nothing because armor is not being used";
			}
		}else if(charValue == 'w') {
			if(player.getWeapon() != null) {
				int newVal = player.getWeapon().getIntValue();
				newVal += intValue;
				player.getWeapon().setIntValue(newVal);
				message = player.getWeapon().getName() + " cursed! " + intValue + " taken from its effectiveness";
				System.out.println(player.getWeapon().getIntValue());
			}else {
				message = "scroll of cursing does nothing because weapon is not being used";
			}
		}
		Rogue.displayMessageInfo(message);
    }

    void Hallucinate(Creature owner){
		//System.out.println("ItemAction Hallucinate " + owner);
		Rogue.displayMessageInfo("You will hallucinate for " + intValue + " moves");
		KeyStrokePrinter.setHallucinateMoveCounter(intValue);
    }
}