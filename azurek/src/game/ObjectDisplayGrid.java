package game;
import asciiPanel.AsciiPanel;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class ObjectDisplayGrid extends JFrame implements KeyListener, InputSubject {
	
	private static final int DEBUG = 0;
    private static final String CLASSID = ".ObjectDisplayGrid";
	
	int width;
	int topHeight;
	int gameHeight;
    int bottomHeight;
    int height;
    int PosX;
    int PosY;
    int isfirst;
    private static AsciiPanel terminal;
    private Stack<Char>[][] objectGrid = null;
    private List<InputObserver> inputObservers = null;
	
	public ObjectDisplayGrid(int _width, int _topHeight, int _gameHeight, int _bottomHeight){
        width = _width;
		topHeight = _topHeight;
		gameHeight = _gameHeight;
        bottomHeight = _bottomHeight;
        height = _gameHeight + _topHeight + _bottomHeight;
		isfirst = 1;
        terminal = new AsciiPanel(width, height);

		//changed to 2D grid of stacks
        objectGrid = (Stack<Char>[][]) new Stack[width][height];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                objectGrid[i][j] = new Stack<Char>();
            }
        }

        initializeDisplay();

        super.add(terminal);
        super.setSize(width, height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // super.repaint();
        // terminal.repaint( );
        super.setVisible(true);
        terminal.setVisible(true);
        super.addKeyListener(this);
        inputObservers = new ArrayList<>();
        super.repaint();
	}
	
	public final void initializeDisplay() {
		
		//THIS WAS USED TO PRINT BOUNDARIES FOR THE MESSAGE BOXES, BUT WE DON'T NEED BOUNDARIES
        /*Char dash = new Char(' ');
		for (int i = 0; i < width; i++) {
			addObjectToDisplay(dash, i, topHeight - 1);
			addObjectToDisplay(dash, i, height - bottomHeight);
		}*/
		
        terminal.repaint();
    }
	
	public void addObjectToDisplay(Char ch, int x, int y) {
        if ((0 <= x) && (x < objectGrid.length)) {
            if ((0 <= y) && (y < objectGrid[0].length)) {
                objectGrid[x][y].add(ch);
                writeToTerminal(x, y);
            }
        }
    }
	
	public void removeObjectToDisplay(int x, int y) {
        if ((0 <= x) && (x < objectGrid.length)) {
            if ((0 <= y) && (y < objectGrid[0].length)) {
                objectGrid[x][y].pop();
                if (objectGrid[x][y].empty() == true){
                    objectGrid[x][y].add(new Char(' '));
                }
                writeToTerminal(x, y);
            }
        }
    }
	
	public void clearObjectDisplay(int x, int y) {
		if ((0 <= x) && (x < objectGrid.length)) {
            if ((0 <= y) && (y < objectGrid[0].length)) {
				while(objectGrid[x][y].empty() == false) {
					objectGrid[x][y].pop();
				}
                objectGrid[x][y].add(new Char(' '));
                writeToTerminal(x, y);
            }
        }
	}

	//simply changed to printing the topmost element in stack
    private void writeToTerminal(int x, int y) {
		Char chObject = objectGrid[x][y].peek();
        char ch = chObject.getChar();
        terminal.write(ch, x, y);
        terminal.repaint();
    }
	
    Stack<Char>[][] getObjectGrid(){
		
        return objectGrid;
    }

    void setTopMessageHeight(int _topHeight){
        topHeight = _topHeight;
        //System.out.println("setTopMessageHeight topHeight: " + topHeight);
    }

    void setBottomMessageHeight(int _bottomHeight){
        bottomHeight = _bottomHeight;
    }

    void setGameHeight(int _gameHeight){
        gameHeight = _gameHeight;
    }

    void setWidth(int _width){
        width = _width;
    }

    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }
	@Override
    public void registerInputObserver(InputObserver observer) {
        if (DEBUG > 0) {
            System.out.println(CLASSID + ".registerInputObserver " + observer.toString());
        }
        inputObservers.add(observer);
    }

	@Override
    public void keyTyped(KeyEvent e) {
        if (DEBUG > 0) {
            System.out.println(CLASSID + ".keyTyped entered" + e.toString());
        }
        KeyEvent keypress = (KeyEvent) e;
        notifyInputObservers(keypress.getKeyChar());
	}

	private void notifyInputObservers(char ch) {
        for (InputObserver observer : inputObservers) {
            observer.observerUpdate(ch);
            if (DEBUG > 0) {
                System.out.println(CLASSID + ".notifyInputObserver " + ch);
            }
        }
    }

    void setPlayerX(int _PosX){
        PosX = _PosX; 
    }

    void setPlayerY(int _PosY){
        PosY = _PosY;
    }

    int getPlayerX(){
        return PosX;
    }

    int getPlayerY(){
        return PosY;
    }

}