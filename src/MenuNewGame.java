import java.awt.*;
import javax.swing.*;

public class MenuNewGame extends JPanel{
	public MenuNewGame(Container parent){
		parent.add((JPanel)this);
	}

	public void paint(Graphics g){
		g.drawImage(Images.TextInput, 100, 50, null);
	}
}