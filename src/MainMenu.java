import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MainMenu extends JPanel{


	ArrayList<MenuButton> buttons = new ArrayList<MenuButton>();
	final Container myParent;
	public MainMenu(Container parent){


		//These two lines set variables for the MenuButton's onClick events
		//since variables used in the inner classes overridden methods 
		//need to be final
		final MainMenu thisMenu = this;
		myParent = parent;

		buttons.add(new MenuButton(Images.MenuNew , new Point(100, 50) , new Point(500, 150)){
			public void onClick(){
				//this menu can be removed now -- another one is taking it's place.
				myParent.remove(thisMenu);
				removeFromParent();
				//remove clickables
				InputHandler.reset();

				//Create new menu, attaches itself to window automatically.
				new MenuNewGame(myParent);
			}
		});
		buttons.add(new MenuButton(Images.MenuLoad, new Point(100, 200), new Point(500, 350)){
			public void onClick(){
				myParent.remove(thisMenu);
				InputHandler.reset();
				new MenuLoadGame(myParent);
			}
		});

		parent.validate();
		parent.setVisible(true);
	}

	public void removeFromParent(){
		myParent.remove(this);
	}
 
	public void paint(Graphics g){
		for (MenuButton button : buttons) {
			g.drawImage(button.getImage(), button.topleft.x, button.topleft.y, null);
		}

	}
}
