class Ghost {
	private String name;
	public Ghost(String name) {//constructor of Ghost
		this.name = name;
	}
	public String getName() {//return ghost name
		return this.name;
	}
	public Ghost getParent() {//get ghost parent,The parent of the ghost is the ghost himself,so return itself
		return this;
	}
	public static void testGhost() {//test ghost
		Ghost g = new Ghost("Whoooo");
		System.out.println(g.getName() == "Whoooo");
		// The parent of the ghost is the ghost himself:
		System.out.println(g.getParent() == g);
	}
}
