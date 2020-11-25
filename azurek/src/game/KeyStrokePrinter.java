package game;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.w3c.dom.css.Counter;

public class KeyStrokePrinter implements InputObserver, Runnable {

    private static int DEBUG = 0;
    private int hpMoveCounter = 0;
    private int hallucinateMoveCounter = 0;
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
                                Rogue.getPlayers().get(0).SetPosX(displayGrid.getPlayerX());
                                hpMoveCounter++;
                                hpMoveCounter = Rogue.checkHpMoves(hpMoveCounter);
                                hallucinateMoveCounter++;
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
                                Rogue.getPlayers().get(0).SetPosX(displayGrid.getPlayerX());
                                hpMoveCounter++;
                                hpMoveCounter = Rogue.checkHpMoves(hpMoveCounter);
                                hallucinateMoveCounter++;                                
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
                                Rogue.getPlayers().get(0).setPosY(displayGrid.getPlayerY());
                                hpMoveCounter++;
                                hpMoveCounter = Rogue.checkHpMoves(hpMoveCounter);
                                hallucinateMoveCounter++;                                
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
                                Rogue.getPlayers().get(0).setPosY(displayGrid.getPlayerY());
                                hpMoveCounter++;
                                hpMoveCounter = Rogue.checkHpMoves(hpMoveCounter);
                                hallucinateMoveCounter++;                                
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
                else if (ch == '?'){
                    Rogue.displayMessageInfo("? H i p r T w");
                }
                else if (ch == 'H'){
                    helpCommand();
                }
                else if (ch == 'c'){
                    //Rogue.changeArmor(); //TODO make changeArmor
                }
                else if (ch == 'E'){
                    dead = endCommand();
                }
                else if (ch == 'r'){
                    readCommand();
                }
                else if (ch == 'T'){
                    takeCommand();
                }
                else if (ch == 'w'){
                    wearCommand();
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
    
	private void helpCommand(){
		boolean dead = false;
		boolean processing = true;
		while (processing) {
			if (inputQueue.peek() == null) {
				processing = true;
			}else if (inputQueue.peek() == '?'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("show the different commands in the info section of the display.");
            }
            else if (inputQueue.peek() == 'i'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("Show or display the inventory");
            }
            else if (inputQueue.peek() == 'p'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("Pick up an item from the dungeon floor");
            }
            else if (inputQueue.peek() == 'r'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("Read an item");
            }
            else if (inputQueue.peek() == 'T'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("Take out a weapon");
            }
            else if (inputQueue.peek() == 'w'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("Wear item");
            }
            else if (inputQueue.peek() == 'c'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("Change, or take off armor");
            }
            else if (inputQueue.peek() == 'd'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("Drop");
            }
            else if (inputQueue.peek() == 'E'){
                processing = false;
                inputQueue.remove();
                Rogue.displayMessageInfo("End game");
            }                        
            else {
                processing = false;
			}
		}
    }

	private boolean endCommand(){
		boolean dead = false;
		boolean processing = true;
		while (processing) {
			if (inputQueue.peek() == null) {
				processing = true;
			}else if ((inputQueue.peek() == 'Y') || (inputQueue.peek() == 'y')){
                processing = false;
                Rogue.displayMessageInfo("Game ended due to command E");
                return true;

			}else {
                processing = false;
            }
        }
        return false;
    }

	private void readCommand(){
		boolean dead = false;
		boolean processing = true;
		while (processing) {
			if (inputQueue.peek() == null) {
				processing = true;
			}else if (((int) inputQueue.peek() > 57) || ((int) inputQueue.peek() < 48)){
                processing = false;
                //Rogue.readScroll(((int) inputQueue.poll()) - ((int) '0')); //TODO implement readScroll
			}else {
                processing = false;
			}
		}
    }

	private void takeCommand(){
		boolean dead = false;
		boolean processing = true;
		while (processing) {
			if (inputQueue.peek() == null) {
				processing = true;
			}else if (((int) inputQueue.peek() > 57) || ((int) inputQueue.peek() < 48)){
                processing = false;
                //Rogue.takeOutWeapon(((int) inputQueue.poll()) - ((int) '0')); //TODO implement takeOutWeapon
			}else {
                processing = false;
			}
		}
    }

	private void wearCommand(){
		boolean dead = false;
		boolean processing = true;
		while (processing) {
			if (inputQueue.peek() == null) {
				processing = true;
			}else if (((int) inputQueue.peek() > 57) || ((int) inputQueue.peek() < 48)){
                processing = false;
                //Rogue.wearItem(((int) inputQueue.poll()) - ((int) '0')); //TODO implement wearItem
			}else {
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
