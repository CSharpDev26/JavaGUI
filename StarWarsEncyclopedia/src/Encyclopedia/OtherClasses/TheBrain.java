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
		JMenuBar jmb = new JMenuBar();
		JMenu planetMenu = new JMenu("Planets");
		planetMenuCreator(planetMenu, backPanel);
		jmb.add(planetMenu);
		jmb.add(peopleMenuCreator(backPanel));
		JMenu droidMenu = new JMenu("Droids");
		droidMenuCreator(droidMenu, backPanel);
		jmb.add(droidMenu);
		JMenu faunaMenu = new JMenu("Fauna");
		faunaMenuCreator(faunaMenu, backPanel);
		jmb.add(faunaMenu);
		JMenu floraMenu = new JMenu("Flora");
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
