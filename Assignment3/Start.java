class Mushroom{
	private String color;
	public Mushroom(String color) {//the constructor of mushroom
		this.color = color;
	}
	public String getColor() {//return the mushroom color
		return this.color;
	}
	public boolean isEdible() {//return it isn't edible for safety reason
		System.out.println("Do not eat this!");
		return false;
	}
	public static void testMushroon() {
		Mushroom m = new Mushroom("Red");
		System.out.println(m.getColor()=="Red");
		System.out.println(m.isEdible()==false);
		
		Mushroom a = new AmanitaPhalloides();
		System.out.println(a.getColor()=="Green");
		System.out.println(a.isEdible()==false);
		
		Mushroom b = new Boletus("Yellow",30);
		System.out.println(b.getColor()=="Yellow");
		System.out.println(b.isEdible()==true);// should be true because it is edible
		System.out.println(((Boletus) b).getPrice()==30);//using type conversion to use subclass method getPrice
		
		Mushroom be_1 = new BoletusEdulis("Green",10);
		System.out.println(be_1.getColor()=="Green");
		System.out.println(be_1.isEdible()==true);
		System.out.println(((Boletus)be_1).getPrice()==10);
		
		Mushroom be_2 = new BoletusEdulis("Green");
		System.out.println(be_2.getColor()=="Green");
		System.out.println(be_2.isEdible()==true);
		System.out.println(((Boletus)be_2).getPrice()==100);//if using the second constructor of BoletusEdulis,its price should always be 100
		
		Mushroom ca = new CepesALaBordelaise();
		/*CepesALaBordelaise is extends from Boletus and it's always with color brown and its prise is always 500*/
		System.out.println(ca.getColor()=="Brown");
		System.out.println(ca.isEdible()==true);
		System.out.println(((Boletus)ca).getPrice()==500);
		
		Mushroom brf = new BoletusRubroflammeus();
		/*BoletusRubroflammeus is extends from Boletus and it's always with color red and its prise is always 0*/
		System.out.println(brf.getColor()=="Red");
		System.out.println(brf.isEdible()==false);// it is not edible
		System.out.println(((Boletus)brf).getPrice()==0);
	}
}
class  AmanitaPhalloides extends Mushroom{
	public  AmanitaPhalloides() {//constructors of AmanitaPhalloides
		super("Green");
	}
}
class  Boletus extends Mushroom{
	private int price;
	public  Boletus(String color,int price) {//constructor of Boletus
		super(color);
		this.price = price;
	}
	public boolean isEdible() {//override the isEdible
		System.out.println("It is edible");
		return true;
	}
	public int getPrice() {//return the price
		return this.price;
	}
}
class BoletusEdulis extends Boletus{//constructor of BoletusEdulis
	public BoletusEdulis(String color, int price) {//first constructor
		super(color,price);
	}
	public BoletusEdulis(String color) {//second constructor which price is always 100
		this(color,100);
	}
}
class CepesALaBordelaise extends BoletusEdulis{
	public CepesALaBordelaise() {//constructor of CepesALaBordelaise
		super("Brown",500);//it is always brown and with the price of 500
	}
}
class  BoletusRubroflammeus extends BoletusEdulis{
	public BoletusRubroflammeus() {//constructor of BoletusRubroflammeus
		super ("Red",0);// it is always red and with price of 0
	}
	public boolean isEdible() {// it is not edible so the method should be overrided
		System.out.println("Do not eat this!");
		return false;
	}
}
class Bag{
	private Mushroom mushroom;
	public Bag(Mushroom mushroom) {//constuctor of Bag
		this.mushroom = mushroom;
	}
	public Mushroom getMushroom() {// get the mushrooms in bag
		return this.mushroom;
	}
	public static void testBag() {
		BoletusRubroflammeus br2;
		Mushroom br1 = new BoletusRubroflammeus();
		Bag b = new Bag(br1);
		br2 = (BoletusRubroflammeus) b.getMushroom();//using type conversion take mushroom from the bag 
		System.out.println(br1==br2);
	}
}
public class Start {
	public static void main(String[] ags) {
		Mushroom.testMushroon();
		Bag.testBag();
	}
	
}
