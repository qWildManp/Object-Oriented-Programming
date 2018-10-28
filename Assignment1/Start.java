class CoffeeMachine{
	private int numCups;
	private int temperature;
	CoffeeMachine(){
		this.numCups = 10;
		this.temperature = 70;
	}
	public int getTemp() {//get the temperature of coffee
		return this.temperature;

	}
	public void getCoffee() {//get one cup of coffee
		if(this.numCups==0) {//if there is no cups
			System.out.println("\"You cannot get coffee when there are no cups!");
		}
		else {//make a cup of coffee
			this.numCups--;
			System.out.println("Success!! Enjoy ur coffee");
		}
	}
	public void addCup() {//add 10 cups
		if(this.numCups!=0) {//if there are cups in the coffee machine
			System.out.println("Not enough space inside the machine to add 10 new cups!");
		}
		else {
			this.numCups = this.numCups+10;
		}
	}
	public void cooler() {// decrease the temperature of coffee
		if(this.temperature<50) {//if the temperature is below 50 degrees
			System.out.println("Coffee cannot go below 50 degrees");
		}
		else {
			System.out.println("Sucess");
			this.temperature = this.temperature - 10;
		}
	}
	public void hotter() {
		if(this.temperature>90) {//if temperature is above 90 degrees 
			System.out.println("Coffee cannot go above 90 degrees");
		}
		else {
			System.out.println("Sucess");
			this.temperature = this.temperature + 10;
		}
	}
	public void setTemp(int newTemp) {
		if(newTemp<50||newTemp>90) {//if the set is out of the range
			System.out.println("Temperature "+newTemp+" must be between 50 and 90!");	
		}
		else if(newTemp%10!=0) {//if the set isn't the multiple of 10
			System.out.println("Temperature"+newTemp+" must be a multiple of 10!");
		}
		else {
			System.out.println("Sucess");
			this.temperature = newTemp;
		}
	}
	public static void testCoffeeMachine() {//test the coffee machine
		System.out.println("Sucess! The test is running ");
		CoffeeMachine ts = new CoffeeMachine();
		ts.getCoffee();
		ts.addCup();
		ts.cooler();
		ts.hotter();
		System.out.println("The temperature is :"+ts.getTemp());
		ts.setTemp(60);
		System.out.println("The temperature is :"+ts.getTemp());
	}
}
public class Start {
public static void main(String[] args) {
     CoffeeMachine.testCoffeeMachine();
}
}
