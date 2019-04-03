/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ViewGetPower extends View<ControllerGetPower>{// view part of get power
	 private JTextField t;
	 public ViewGetPower(ElectricityCompany m,ControllerGetPower c) {//construction of vie get power
		 super(m,c);
		 this.setTitle("View Get Power");
		 this.t = new JTextField("Type a consumer name here");
		 JButton getP= new JButton("Tell me the power");
		 this.add(t);
		 this.add(getP);
		 this.setLayout(new GridLayout(2,1));
		 getP.addActionListener(new ActionListener(){//add a action listener to the button
			@Override
			 public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Tell me the power")){//if button clicked, show the power according to the name
					JOptionPane.showMessageDialog(null, c.getPower(t.getText()),"Message",JOptionPane.INFORMATION_MESSAGE);
				}
			 }	 
		 });
	 }
	 @Override
	 public void update() {
	 }
}
