/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ViewCreate extends View<ControllerCreate>{//view part of add a consumer 
	private JTextField t1;
	private JTextField t2;
	private JComboBox<String> cb;
	public ViewCreate(ElectricityCompany m, ControllerCreate c) {//construction of view create
		super(m,c);
		this.setTitle("View Create");
		this.t1 = new JTextField("Type a new consumer name here");
		this.t2 = new JTextField("Type an amount of power here");
		this.cb = new JComboBox<String>();
		cb.addItem("Power Plant");
		cb.addItem("House");
		cb.addItem("Solar House");
		JButton create = new JButton("Create");
		this.add(t1);
		this.add(t2);
		this.add(cb);
		this.add(create);
		this.setLayout(new GridLayout(4,1));
		create.addActionListener(new ActionListener() {//when button clicked create and add a consumer 
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Create")) {
					JOptionPane.showMessageDialog(null,c.create(t1.getText(),t2.getText(),cb.getSelectedIndex()), "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	@Override
	public void update() {
	}

}
