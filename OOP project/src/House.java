import java.io.Serializable;

/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
 class House extends Building{
	 public House(String name,int power) throws NotAPowerGeneratorException {//the constructor of house
			 super(name,power);
			 if(power < 0) {
			 throw new NotAPowerGeneratorException("A new house cannot generate power");
			 }
	 }
	 @Override
	 public void morePower(int amount) throws NotAPowerGeneratorException{// the more power method
		 int result = this.getPower() + amount;
			 if(result < 0) {
				 throw new NotAPowerGeneratorException("A house cannot generate " + Math.abs(result) + " watts of power");
			 }
			 else {
				this.setPower(result); 
		 }
		 
	 }
	public static void testHouse() {// test house
		try {
		House h  = new House("Bob",-10000);//house cannot generate power
		}catch(NotAPowerGeneratorException e) {
			System.out.println(e.getMessage());
		}
		try {
		House ht = new House("Tom", 10000);
		System.out.println(ht.getName()=="Tom");
		System.out.println(ht.getPower() ==  10000);
		ht.morePower(1000);
		System.out.println(ht.getPower() ==  11000);
		ht.morePower(-2000);
		System.out.println(ht.getPower() ==  9000);
		ht.morePower(-20000);// house cannot generate power
		}catch(NotAPowerGeneratorException e) {
			System.out.println(e.getMessage());
		}
	}
}
