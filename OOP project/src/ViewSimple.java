/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
import javax.swing.*;
class ViewSimple extends View implements ModelListener{//subclass of view
	 private JLabel label;
	 public ViewSimple(ElectricityCompany m,Controller c) {//construction of ViewSimple
		 super(m,c);
		 this.setTitle("View Simple");
		 label = new JLabel("The total power consumption : " + m.totalConsumption());
		 this.add(label);	 
	 }
	 @Override
	 public void update() {//update method
		 label.setText("The total power consumption : " + m.totalConsumption());
	 }
}
