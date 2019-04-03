/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
import java.awt.event.*;

import javax.swing.*; 
abstract class View<T extends Controller> extends JFrame implements ModelListener {//view part
	 protected ElectricityCompany m;
	 protected T c;
	 public View(ElectricityCompany m,T c) {//construction of view
		 this.m = m;
		 this.c = c;
		 m.addListener(this);
		 this.setSize(250, 150);
		 this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 this.setVisible(true);
		 this.addWindowListener(new WindowAdapter() {
			 @Override
			 public void windowClosing(WindowEvent e){
				 c.shutdown();
			 }
		 });
	 }
	 public abstract void update();// update depends on the certain view , so it should be abstract

}
