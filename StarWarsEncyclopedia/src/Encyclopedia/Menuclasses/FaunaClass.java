package Encyclopedia.Menuclasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Encyclopedia.OtherClasses.DataManagement;
import Encyclopedia.OtherClasses.FrontEndClass;

public class FaunaClass {
	public ArrayList<JMenuItem> createMenu(JPanel backPanel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DataManagement dm = new DataManagement();
		ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
		ArrayList<String> names;
		FrontEndClass fec = new FrontEndClass();
		names = dm.getNames("faunas");
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
		Object [] faunaData = dm.getFaunaData(name);
		
		backPanel.removeAll();
		backPanel.setLayout(null);

		backPanel.invalidate();
		backPanel.validate();
		backPanel.repaint();
	}
}
