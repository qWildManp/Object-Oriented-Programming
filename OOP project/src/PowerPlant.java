import java.io.Serializable;

/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
class PowerPlant extends Building{
	 public PowerPlant(String name,int power) {//constructor of power plant
		 super(name,-power);
	 }
	 @Override
	 public void morePower(int amount) {// override the more power method, power of power plant reduce the amount of power that was input
		 this.setPower(this.getPower()-amount);
		 }
	 public static void testPowerPlant() {
		 PowerPlant p = new PowerPlant("UIC Power Plant", 1000000);
		 System.out.println(p.getName() == "UIC Power Plant");
		 System.out.println(p.getPower() == -1000000);
		 p.setPower(-2000000); // Sets the power consumed by the power plant.
		 System.out.println(p.getPower() == -2000000);
		 p.morePower(500000); // Increases the power generated by the power plant.
		 System.out.println(p.getPower() == -2500000);
		 p.morePower(-2510000); // Turn off the power plant: it now consumes electricity.
		 System.out.println(p.getPower() == 10000);
	 }
}
