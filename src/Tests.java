import java.io.*;

public class Tests{
	public static void main(String[] args) throws Exception{
		boolean passed = true;
		passed &= should(savehandlerAddsItems(), "Savehandler is not adding items.");


		if(passed){
			System.out.println("All tests passed successfully.");
		}
		else{
			throw new Exception("One or more tests did not pass.");
		}
	}

	public static boolean should(boolean success, String errorMessage){
		if(!success){
			System.out.println(errorMessage);
		}
		return success;
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