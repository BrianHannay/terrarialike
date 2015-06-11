import java.io.File;
import java.util.ArrayList;

public class SaveHandler{
	public static final Savable[] saveIndices = new Savable[] {};
	public static ArrayList<Savable> itemsToSave = new ArrayList<Savable>();

	public SaveHandler(){};

	public static void addSavable(Savable object){
		itemsToSave.add(object);
	}

}