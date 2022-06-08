package Encyclopedia.OtherClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class FrontEndClass {
	
	static FrontEndClass instance = null;
	
	private FrontEndClass() {}
	
	public static FrontEndClass getInstance() {
		if(instance != null)
			return instance;
		else {
			instance = new FrontEndClass();
			return instance;
		}
	}
	
	public void textEditor(JTextArea TA) {
		//Segoe Script
		TA.setFont(new Font("Verdana", Font.BOLD, 20));
		TA.setEditable(false);
		TA.setLineWrap(true);
		TA.setWrapStyleWord(true);
		TA.setOpaque(false);
		TA.setForeground(Color.yellow);
	}
	
	//buttons and create a fauna and flora menu??
	public void listTextEditor(JTextArea TA, String text) {
		String[] textContainer = text.split(",");
		for(String word: textContainer) {
			TA.append( "- " + word + "\n");
		}
		textEditor(TA);
	}
	public static JMenuBar menuBarFrontEnd() {
		JMenuBar jmb = new JMenuBar();
		Border emptyBorder = BorderFactory.createEmptyBorder(1,1,1,1);
		jmb.setBorder(emptyBorder);
		jmb.setOpaque(true);
		jmb.setBackground(Color.BLACK);
		jmb.setForeground(Color.YELLOW);
		return jmb;
	}
	public static JMenu menuFrontEnd(String text) {
		JMenu jMenu = new JMenu(text);
		jMenu.setOpaque(true);
		jMenu.setBackground(Color.BLACK);
		jMenu.setForeground(Color.YELLOW);
		jMenu.setFont(new Font("Verdana", Font.BOLD, 15));
		Border emptyBorder = BorderFactory.createEmptyBorder(1,1,1,1);
		jMenu.setBorder(emptyBorder);
		return jMenu;
	}
	public JMenuItem menuItemFrontEnd(String text) {
		JMenuItem jMenuItem = new JMenuItem(text);
		jMenuItem.setOpaque(true);
		jMenuItem.setBackground(Color.BLACK);
		jMenuItem.setForeground(Color.YELLOW);
		jMenuItem.setFont(new Font("Verdana", Font.BOLD, 15));
		Border emptyBorder = BorderFactory.createEmptyBorder(1,1,1,1);
		jMenuItem.setBorder(emptyBorder);
		return jMenuItem;
	}
}
