import java.awt.image.BufferedImage;
import java.awt.Point;


public abstract class MenuButton implements Clickable{
	public Point topleft, bottomright;
	BufferedImage bi;
	public MenuButton(BufferedImage bi, Point topleft, Point bottomright){
		this.bi = bi;
		this.topleft = topleft;
		this.bottomright = bottomright;
		InputHandler.registerClickable(this);
	}

	public void tryClick(Point p){
		if (p.x >= topleft.x && p.y >= topleft.y && p.x <= bottomright.x && p.y <= bottomright.y) {
			onClick();
		}
		else{
			System.out.println("Click coords:");
			System.out.println(p);
			System.out.println("Must be within: ");
			System.out.println(topleft);
			System.out.println("And");
			System.out.println(bottomright);
		}
	}

	public abstract void onClick();

	public BufferedImage getImage(){
		return bi;
	}
}