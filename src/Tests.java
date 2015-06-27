import java.io.*;

public class Tests{
	public static void main(String[] args) throws Exception{
		if(!savehandlerAddsItems()){
				System.out.println("Savehandler is not adding items.");
				throw new Exception("Savehandler");
		}
	}

	public static boolean savehandlerAddsItems(){
		int beforeAdding = SaveHandler.itemsToSave.size();
		SaveHandler.addSavable(new Savable(){
			public Savable load(File f){
				return null;
			}
			public void save(Savable s, File f){}
		});

		return (SaveHandler.itemsToSave.size() == beforeAdding + 1);
	}
}