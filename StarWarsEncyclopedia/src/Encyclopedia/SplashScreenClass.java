package Encyclopedia;

import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
		
		
		//window.setVisible(false);
		//WDSWwindow.dispose();
	}
	
	private void musicPlayer(String path){
		InputStream music;
		try {
			music = new FileInputStream(new File(path));
			//AudioStream aS = new AudioStream(music);
			//AuidoPlayer
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
