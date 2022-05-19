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
		jmb.add(planetMenu);
		jmb.add(peopleMenuCreator(backPanel));
		return jmb;
	}
	
	private void planetMenuCreator(JMenu menu, JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PlanetClass pC = new PlanetClass();
		ArrayList<JMenuItem> planetNameList = pC.createMenu(backPanel);
		for(JMenuItem item : planetNameList) {
			menu.add(item);
		}
	}
	
	private JMenu peopleMenuCreator(JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		JMenu peopleMenu = new JMenu("People");
		
		JMenu jediMenu = new JMenu("Jedi");
		peopleSubMenuCreator(jediMenu, backPanel);
		peopleMenu.add(jediMenu);
		JMenu sithMenu = new JMenu("Sith");
		peopleSubMenuCreator(sithMenu, backPanel);
		peopleMenu.add(sithMenu);
		JMenu senatorMenu = new JMenu("Senator");
		peopleSubMenuCreator(senatorMenu, backPanel);
		peopleMenu.add(senatorMenu);
		JMenu crimeLordMenu = new JMenu("Crime lord");
		peopleSubMenuCreator(crimeLordMenu, backPanel);
		peopleMenu.add(crimeLordMenu);
		JMenu smugglerMenu = new JMenu("Smuggler");
		peopleSubMenuCreator(smugglerMenu, backPanel);
		peopleMenu.add(smugglerMenu);
		JMenu bountyHunterMenu = new JMenu("Bounty hunter");
		peopleSubMenuCreator(bountyHunterMenu, backPanel);
		peopleMenu.add(bountyHunterMenu);
		JMenu otherMenu = new JMenu("Other");
		peopleSubMenuCreator(otherMenu, backPanel);
		peopleMenu.add(otherMenu);
		return peopleMenu;
	}
	
	private void peopleSubMenuCreator(JMenu menu, JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<JMenuItem> peopleNameList;
		PeopleClass people = new PeopleClass();
		peopleNameList = people.createMenu(backPanel,menu.getText());
		for(JMenuItem item : peopleNameList) {
			menu.add(item);
		}
	}
}
