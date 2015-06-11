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
		//printable characters are within this range - Sure, the numbers may be magic but they're never going to change.
		else if(ke.getKeyChar() >= 32 && ke.getKeyChar() < 127){
			nameGiven += ke.getKeyChar();
		}
		System.out.println(nameGiven);
	}

	public void paint(Graphics g){
		switch(currentState){
			case GET_NAME:
				g.drawString("Please enter your name as you would like it to appear on your boarding pass", 100, 40);
				g.drawImage(Images.TextInput, 100, 50, null);
				g.setFont(inputFont);
				g.drawString(nameGiven, 110, 60);
				break;
			default:
				ErrorHandler.err(new Exception(), parent, "Unknown state for MenuNewGame; State="+currentState);
		}
	}
}