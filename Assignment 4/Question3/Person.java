class Person implements Parentable{
	private String name;
	private Parentable parent;
	public Person(String name, Parentable parent) {//constructor of Person
		this.name = name;
		this.parent = parent;
	}
	public String getName() {//return person's name
		return this.name;
	}
	public Parentable getParent() {//get the parent of this person
		return this.parent;
	}
	public static void testPerson() {//test person
		Ghost g = new Ghost("David");//ghost as the first parent
		Person p1 = new Person("Lisa",g);
		System.out.println(p1.getName()=="Lisa");
		System.out.println(p1.getParent()==g);
		//use p1 as second parent
		Person p2 = new Person("Lily",p1);
		System.out.println(p2.getName()=="Lily");
		System.out.println(p2.getParent()==p1);
	}
}
