
package coinmachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;
/**
 * Respresent the status of the capicitor of the coin,
 * the progress bar is depending on the number of coin.
 * @author methawee
 *
 */
public class statusUI extends JFrame implements Observer {

	private JLabel balance;
	private JLabel status;
	private JProgressBar statusBar;
	private JPanel money;
	private JButton oneCoin;
	private JButton fiveCoin;
	private JButton tenCoin;
	private CoinMachine machine;

	/**
	 * Constructor value of the status in coinMachine
	 * @param machine
	 */
	public statusUI(CoinMachine machine) {

		this.machine = machine;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
/**
 * Design the status updater page by using the status bar to respresents
 * the status of this capacitor, and can press the button of money in baht by pressing button
 */
	private void initComponents() {

		FlowLayout balanceWindows = new FlowLayout();
		this.setLayout(balanceWindows);
		
		balance = new JLabel("Balance: " + machine.getBalance());
		status = new JLabel("Status: ");
		statusBar = new JProgressBar();
		money = new JPanel();

		statusBar.setMaximum(machine.getCapacity());
		statusBar.setStringPainted(true);

		Border title = BorderFactory.createTitledBorder("Insert Money");

		ImageIcon oneBaht = new ImageIcon("src/images/1baht.png");
		ImageIcon fiveBaht = new ImageIcon("src/images/5baht.png");
		ImageIcon tenBaht = new ImageIcon("src/images/10baht.png");

		oneCoin = new JButton(oneBaht);
		oneCoin.setPreferredSize(new Dimension(90, 90));
		fiveCoin = new JButton(fiveBaht);
		fiveCoin.setPreferredSize(new Dimension(90, 90));
		tenCoin = new JButton(tenBaht);
		tenCoin.setPreferredSize(new Dimension(90, 90));

		this.add(balance);
		this.add(status);
		this.add(statusBar);
		this.add(money);

		money.setBorder(title);
		money.setSize(200, 100);
		money.add(oneCoin);
		money.add(fiveCoin);
		money.add(tenCoin);

		ActionListener listener = new OneCoinButtonListener();
		oneCoin.addActionListener(listener);

		ActionListener five_listener = new FiveCoinButtonListener();
		fiveCoin.addActionListener(five_listener);

		ActionListener ten_listener = new TenCoinButtonListener();
		tenCoin.addActionListener(ten_listener);

		this.run();

	}
/**
 * Perform the one coin to the list of a coin.
 */
	class OneCoinButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Coin one = new Coin(1, "Bath");
			machine.insert(one);
		}
	}
/**
 * Perform the five coin to the list of a coin.
 */
	class FiveCoinButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Coin five = new Coin(5, "Bath");
			machine.insert(five);

		}
	}
/**
 * Perform the ten coin to the list of a coin.
 */
	class TenCoinButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Coin ten = new Coin(10, "Bath");
			machine.insert(ten);

		}
	}
/**
 * if the coin has changed, the data of coin will update
 */
	public void update(Observable subject, Object info) {
		
		balance.setText("Balance: " + machine.getBalance());
		statusBar.setValue(machine.getCount());
		statusBar.setToolTipText(machine.getCount() + "");
		statusBar.setString(machine.getCount() + "");

	}
/**
 * run out of the programme
 */
	public void run() {
		pack();
		setBounds(50, 50, 320, 180);
		setResizable(false);
		setVisible(true);
	}

}
