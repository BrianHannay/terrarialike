import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;


/**
** MenuNewGame is part of the menu system for TerrariaLike.
** It adds itself to graphics object that it is given - object g.
**/
public class MenuNewGame extends JPanel{

	private enum State{
		GET_NAME,
		GET_PLR;
	}

	public State currentState = State.GET_NAME;
	private Container parent;
	private InputBox nameBox;

	public MenuNewGame(Container parent){
		this.parent = parent;
		parent.add(this);
		setFirstState();
	}

	private void setFirstState(){		
		currentState = State.GET_NAME;
		nameBox = new InputBox(this, 100, 50);
	}

	 

	public void paint(Graphics g){
		super.paint(g);
		switch(currentState){
			case GET_NAME:
				//This is placed directly on top of the TextInput
				g.drawString("Please enter your name as you would like it to appear on your boarding pass", 100, 40);
				nameBox.draw(g);
				break;
			case GET_PLR:

				break;
			default:
				ErrorHandler.err(new Exception(), parent, "Unknown state for MenuNewGame; State="+currentState);
		}
	}


	private class InputBox extends JPanel implements KeyHandler{

		private String nameGiven = "";
		private Font inputFont = new Font("Arial", Font.PLAIN, 26);
		public int x, y;

		public InputBox(Container parent, int x, int y){
			parent.add(this);
			System.out.println("Added to parent.");
			InputHandler.registerKeyHandler(this);
			this.x = x;
			this.y = y;
		}

		public void pressed(KeyEvent ke){
			if(ke.getKeyCode() == KeyEvent.VK_ENTER && nameGiven.length() > 0){
				//player has finished entering their name, continue to character creation
				currentState = State.GET_PLR;

			}
			else if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
				//this needs to be compared seperately. We don't want a VK_BACK_SPACE appended to the string
				//if the string length is 0 (VK_BACK_SPACE is a printable character)
				if(nameGiven.length() > 0){
					nameGiven = nameGiven.substring(0, nameGiven.length() -1);
				}
			}
			//printable characters are within this range - from ' ' to '~'.
			//namegiven may be at most 14 characters.
			else if(ke.getKeyChar() >= (int)' ' && ke.getKeyChar() < (int)'~' && nameGiven.length() < 14){
				nameGiven += ke.getKeyChar();
			}
			//else ignore input
		}

		public void draw(Graphics g){
			System.out.println("\""+(int)' '+"\"");
			//super.paintComponent(g);
			g.setFont(inputFont);
			g.drawImage(Images.TextInput, x, y, null);
			g.drawString(this.get(), x, y+20);
		}

		public String get(){
			return nameGiven;
		}
	}
}