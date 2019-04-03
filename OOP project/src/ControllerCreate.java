/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
class ControllerCreate extends Controller{//control part of add a consumer
	public ControllerCreate(ElectricityCompany m) {//construction of controller create
		super(m);
	}
	public String create(String name,String amount,int type) {//create a consumer according to house type
		try {
			int amount_Int = Integer.parseInt(amount);
			switch(type) {
			case 0 ://power plant case
				m.addConsumer(new PowerPlant(name,amount_Int));
				break;
			case 1 ://house case
				m.addConsumer(new House(name,amount_Int));
				break;
			case 2 ://solar house case
				m.addConsumer(new SolarHouse(name,amount_Int));
				break;
			default : 
				return "nothing";
		}
		//throw exceptions
		}catch(NotAPowerGeneratorException nge) {
			return nge.getMessage();
		}catch(NumberFormatException nfe) {
			return nfe.getMessage();
		}
		return "Success !";
		
	}
}

