package Encyclopedia.Interfaces;

import javax.swing.JPanel;

import Encyclopedia.OtherClasses.FrontEndClass;

public interface MenuInterface {
	JPanel titlePanel(String name, FrontEndClass fec);
	JPanel imagePanel(String imageName);
	JPanel descPanel(String desc, FrontEndClass fec);
	JPanel affiliationPanel();
}
