/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
class GUI {
	public static void main(String[] ags) {//GUI Part to display the total consumption
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ElectricityCompany uic_ec = new ElectricityCompany("UIC Electric");
				ControllerSimple c_sim = new ControllerSimple(uic_ec);//controller of get total consumption
				ControllerGetPower c_get = new ControllerGetPower(uic_ec);//controller of get power
				ControllerMorePower c_more =  new ControllerMorePower(uic_ec);//controller of more power
				ControllerCreate c_create = new ControllerCreate(uic_ec);//controller of create
				ControllerHistory c_history = new ControllerHistory(uic_ec);//controller of history
				//add some consumer to the ElectricityCompany
				/*uic_ec.addConsumer(new PowerPlant("uic", 5000));
				try {
					uic_ec.addConsumer(new House("Harry", 1000));
					uic_ec.addConsumer(new SolarHouse("KK", 2000));
				} catch (NotAPowerGeneratorException nge) {
					System.out.println(nge.getMessage());
				}*/
				ViewSimple v_sim = new ViewSimple(uic_ec,c_sim);//view of get total consumption
				ViewGetPower v_get = new ViewGetPower(uic_ec,c_get);//view of get get power
				ViewMorePower v_more = new ViewMorePower(uic_ec,c_more);//view of more power
				ViewCreate v_create = new ViewCreate(uic_ec,c_create);//view of create a consumer
				ViewHistory v_history = new ViewHistory(uic_ec,c_history);//view of history
			}
		});

	}
}
