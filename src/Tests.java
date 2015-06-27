import java.io.*;
import java.awt.*;
import javax.swing.*;
public class Tests{
	public static void main(String[] args) throws Exception{
		boolean passed = true;

		//Tests go here
		passed &= should(savehandlerAddsItems(), "Savehandler adding savables.");
		passed &= should(windowSwitchesViews() == 0, "Window switching views");

		if(passed){
			System.out.println("All tests passed successfully.");
		}
		else{
			System.out.println(windowSwitchesViews());
			System.out.flush();
			throw new Exception("One or more tests did not pass.");
		}
	}

	public static boolean should(boolean success, String errorMessage){
		if(!success){
			System.out.println("Error while running test: " + errorMessage);
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

	//returns the reason for the error or 0 for no error
	public static int windowSwitchesViews(){
		Window testWindow = new Window();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		testWindow.switchView(jp1);
		if(testWindow.currentView != jp1){
			return 1;
		}
		//if(testWindow.getComponent(0) != jp1){
		//	System.out.println(testWindow.getComponent(0));
		//}
		testWindow.switchView(jp2);
		if(testWindow.currentView != jp2){
			return 3;
		}
		// if(testWindow.getComponent(0) != jp2){
		// 	return 4;
		// }
		return 0;

	}
}