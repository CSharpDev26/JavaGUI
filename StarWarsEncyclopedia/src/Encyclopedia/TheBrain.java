package Encyclopedia;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TheBrain {

	public JPanel createBackgroundPanel(){
		final ImageIcon icon = new ImageIcon("images/background/galaxy.jpg");
		JPanel backGroundPanel = new JPanel(){
			Image img = icon.getImage();
		      {setOpaque(false);}
		      public void paintComponent(Graphics graphics) 
		      {
		        graphics.drawImage(img, 0, 0, this);
		        super.paintComponent(graphics);
		      }
		};
		backGroundPanel.setLocation(0, 0);
		backGroundPanel.setSize(1904, 1041);
		backGroundPanel.setLayout(null);
		return backGroundPanel;
	}
	public JMenuBar createMenu(JPanel panel) {
		JMenuBar jmb = new JMenuBar();
		JMenu planetMenu = new JMenu("Planets");
		JMenuItem dagobah = new JMenuItem("Dagobah");
		JMenuItem jedi = new JMenuItem("jedi");
		jedi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setLayout(new GridLayout(2,1));
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				p1.add(new JLabel("panel 1"));
				p2.add(new JLabel("panel 2"));
				panel.add(p1);
				panel.add(p2);
				p1.setOpaque(false);
				panel.invalidate();
				panel.validate();
				panel.repaint();
			}
		});
		
		dagobah.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setLayout(new GridLayout(4,2));
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();
				JPanel p4 = new JPanel();
				p1.add(new JLabel("panel 3"));
				p2.add(new JLabel("panel 4"));
				panel.add(p1);
				panel.add(p2);
				panel.add(p3);
				panel.add(p4);
				p1.setOpaque(false);
				panel.invalidate();
				panel.validate();
				panel.repaint();
			}
		});

		planetMenu.add(dagobah);
		jmb.add(planetMenu);
		JMenu peopleMenu = new JMenu("People");
		peopleMenu.add(jedi);
		jmb.add(peopleMenu);
		return jmb;
	}
}
