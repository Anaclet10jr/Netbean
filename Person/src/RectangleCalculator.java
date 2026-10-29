
class Rectangle {
    double length;
    double width;

    // Constructor
    Rectangle(double rectangleLength, double rectangleWidth) {
        length = rectangleLength;
        width = rectangleWidth;
    }

    // Calculates area
    double calculateArea() {
        return length * width;
    }

    // Calculates perimeter
    double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Checks whether the rectangle is a square
    boolean isSquare() {
        return length == width;
    }

    // Displays rectangle information
    void displayInformation() {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());

        if (isSquare()) {
            System.out.println("Square: Yes");
        } else {
            System.out.println("Square: No");
        }
    }

    // Challenge: compares the areas of two rectangles
    void compareArea(Rectangle anotherRectangle) {
        if (calculateArea() > anotherRectangle.calculateArea()) {
            System.out.println("This rectangle has the larger area.");
        } else if (calculateArea() < anotherRectangle.calculateArea()) {
            System.out.println("The other rectangle has the larger area.");
        } else {
            System.out.println("Both rectangles have equal areas.");
        }
    }
}

public class RectangleCalculator {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(10, 5);
        Rectangle rectangle2 = new Rectangle(4, 4);
        Rectangle rectangle3 = new Rectangle(8, 3);

        System.out.println("===== RECTANGLE 1 =====");
        rectangle1.displayInformation();

        System.out.println("\n===== RECTANGLE 2 =====");
        rectangle2.displayInformation();

        System.out.println("\n===== RECTANGLE 3 =====");
        rectangle3.displayInformation();

        System.out.println("\n===== AREA COMPARISON =====");
        rectangle1.compareArea(rectangle2);
    }
}
