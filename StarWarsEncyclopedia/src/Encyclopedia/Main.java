package Encyclopedia;

import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.*;

import Encyclopedia.OtherClasses.TheBrain;

public class Main {

	public JFrame frame;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Main() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setSize(1300, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TheBrain brain = new TheBrain();
		JPanel backPanel = brain.createBackgroundPanel();
		frame.getContentPane().add(backPanel);
		frame.setJMenuBar(brain.createMenu(backPanel));
	}
}