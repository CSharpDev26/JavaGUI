package Encyclopedia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PeopleClass {
	
	public ArrayList<JMenuItem> createMenu(JPanel backPanel, String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DataManagement dm = new DataManagement();
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
		ArrayList<String> names = dm.getNames(type);
		for(String name: names) {
			JMenuItem menuItem = new JMenuItem(name);
			menuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						contentPanelCreator(backPanel,name);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			list.add(menuItem);
		}
		return list;
	}
	
	private void contentPanelCreator(JPanel backPanel, String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DataManagement dm = new DataManagement();
		Object [] personData = dm.getPersonData(name);
		
		backPanel.removeAll();
		backPanel.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(435, 11, 417, 53);
		titlePanel.setLayout(null);
	
		
		JTextArea title_TA = new JTextArea();
		title_TA.setBounds(35, 11, 372, 31);
		titlePanel.add(title_TA);
		
		JPanel descPanel = new JPanel();
		descPanel.setBounds(291, 337, 616, 404);
		descPanel.setLayout(null);
		
		JTextArea desc_TA = new JTextArea();
		desc_TA.setBounds(10, 11, 596, 382);
		descPanel.add(desc_TA);
		
		JPanel baseInfoPanel = new JPanel();
		baseInfoPanel.setBounds(46, 337, 235, 404);
		baseInfoPanel.setLayout(null);
		
		JTextArea homeWorld_TA = new JTextArea();
		homeWorld_TA.setBounds(10, 40, 215, 33);
		baseInfoPanel.add(homeWorld_TA);
		
		JTextArea born_TA = new JTextArea();
		born_TA.setBounds(10, 109, 215, 33);
		baseInfoPanel.add(born_TA);
		
		JTextArea died_TA = new JTextArea();
		died_TA.setBounds(10, 182, 215, 33);
		baseInfoPanel.add(died_TA);
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBounds(917, 337, 328, 404);
		detailsPanel.setLayout(null);
		
		JTextArea species_TA = new JTextArea();
		species_TA.setBounds(10, 11, 308, 30);
		detailsPanel.add(species_TA);
		
		JTextArea gender_TA = new JTextArea();
		gender_TA.setBounds(10, 52, 308, 30);
		detailsPanel.add(gender_TA);
		
		JTextArea height_TA = new JTextArea();
		height_TA.setBounds(10, 93, 308, 30);
		detailsPanel.add(height_TA);
		
		JTextArea mass_TA = new JTextArea();
		mass_TA.setBounds(10, 134, 308, 30);
		detailsPanel.add(mass_TA);
		
		JTextArea hairColor_TA = new JTextArea();
		hairColor_TA.setBounds(10, 175, 308, 30);
		detailsPanel.add(hairColor_TA);
		
		JTextArea skinColor_TA = new JTextArea();
		skinColor_TA.setBounds(10, 216, 308, 30);
		detailsPanel.add(skinColor_TA);
		
		JTextArea eyeColor_TA = new JTextArea();
		eyeColor_TA.setBounds(10, 257, 308, 30);
		detailsPanel.add(eyeColor_TA);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(485, 75, 315, 237);
		baseInfoPanel.setLayout(null);
		
		JPanel affiliationPanel = new JPanel();
		affiliationPanel.setBounds(119, 760, 912, 68);
		affiliationPanel.setLayout(null);
		

		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}	
}
