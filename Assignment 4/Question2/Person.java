class Person {
	private String name;
	private Person parent;
	public Person(String name, Person parent) {//constructor of Person
		this.name = name;
		this.parent = parent;
	}
	public String getName() {//return person's name
		return this.name;
	}
	public Person getPaerent() {//get the parent of this person
		return this.parent;
	}
	public static void testPerson() {//test person
		System.out.println("It is a person");
	}
}
