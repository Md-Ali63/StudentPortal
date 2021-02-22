package demo;

import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;


public class StudentEmailGUI extends JFrame {
	
	JTextArea studentTextArea = new JTextArea();
	
	JLabel idLable = new JLabel("ID: ");
	JTextField idTextField = new JTextField(10);
	JLabel nameLable = new JLabel("Name: ");
	JTextField nameTextField = new JTextField(10);
	
	JButton addButton = new JButton("Add");
	JButton deleteButton = new JButton("Delete");
	JButton dispalyallButton = new JButton("Display All");
	JButton exitButton = new JButton("Exit");
	
	LinkedList<StudentEmail> studentList = new LinkedList<StudentEmail>();
	
	
	public StudentEmailGUI() {
		
		JPanel flowPanel1 = new JPanel(new FlowLayout (FlowLayout.CENTER));
		JPanel flowPanel2 = new JPanel(new FlowLayout (FlowLayout.CENTER));
		JPanel gridPanel = new JPanel(new GridLayout(2,1));
		
		studentTextArea.setEditable(false);
		
		flowPanel1.add(idLable);
		flowPanel1.add(idTextField);
		flowPanel1.add(nameLable);
		flowPanel1.add(nameTextField);
		
		flowPanel2.add(addButton);
		flowPanel2.add(deleteButton);
		flowPanel2.add(dispalyallButton);
		flowPanel2.add(exitButton);
		
		gridPanel.add (flowPanel1);
		gridPanel.add (flowPanel2);
		
		add(studentTextArea, BorderLayout.CENTER);
		add(gridPanel, BorderLayout.SOUTH);
		
		addButton.addActionListener(event -> addStudent());
		deleteButton.addActionListener(event -> deleteEntry());
		dispalyallButton.addActionListener(event -> displayAll());
		exitButton.addActionListener(event -> exitApp());
	}
	
	private boolean isStudentIdLinkedlist(String idStr) {
		boolean inList = false;
		
		for(StudentEmail std : studentList) {
			if(std.getId().compareToIgnoreCase(idStr)== 0) {
				inList = true;
			}
		}
		return inList;
	}
	
	private void addStudent() {
		
		if(isStudentIdLinkedlist(idTextField.getText()) == true) {
			JOptionPane.showMessageDialog(null, "Error: Student id is not Unique");
		}
		else {
		studentList.add(new StudentEmail(nameTextField.getText(),idTextField.getText()));
		displayAll();
	}
}
	
	private void deleteEntry() {
		if(isStudentIdLinkedlist(idTextField.getText()) == false) {
			JOptionPane.showMessageDialog(null, "Error: Student id is not in the database");
		}
		else {
			for(int i = 0; i<studentList.size(); i++) {
				
				String curId = studentList.get(i).getId();
				if(curId.compareToIgnoreCase(idTextField.getText())== 0) {
					studentList.remove(i);
				}
			}
		displayAll();
	    }
		
}
	 
	
	private void displayAll() {
		
		studentTextArea.setText("");
		
		for(StudentEmail std : studentList) {
			studentTextArea.append (std + "\n");
		}
	}
	
	private void exitApp() {
		
		System.exit(0);
	}
	
	public static void main(String[]args) {
		
		StudentEmailGUI app = new StudentEmailGUI();
		app.setVisible(true);
		app.setSize(500, 500);
		app.setLocation(200, 100);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
