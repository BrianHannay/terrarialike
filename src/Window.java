/**
* This file starts the game -- program entry point
*
**/

import javax.swing.*;
import java.io.IOException;
public class Window extends JFrame 
{
	static boolean isFullscreen = false;

	static JFrame window;

	static InputHandler ih;

	private void init(){
		window = this;
		
		//Creating a menu adds it to the container it is passed
		new Menu(this);
	}

	public static void main(String[] args){



		Window game = new Window();
		ih = new InputHandler(game);

		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(600, 400);
		game.setResizable(false);
		game.setVisible(true);



		try{
			Images.loadImages();
		}
		catch(IOException e){
			ErrorHandler.err(e, game, "Unable to load one or more images");
		}

		game.init();
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