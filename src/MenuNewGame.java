import java.awt.*;
import javax.swing.*;

public class MenuNewGame extends JPanel{

	private enum State{
		GET_NAME;
	}

	public State currentState = State.GET_NAME;
	private Container parent;

	public MenuNewGame(Container parent){
		this.parent = parent;
		parent.add(this);
	}

	public void paint(Graphics g){
		switch(currentState){
			case GET_NAME:
				g.drawString("Please enter your name as you would like it to appear on your boarding pass", 100, 40);
				g.drawImage(Images.TextInput, 100, 50, null);
				break;
			default:
				ErrorHandler.err(new Exception(), parent, "Unknown state for MenuNewGame; State="+currentState);
		}
	}
}