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

public class FaunaClass implements MenuInterface {
	
	public ArrayList<JMenuItem> createMenu(JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DataManagement dm = DataManagement.getInstance();
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
		ArrayList<String> names;
		FrontEndClass fec = FrontEndClass.getInstance();
		names = dm.getNames("faunas");
		for(String name: names) {
			JMenuItem menuItem = fec.menuItemFrontEnd(name);
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
		Object [] faunaData = dm.getFaunaData(name);
		
		backPanel.removeAll();
		backPanel.setLayout(null);
		backPanel.add(imagePanel((String)faunaData[10]));
		backPanel.add(titlePanel((String)faunaData[1],fec));
		backPanel.add(descPanel((String)faunaData[2],fec));
		backPanel.add(baseInfoPanel((String)faunaData[7], (String)faunaData[8], (String)faunaData[9], fec));
		backPanel.add(otherInfoPanel((String)faunaData[5], (String)faunaData[6], (Double)faunaData[3], (Integer)faunaData[4], fec));
		backPanel.add(affiliationPanel());
		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}
	
	public JPanel imagePanel(String imageName) {
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(473, 82, 340, 249);
		imagePanel.setLayout(null);
		
		String imageFullName = "images/fauna/" + imageName;
		ImageIcon iC = new ImageIcon(imageFullName);
		Image planetImage = iC.getImage();  
		Image resizedImg = planetImage.getScaledInstance(340, 249,  java.awt.Image.SCALE_SMOOTH); 
		iC = new ImageIcon(resizedImg); 
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 340, 249);
		imageLabel.setIcon(iC);
		imagePanel.add(imageLabel);
		return imagePanel;
	}
	
	public JPanel titlePanel(String name, FrontEndClass fec) {
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(517, 11, 340, 47);
		titlePanel.setLayout(null);
		titlePanel.setOpaque(false);
		
		JTextArea name_TA = new JTextArea();
		name_TA.setBounds(72, 11, 258, 25);
		name_TA.setText(name);
		fec.textEditor(name_TA);
		titlePanel.add(name_TA);
		return titlePanel;
	}
	
	public JPanel descPanel(String desc, FrontEndClass fec) {
		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setBounds(350, 342, 584, 380);
		descriptionPanel.setLayout(null);
		descriptionPanel.setOpaque(false);

		JTextArea desc_TA = new JTextArea();
		desc_TA.setBounds(10, 11, 564, 358);
		desc_TA.setText(desc);
		fec.textEditor(desc_TA);
		descriptionPanel.add(desc_TA);
		return descriptionPanel;
	}
	
	private JPanel baseInfoPanel(String homeWorld, String habitat, String diet, FrontEndClass fec) {
		String[] data = {homeWorld, habitat, diet};
		data = dataCheckerAndTextCreator(data, true);
		
		JPanel baseInfoPanel = new JPanel();
		baseInfoPanel.setBounds(10, 342, 330, 380);
		baseInfoPanel.setLayout(null);
		baseInfoPanel.setOpaque(false);
		
		JTextArea homeWorld_TA = new JTextArea();
		homeWorld_TA.setBounds(10, 11, 310, 76);
		homeWorld_TA.setText(data[0]);
		fec.textEditor(homeWorld_TA);
		baseInfoPanel.add(homeWorld_TA);
		
		JTextArea habitat_TA = new JTextArea();
		habitat_TA.setBounds(10, 98, 310, 76);
		habitat_TA.setText(data[1]);
		fec.textEditor(habitat_TA);
		baseInfoPanel.add(habitat_TA);
		
		JTextArea diet_TA = new JTextArea();
		diet_TA.setBounds(10, 185, 310, 76);
		diet_TA.setText(data[2]);
		fec.textEditor(diet_TA);
		baseInfoPanel.add(diet_TA);
		return baseInfoPanel;
	}
	
	private JPanel otherInfoPanel(String skin, String eye, Double height, Integer mass, FrontEndClass fec) {
		String heightHolder, massHolder;
		if(height == 0.0) {
			heightHolder = new String();
		}
		else {
			heightHolder = height.toString();
		}
		if(mass == 0) {
			massHolder = new String();
		}
		else {
			massHolder = mass.toString();
		}
		String[] data = {skin, eye, heightHolder, massHolder};
		data = dataCheckerAndTextCreator(data, false);
		
		JPanel otherInformationPanel = new JPanel();
		otherInformationPanel.setBounds(944, 342, 330, 380);
		otherInformationPanel.setLayout(null);
		otherInformationPanel.setOpaque(false);
		
		JTextArea skin_TA = new JTextArea();
		skin_TA.setBounds(10, 11, 310, 76);
		skin_TA.setText(data[0]);
		fec.textEditor(skin_TA);
		otherInformationPanel.add(skin_TA);
		
		JTextArea eye_TA = new JTextArea();
		eye_TA.setBounds(10, 98, 310, 76);
		eye_TA.setText(data[1]);
		fec.textEditor(eye_TA);
		otherInformationPanel.add(eye_TA);
		
		JTextArea mass_TA = new JTextArea();
		mass_TA.setBounds(10, 185, 310, 76);
		mass_TA.setText(data[3]);
		fec.textEditor(mass_TA);
		otherInformationPanel.add(mass_TA);
		
		JTextArea height_TA = new JTextArea();
		height_TA.setBounds(10, 272, 310, 76);
		height_TA.setText(data[2]);
		fec.textEditor(height_TA);
		otherInformationPanel.add(height_TA);
		return otherInformationPanel;
		
	}
	
	public JPanel affiliationPanel() {
		JPanel affiliationPanel = new JPanel();
		affiliationPanel.setBounds(303, 733, 683, 95);
		affiliationPanel.setLayout(null);
		affiliationPanel.setOpaque(false);
		return affiliationPanel;
	}
	
	private String[] dataCheckerAndTextCreator(String[] data, boolean info) {
		if(info)
			return baseInfoTextCreator(data);
		else
			return otherInfoTextCreator(data);
	}
	
	private String[] baseInfoTextCreator(String[] data) {
		for(int i = 0; i < data.length; i++) {
			if(!data[i].isEmpty()) {
				if(i == 0)
					data[i] = "Homeworld: \n" + data[i];
				else if(i == 1) 
					data[i] = "Habitat: \n" + data[i];
				else
					data[i] = "Diet: \n" + data[i];
			}
			else {
				if(i == 0)
					data[i] = "Homeworld: \nUnknown";
				else if(i == 1) 
					data[i] = "Habitat: \nUnknown";
				else
					data[i] = "Diet: \nUnknown";
			}
		}
		return data;
	}
	
	private String[] otherInfoTextCreator(String[] data) {
		for(int i = 0; i < data.length; i++) {
			if(!data[i].isEmpty()) {
				if(i == 0)
					data[i] = "Skin color: \n" + data[i];
				else if(i == 1) 
					data[i] = "Eye color: \n" + data[i];
				else if(i == 2)
					data[i] = "Height: \n" + data[i] + " m";
				else
					data[i] = "Mass: \n" + data[i] + " kg";
			}
			else {
				if(i == 0)
					data[i] = "Skin color: \nUnknown";
				else if(i == 1) 
					data[i] = "Eye color: \nUnknown";
				else if(i == 2)
					data[i] = "Height: \nUnknown";
				else
					data[i] = "Mass: \nUnknown";
			}
		}
		return data;
	}
}
