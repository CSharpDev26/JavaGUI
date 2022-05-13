package Encyclopedia;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;

public class PlanetClass {
	
	public JMenuItem createPanel() {
		JMenuItem item = new JMenuItem("Dagobah");
		JPanel planetPanel = new JPanel();
		planetPanel = setPanel(planetPanel);
		item.add(planetPanel);
		return item;
	}
	private JPanel setPanel(JPanel pp) {
		pp.setSize(1000,1000);
		pp.add(new JLabel("asd"));
		return pp;
		
	}
}
