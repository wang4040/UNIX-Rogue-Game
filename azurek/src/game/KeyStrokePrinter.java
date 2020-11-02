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
                    if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() - 1][displayGrid.getPlayerY()].peek().getChar() == '.'){
                        displayGrid.removeObjectToDisplay(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                        displayGrid.addObjectToDisplay(new Char('@'), displayGrid.getPlayerX() - 1, displayGrid.getPlayerY());
                        displayGrid.setPlayerX(displayGrid.getPlayerX() - 1);
                    }
                }
                else if(ch == 'j'){
                    if (displayGrid.getObjectGrid()[displayGrid.getPlayerX() + 1][displayGrid.getPlayerY()].peek().getChar() != 'X'){
                        displayGrid.removeObjectToDisplay(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                        displayGrid.addObjectToDisplay(new Char('@'), displayGrid.getPlayerX() + 1, displayGrid.getPlayerY());
                        displayGrid.setPlayerX(displayGrid.getPlayerX() + 1);
                    }                    
                }
                else if(ch == 'k'){
                    if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() + 1].peek().getChar() != 'X'){
                        displayGrid.removeObjectToDisplay(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                        displayGrid.addObjectToDisplay(new Char('@'), displayGrid.getPlayerX(), displayGrid.getPlayerY() + 1);
                        displayGrid.setPlayerY(displayGrid.getPlayerY() + 1);
                    }                    
                }
                else if(ch == 'l'){
                    if (displayGrid.getObjectGrid()[displayGrid.getPlayerX()][displayGrid.getPlayerY() - 1].peek().getChar() != 'X'){
                        displayGrid.removeObjectToDisplay(displayGrid.getPlayerX(), displayGrid.getPlayerY());
                        displayGrid.addObjectToDisplay(new Char('@'), displayGrid.getPlayerX(), displayGrid.getPlayerY() - 1);
                        displayGrid.setPlayerY(displayGrid.getPlayerY() - 1);
                    }                    
                }
                else {
                    System.out.println("character " + ch + " entered on the keyboard");
                }
            }
        }
        return true;
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
