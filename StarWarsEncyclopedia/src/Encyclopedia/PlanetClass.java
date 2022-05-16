package Encyclopedia;
import java.sql.ResultSet;
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
		backPanel.add((imagePanelContentCreator((String)planetData[8])));
		backPanel.add(descriptionPanelContentCreator((String)planetData[1]));

		JPanel name_panel = new JPanel();
		name_panel.setLayout(null);
		name_panel.setBounds(781, 23, 343, 45);
		JLabel name_label = new JLabel();
		name_label.setBounds(23, 11, 298, 23);
		name_panel.add(name_label);
		backPanel.add(name_panel);
		
		JPanel fauna_flora_panel = new JPanel();
		fauna_flora_panel.setLayout(null);
		fauna_flora_panel.setBounds(1481, 121, 327, 629);
		JLabel fauna_label = new JLabel();
		fauna_label.setBounds(10, 46, 307, 187);
		fauna_flora_panel.add(fauna_label);
		JLabel flora_label = new JLabel();
		flora_label.setBounds(10, 340, 307, 219);
		fauna_flora_panel.add(flora_label);
		backPanel.add(fauna_flora_panel);

		JPanel other_data_panel = new JPanel();
		other_data_panel.setLayout(null);
		other_data_panel.setBounds(50, 458, 365, 519);
		JLabel atmosphere_label = new JLabel();
		atmosphere_label.setBounds(42, 79, 269, 173);
		other_data_panel.add(atmosphere_label);
		JLabel diameter_label = new JLabel();
		diameter_label.setBounds(42, 328, 269, 31);
		other_data_panel.add(diameter_label);
		JLabel moons_label = new JLabel();
		moons_label.setBounds(42, 423, 269, 31);
		other_data_panel.add(moons_label);
		backPanel.add(other_data_panel);
		
		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}
	
	private JPanel imagePanelContentCreator(String imageName) {
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
	
	private JPanel descriptionPanelContentCreator(String desc) {
		JPanel desc_Panel = new JPanel();
		desc_Panel.setLayout(null);
		desc_Panel.setBounds(583, 121, 769, 629);
		JLabel description_label = new JLabel();
		description_label.setBounds(54, 44, 668, 554);
		description_label.setText(desc);
		desc_Panel.add(description_label);
		return desc_Panel;
	}

	private String descriptionEditing(String desc) {
		String edited = desc;
		char[] stringArray = edited.toCharArray();
		for(int i = 0; i < stringArray.length;i++) {
			if(i / 50 > 1 ) {
				if(stringArray[i] == ' ') {
				}
			}
		}
		
		return edited;
	}
}
