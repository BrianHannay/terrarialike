import java.awt.*;
import javax.swing.*;

public class MenuNewGame extends JPanel{

	static final String[] state = {"Get Name"};

	public String currentState = state[0];

	public MenuNewGame(Container parent){
		parent.add(this);
	}

	public void paint(Graphics g){
		g.drawImage(Images.TextInput, 100, 50, null);
	}
}