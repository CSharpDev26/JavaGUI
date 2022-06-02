package Encyclopedia.Menuclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Encyclopedia.OtherClasses.*;

public class PeopleClass {
	
	public ArrayList<JMenuItem> createMenu(JPanel backPanel, String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DataManagement dm = new DataManagement();
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
		ArrayList<String> names = dm.getNames(type);
		FrontEndClass fec = new FrontEndClass();
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
		DataManagement dm = new DataManagement();
		Object [] personData = dm.getPersonData(name);
		
		backPanel.removeAll();
		backPanel.setLayout(null);
		backPanel.add(imagePanel((String)personData[12]));
		backPanel.add(titlePanel((String)personData[1], fec));
		backPanel.add(descPanel((String)personData[13], fec));
		backPanel.add(baseInfoPanel((String)personData[2],(String)personData[3],(String)personData[4], fec));
		backPanel.add(detailsPanel((String)personData[5],(String)personData[6],(Double)personData[7],(Integer)personData[8],(String)personData[9],(String)personData[10],(String)personData[11], fec));
		backPanel.add(affiliationPanel());
		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}	
	
	private JPanel imagePanel(String imageName) {
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(485, 75, 315, 237);
		imagePanel.setLayout(null);
		String imageFullName = "images/people/" + imageName;
		ImageIcon iC = new ImageIcon(imageFullName);
		Image planetImage = iC.getImage();  
		Image resizedImg = planetImage.getScaledInstance(315, 237,  java.awt.Image.SCALE_SMOOTH); 
		iC = new ImageIcon(resizedImg);  
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 315, 237);
		imageLabel.setIcon(iC);
		imagePanel.add(imageLabel);
		return imagePanel;
	}
	
	private JPanel titlePanel(String name, FrontEndClass fec) {
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(514, 11, 417, 53);
		titlePanel.setOpaque(false);
		titlePanel.setLayout(null);
		JTextArea title_TA = new JTextArea();
		title_TA.setBounds(35, 11, 372, 31);
		title_TA.setText(name);
		fec.textEditor(title_TA);
		titlePanel.add(title_TA);
		return titlePanel;
	}
	
	private JPanel descPanel(String desc, FrontEndClass fec) {
		JPanel descPanel = new JPanel();
		descPanel.setBounds(291, 337, 616, 404);
		descPanel.setOpaque(false);
		descPanel.setLayout(null);
		
		JTextArea desc_TA = new JTextArea();
		desc_TA.setBounds(10, 11, 596, 382);
		desc_TA.setText(desc);
		fec.textEditor(desc_TA);
		descPanel.add(desc_TA);
		return descPanel;
	}
	
	private JPanel baseInfoPanel(String homeworld, String born, String died, FrontEndClass fec) {
		JPanel baseInfoPanel = new JPanel();
		baseInfoPanel.setBounds(46, 337, 235, 404);
		baseInfoPanel.setOpaque(false);
		baseInfoPanel.setLayout(null);
		
		JTextArea homeWorld_TA = new JTextArea();
		homeWorld_TA.setBounds(10, 40, 215, 66);
		String homeWorldfull;
		if(homeworld.isEmpty())
			homeWorldfull = "Homeworld: \nUnknown";
		else
			homeWorldfull = "Homeworld: \n" + homeworld;
		homeWorld_TA.setText(homeWorldfull);
		fec.textEditor(homeWorld_TA);
		baseInfoPanel.add(homeWorld_TA);
		
		JTextArea born_TA = new JTextArea();
		born_TA.setBounds(10, 117, 215, 67);
		String bornFull;
		if(born.isEmpty())
			bornFull = "Born: \nUnknown";
		else
			bornFull = "Born: \n" + born;
		born_TA.setText(bornFull);
		fec.textEditor(born_TA);
		baseInfoPanel.add(born_TA);
		
		JTextArea died_TA = new JTextArea();
		died_TA.setBounds(10, 195, 215, 66);
		String diedFull;
		if(died.isEmpty())
			diedFull = "Died: \nUnknown";
		else
			diedFull = "Died: \n" + died;
		died_TA.setText(diedFull);
		fec.textEditor(died_TA);
		baseInfoPanel.add(died_TA);
		return baseInfoPanel;
	}
	
	private JPanel detailsPanel(String species, String gender, Double height, Integer mass, String hairColor, String skinColor, String eyeColor, FrontEndClass fec ) {
		String heightHolder, massHolder;
		if(height == 0.0)
			heightHolder = new String();
		else
			heightHolder = height.toString();
		if(mass == 0)
			massHolder = new String();
		else
			massHolder = mass.toString();
		
		String[] textData = new String[7];
		textData[0] = species;
		textData[1] = gender;
		textData[2] = heightHolder;
		textData[3] = massHolder;
		textData[4] = hairColor;
		textData[5] = skinColor;
		textData[6] = eyeColor;
		textData = dataCheckerAndTextCreator(textData);
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBounds(917, 337, 328, 404);
		detailsPanel.setOpaque(false);
		detailsPanel.setLayout(null);
		
		JTextArea species_TA = new JTextArea();
		species_TA.setBounds(10, 11, 308, 30);
		species_TA.setText(textData[0]);
		fec.textEditor(species_TA);
		detailsPanel.add(species_TA);
		
		JTextArea gender_TA = new JTextArea();
		gender_TA.setBounds(10, 52, 308, 30);
		gender_TA.setText(textData[1]);
		fec.textEditor(gender_TA);
		detailsPanel.add(gender_TA);
		
		JTextArea height_TA = new JTextArea();
		height_TA.setBounds(10, 93, 308, 30);
		height_TA.setText(textData[2]);
		fec.textEditor(height_TA);
		detailsPanel.add(height_TA);
		
		JTextArea mass_TA = new JTextArea();
		mass_TA.setBounds(10, 134, 308, 30);
		mass_TA.setText(textData[3]);
		fec.textEditor(mass_TA);
		detailsPanel.add(mass_TA);
		
		JTextArea hairColor_TA = new JTextArea();
		hairColor_TA.setBounds(10, 175, 308, 30);
		hairColor_TA.setText(textData[4]);
		fec.textEditor(hairColor_TA);
		detailsPanel.add(hairColor_TA);
		
		JTextArea skinColor_TA = new JTextArea();
		skinColor_TA.setBounds(10, 216, 308, 30);
		skinColor_TA.setText(textData[5]);
		fec.textEditor(skinColor_TA);
		detailsPanel.add(skinColor_TA);
		
		JTextArea eyeColor_TA = new JTextArea();
		eyeColor_TA.setBounds(10, 257, 308, 30);
		eyeColor_TA.setText(textData[6]);
		fec.textEditor(eyeColor_TA);
		detailsPanel.add(eyeColor_TA);
		
		return detailsPanel;
	}
	
	private JPanel affiliationPanel() {
		JPanel affiliationPanel = new JPanel();
		affiliationPanel.setBounds(119, 760, 912, 68);
		affiliationPanel.setOpaque(false);
		affiliationPanel.setLayout(null);
		return affiliationPanel;
	}
	
	private String[] dataCheckerAndTextCreator(String[] data) {
		for(int i = 0; i < data.length; i++) {
			if(!data[i].isEmpty()) {
				if(i == 0)
					data[i] = "Species: " + data[i];
				else if(i == 1)
					data[i] = "Gender: " + data[i];
				else if(i == 2)
					data[i] = "Height: " + data[i] + " m";
				else if(i == 3)
					data[i] = "Mass: " + data[i] + " kg";
				else if(i == 4)
					data[i] = "Hair color: " + data[i]; 
				else if(i == 5)
					data[i] = "Skin color: " + data[i];
				else if(i == 6)
					data[i] = "Eye color: " + data[i];
			}
			else {
				if(i == 0)
					data[i] = "Species: Unknown";
				else if(i == 1)
					data[i] = "Gender: Unknown";
				else if(i == 2)
					data[i] = "Height: Unknown";
				else if(i == 3)
					data[i] = "Mass: Unknown";
				else if(i == 4)
					data[i] = "Hair color: Unknown"; 
				else if(i == 5)
					data[i] = "Skin color: Unknown";
				else if(i == 6)
					data[i] = "Eye color: Unknown";
			}
		}
		
		return data;
	}
}
