package Encyclopedia.Menuclasses;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Encyclopedia.Interfaces.MenuInterface;
import Encyclopedia.OtherClasses.DataManagement;
import Encyclopedia.OtherClasses.FrontEndClass;

public class FloraClass implements MenuInterface {
	
	public ArrayList<JMenuItem> createMenu(JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DataManagement dm = DataManagement.getInstance();
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
		ArrayList<String> names;
		FrontEndClass fec = FrontEndClass.getInstance();
		names = dm.getNames("floras");
		for(String name: names) {
			JMenuItem menuItem = new JMenuItem(name);
			menuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						contentPanelCreator(backPanel, name, fec);
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
	
	private void contentPanelCreator(JPanel backPanel, String name, FrontEndClass fec) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DataManagement dm = DataManagement.getInstance();
		Object [] floraData = dm.getFloraData(name);
		
		backPanel.removeAll();
		backPanel.setLayout(null);
		backPanel.add(titlePanel((String)floraData[1], fec));
		backPanel.add(imagePanel((String)floraData[7]));
		backPanel.add(descPanel((String)floraData[2], fec));
		backPanel.add(dataPanel((String)floraData[3], (String)floraData[4], (String)floraData[5], (String)floraData[6], fec));
		backPanel.add(affiliationPanel());
		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}
	public JPanel titlePanel(String name, FrontEndClass fec) {
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(486, 11, 524, 62);
		titlePanel.setLayout(null);
		titlePanel.setOpaque(false);
		
		JTextArea name_TA = new JTextArea();
		name_TA.setBounds(111, 11, 390, 40);
		name_TA.setText(name);
		fec.textEditor(name_TA);
		titlePanel.add(name_TA);
		return titlePanel;	
	}
	
	public JPanel imagePanel(String imageName) {
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(483, 98, 351, 258);
		imagePanel.setLayout(null);
		imagePanel.setOpaque(false);
		String imageFullName = "images/flora/" + imageName;
		ImageIcon iC = new ImageIcon(imageFullName);
		Image planetImage = iC.getImage();  
		Image resizedImg = planetImage.getScaledInstance(351, 258,  java.awt.Image.SCALE_SMOOTH); 
		iC = new ImageIcon(resizedImg);  
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 351, 258);
		imageLabel.setIcon(iC);
		imagePanel.add(imageLabel);
		return imagePanel;
	}
	
	public JPanel descPanel(String desc, FrontEndClass fec) {
		JPanel descPanel = new JPanel();
		descPanel.setBounds(346, 367, 594, 461);
		descPanel.setLayout(null);
		descPanel.setOpaque(false);
		
		JTextArea desc_TA = new JTextArea();
		desc_TA.setBounds(0, 0, 594, 461);
		desc_TA.setText(desc);
		fec.textEditor(desc_TA);
		descPanel.add(desc_TA);
		return descPanel;
	}
	
	private JPanel dataPanel(String classString, String homeWorld, String habitat, String phisical, FrontEndClass fec) {
		JPanel dataPanel = new JPanel();
		dataPanel.setBounds(10, 327, 316, 487);
		dataPanel.setLayout(null);
		dataPanel.setOpaque(false);
		
		JTextArea class_TA = new JTextArea();
		class_TA.setBounds(10, 11, 296, 69);
		if(classString.isEmpty())
			classString = "Classification: \nUnknown";
		else
			classString = "Classification: \n" + classString; 
		class_TA.setText(classString);
		fec.textEditor(class_TA);
		dataPanel.add(class_TA);
		
		JTextArea homeWorld_TA = new JTextArea();
		homeWorld_TA.setBounds(10, 95, 296, 69);
		if(homeWorld.isEmpty())
			homeWorld = "Homeworld: \nUnknown";
		else
			homeWorld = "Homeworld: \n" + homeWorld;
		homeWorld_TA.setText(homeWorld);
		fec.textEditor(homeWorld_TA);
		dataPanel.add(homeWorld_TA);
		
		JTextArea habitat_TA = new JTextArea();
		habitat_TA.setBounds(10, 182, 296, 69);
		if(habitat.isEmpty())
			habitat = "Habitat: \nUknown";
		else
			habitat = "Habitat: \n" + habitat;
		habitat_TA.setText(habitat);
		fec.textEditor(habitat_TA);
		dataPanel.add(habitat_TA);
		
		JTextArea phisical_TA = new JTextArea();
		phisical_TA.setBounds(10, 268, 296, 208);
		if(phisical.isEmpty())
			phisical = "Phisical description: \nUnknown";
		else {
			phisical_TA.append("Phisical description:\n");
			fec.listTextEditor(phisical_TA, phisical);
		}

		dataPanel.add(phisical_TA);
		return dataPanel;
	}
	
	public JPanel affiliationPanel() {
		JPanel affiliationPanel = new JPanel();
		affiliationPanel.setBounds(957, 351, 317, 463);
		affiliationPanel.setLayout(null);
		affiliationPanel.setOpaque(false);
		return affiliationPanel;
	}
}
