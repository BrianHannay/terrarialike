import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MenuNewGame extends JPanel implements KeyHandler{

	private enum State{
		GET_NAME;
	}

	public State currentState = State.GET_NAME;
	private Container parent;
	private String nameGiven = "";

	public MenuNewGame(Container parent){
		this.parent = parent;
		parent.add(this);
		InputHandler.registerKeyHandler(this);
	}

	public void pressed(KeyEvent ke){
		if(ke.getKeyChar() != KeyEvent.CHAR_UNDEFINED){
			nameGiven += ke.getKeyChar();
		}
		else if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			nameGiven = nameGiven.substring(0, nameGiven.length() -1);
		}
		System.out.println(nameGiven);
	}

	public void paint(Graphics g){
		switch(currentState){
			case GET_NAME:
				g.drawString("Please enter your name as you would like it to appear on your boarding pass", 100, 40);
				g.drawImage(Images.TextInput, 100, 50, null);
				g.drawString(nameGiven, 110, 60);
				break;
			default:
				ErrorHandler.err(new Exception(), parent, "Unknown state for MenuNewGame; State="+currentState);
		}
	}
}