import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class InputHandler implements KeyListener, MouseListener{



	/**
	** These are the MOUSE events
	**/

	public InputHandler(JFrame window){
		window.addMouseListener(this);
		System.out.println("Made InputHandler");

	}

	public static void reset(){
		clickables = new ArrayList<Clickable>();
		keys = new ArrayList<Key>();
		keyHandlers = new ArrayList<KeyHandler>();
	}

	private static ArrayList<Clickable> clickables = new ArrayList<Clickable>();
	public static void registerClickable(Clickable c){
		clickables.add(c);
		System.out.println("Clickable registered.");
	}

	public void mouseExited(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		
	}
	public void mousePressed(MouseEvent e){
		
	}
	public void mouseClicked(MouseEvent e){
		for (Clickable c : clickables) {
			c.tryClick(e.getPoint());
		}
	}




	/**
	** These are the KEY events
	**/


	private static ArrayList<KeyHandler> keyHandlers = new ArrayList<KeyHandler>();

	public static boolean isDown(int keyNum){
		for(int i=0; i<keys.size(); i++){
			if(keys.get(i).code == keyNum){
				return true;
			}
		}
		return false;
	}

	private static ArrayList<Key> keys = new ArrayList<Key>();

	public void keyReleased(KeyEvent ev){
		setKey(ev.getKeyCode(), false);
	}
	public void keyPressed(KeyEvent ev){
		setKey(ev.getKeyCode(), true);	
		for(KeyHandler kh : keyHandlers){
			kh.pressed(ev);
		}
	}

	private static void setKey(int code, boolean down){
		for (Key c : keys) {
			if(c.code == code){
				c.down = down;
				return;
			}
		}
		Key c = new Key(code, down);
		keys.add(c);
	}

	//noop, required to implement KeyListener
	public void keyTyped(KeyEvent ev){}


	


	private static class Key{
		public int code;
		public boolean down;
		public Key(int c, boolean d){
			code=c;
			down=d;
		}
	}

}