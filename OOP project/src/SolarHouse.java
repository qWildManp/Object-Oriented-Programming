/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
class SolarHouse extends House{
	public SolarHouse(String name, int power) throws NotAPowerGeneratorException {// constructor of SolarHouse
		super(name, power);
	}
	@Override
	public void morePower(int amount) {// override the more power method, solar house can generate power
		int result = this.getPower() + amount;
		this.setPower(result);
	}

	public static void testSolarHouse() {//test Solar House
		try {
			SolarHouse sh = new SolarHouse("Harry", -400);
		} catch (NotAPowerGeneratorException e) {
			System.out.println(e.getMessage());
		}
		try {
			SolarHouse sh2 = new SolarHouse("Harry",4000);
			System.out.println(sh2.getName()=="Harry");
			System.out.println(sh2.getPower()==4000);
			sh2.morePower(5000);
			System.out.println(sh2.getPower()==9000);
			sh2.morePower(-30000);
			System.out.println(sh2.getPower()==-21000);
		}catch(NotAPowerGeneratorException e) {
			System.out.println(e.getMessage());
		}
	}

}
