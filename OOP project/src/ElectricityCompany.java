/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
import java.io.*;
import java.util.*; 
class ElectricityCompany{ 
	 private String name;
	 private ArrayList<Consumer> consumers;
	 private ArrayList<ModelListener> listeners;
	 private ArrayList<Integer>history;
	 private File file;
	 public ElectricityCompany(String name) {// the constructor of electricity company
		 this.name = name;
		 this.listeners = new ArrayList<ModelListener>();
		 this.file = new File(this.name+".bin");
		 if(file.exists()) {//if the file exists
			 try {
				FileInputStream fi = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fi);
						this.consumers = (ArrayList<Consumer>) in.readObject();
						this.history = (ArrayList<Integer>) in.readObject();
						fi.close();
						in.close();
			 }catch(FileNotFoundException ex) {
				 System.err.println(ex.getMessage());
				 System.exit(1); // End immediately.
			 }catch(IOException e) {
				 System.err.println(e.getMessage());
				 System.exit(1);
			 }catch(ClassNotFoundException e) {
				// This only happens if classes does not exist
				// in the Java software used to read the binary file.
				System.err.println(e.getMessage());
				System.exit(1);
			}
		 }
		 else {//if the file doesn't exists
			this.consumers = new ArrayList<Consumer>();
			this.history = new ArrayList<Integer>();
			this.history.add(0); 
		 }
		 
	 }
	 public void saveData() {//method to save data
		 try {
			 FileOutputStream fo = new FileOutputStream(this.file);
			 ObjectOutputStream out = new ObjectOutputStream(fo);
				 out.writeObject(this.consumers);
				 out.writeObject(this.history);
				 out.close();
				 fo.close();
		 } catch(FileNotFoundException fne) {
			 System.err.println(fne.getMessage());
			 System.exit(1); // End immediately.
		 }catch(IOException IOe) {
			 System.err.println(IOe.getMessage());
			 System.exit(1);
		 }
	 }
	 public void addTohistory(int h) {//add the previous amount to the history
		 this.history.add(h);
	 }
	 public ArrayList<Integer> getHistory() {// get the history
		 return this.history;
	 }
	 public void addListener(ModelListener m) {//add listener to the listeners
		 this.listeners.add(m);
	 }
	 public void addConsumer(Consumer consumer) {//add a consumer to the consumers
		 this.consumers.add(consumer);
		 this.addTohistory(this.totalConsumption());
		 this.notifyListeners();
	 }
	 public int totalConsumption() {//return the total amount of consumption of consumers
		 int sum = 0;
		 for(int i = 0;i < this.consumers.size();i++) {
			 sum = sum + this.consumers.get(i).getPower();
		 }
		 return sum;
	 }
	 public int getPower(String name) throws UnknownConsumerException{ //get the the certain user's amount of power consumption
		 int length = this.consumers.size();
		 int result = 0;
		 if(length == 0) {
			 throw new UnknownConsumerException("Consumer "+name+" unknown");
		 }
		 else {
		 
		 for(int i = 0;i < length; i++) {//find the user
			Consumer index = this.consumers.get(i);
			if(name.equals(index.getName())) {//if find user
				result = index.getPower();
				break;
			}
			else if(!(name.equals(index.getName())) && i == length-1) {//if user not found
				throw new UnknownConsumerException("Consumer "+name+" unknown");
			}
			}
		}
		return result;	 
	 }
	 public void morePower(String name , int amount) throws UnknownConsumerException, NotAPowerGeneratorException{//change the certain consumers amount of power consumption
		 int i = 0;
		 int length = this.consumers.size();
		 if(length == 0) {
			 throw new UnknownConsumerException("Consumer "+name+" unknown");
		 }
		 else {
		 
		 for( i = 0;i < length; i++) {
			 Consumer index = this.consumers.get(i);
				if(name.equals(index.getName())) {//if find user
					index.morePower(amount);
					this.addTohistory(this.totalConsumption());
					this.notifyListeners();
					break;
				}
				if(!name.equals(index.getName()) && i == length-1) {//if user not found
					throw new UnknownConsumerException("Consumer "+name+" unknown");
				}
				}
		 }
	 }
	 private void notifyListeners() {
		 for(ModelListener ml:listeners) {
			 ml.update();
		 }
	 }
	 public static void testElectricityCompany() {//test Electricity Company
		 
		 try {//test get power method
		ElectricityCompany ect = new  ElectricityCompany("WM");
		 ect.addConsumer(new House("KK",1000));
		 ect.addConsumer(new SolarHouse("BB",200));
		 System.out.println(ect.totalConsumption()==1200);
		 System.out.println(ect.getPower("KK")==1000);
		 System.out.println(ect.getPower("AA")==0);
		 }
		 catch(UnknownConsumerException ue) {
			 System.out.println(ue.getMessage());
		 }
		 catch(NotAPowerGeneratorException ng) {
			 System.out.println(ng.getMessage());
		 }
		 finally{
			 try {//test more power method
				 ElectricityCompany ect1 = new  ElectricityCompany("WM");
				 ect1.addConsumer(new House("47",1000));
				 ect1.morePower("47",120);
				 System.out.println(ect1.getPower("47")==1120);
				 ect1.morePower("46", 10000);
			 }
			 catch(UnknownConsumerException ue) {
				 System.out.println(ue.getMessage());
			 }
			 catch(NotAPowerGeneratorException ng) {
				 System.out.println(ng.getMessage());
			 }
		 }
	}
	 
}
