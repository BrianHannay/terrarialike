/**
* This file starts the game -- program entry point
*
**/
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
public class Window extends JFrame implements ActionListener
{
	static boolean isFullscreen = false;

	static JFrame window;

	static InputHandler ih;
	static Timer frameTimer;



	private void init(){
		window = this;
		
		//Creating a menu adds it to the container it is passed
		this.add(new MainMenu(this));
	}

	public static void main(String[] args){



		Window game = new Window();

		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(600, 400);
		game.setResizable(false);
		game.setVisible(true);

		ih = new InputHandler(game);


		try{
			Images.loadImages();
		}
		catch(IOException e){
			ErrorHandler.err(e, game, "Unable to load one or more images");
		}

		game.init();
		
		frameTimer = new Timer(15, game);
		frameTimer.start();
	}


	public static boolean threadLocked = false;
	public void actionPerformed(ActionEvent e){
		if(threadLocked){
			System.out.println("Ignoring repaint - already repainting.");
			return;
		}
		threadLocked = true;
		repaint();
		revalidate();
		threadLocked = false;
	}


	public static void toggleFullscreen(){
		if(Window.isFullscreen){
		}
		else{
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}

		window.setUndecorated(Window.isFullscreen);
		Window.isFullscreen = !Window.isFullscreen;
	}
}