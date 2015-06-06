import java.awt.*;
import javax.swing.*;

//required for MenuButton
import java.awt.image.BufferedImage;
import java.awt.Point;

import java.util.ArrayList;

public class Menu extends JPanel{


	ArrayList<MenuButton> buttons = new ArrayList<MenuButton>();

	public Menu(Container parent){
		parent.add((JPanel)this);

		buttons.add(new MenuButton(Images.MenuNew , new Point(100, 50) , new Point(500, 150)){
			public void onClick(){
				new MenuNewGame(Window.window);
			}
		});
		buttons.add(new MenuButton(Images.MenuLoad, new Point(100, 200), new Point(500, 350)){
			public void onClick(){
				new MenuLoadGame(Window.window);
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

	private abstract class MenuButton implements Clickable{
		public Point topleft, bottomright;
		BufferedImage bi;
		public MenuButton(BufferedImage bi, Point topleft, Point bottomright){
			this.bi = bi;
			this.topleft = topleft;
			this.bottomright = bottomright;
			InputHandler.registerClickable(this);
		}

		public void tryClick(Point p){
			if (p.x > topleft.x && p.y > topleft.y && p.x < bottomright.x && p.y < bottomright.y) {
				onClick();
			}
		}

		public abstract void onClick();

		public BufferedImage getImage(){
			return bi;
		}
	}
}
