import java.io.Serializable;

/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
abstract class Building implements Consumer,Serializable{
	 private String name;
	 private int power;
	 public Building(String name, int power) {//constructor of Building
		 this.name = name;
		 this.power = power;
	 }
	 public String getName() {//get owner's name
		 return this.name;
	 }
	 public int getPower() {//get the power of the building
		 return this.power;
	 }
	 protected void setPower(int power) {//set the amount of power of the building
		 this.power = power;
	 }
	 abstract public void morePower(int amount) throws NotAPowerGeneratorException;
	 public static void testBuilding() {//test the building
		 System.out.println("This isa building, but we don't know which type is");
	 }
}
