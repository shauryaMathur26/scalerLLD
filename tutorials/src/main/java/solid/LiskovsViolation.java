package solid;


// Superclass
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}

// Subclass violating LSP
class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // Violation: Setting both width and height to the same value
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height); // Violation: Setting width instead of height
        super.setHeight(height);
    }
}

public class LiskovsViolation {

    static void modifyRectangle(Rectangle rectangle, int newWidth, int newHeight) {
        rectangle.setWidth(newWidth);
        rectangle.setHeight(newHeight);
    }
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(5);
        rectangle.setHeight(10);

        Rectangle rectangle2 = new Square();
        modifyRectangle(rectangle2, 5, 10);

        int area = rectangle.calculateArea();
        System.out.println("Area: " + area);

        int area2 = rectangle2.calculateArea();
        System.out.println("Area of modified - " + area2);
    }
}

//NOTE : In this Java example, the Square class inherits from Rectangle, and it overrides the setWidth and setHeight methods since both width and height are always the same for a square.
// However, when these methods are overridden in a way that contradicts the behavior expected from the base class, it violates Liskov Substitution Principle.

//When the Square object is passed to the modifyRectangle method, unexpected behavior occurs. The width and height are set independently, breaking the square's invariant(property or condition that should always hold true for a square), and the printed area is not what one would expect from a rectangle.

//This violation can lead to subtle bugs and makes it challenging to use instances of the derived class (Square) interchangeably with instances of the base class (Rectangle).
