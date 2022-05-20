package Encyclopedia.OtherClasses;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class FrontEndClass {
	//Singleton
	public void textEditor(JTextArea TA) {
		//Segoe Script
		TA.setFont(new Font("Verdana", Font.BOLD, 20));
		TA.setEditable(false);
		TA.setLineWrap(true);
		TA.setWrapStyleWord(true);
		TA.setOpaque(false);
		TA.setForeground(Color.white);
	}
	
	//buttons and create a fauna and flora menu??
	public void listTextEditor(JTextArea TA, String text) {
		String[] textContainer = text.split(",");
		for(String word: textContainer) {
			TA.append( "-" + word + "\n");
		}
		textEditor(TA);
	}
}
