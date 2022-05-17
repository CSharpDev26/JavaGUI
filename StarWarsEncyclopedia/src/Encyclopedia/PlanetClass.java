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
		names = dm.getPlanetNames();
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
		imagePanel.setBounds(10, 10, 400, 400);
		String imageFullName = "images/planets/" + imageName;
		ImageIcon iC = new ImageIcon(imageFullName);
		Image planetImage = iC.getImage();  
		Image resized_img = planetImage.getScaledInstance(400, 400,  java.awt.Image.SCALE_SMOOTH); 
		iC = new ImageIcon(resized_img);  
		JLabel image_label = new JLabel();
		image_label.setBounds(0, 0, 400, 400);
		image_label.setIcon(iC);
		imagePanel.add(image_label);
		return imagePanel;
	}
	
	private JPanel descriptionPanel(String desc) {
		JPanel desc_Panel = new JPanel();
		desc_Panel.setLayout(null);
		desc_Panel.setBounds(583, 121, 769, 629);
		desc_Panel.setOpaque(false);
		JTextArea description_TA = new JTextArea();
		description_TA.setBounds(137, 87, 469, 427);
		description_TA.setText(desc);
		textEditor(description_TA);
		desc_Panel.add(description_TA);
		return desc_Panel;
	}
	
	private JPanel titlePanel(String name) {
		JPanel name_panel = new JPanel();
		name_panel.setLayout(null);
		name_panel.setBounds(781, 23, 343, 45);
		name_panel.setOpaque(false);
		JTextArea name_TA = new JTextArea();
		name_TA.setText(name);
		textEditor(name_TA);
		name_TA.setBounds(79, 11, 254, 26);
		name_panel.add(name_TA);
		return name_panel;
	} 
	
	private JPanel floraFaunaPanel(String flora, String fauna) {
		JPanel fauna_flora_panel = new JPanel();
		fauna_flora_panel.setLayout(null);
		fauna_flora_panel.setBounds(1481, 121, 327, 629);
		fauna_flora_panel.setOpaque(false);
		
		//JTextPane a = new JTextPane();
		JTextArea fauna_TA = new JTextArea();
		fauna_TA.setBounds(10, 56, 307, 187);
		fauna_TA.append("    Fauna \n\n");
		listTextEditor(fauna_TA, fauna);
		fauna_flora_panel.add(fauna_TA);
		
		JTextArea flora_TA = new JTextArea();
		flora_TA.setBounds(10, 340, 307, 219);
		flora_TA.append("    Flora \n\n");
		listTextEditor(flora_TA, flora);
		fauna_flora_panel.add(flora_TA);
		
		return fauna_flora_panel;
	}
	
	private JPanel otherDataPanel(String atmosphere, Integer moons, Integer diameter, Integer suns) {
		JPanel other_data_panel = new JPanel();
		other_data_panel.setLayout(null);
		other_data_panel.setBounds(50, 458, 461, 519);
		other_data_panel.setOpaque(false);
		
		JTextArea atmosphere_TA = new JTextArea();
		atmosphere_TA.setBounds(42, 79, 269, 173);
		atmosphere_TA.append("    Atmosphere \n\n");
		listTextEditor(atmosphere_TA,atmosphere);
		other_data_panel.add(atmosphere_TA);
		
		JTextArea diameter_TA = new JTextArea();
		diameter_TA.setBounds(42, 328, 409, 31);
		String temp = "Diameter: " + diameter + " kilometers"; 
		diameter_TA.append(temp);
		textEditor(diameter_TA);
		other_data_panel.add(diameter_TA);
		
		JTextArea suns_TA = new JTextArea();
		suns_TA.setBounds(42, 403, 269, 31);
		suns_TA.append("Suns: " + suns);
		textEditor(suns_TA);
		other_data_panel.add(suns_TA);
		
		JTextArea moons_TA = new JTextArea();
		moons_TA.setBounds(42, 440, 269, 31);
		moons_TA.append("Moons: " + moons);
		textEditor(moons_TA);
		other_data_panel.add(moons_TA);
		
		return other_data_panel;
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
