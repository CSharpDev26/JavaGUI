package Encyclopedia;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;


public class SplashScreenClass {

	public static void createSplash() {
		JWindow window = new JWindow();
		window.getContentPane().add(
		new JLabel("", new ImageIcon("images/splash/splash.gif"), SwingConstants.CENTER));
		window.setSize(500, 303);
		window.setVisible(true);
		musicPlayer("splashsound/starwars.wav");
		//window.setVisible(false);
		//window.dispose();
	}
	
	public static void musicPlayer(String path){
		File audioFile = new File(path);
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(audioFile);
			Clip clip = AudioSystem.getClip();
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
