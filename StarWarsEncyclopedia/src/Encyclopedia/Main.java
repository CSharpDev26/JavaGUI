package Encyclopedia;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javax.swing.*;

import Encyclopedia.OtherClasses.TheBrain;
import Encyclopedia.SplashScreenClass;

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
	 * @throws MalformedURLException 
	 */
	public Main() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//splash();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws MalformedURLException 
	 */
	private void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setSize(1300, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TheBrain brain = TheBrain.getInstance();
		JPanel backPanel = brain.createBackgroundPanel();
		frame.getContentPane().add(backPanel);
		frame.setJMenuBar(brain.createMenu(backPanel));
		try {
			splash();
			Thread.sleep(2000);
		}
		catch(Exception e) {
		}
	}
	private void splash() {
		 SplashScreenClass.createSplash();
	}
}