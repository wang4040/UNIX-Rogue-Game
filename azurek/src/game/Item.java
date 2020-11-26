package game;

import java.util.ArrayList;

public class Item extends Displayable{

	int serial;
	ArrayList<ItemAction> ia = new ArrayList<ItemAction>();
	Creature _owner;

    void setOwner(Creature owner){
		//System.out.println("setOwner Creature for item: " + owner);
		_owner = owner;
	}
	
	int getSerial() {
		return serial;
	}

	void addItemAction(ItemAction _ia){
		ia.add(_ia);
	}

	void doItemAction(){
		if (ia.isEmpty() == true)
			return;

		for (int i = 0; i <ia.size(); i++){
			if (ia.get(i).action.equals("Hallucinate"))
				ia.get(i).Hallucinate(_owner);
			else
				ia.get(i).BlessCurseOwner(_owner);
		}
	}

}