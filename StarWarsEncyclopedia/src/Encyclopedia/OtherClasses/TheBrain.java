package Encyclopedia.OtherClasses;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import Encyclopedia.Menuclasses.*;

public class TheBrain {
	
	static TheBrain instance = null;
	
	private TheBrain() {}
	
	public static TheBrain getInstance() {
		if(instance != null)
			return instance;
		else {
			instance = new TheBrain();
			return instance;
		}
	}

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
		UIManager.put("MenuBar.selectionBackground", Color.BLUE);
		UIManager.put("MenuBar.selectionForeground", Color.WHITE);
		UIManager.put("Menu.selectionBackground", Color.BLUE);
		UIManager.put("Menu.selectionForeground", Color.WHITE);
		UIManager.put("MenuItem.selectionBackground", Color.BLUE);
		UIManager.put("MenuItem.selectionForeground", Color.WHITE);
		JMenuBar jmb = FrontEndClass.menuBarFrontEnd();
		JMenu planetMenu = FrontEndClass.menuFrontEnd("Planets");
		planetMenuCreator(planetMenu, backPanel);
		jmb.add(planetMenu);
		JMenu peopleMenu = FrontEndClass.menuFrontEnd("People");
		peopleMenuCreator(backPanel, peopleMenu);
		jmb.add(peopleMenu);
		JMenu droidMenu = FrontEndClass.menuFrontEnd("Droids");
		droidMenuCreator(droidMenu, backPanel);
		jmb.add(droidMenu);
		JMenu faunaMenu = FrontEndClass.menuFrontEnd("Fauna");
		faunaMenuCreator(faunaMenu, backPanel);
		jmb.add(faunaMenu);
		JMenu floraMenu = FrontEndClass.menuFrontEnd("Flora");
		floraMenuCreator(floraMenu, backPanel);
		jmb.add(floraMenu);
		return jmb;
	}
	
	private void planetMenuCreator(JMenu menu, JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PlanetClass pC = new PlanetClass();
		ArrayList<JMenuItem> planetNameList = pC.createMenu(backPanel);
		for(JMenuItem item : planetNameList) {
			menu.add(item);
		}
	}
	
	private void peopleMenuCreator(JPanel backPanel, JMenu peopleMenu) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		JMenu jediMenu = FrontEndClass.menuFrontEnd("Jedi");
		peopleSubMenuCreator(jediMenu, backPanel);
		peopleMenu.add(jediMenu);
		JMenu sithMenu = FrontEndClass.menuFrontEnd("Sith");
		peopleSubMenuCreator(sithMenu, backPanel);
		peopleMenu.add(sithMenu);
		JMenu senatorMenu = FrontEndClass.menuFrontEnd("Senator");
		peopleSubMenuCreator(senatorMenu, backPanel);
		peopleMenu.add(senatorMenu);
		JMenu crimeLordMenu = FrontEndClass.menuFrontEnd("Crime lord");
		peopleSubMenuCreator(crimeLordMenu, backPanel);
		peopleMenu.add(crimeLordMenu);
		JMenu smugglerMenu = FrontEndClass.menuFrontEnd("Smuggler");
		peopleSubMenuCreator(smugglerMenu, backPanel);
		peopleMenu.add(smugglerMenu);
		JMenu bountyHunterMenu = FrontEndClass.menuFrontEnd("Bounty hunter");
		peopleSubMenuCreator(bountyHunterMenu, backPanel);
		peopleMenu.add(bountyHunterMenu);
		JMenu otherMenu = FrontEndClass.menuFrontEnd("Other");
		peopleSubMenuCreator(otherMenu, backPanel);
		peopleMenu.add(otherMenu);
   }
	
	private void peopleSubMenuCreator(JMenu menu, JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<JMenuItem> peopleNameList;
		PeopleClass people = new PeopleClass();
		peopleNameList = people.createMenu(backPanel, menu.getText());
		for(JMenuItem item : peopleNameList) {
			menu.add(item);
		}
	}

	private void faunaMenuCreator(JMenu menu, JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		FaunaClass fC = new FaunaClass();
		ArrayList<JMenuItem> faunaNameList = fC.createMenu(backPanel);
		for(JMenuItem item : faunaNameList) {
			menu.add(item);
		}
	}
	
	private void floraMenuCreator(JMenu menu, JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		FloraClass fC = new FloraClass();
		ArrayList<JMenuItem> floraNameList = fC.createMenu(backPanel);
		for(JMenuItem item : floraNameList) {
			menu.add(item);
		}
	}
	
	private void droidMenuCreator(JMenu menu, JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DroidClass dC = new DroidClass();
		ArrayList<JMenuItem> floraNameList = dC.createMenu(backPanel);
		for(JMenuItem item : floraNameList) {
			menu.add(item);
		}
	}
	
}
