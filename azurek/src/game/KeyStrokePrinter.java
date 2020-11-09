package game;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class KeyStrokePrinter implements InputObserver, Runnable {

    private static int DEBUG = 0;
    private static String CLASSID = "KeyStrokePrinter";
    private static Queue<Character> inputQueue = null;
    private ObjectDisplayGrid displayGrid;

    public KeyStrokePrinter(ObjectDisplayGrid grid) {
        inputQueue = new ConcurrentLinkedQueue<>();
        displayGrid = grid;
    }

    @Override
    public void observerUpdate(char ch) {
        if (DEBUG > 0) {
            System.out.println(CLASSID + ".observerUpdate receiving character " + ch);
        }
        inputQueue.add(ch);
    }

    private void rest() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private boolean processInput() {

        char ch;
        boolean dead = false;
        boolean processing = true;
        while (processing) {
            if (inputQueue.peek() == null) {
                processing = false;
            } else {
                ch = inputQueue.poll();
                if (DEBUG > 1) {
                    System.out.println(CLASSID + ".processInput peek is " + ch);
                }
                if (ch == 'h') {
                    if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() - 1][displayGrid.getPlayerY()].empty() == false){
                        if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() - 1][displayGrid.getPlayerY()].peek().getChar() != 'X'){
                            if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() - 1][displayGrid.getPlayerY()].peek().getChar() == 'S'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX() - 1, displayGrid.getPlayerY());
                            }
                            else if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() - 1][displayGrid.getPlayerY()].peek().getChar() == 'T'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX() - 1, displayGrid.getPlayerY());
                            }
                            else if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() - 1][displayGrid.getPlayerY()].peek().getChar() == 'H'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX() - 1, displayGrid.getPlayerY());
                            }
                            else{
                                displayGrid.removeObjectToDisplay(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                                displayGrid.addObjectToDisplay(new Char('@'), displayGrid.getPlayerX() - 1, displayGrid.getPlayerY());
                                displayGrid.setPlayerX(displayGrid.getPlayerX() - 1);
                            }
                        }
                    }
                }
                else if(ch == 'l'){
                    if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() + 1][displayGrid.getPlayerY()].empty() == false){
                        if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() + 1][displayGrid.getPlayerY()].peek().getChar() != 'X'){
                            if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() + 1][displayGrid.getPlayerY()].peek().getChar() == 'S'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX() + 1, displayGrid.getPlayerY());
                            }
                            else if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() + 1][displayGrid.getPlayerY()].peek().getChar() == 'T'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX() + 1, displayGrid.getPlayerY());
                            }
                            else if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() + 1][displayGrid.getPlayerY()].peek().getChar() == 'H'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX() + 1, displayGrid.getPlayerY());
                            }
                            else{
                                displayGrid.removeObjectToDisplay(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                                displayGrid.addObjectToDisplay(new Char('@'), displayGrid.getPlayerX() + 1, displayGrid.getPlayerY());
                                displayGrid.setPlayerX(displayGrid.getPlayerX() + 1);
                            }
                        }
                    }                    
                }
                else if(ch == 'j'){
                    if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() + 1].empty() == false){
                        if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() + 1].peek().getChar() != 'X'){
                            if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() + 1].peek().getChar() == 'S'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX(), displayGrid.getPlayerY() + 1);
                            }
                            else if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() + 1].peek().getChar() == 'T'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX(), displayGrid.getPlayerY() + 1);
                            }
                            else if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() + 1].peek().getChar() == 'H'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX(), displayGrid.getPlayerY() + 1);
                            }
                            else {
                                displayGrid.removeObjectToDisplay(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                                displayGrid.addObjectToDisplay(new Char('@'), displayGrid.getPlayerX(), displayGrid.getPlayerY() + 1);
                                displayGrid.setPlayerY(displayGrid.getPlayerY() + 1);
                            }
                        }
                    }                    
                }
                else if(ch == 'k'){
                    if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() - 1].empty() == false){
                        if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() - 1].peek().getChar() != 'X'){
                            if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() - 1].peek().getChar() == 'S'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX(), displayGrid.getPlayerY() - 1);
                            }
                            else if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() - 1].peek().getChar() == 'T'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX(), displayGrid.getPlayerY() - 1);
                            }
                            else if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() - 1].peek().getChar() == 'H'){
                                dead = Rogue.CombatSimulator(displayGrid.getPlayerX(), displayGrid.getPlayerY() - 1);
                            }
                            else {
                                displayGrid.removeObjectToDisplay(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                                displayGrid.addObjectToDisplay(new Char('@'), displayGrid.getPlayerX(), displayGrid.getPlayerY() - 1);
                                displayGrid.setPlayerY(displayGrid.getPlayerY() - 1);
                            }
                        }
                    }                    
                }
                else if (ch == 'p'){
                    Rogue.pickupItem(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                }
                else if (ch == 'i'){
                    Rogue.displayInventory();
                }
                else if (ch == 'd'){
                    dropCommand();
                }
                else {
                    System.out.println("character " + ch + " entered on the keyboard");
                }
            }
        }
        if (dead == true)
            return false;
        else
            return true;
    }
   
	private void dropCommand(){
		boolean dead = false;
		boolean processing = true;
		while (processing) {
			if (inputQueue.peek() == null) {
				processing = true;
			}else if (((int) inputQueue.peek() > 57) || ((int) inputQueue.peek() < 48)){
                processing = false;
			}else {
                Rogue.dropItem((int)(inputQueue.poll()) - (int)'0');
                processing = false;
			}
		}
	}

    @Override
    public void run() {
        displayGrid.registerInputObserver(this);
        boolean working = true;
        while (working) {
            rest();
            working = (processInput( ));
        }
    }
}
