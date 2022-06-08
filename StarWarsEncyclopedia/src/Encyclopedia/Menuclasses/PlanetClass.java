package Encyclopedia.Menuclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Encyclopedia.Interfaces.MenuInterface;
import Encyclopedia.OtherClasses.*;

public class PlanetClass implements MenuInterface {
		
	public ArrayList<JMenuItem> createMenu(JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DataManagement dm = DataManagement.getInstance();
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
		ArrayList<String> names;
		FrontEndClass fec = FrontEndClass.getInstance();
		names = dm.getNames("planets");
		for(String name: names) {
			JMenuItem menuItem = fec.menuItemFrontEnd(name);
			menuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						contentPanelCreator(backPanel,name, fec);
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
		Object [] planetData = dm.getPlanetData(name);
		
		backPanel.removeAll();
		backPanel.setLayout(null);
		backPanel.add((imagePanel((String)planetData[8])));
		backPanel.add(descPanel((String)planetData[1], fec));
		backPanel.add(titlePanel((String)planetData[7], fec));
		backPanel.add(floraFaunaPanel((String)planetData[5], (String)planetData[6], fec));
		backPanel.add(otherDataPanel((String)planetData[2],(Integer)planetData[3],(Integer)planetData[4],(Integer)planetData[9], fec));
		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}
	
	public JPanel imagePanel(String imageName) {
		JPanel imagePanel = new JPanel();
		imagePanel.setLayout(null);
		imagePanel.setBounds(544, 92, 293, 294);
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
	
	public JPanel descPanel(String desc, FrontEndClass fec) {
		JPanel descPanel = new JPanel();
		descPanel.setLayout(null);
		descPanel.setBounds(439, 397, 478, 358);
		descPanel.setOpaque(false);
		JTextArea description_TA = new JTextArea();
		description_TA.setBounds(0, 0, 478, 358);
		description_TA.setText(desc);
		fec.textEditor(description_TA);
		descPanel.add(description_TA);
		return descPanel;
	}
	
	public JPanel titlePanel(String name, FrontEndClass fec) {
		JPanel namePanel = new JPanel();
		namePanel.setLayout(null);
		namePanel.setBounds(532, 21, 343, 45);
		namePanel.setOpaque(false);
		JTextArea name_TA = new JTextArea();
		name_TA.setText(name);
		fec.textEditor(name_TA);
		name_TA.setBounds(79, 11, 254, 26);
		namePanel.add(name_TA);
		return namePanel;
	} 
	
	private JPanel floraFaunaPanel(String flora, String fauna, FrontEndClass fec) {
		JPanel faunaFloraPanel = new JPanel();
		faunaFloraPanel.setLayout(null);
		faunaFloraPanel.setBounds(1000, 304, 249, 451);
		faunaFloraPanel.setOpaque(false);
		
		JTextArea fauna_TA = new JTextArea();
		fauna_TA.setBounds(0, 0, 242, 219);
		fauna_TA.append("    Fauna \n");
		fec.listTextEditor(fauna_TA, fauna);
		faunaFloraPanel.add(fauna_TA);
		
		JTextArea flora_TA = new JTextArea();
		flora_TA.setBounds(0, 230, 242, 219);
		flora_TA.append("    Flora \n");
		fec.listTextEditor(flora_TA, flora);
		faunaFloraPanel.add(flora_TA);
		
		return faunaFloraPanel;
	}
	
	private JPanel otherDataPanel(String atmosphere, Integer moons, Integer diameter, Integer suns, FrontEndClass fec) {
		JPanel otherDataPanel = new JPanel();
		otherDataPanel.setLayout(null);
		otherDataPanel.setBounds(10, 384, 366, 371);
		otherDataPanel.setOpaque(false);
		
		JTextArea atmosphere_TA = new JTextArea();
		atmosphere_TA.setBounds(0, 11, 269, 173);
		atmosphere_TA.append("    Atmosphere \n");
		fec.listTextEditor(atmosphere_TA, atmosphere);
		otherDataPanel.add(atmosphere_TA);
		
		JTextArea diameter_TA = new JTextArea();
		diameter_TA.setBounds(0, 195, 364, 31);
		String temp = "Diameter: " + diameter + " km"; 
		diameter_TA.append(temp);
		fec.textEditor(diameter_TA);
		otherDataPanel.add(diameter_TA);
		
		JTextArea suns_TA = new JTextArea();
		suns_TA.setBounds(0, 237, 269, 31);
		suns_TA.append("Suns: " + suns);
		fec.textEditor(suns_TA);
		otherDataPanel.add(suns_TA);
		
		JTextArea moons_TA = new JTextArea();
		moons_TA.setBounds(0, 290, 269, 31);
		moons_TA.append("Moons: " + moons);
		fec.textEditor(moons_TA);
		otherDataPanel.add(moons_TA);
		
		return otherDataPanel;
	}

	@Override
	public JPanel affiliationPanel() {
		JPanel affiliationPanel = new JPanel();
		affiliationPanel.setBounds(297, 766, 656, 62);
		affiliationPanel.setOpaque(false);
		return affiliationPanel;
	}
}
