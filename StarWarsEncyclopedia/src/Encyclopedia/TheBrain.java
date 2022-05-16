package Encyclopedia;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class TheBrain {

	public JPanel createBackgroundPanel(){
		
		final ImageIcon icon = new ImageIcon("images/background/galaxy.jpg");
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
		backGroundPanel.setSize(1904, 1041);
		backGroundPanel.setLayout(null);
		return backGroundPanel;
	}
	
	public JMenuBar createMenu(JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		JMenuBar jmb = new JMenuBar();
		JMenu planetMenu = new JMenu("Planets");
		planetMenuCreator(planetMenu,backPanel);
		
		JMenuItem jedi = new JMenuItem("jedi");
		jedi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backPanel.removeAll();
				backPanel.setLayout(new GridLayout(2,1));
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				p1.add(new JLabel("panel 1"));
				p2.add(new JLabel("panel 2"));
				backPanel.add(p1);
				backPanel.add(p2);
				p1.setOpaque(false);
				backPanel.invalidate();
				backPanel.validate();
				backPanel.repaint();
			}
		});
		jmb.add(planetMenu);
		JMenu peopleMenu = new JMenu("People");
		peopleMenu.add(jedi);
		jmb.add(peopleMenu);
		return jmb;
	}
	
	private void planetMenuCreator(JMenu menu, JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PlanetClass pC = new PlanetClass();
		ArrayList<JMenuItem> planetNameList = pC.createMenu(backPanel);
		for(JMenuItem item : planetNameList) {
			menu.add(item);
		}
	}
}
