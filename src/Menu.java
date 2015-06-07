import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Menu extends JPanel{


	ArrayList<MenuButton> buttons = new ArrayList<MenuButton>();
	
	public Menu(Container parent){
		parent.add((JPanel)this);

		//These two lines set variables for the MenuButton's onClick events
		//since variables used in the inner classes overridden methods 
		//need to be final
		final Menu thisMenu = this;
		final Container myParent = parent;

		buttons.add(new MenuButton(Images.MenuNew , new Point(100, 50) , new Point(500, 150)){
			public void onClick(){
				//this menu can be removed now -- another one is taking it's place.
				myParent.remove(thisMenu);
				new MenuNewGame(Window.window);
				myParent.validate();
			}
		});
		buttons.add(new MenuButton(Images.MenuLoad, new Point(100, 200), new Point(500, 350)){
			public void onClick(){
				myParent.remove(thisMenu);
				new MenuLoadGame(myParent);
				myParent.validate();
			}
		});

		parent.validate();
		parent.setVisible(true);
	}
 
	public void paint(Graphics g){

		for (MenuButton button : buttons) {
			g.drawImage(button.getImage(), button.topleft.x, button.topleft.y, null);
		}

	}
}
