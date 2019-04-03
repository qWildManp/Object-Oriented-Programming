/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
class ControllerGetPower extends Controller{
	public ControllerGetPower(ElectricityCompany m) {
		super(m);
	}
	public String getPower(String name) {//return the power as a string
		try {
		return " "+m.getPower(name)+" ";
		}
		catch(UnknownConsumerException uce) {
		return uce.getMessage();
		}
	}
}
