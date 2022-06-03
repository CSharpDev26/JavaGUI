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

public class DroidClass implements MenuInterface {
	
	public ArrayList<JMenuItem> createMenu(JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DataManagement dm = DataManagement.getInstance();
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
		ArrayList<String> names;
		FrontEndClass fec = FrontEndClass.getInstance();
		names = dm.getNames("droids");
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
		Object [] droidData = dm.getDroidData(name);
		
		backPanel.removeAll();
		backPanel.setLayout(null);
		backPanel.add(titlePanel((String)droidData[1], fec));
		backPanel.add(imagePanel((String)droidData[10]));
		backPanel.add(descPanel((String)droidData[2], fec));
		backPanel.add(baseInfoPanel((String)droidData[3], (String)droidData[4], (String)droidData[5], fec));
		backPanel.add(otherInfoPanel((String)droidData[6], (String)droidData[7], (String)droidData[8], (String)droidData[9], fec));
		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}
	
	@Override
	public JPanel titlePanel(String name, FrontEndClass fec) {
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(445, 11, 706, 57);
		titlePanel.setLayout(null);
		titlePanel.setOpaque(false);
		
		JTextArea name_TA = new JTextArea();
		name_TA.setBounds(129, 11, 475, 46);
		name_TA.setText(name);
		fec.textEditor(name_TA);
		titlePanel.add(name_TA);
		return titlePanel;
	}
	
	@Override
	public JPanel imagePanel(String imageName) {
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(435, 79, 370, 249);
		imagePanel.setLayout(null);
		String imageFullName = "images/droids/" + imageName;
		ImageIcon iC = new ImageIcon(imageFullName);
		Image planetImage = iC.getImage();  
		Image resizedImg = planetImage.getScaledInstance(370, 249,  java.awt.Image.SCALE_SMOOTH); 
		iC = new ImageIcon(resizedImg);  
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 370, 249);
		imageLabel.setIcon(iC);
		imagePanel.add(imageLabel);
		return imagePanel;
	}

	@Override
	public JPanel descPanel(String desc, FrontEndClass fec) {
		JPanel descPanel = new JPanel();
		descPanel.setBounds(317, 358, 667, 384);
		descPanel.setLayout(null);
		descPanel.setOpaque(false);
		
		JTextArea desc_TA = new JTextArea();
		desc_TA.setBounds(0, 0, 667, 384);
		desc_TA.setText(desc);
		fec.textEditor(desc_TA);
		descPanel.add(desc_TA);
		return descPanel;
	}
	
	private JPanel baseInfoPanel(String homeWorld, String creationDate, String destroyedDate, FrontEndClass fec) {
		JPanel baseDataPanel = new JPanel();
		baseDataPanel.setBounds(10, 358, 297, 384);
		baseDataPanel.setLayout(null);
		baseDataPanel.setOpaque(false);
		
		JTextArea homeWorld_TA = new JTextArea();
		homeWorld_TA.setBounds(10, 11, 277, 94);
		if(homeWorld.isEmpty())
			homeWorld = "Homeworld: \nUnknown";
		else
			homeWorld = "Homeworld: \n" + homeWorld;
		homeWorld_TA.setText(homeWorld);
		fec.textEditor(homeWorld_TA);
		baseDataPanel.add(homeWorld_TA);
		
		JTextArea creationDate_TA = new JTextArea();
		creationDate_TA.setBounds(10, 116, 277, 94);
		if(creationDate.isEmpty())
			creationDate = "Date of creation: \nUnknown";
		else
			creationDate = "Date of creation: \n" + creationDate;
		creationDate_TA.setText(creationDate);
		fec.textEditor(creationDate_TA);
		baseDataPanel.add(creationDate_TA);
		
		JTextArea destroyedDate_TA = new JTextArea();
		destroyedDate_TA.setBounds(10, 221, 277, 94);
		if(destroyedDate.isEmpty())
			destroyedDate = "Date of destruction: \nUnknown";
		else
			destroyedDate = "Date of destruction: \n" + destroyedDate;
		destroyedDate_TA.setText(destroyedDate);
		fec.textEditor(destroyedDate_TA);
		baseDataPanel.add(destroyedDate_TA);
		return baseDataPanel;
	}
	
	private JPanel otherInfoPanel(String manufacturer, String classString, String model, String color, FrontEndClass fec) {
		JPanel otherDataPanel = new JPanel();
		otherDataPanel.setBounds(994, 358, 280, 404);
		otherDataPanel.setLayout(null);
		otherDataPanel.setOpaque(false);
		
		JTextArea manufacturer_TA = new JTextArea();
		manufacturer_TA.setBounds(10, 11, 260, 87);
		if(manufacturer.isEmpty())
			manufacturer = "Manufacturer: \nUnknown";
		else
			manufacturer = "Manufacturer: \n" + manufacturer;
		manufacturer_TA.setText(manufacturer);
		fec.textEditor(manufacturer_TA);
		otherDataPanel.add(manufacturer_TA);
		
		JTextArea class_TA = new JTextArea();
		class_TA.setBounds(10, 109, 260, 87);
		if(classString.isEmpty())
			classString = "Class: \nUnknown";
		else
			classString = "Class: \n" + classString;
		class_TA.setText(classString);
		fec.textEditor(class_TA);
		otherDataPanel.add(class_TA);
		
		JTextArea model_TA = new JTextArea();
		model_TA.setBounds(10, 207, 260, 87);
		if(model.isEmpty())
			model = "Model: \nUnknown";
		else
			model = "Model: \n" + model;
		model_TA.setText(model);
		fec.textEditor(model_TA);
		otherDataPanel.add(model_TA);
		
		JTextArea color_TA = new JTextArea();
		color_TA.setBounds(10, 305, 260, 87);
		if(color.isEmpty())
			color = "Color: \nUnknown";
		else
			color = "Color: \n" + color;
		color_TA.setText(color);
		fec.textEditor(color_TA);
		otherDataPanel.add(color_TA);
		return otherDataPanel;
	}

	@Override
	public JPanel affiliationPanel() {
		JPanel affiliationPanel = new JPanel();
		affiliationPanel.setBounds(261, 753, 742, 64);
		affiliationPanel.setOpaque(false);
		return affiliationPanel;
	}
	
}
