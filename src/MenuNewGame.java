import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MenuNewGame extends JPanel implements KeyHandler{

	private enum State{
		GET_NAME,
		GET_PLR;
	}

	public State currentState = State.GET_NAME;
	private Container parent;
	private String nameGiven = "";
	private static Font inputFont = new Font("Arial", Font.PLAIN, 26);

	public MenuNewGame(Container parent){
		this.parent = parent;
		parent.add(this);
		InputHandler.registerKeyHandler(this);
	}

	public void pressed(KeyEvent ke){

		if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			//this needs to be compared seperately. We don't want a VK_BACK_SPACE appended to the string
			//if the string length is 0 (VK_BACK_SPACE is a printable character)
			if(nameGiven.length() > 0){
				nameGiven = nameGiven.substring(0, nameGiven.length() -1);
			}
		}
		else if(ke.getKeyCode() == KeyEvent.VK_ENTER && nameGiven.length() > 0){
			currentState = State.GET_PLR;
		}
		//printable characters are within this range - Sure, the numbers may be magic but they're never going to change.
		//namegiven may be at most 14 characters.
		else if(ke.getKeyChar() >= 32 && ke.getKeyChar() < 127 && nameGiven.length() < 14){
			nameGiven += ke.getKeyChar();
		}
		//else ignore input
	}

	public void paint(Graphics g){
		switch(currentState){
			case GET_NAME:
				g.drawString("Please enter your name as you would like it to appear on your boarding pass", 100, 40);
				g.drawImage(Images.TextInput, 100, 50, null);
				g.setFont(inputFont);
				g.drawString(nameGiven, 110, 90);
				break;
			case GET_PLR:
				break;
			default:
				ErrorHandler.err(new Exception(), parent, "Unknown state for MenuNewGame; State="+currentState);
		}
	}
}