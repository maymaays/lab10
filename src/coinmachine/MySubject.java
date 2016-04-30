package coinmachine;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

public class MySubject extends JFrame {
	
	private JTextField inputCoin;
	private JButton image;
	private 
	
	public MySubject() {
		this.setTitle("Distance Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	private void initComponents() {

		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
	}

		public void run() {
		pack();
		setBounds(50, 50, 700, 90);
		setResizable(false);
		setVisible(true);
	}




}
