import asciiPanel.AsciiPanel;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

package src;

public class ObjectDisplayGrid extends JFrame implements KeyListener, InputSubject {
	
	int width;
	int topHeight;
	int gameHeight;
    int bottomHeight;
    private static AsciiPanel terminal;
    private Char[][] objectGrid = null;
    private List<InputObserver> inputObservers = null;
	
	public ObjectDisplayGrid(int _width, int _topHeight, int _gameHeight, int _bottomHeight){
        width = _width;
		topHeight = _topHeight;
		gameHeight = _gameHeight;
		bottomHeight = _bottomHeight;

        terminal = new AsciiPanel(width, _gameHeight + _topHeight + _bottomHeight);

        objectGrid = new Char[width][height];

        initializeDisplay();

        super.add(terminal);
        super.setSize(width * 9, height * 16);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // super.repaint();
        // terminal.repaint( );
        super.setVisible(true);
        terminal.setVisible(true);
        super.addKeyListener(this);
        inputObservers = new ArrayList<>();
        super.repaint();
	}
	
    void getObjectDisplayGrid(int _width, int _topHeight, int _gameHeight, int _bottomHeight){
		
        System.out.println("getObjectDisplayGrid gameHeight: " + gameHeight + " width: " + width + " topHeight: " + topHeight);
    }

    void setTopMessageHeight(int topHeight){
        System.out.println("setTopMessageHeight topHeight: " + topHeight);
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(Keyevent e){

    }

}