package Control;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.View;

import Model.Model;

public class Control {
	 Model model;
	    private View view;

	    public void Controller(Model model, View view) {
	        this.model = model;
	        this.view = view;
	    }

	    public void handleUserInput() {
	        String input = JOptionPane.showInputDialog(this.getText());
	        if (input != null) {
	            model.addItem(input);
	            this.setText("");
	            this.showMessage("Item added to collection.");
	        }
	    }

		private void setText(String string) {
			// TODO Auto-generated method stub
			
		}

		private void showMessage(String string) {
			// TODO Auto-generated method stub
			
		}

		private Object getText() {
			// TODO Auto-generated method stub
			return null;
		}
	

	
	    public static void saveData(List<String> data, String filename) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
	            for (String item : data) {
	                writer.println(item);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static List<String> loadData(String filename) {
	        List<String> data = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                data.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return data;
	    }

	    public static void recursiveFolderSearch(String folderPath) {
	        try {
	            Files.walk(Paths.get(folderPath)).forEach(System.out::println);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


