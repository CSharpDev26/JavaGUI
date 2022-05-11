package Encyclopedia;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final ImageIcon icon = new ImageIcon("images/background/galaxy.jpg");
		frame = new JFrame();
		frame.setSize(1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel backGroundPanel = new JPanel(){
			Image img = icon.getImage();
		      {setOpaque(false);}
		      public void paintComponent(Graphics graphics) 
		      {
		        graphics.drawImage(img, 0, 0, this);
		        super.paintComponent(graphics);
		      }
		};
		backGroundPanel.setLocation(0, 0);
		backGroundPanel.setSize(1904, 1041);;
		frame.getContentPane().add(backGroundPanel);
	}
}
