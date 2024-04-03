package Control;

import java.lang.ModuleLayer.Controller;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.text.View;

import Model.Model;
import View.test;

public class Editor {
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            Model model = new Model();
	            test view = new test();
	            Control control = new Control();

	            view.showMessage("Enter an item:");
	            control.handleUserInput();

	            // Save and load data
	            String filename = "data.txt";
	            saveData(model.getitem(), filename);
	            List<String> loadedData = loadData(filename);
	            view.showMessage("Loaded data: " + loadedData);

	            // Recursive folder search
	            String folderPath = "/path/to/folder";
	            recursiveFolderSearch(folderPath);
	        });
	    }

		private static void recursiveFolderSearch(String folderPath) {
			
		}

		private static List<String> loadData(String filename) {
			return null;
		}

		private static void saveData(List<String> getitem, String filename) {
			
		}


}