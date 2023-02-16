package Pallete;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;


public class sideMenuPanel {
	private  Color backgColor , buttonsColor;
	private Font panelfont;
	private Map<String,JButton> buttons ;
	
	
	private void initButtons(List <String> ButtonsNames) {
		Buttons  <>
		ButtonsNames.forEach(nameOfButton->{
			JButton btn = new JButton(nameOfButton);
			btn.
			Buttons.add(btn)
			
		});
		
	}
	private void initPanel(List <String> ButtonsNames ) {
		initButtons(ButtonsNames);
        setBackground(backGroundColor);
        setLayout(new GridLayout(ButtonsNames.size(),1));
        
	}
	
	public sideMenuPanel(Color bgcolor ,Color buttonstextColor , Font font , List<String> ButtonsNames) {
		this.backgColor= bgcolor;
		this.buttonsColor=buttonstextColor;
		this.panelfont=font;
		initButtons(ButtonsNames);
	
	}

}
