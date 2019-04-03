/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
class Controller {//controller part
	protected ElectricityCompany m;
	public Controller(ElectricityCompany m) {//construction of controller
		this.m = m;
	}
	protected void shutdown(){//shut down the program
		m.saveData();
		System.exit(0);
	}
}
