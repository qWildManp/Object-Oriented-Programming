/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
class ViewHistory extends View<ControllerHistory>{//view part of history
	public ViewHistory(ElectricityCompany m,ControllerHistory c) {//construction of view history
		super(m,c);		
		this.setTitle("View History");
		this.setSize(400,300);
		HistoryPanel history =  new HistoryPanel(m);
		this.add(history);
		
	}
	@Override
	public void update() {//to repaint the graphic
		this.repaint();
	}
}
