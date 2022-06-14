package Encyclopedia;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.Dimension;

import Encyclopedia.OtherClasses.TheBrain;
import Encyclopedia.SplashScreenClass;

public class Main {

	public JFrame frame;
	static Clip clip;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		musicPlayer();
		try {
			Thread.sleep(1300);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		SplashScreenClass splash = new SplashScreenClass();
	      try {
	         Thread.sleep(16000);
	         clip.stop();
	         splash.dispose();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(screenSize.width / 2 - 650, screenSize.height / 2 - 450);
		TheBrain brain = TheBrain.getInstance();
		JPanel backPanel = brain.createBackgroundPanel();
		frame.getContentPane().add(backPanel);
		frame.setJMenuBar(brain.createMenu(backPanel));
	}
	
	 public static void musicPlayer(){
			File audioFile = new File("splashsound/starwars.wav");
			try {
				AudioInputStream audio = AudioSystem.getAudioInputStream(audioFile);
				clip = AudioSystem.getClip();
				clip.open(audio);
				clip.start();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
