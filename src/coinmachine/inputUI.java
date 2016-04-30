package coinmachine;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observer;
import java.util.Observable;
import javax.swing.*;

/**
 * Respresents a coin updater, this progrogram will update, when a coin is inserted
 * and the progress bar will update, if the number of coin is increasing.
 * @author methawee
 *
 */
public class inputUI extends JFrame implements Observer {

	private JLabel number;
	private JTextField numberOfCoin;
	private JLabel textStatus;
	private CoinMachine machine;
	
/**
 * Construct the value of coin updater 
 * @param machine - construct with the CoinMachine class
 */
	public inputUI(CoinMachine machine) {
		this.machine = machine;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
/**
 * Perform the frame of coin updater by counting the number of coin,
 * if the number of coin is equals the capacity, it will not add more coin.
 */
	private void initComponents() {

		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);

		number = new JLabel("#Coins: ");

		numberOfCoin = new JTextField(4);
		numberOfCoin.setText(machine.getCount() + "");
		numberOfCoin.setEditable(false);

		textStatus = new JLabel("Accepting Coins");
		textStatus.setForeground(Color.GREEN);

		this.add(number);
		this.add(numberOfCoin);
		this.add(textStatus);
		
		this.run();
				
	}
/**
 * if the coin has changed, the data of coin will update
 */
	public void update(Observable subject, Object info) {
		numberOfCoin.setText(machine.getCount() + "");
		if (machine.isFull()) {
			textStatus.setText("Machine is full");
			textStatus.setForeground(Color.RED);
			
		}
	}
/**
 * Run the program
 */
	public void run() {
		pack();
		setBounds(50, 50, 200, 90);
		setResizable(false);
		setVisible(true);
	}
		

}
