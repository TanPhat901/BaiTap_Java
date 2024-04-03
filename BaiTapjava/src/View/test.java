package View;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class test extends JFrame {
	private JFrame frame;
	private JTextArea textarea;
	private JButton saveButton;
	private JButton loadButton;

	public test() {
		frame = new JFrame("Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		textarea = new JTextArea();
		this.add(new JScrollPane(textarea), BorderLayout.CENTER);

		saveButton = new JButton("Save");
		saveButton.addActionListener(event -> saveData());
		this.add(saveButton, BorderLayout.NORTH);

		loadButton = new JButton("Load");
		loadButton.addActionListener(event -> loadData());
		this.add(loadButton, BorderLayout.SOUTH);

		this.setSize(400, 300);
		this.setVisible(true);
	}

	public String getText() {
		return textarea.getText();
	}

	public void setText(String text) {
		textarea.setText(text);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	private void saveData() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
				writer.println(getText());
				showMessage("Data saved successfully.");
			} catch (IOException e) {
				e.printStackTrace();
				showMessage("Error saving data.");
			}
		}
	}

	private void loadData() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				StringBuilder data = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					data.append(line).append("\n");
				}
				setText(data.toString());
				showMessage("Data loaded successfully.");
			} catch (IOException e) {
				e.printStackTrace();
				showMessage("Error loading data.");
			}
		}
	}

	public static void main(String[] args) {
		new test();
	}

}
