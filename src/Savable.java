import java.io.File;

public abstract class Savable{
	public void registerSavable(){
		SaveHandler.addSavable(this);
	}
	public abstract Savable load(File f);
	public abstract void save(Savable s, File f);
}