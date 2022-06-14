package Encyclopedia;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JWindow;

public class SplashScreenClass extends JWindow {
		Clip clip; 
	   Image splashScreen;
	   ImageIcon imageIcon;
	   public SplashScreenClass() {
	      splashScreen = Toolkit.getDefaultToolkit().getImage("images/splash/splash.gif");
	      imageIcon = new ImageIcon(splashScreen);
	      setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      int x = (screenSize.width-getSize().width)/2;
	      int y = (screenSize.height-getSize().height)/2;
	      setLocation(x,y);
	      setVisible(true);
	   }
	   public void paint(Graphics g) {
	      super.paint(g);
	      g.drawImage(splashScreen, 0, 0, this);
	   }
	   public Clip getSoundPlayer() {
		   return clip;
	   }
	}
