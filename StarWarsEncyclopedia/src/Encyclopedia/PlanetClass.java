package Encyclopedia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlanetClass {
	
	public ArrayList<JMenuItem> createMenu(JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DataManagement dm = new DataManagement();
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
		ArrayList<String> names;
		names = dm.getNames("planets");
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
		Object [] planetData = dm.getPlanetData(name);
		
		backPanel.removeAll();
		backPanel.setLayout(null);
		backPanel.add((imagePanel((String)planetData[8])));
		backPanel.add(descriptionPanel((String)planetData[1]));
		backPanel.add(titlePanel((String)planetData[7]));
		backPanel.add(floraFaunaPanel((String)planetData[5], (String)planetData[6]));
		backPanel.add(otherDataPanel((String)planetData[2],(Integer)planetData[3],(Integer)planetData[4],(Integer)planetData[9]));
		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}
	
	private JPanel imagePanel(String imageName) {
		JPanel imagePanel = new JPanel();
		imagePanel.setLayout(null);
		imagePanel.setBounds(55, 10, 293, 294);
		String imageFullName = "images/planets/" + imageName;
		ImageIcon iC = new ImageIcon(imageFullName);
		Image planetImage = iC.getImage();  
		Image resizedImg = planetImage.getScaledInstance(293, 294,  java.awt.Image.SCALE_SMOOTH); 
		iC = new ImageIcon(resizedImg);  
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 293, 294);
		imageLabel.setIcon(iC);
		imagePanel.add(imageLabel);
		return imagePanel;
	}
	
	private JPanel descriptionPanel(String desc) {
		JPanel descPanel = new JPanel();
		descPanel.setLayout(null);
		descPanel.setBounds(418, 226, 478, 578);
		descPanel.setOpaque(false);
		JTextArea description_TA = new JTextArea();
		description_TA.setBounds(10, 11, 458, 556);
		description_TA.setText(desc);
		textEditor(description_TA);
		descPanel.add(description_TA);
		return descPanel;
	}
	
	private JPanel titlePanel(String name) {
		JPanel namePanel = new JPanel();
		namePanel.setLayout(null);
		namePanel.setBounds(532, 21, 343, 45);
		namePanel.setOpaque(false);
		JTextArea name_TA = new JTextArea();
		name_TA.setText(name);
		textEditor(name_TA);
		name_TA.setBounds(79, 11, 254, 26);
		namePanel.add(name_TA);
		return namePanel;
	} 
	
	private JPanel floraFaunaPanel(String flora, String fauna) {
		JPanel faunaFloraPanel = new JPanel();
		faunaFloraPanel.setLayout(null);
		faunaFloraPanel.setBounds(935, 139, 283, 578);
		faunaFloraPanel.setOpaque(false);
		
		//JTextPane a = new JTextPane();
		JTextArea fauna_TA = new JTextArea();
		fauna_TA.setBounds(10, 56, 242, 187);
		fauna_TA.append("    Fauna \n\n");
		listTextEditor(fauna_TA, fauna);
		faunaFloraPanel.add(fauna_TA);
		
		JTextArea flora_TA = new JTextArea();
		flora_TA.setBounds(10, 340, 242, 219);
		flora_TA.append("    Flora \n\n");
		listTextEditor(flora_TA, flora);
		faunaFloraPanel.add(flora_TA);
		
		return faunaFloraPanel;
	}
	
	private JPanel otherDataPanel(String atmosphere, Integer moons, Integer diameter, Integer suns) {
		JPanel otherDataPanel = new JPanel();
		otherDataPanel.setLayout(null);
		otherDataPanel.setBounds(45, 315, 374, 519);
		otherDataPanel.setOpaque(false);
		
		JTextArea atmosphere_TA = new JTextArea();
		atmosphere_TA.setBounds(10, 79, 269, 173);
		atmosphere_TA.append("    Atmosphere \n\n");
		listTextEditor(atmosphere_TA,atmosphere);
		otherDataPanel.add(atmosphere_TA);
		
		JTextArea diameter_TA = new JTextArea();
		diameter_TA.setBounds(10, 329, 364, 31);
		String temp = "Diameter: " + diameter + " km"; 
		diameter_TA.append(temp);
		textEditor(diameter_TA);
		otherDataPanel.add(diameter_TA);
		
		JTextArea suns_TA = new JTextArea();
		suns_TA.setBounds(10, 398, 269, 31);
		suns_TA.append("Suns: " + suns);
		textEditor(suns_TA);
		otherDataPanel.add(suns_TA);
		
		JTextArea moons_TA = new JTextArea();
		moons_TA.setBounds(10, 439, 269, 31);
		moons_TA.append("Moons: " + moons);
		textEditor(moons_TA);
		otherDataPanel.add(moons_TA);
		
		return otherDataPanel;
	}
	
	private void textEditor(JTextArea TA) {
		//Segoe Script
		TA.setFont(new Font("Verdana", Font.BOLD, 20));
		TA.setEditable(false);
		TA.setLineWrap(true);
		TA.setWrapStyleWord(true);
		TA.setOpaque(false);
		TA.setForeground(Color.white);
	}
	
	//buttons and create a fauna and flora menu??
	private void listTextEditor(JTextArea TA, String text) {
		
		String[] textContainer = text.split(",");
		for(String word: textContainer) {
			TA.append( "-" + word + "\n");
		}
		textEditor(TA);
	}

}
