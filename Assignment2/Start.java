class Wheel{
	private boolean flat;
	public Wheel() {//constructor of wheel
		this.flat = false;
	}
	public boolean isFlat(){//check the condition of wheel
		return this.flat;
	}
	public void setFlat() {//let wheel be flat
		if(this.flat==false) {
			this.flat = true;
		}
		else
			this.flat = false;
	}
	public static void testWheel() {
		Wheel wtest = new Wheel();
		System.out.println("Is the wheel is flat: "+wtest.isFlat());
		wtest.setFlat();
		System.out.println("Is the wheel is flat: "+wtest.isFlat());
	}
}

class Motorcycle{
	private Wheel frontWheel;
	private Wheel backWheel;
	private String color;
	private int gasoline; 
	
	public Motorcycle(String color,int gasoline) {//constructor of motorcycle
		this.color = color;
		this.gasoline = gasoline;
		frontWheel = new Wheel();
		backWheel = new Wheel();
	}
	public String getColor() {//get motor's color
		return this.color;
	}
	public int getGasoline() {//get motor's gasoline 
		return this.gasoline;
	}
	public boolean addGasoline(int gasoline) {//add gasoline
		if(gasoline < 0||gasoline==0) {//if input is negative number or zero, the amount of gasoline won't be changed
			return false;
		}
		else {
			this.gasoline = this.gasoline+gasoline;
			return true;
		}
	}
	public void drive() {//drive the motor
		if(this.gasoline>=2) {//motor can be run when the the amount of gasoline isn't less than 2
		this.gasoline = this.gasoline - 2;
		}
	}
	public void accident() {//the motor has accident and front wheel is broken
		frontWheel.setFlat();
	}
	public void repair() {//repair the motor------exchange a new wheel with the old broken one
		frontWheel = new Wheel();
	}
	public int getMaxSpeed() {//get the max speed
		if(this.gasoline==0||this.gasoline<2) {//if there is no gasoline or the amount is lower than 2
			return 0;
		}
		else if(frontWheel.isFlat()||backWheel.isFlat()&&this.gasoline>0) {//if any wheel is broken
			return 10;
		}
		else
			return 100;
	}
	public static void testMotorcycle() {
		Motorcycle mtest2 = new Motorcycle("green",1);
		System.out.println("The color is: "+mtest2.getColor());
		System.out.println("Now the amount of gasoline is :"+mtest2.getGasoline());
		mtest2.drive();
		System.out.println("Now the amount of gasoline is :"+mtest2.getGasoline());//it shouldn't change because the amount of gasoline is lower than 2
		System.out.println("Now the max speed is :"+mtest2.getMaxSpeed());
		Motorcycle mtest = new Motorcycle("red",10);
		System.out.println("The color is: "+mtest.getColor());
		System.out.println("The amount of gasoline is :"+mtest.getGasoline());
		mtest.drive();
		mtest.addGasoline(-2);
		System.out.println("Now the amount of gasoline is :"+mtest.getGasoline());//it shouldn't be changed because the add of gas is a negative number
		mtest.addGasoline(8);
		System.out.println("Now the amount of gasoline is :"+mtest.getGasoline());
		System.out.println("Now the max speed is :"+mtest.getMaxSpeed());
		mtest.accident();
		System.out.println("Now the max speed is :"+mtest.getMaxSpeed());//the motor has accident , so the max speed should be 10
		mtest.repair();
		System.out.println("Now the max speed is :"+mtest.getMaxSpeed());//after repair, the max speed will up to 100 
	}
}
class BankAccount{
	private int money;
	public BankAccount(int money) {//construct of bank account
		if(money>=0) {
			this.money = money;}
		else {
			this.money = 0;
		}
	}
	public int getMoney() {//get money
		return this.money;
	}
	public void setMoney(int money) {//set money
		if(this.money-money < 0)
		{
			System.out.println("You dont have enough money");
		}
		else {
		this.money = this.money + money;
		}
		
	}
	public static void testBankAccount() {
		BankAccount btest = new BankAccount(10000);
		System.out.println(btest.getMoney());
		btest.setMoney(-100);
		System.out.println(btest.getMoney());
		btest.setMoney(-20000000);
		System.out.println(btest.getMoney());//it shouldn't be changed because the bank account don't have enough money
		btest.setMoney(5000);
		System.out.println(btest.getMoney());
	}
}
class Person{
	private String name;
	private BankAccount account;
	private Motorcycle motorcycle;
	public Person(String name, int money, Motorcycle motorcycle) {//constructor of person
		this.name = name;
		this.account = new BankAccount(money);
		this.motorcycle = motorcycle;
	}
	public String getDescr() {//get the description of a person
		return (this.name+" has"+this.account.getMoney()+" yuans and a "+this.motorcycle.getColor()+" motorcycle with "+this.motorcycle.getGasoline()+" liters of gasoline");
	}
	public void buyGasoline(int money) {//buy gasoline
		if(this.account.getMoney()>=money&&money>=8) {//if the person have enough money to buy gasoline
			this.motorcycle.addGasoline(money/8);
			this.account.setMoney(-(money/8)*8);
		}
	}
	public static void testPerson() {//test Person
		Person pt = new Person("HarryLong",16,new Motorcycle("Black",8));
		System.out.println(pt.getDescr());
		pt.buyGasoline(5);
		System.out.println(pt.getDescr());//it shouldn't be changed because costs is lower than 8
		pt.buyGasoline(16);
		System.out.println(pt.getDescr());
		pt.buyGasoline(168);//it shouldn't be changed because costs is greater than the money in the users bank
		System.out.println(pt.getDescr());
	}
	
}
public class Start {
	public static void main(String[] ags) {
		Wheel.testWheel();
		Motorcycle.testMotorcycle();
		Person.testPerson();
	}
}
