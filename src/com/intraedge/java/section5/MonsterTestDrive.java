/*
* Take a look at the three classes Monster, Vampire, and Dragon. Do you understand the
* inheritance hierarchy established here. Check out what the main() method does. Can you
* guess the outut of this program?
*/
public class MonsterTestDrive {
	public static void main(String[] args) {
    	Monster[] ma = new Monster[3];
    	ma[0] = new Vampire(); // we are inserting a Vampire into an array that holds only Monsters. Is this possible?
    	ma[1] = new Dragon(); // same like above? Can we really insert a Dragon into a Monster array?
    	ma[2] = new Monster(); // this definitely makes sense!
    	for(int x=0; x<3; x++) {
    		ma[x].frighten(x);
    	}
	}
}

class Monster {
	boolean frighten(int degree) {
		System.out.println("monster breathing fire");
		return true;
	}
}

class Vampire extends Monster {
	boolean frighten(int degree) {
		System.out.println("vampire breathing fire");
		return true;
	}
}

class Dragon extends Monster {
	boolean frighten(int degree) {
		System.out.println("dragon breathing fire");
		return true;
	}
}
