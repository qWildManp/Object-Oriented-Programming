 /*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
class ControllerMorePower extends Controller{//control part of more power
	 public ControllerMorePower(ElectricityCompany m) {//construction of more power controller
		 super(m);
	 }
	 public String morePower(String name,String amount) {//change the user amount of power consumption with two String arguments
		 try {
			 m.morePower(name, Integer.parseInt(amount));
			 return "Success !";
		 }
		 //catch and throws exceptions
		 catch(UnknownConsumerException uce) {
			 return uce.getMessage();
		 }
		 catch(NotAPowerGeneratorException nge) {
			 return nge.getMessage();
		 }
		 catch(NumberFormatException nfe) {
			 return nfe.getMessage();
		 }
	 }
}
