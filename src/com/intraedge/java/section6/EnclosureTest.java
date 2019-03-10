/**
 * Modify the classes Circle and Square so that they both implement the Enclosure interface.
 * Create a store some circle and square objects in an Enclosure array. Use ploymorphism
 * to compute and print the area and perimeter for these shapes. You can find the constant
 * PI in the Math class
 */
interface Enclosure {
	public double perimeter();
	public double area();
}

class Circle {
	double radius;
	Circle(double radius) {
    	this.radius = radius;
	}
}

class Square {
	double width;
	Square(double width) {
    	this.width = width;
	}
}

public class EnclosureTest {
	
}