package GuiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuNou extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuNou window = new MenuNou();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuNou() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Create Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateOrder();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(153, 84, 117, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageProduct();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(153, 120, 117, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Manager Menu");
		btnNewButton_2.setBounds(153, 154, 117, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Check Schedule");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(153, 188, 117, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblScDumisSrl = new JLabel("SC DUMIS SRL");
		lblScDumisSrl.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblScDumisSrl.setHorizontalAlignment(SwingConstants.CENTER);
		lblScDumisSrl.setBounds(120, 11, 184, 31);
		panel.add(lblScDumisSrl);
	}
}
