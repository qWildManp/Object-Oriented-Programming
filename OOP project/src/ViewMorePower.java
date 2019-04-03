/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/ 
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class ViewMorePower extends View<ControllerMorePower>{//view part of get power method
	 private JTextField t1;
	 private JTextField t2;
	 public ViewMorePower(ElectricityCompany m, ControllerMorePower c) {//construction of more power view
		 super(m,c);
		 this.setTitle("View More Power");
		 this.t1 = new JTextField("Type a consumer name here");
		 this.t2 = new JTextField("Type an amount of power here");
		 JButton more_P = new JButton("More Power");
		 this.add(t1);
		 this.add(t2);
		 this.add(more_P);
		 this.setLayout(new GridLayout(3,1));
		 more_P.addActionListener(new ActionListener() {//if button clicked , then use the more power method
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 if(e.getActionCommand().equals("More Power")) {
					 JOptionPane.showMessageDialog(null,c.morePower(t1.getText(), t2.getText()) , "Message", JOptionPane.INFORMATION_MESSAGE);
				 }
			 }
		 });
	 }
	 @Override
	 public void update() {
	 }
}
