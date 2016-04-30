package coinmachine;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observer;
import java.util.Observable;
import javax.swing.*;

public class inputUI extends JFrame implements Observer {

	private JLabel number;
	private JTextField input;
	private JLabel textStatus;
	private CoinMachine machine;
	

	public inputUI(CoinMachine machine) {
		this.machine = machine;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {

		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);

		number = new JLabel("#Coins: ");

		input = new JTextField(4);
		input.setText(machine.getCount() + "");
		input.setEditable(false);

		textStatus = new JLabel("Accepting Coins");
		textStatus.setForeground(Color.GREEN);

		this.add(number);
		this.add(input);
		this.add(textStatus);
		
		this.run();
				
	}

	public void update(Observable subject, Object info) {
		input.setText(machine.getCount() + "");
		if (machine.isFull()) {
			textStatus.setText("Machine is full");
			textStatus.setForeground(Color.RED);
			
		}
	}

	public void setInputText(String text) {
		input.setText(text);
	}

	public void run() {
		pack();
		setBounds(50, 50, 200, 90);
		setResizable(false);
		setVisible(true);
	}
		

}
