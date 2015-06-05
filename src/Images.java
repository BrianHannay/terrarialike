import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Images{
	public static BufferedImage MenuLoad, MenuNew;
	public static void loadImages() throws IOException{
		MenuLoad = ImageIO.read(new File("image/menuLoad.png"));
		MenuNew = ImageIO.read(new File("image/menuNew.png"));
	}
}