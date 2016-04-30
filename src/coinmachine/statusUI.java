
package coinmachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;

public class statusUI extends JFrame implements Observer {

	private JLabel balance;
	private JLabel status;
	private JProgressBar statusBar;
	private JPanel money;
	private JButton firstCoin;
	private JButton secondCoin;
	private JButton thirdCoin;
	private CoinMachine machine;

	public statusUI(CoinMachine machine) {

		this.machine = machine;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {

		FlowLayout balanceWindows = new FlowLayout();
		this.setLayout(balanceWindows);
		balance = new JLabel("Balance: " + machine.getBalance());
		status = new JLabel("Status: ");
		statusBar = new JProgressBar();
		money = new JPanel();
		
		statusBar.setMaximum(machine.getCapacity());
		
		Border title = BorderFactory.createTitledBorder("Insert Money");

		ImageIcon five = new ImageIcon("src/images/1baht.png");
		ImageIcon second = new ImageIcon("src/images/5baht.png");
		Icon ten = new ImageIcon("src/images/10baht.png");

		firstCoin = new JButton(five);
		firstCoin.setPreferredSize(new Dimension(90, 90));
		secondCoin = new JButton(second);
		secondCoin.setPreferredSize(new Dimension(90, 90));
		thirdCoin = new JButton(ten);
		thirdCoin.setPreferredSize(new Dimension(90, 90));
		
		this.add(balance);
		this.add(status);
		this.add(statusBar);
		this.add(money);

		money.setBorder(title);
		money.setSize(200, 100);
		money.add(firstCoin);
		money.add(secondCoin);
		money.add(thirdCoin);
		
		ActionListener listener = new FirstCoinButtonListener();
		firstCoin.addActionListener(listener);

		ActionListener five_listener = new SecondCoinButtonListener();
		secondCoin.addActionListener(five_listener);

		ActionListener ten_listener = new ThirdCoinButtonListener();
		thirdCoin.addActionListener(ten_listener);

		this.run();

	}

	class FirstCoinButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Coin one = new Coin(1, "Bath");
			machine.insert(one);
		}
	}

	class SecondCoinButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Coin five = new Coin(5, "Bath");
			machine.insert(five);

		}
	}

	class ThirdCoinButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Coin ten = new Coin(10, "Bath");
			machine.insert(ten);

		}
	}

	public void update(Observable subject, Object info) {

			balance.setText("Balance: " + machine.getBalance());
			statusBar.setValue(machine.getCount());
			
				statusBar.setStringPainted(true);
				statusBar.setForeground(Color.RED);
				statusBar.setForeground(Color.GREEN);
				statusBar.setString(machine.getCount() + "");
				
		

		
	}

	public void run() {
		pack();
		setBounds(50, 50, 320, 180);
		setResizable(false);
		setVisible(true);
	}

}
