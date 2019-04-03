/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
import java.util.*;

class CLI {
	private static Scanner input = new Scanner(System.in);

	private static String readLine(String str) {//read line method
		String s;
		System.out.print(str);
		s = input.nextLine();
		return s;//return the input line

	}

	private static int readPosInt(String str) {//read a integer method
		int i = 0, temp = 0;
		boolean checker = false;// checker to control the output
		while (checker == false) {//if checker isn't true means the input is invalid and need to retype
			System.out.print(str);
			while (checker == false) {//check if the input is an integer
				try {
					i = input.nextInt();
					checker = true;//if is a number the checker set to true
				} catch (InputMismatchException e) {
					System.out.println("You must type an integer!");
					System.out.print(str);
				} finally {//clean the previous input in console
					input.nextLine();
				}
			}
			temp = i;
			if(temp < 0) {//check if input number is a positive number
				System.out.println("Positive integers only!");
				checker = false; // if not the checker set to false
			}
		}
		return i;//return the input positive integer
	}

	public static void main(String[] args) {//test
			ElectricityCompany uic_ec = new ElectricityCompany("UIC Electric");
			int action = 0;
			while(action!=6) {
				action = readPosInt("Type an action (total:1 add:2 get:3 more:4 less:5 quit:6):");
				switch(action){
				case 1 : //printing the total amount of power consumed
					System.out.println("Total amount of power consumed: "+uic_ec.totalConsumption());
					break;
				case 2 ://adding a new consumer to the electricity company.
					int type = readPosInt("Type the consumer type (power plant:1 house:2 solar house:3): ");
					String name;
					int power;
					switch(type) {
					case 1://power plant type
						 	name = readLine("Enter the name of the consumer: ");
						 	power = readPosInt("Enter the initial amount of power: ");
						 	uic_ec.addConsumer(new PowerPlant(name,power));
						 	System.out.println("Power Plant "+name+" generationg "+power+" watts of power added");
						 	break;
					case 2://house type
					    	name = readLine("Enter the name of the consumer: ");
					    	power = readPosInt("Enter the initial amount of power: ");
					    	try {
					    	uic_ec.addConsumer(new House(name,power));
					    	}catch(NotAPowerGeneratorException nge) {
					    		System.out.println(nge.getMessage());
					    	}
					    	System.out.println("House "+name+" consuming "+power+" watts of power added");
					    	break;
					case 3://solar house type
							name = readLine("Enter the name of the consumer: ");
							power = readPosInt("Enter the initial amount of power: ");
							try {
								uic_ec.addConsumer(new SolarHouse(name,power));
							}catch(NotAPowerGeneratorException nge) {
								System.out.println(nge.getMessage());
							}
							System.out.println("Solar House "+name+" consuming "+power+" watts of power added");
					    	break;
				    default :
				    		System.out.println("Unknown type of consumer !");
				    		break;
					}
					break;
				case 3://listing the amount of power consumed by a given consumer.
					name = readLine("Enter the name of the consumer: ");
					try {
					System.out.println(name + " uses " +  uic_ec.getPower(name));
					}
					catch(UnknownConsumerException uce) {
						System.out.println(uce.getMessage());
					}
					break;
				case 4://increasing the power of a given consumer.
					name = readLine("Enter the name of the consumer: ");
					int amount = readPosInt("Enter the amount of power:");
					try {
						uic_ec.morePower(name, amount);
					}catch(NotAPowerGeneratorException nge) {
						System.out.println(nge.getMessage());
					}catch (UnknownConsumerException uce) {
						System.out.println(uce.getMessage());
					}
					break;
				case 5://decreasing the power of a given consumer
					name = readLine("Enter the name of the consumer: ");
				    amount =-(readPosInt("Enter the amount of power:"));
				    try {
				    	uic_ec.morePower(name, amount);
				    }catch(NotAPowerGeneratorException nge) {
						System.out.println(nge.getMessage());
					}catch (UnknownConsumerException uce) {
						System.out.println(uce.getMessage());
					}
					break;
				case 6 ://quit the program
					uic_ec.saveData();
					System.out.println("Goodbye!");
					break;
				default :// if the input number is not between 1-6
					System.out.println("Unknown acion!");
				}
			}
			
	}
}
